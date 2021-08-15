package com.task.roomoccupancymanager.service;


import com.task.roomoccupancymanager.entity.HotelRequest;
import com.task.roomoccupancymanager.entity.HotelResponse;
import com.task.roomoccupancymanager.service.interfaces.IHotelService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {

    @Override
    public HotelResponse optimizeRooms(HotelRequest request) {
        return optimize(request);
    }

    HotelResponse optimize(HotelRequest request) {

        double premiumRevenue = 0d;
        double economyRevenue = 0d;

        List<Double> highList = Arrays.stream(request.getPotentialGuests())
                .filter(x -> x >= 100)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        List<Double> lowList = Arrays.stream(request.getPotentialGuests())
                .filter(x -> x < 100)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int premiumRoom = request.getFreePremiumRooms();
        int economyRoom = request.getFreeEconomyRooms();
        int economyCount = lowList.size(); //tracks the number of available economy guests.

        //Admit premium guests to available premium rooms.
        for (int i = 0; i < highList.size(); i++) {
            if (premiumRoom > 0) {
                premiumRevenue += highList.get(i);
                premiumRoom--;
            }
        }

        //Admit economy guests to available economy rooms, and
        //admit high paying ones into premium rooms if they are empty.
        if (lowList.size() < economyRoom) {
            for (Double guest : lowList) {
                economyRevenue += guest;
                economyRoom--;
            }
        } else {
            for (int i = 0; i < lowList.size(); i++) {
                if (economyRoom >= economyCount) {
                    economyRevenue += lowList.get(i);
                    economyCount--;
                    economyRoom--;
                } else {
                    if (premiumRoom > 0) {
                        premiumRevenue += lowList.get(i);
                        premiumRoom--;
                        economyCount--;
                    } else {
                        if (economyRoom <= 0) {
                            break;
                        }
                        economyRevenue += lowList.get(i);
                        economyRoom--;
                    }
                }
            }
        }
        HotelResponse response = new HotelResponse();

        response.setOccupiedPremiumRooms(request.getFreePremiumRooms() - premiumRoom);
        response.setOccupiedEconomyRooms(request.getFreeEconomyRooms() - economyRoom);
        response.setRevenuePremium(premiumRevenue);
        response.setRevenueEconomy(economyRevenue);

        return response;

    }
}
