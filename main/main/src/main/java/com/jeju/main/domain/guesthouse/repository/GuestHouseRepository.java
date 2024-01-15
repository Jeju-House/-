package com.jeju.main.domain.guesthouse.repository;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestHouseRepository extends JpaRepository<GuestHouse,Long> {
}
