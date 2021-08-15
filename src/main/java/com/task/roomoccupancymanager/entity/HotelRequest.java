package com.task.roomoccupancymanager.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelRequest{
    private Integer freePremiumRooms;
    private Integer freeEconomyRooms;
    private Double [] potentialGuests;
}
