package com.jeju.main.domain.user.service;

import com.jeju.main.domain.user.domain.User;
import com.jeju.main.domain.user.dto.request.SignUpRequestDto;
import com.jeju.main.domain.user.dto.response.SignInResponseDto;
import com.jeju.main.domain.user.dto.response.SignUpResponseDto;
import com.jeju.main.domain.user.repository.RefreshTokenRepository;
import com.jeju.main.domain.user.repository.UserRepository;
import com.jeju.main.global.config.auth.JwtProvider;
import com.jeju.main.global.config.auth.TokenInfo;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.jeju.main.domain.user.domain.RefreshToken.createRefreshToken;
import static com.jeju.main.global.error.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtProvider jwtProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    private final UserRepository userRepository;
    public SignInResponseDto signIn(Long userId){
        User user = findUserByUserId(userId);
        Boolean isFirstLogin = Objects.isNull(user.getRole()) ? Boolean.TRUE : Boolean.FALSE;
        TokenInfo tokenInfo = issueAccessTokenAndRefreshToken(user);
        updateRefreshToken(tokenInfo.getRefreshToken(), user);
        saveUser(user);
        return SignInResponseDto.of(user, tokenInfo, isFirstLogin);
    }
    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){
        User user = User.createUser(signUpRequestDto.getAccount(),signUpRequestDto.getPassword(), signUpRequestDto.getGender(),signUpRequestDto.getRole());
        saveUser(user);
        return SignUpResponseDto.of(user);
    }
    private TokenInfo issueAccessTokenAndRefreshToken(User user) {
        return jwtProvider.issueToken(user.getId());
    }
    private User saveUser(User user){
        return userRepository.save(user);
    }
    private void updateRefreshToken(String refreshToken, User user) {
        user.updateRefreshToken(refreshToken);
        refreshTokenRepository.save(createRefreshToken(user.getId(), refreshToken));
    }
    private User findUserByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));
    }

}
