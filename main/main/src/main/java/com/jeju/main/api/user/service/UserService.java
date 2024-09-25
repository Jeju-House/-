package com.jeju.main.api.user.service;

import com.jeju.main.domain.user.domain.User;
import com.jeju.main.domain.user.dto.request.SignUpRequestDto;
import com.jeju.main.domain.user.dto.response.SignInResponseDto;
import com.jeju.main.domain.user.dto.response.SignUpResponseDto;
import com.jeju.main.domain.user.repository.RefreshTokenRepository;
import com.jeju.main.domain.user.repository.UserRepository;
import com.jeju.main.domain.user.service.UserModifier;
import com.jeju.main.domain.user.service.UserReader;
import com.jeju.main.global.config.auth.JwtProvider;
import com.jeju.main.global.config.auth.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.jeju.main.domain.user.domain.RefreshToken.createRefreshToken;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtProvider jwtProvider;
//    private final RefreshTokenRepository refreshTokenRepository;
    private final UserReader userReader;
    private final UserModifier userModifier;

    private final UserRepository userRepository;
    public SignInResponseDto signIn(Long userId){

        User user = userReader.findUserByUserId(userId);

        Boolean isFirstLogin = Objects.isNull(user.getRole()) ? Boolean.TRUE : Boolean.FALSE;

        TokenInfo tokenInfo = issueAccessTokenAndRefreshToken(user);

        updateRefreshToken(tokenInfo.getRefreshToken(), user);

        userModifier.saveUser(user);

        return SignInResponseDto.of(user, tokenInfo, isFirstLogin);
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto){
        User user = User.createUser(signUpRequestDto.getAccount(),signUpRequestDto.getPassword(), signUpRequestDto.getGender(),signUpRequestDto.getRole());
        userModifier.saveUser(user);
        return SignUpResponseDto.of(user);
    }

    private TokenInfo issueAccessTokenAndRefreshToken(User user) {
        return jwtProvider.issueToken(user.getId());
    }

    private void updateRefreshToken(String refreshToken, User user) {
        user.updateRefreshToken(refreshToken);
//        refreshTokenRepository.save(createRefreshToken(user.getId(), refreshToken));
    }

}
