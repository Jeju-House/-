package com.jeju.main.domain.user.service;

import com.jeju.main.domain.user.domain.User;
import com.jeju.main.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserModifier {
    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
