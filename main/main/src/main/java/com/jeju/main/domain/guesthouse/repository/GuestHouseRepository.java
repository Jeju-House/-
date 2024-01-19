package com.jeju.main.domain.guesthouse.repository;

import com.jeju.main.domain.guesthouse.domain.GuestHouse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse,Long> {
    List<GuestHouse> findByRegion(String region);
}
