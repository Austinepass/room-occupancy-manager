package com.task.roomoccupancymanager.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelResponse {
    private Integer noOfOccupiedPremiumRooms;
    private Integer noOfOccupiedEconomyRooms;
    private Integer totalAmount; //in EUR
}
