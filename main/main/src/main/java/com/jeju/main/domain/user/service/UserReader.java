package com.jeju.main.domain.user.service;

import com.jeju.main.domain.user.domain.User;
import com.jeju.main.domain.user.repository.UserRepository;
import com.jeju.main.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.jeju.main.global.error.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

    public User findUserByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException(USER_NOT_FOUND));
    }
}
