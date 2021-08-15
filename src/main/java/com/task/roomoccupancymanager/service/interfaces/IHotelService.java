package com.task.roomoccupancymanager.service.interfaces;

import com.task.roomoccupancymanager.entity.HotelRequest;
import com.task.roomoccupancymanager.entity.HotelResponse;
import org.springframework.http.ResponseEntity;

public interface IHotelService {
    HotelResponse optimizeRooms(HotelRequest request);
}
