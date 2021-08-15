package com.task.roomoccupancymanager.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelResponse {
    private Integer occupiedPremiumRooms;
    private Integer occupiedEconomyRooms;
    private Double revenuePremium;
    private Double revenueEconomy;
}
