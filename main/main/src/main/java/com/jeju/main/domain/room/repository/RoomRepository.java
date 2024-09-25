package com.jeju.main.domain.room.repository;

import com.jeju.main.domain.room.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.guest_house.id IN :guesthouseId")
    List<Room> findAllByGuestHouseId(@Param("guesthouseId")Long guesthouseId);
}
