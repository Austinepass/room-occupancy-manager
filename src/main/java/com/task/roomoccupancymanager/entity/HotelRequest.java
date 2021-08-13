package com.task.roomoccupancymanager.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HotelRequest{
    private Integer noOfAvailablePremiumRooms;
    private Integer noOfAvailableEconomyRooms;
    private List<Integer> potentialGuests;
}
