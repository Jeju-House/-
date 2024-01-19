package com.jeju.main.domain.user.repository;

import com.jeju.main.domain.user.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
}

