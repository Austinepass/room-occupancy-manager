package com.task.roomoccupancymanager.controller;

import com.task.roomoccupancymanager.entity.HotelRequest;
import com.task.roomoccupancymanager.entity.HotelResponse;
import com.task.roomoccupancymanager.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rooms")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/optimize")
    ResponseEntity<HotelResponse> optimizeRooms(@RequestBody HotelRequest request) {
        HotelResponse response = hotelService.optimizeRooms(request);

        return ResponseEntity.ok(response);
    }

}
