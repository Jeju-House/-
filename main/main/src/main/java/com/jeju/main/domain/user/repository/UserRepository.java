package com.jeju.main.domain.user.repository;

import com.jeju.main.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
