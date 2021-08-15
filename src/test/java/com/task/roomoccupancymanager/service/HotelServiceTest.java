package com.task.roomoccupancymanager.service;

import com.task.roomoccupancymanager.entity.HotelRequest;
import com.task.roomoccupancymanager.entity.HotelResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HotelServiceTest {

    @Resource
    HotelService hotelService;
    HotelRequest request = new HotelRequest();
    HotelResponse response;

    @BeforeEach
    void setUp() {
        request.setPotentialGuests(new Double[]{23d, 45d, 155d, 374d, 22d, 99.99d, 100d, 101d, 115d, 209d});
    }

    @Test
    void testCaseOne() {
        request.setFreePremiumRooms(3);
        request.setFreeEconomyRooms(3);
        response = hotelService.optimizeRooms(request);
        assertEquals(response.getRevenuePremium(), 738);
        assertEquals(response.getRevenueEconomy(), 167.99);
        assertEquals(response.getOccupiedPremiumRooms(), 3);
        assertEquals(response.getOccupiedEconomyRooms(), 3);
    }

    @Test
    void testCaseTwo() {
        request.setFreePremiumRooms(7);
        request.setFreeEconomyRooms(5);
        response = hotelService.optimizeRooms(request);
        assertEquals(response.getRevenuePremium(), 1054);
        assertEquals(response.getRevenueEconomy(), 189.99);
        assertEquals(response.getOccupiedPremiumRooms(), 6);
        assertEquals(response.getOccupiedEconomyRooms(), 4);
    }

    @Test
    void testCaseThree() {
        request.setFreePremiumRooms(2);
        request.setFreeEconomyRooms(7);
        response = hotelService.optimizeRooms(request);
        assertEquals(response.getRevenuePremium(), 583);
        assertEquals(response.getRevenueEconomy(), 189.99);
        assertEquals(response.getOccupiedPremiumRooms(), 2);
        assertEquals(response.getOccupiedEconomyRooms(), 4);
    }

    @Test
    void testCaseFour() {
        request.setFreePremiumRooms(7);
        request.setFreeEconomyRooms(1);
        response = hotelService.optimizeRooms(request);
        assertEquals(response.getRevenuePremium(), 1153.99);
        assertEquals(response.getRevenueEconomy(), 45);
        assertEquals(response.getOccupiedPremiumRooms(), 7);
        assertEquals(response.getOccupiedEconomyRooms(), 1);
    }

    @Test
    void testCaseFive() {
        request.setFreePremiumRooms(9);
        request.setFreeEconomyRooms(2);
        response = hotelService.optimizeRooms(request);
        assertEquals(response.getRevenuePremium(), 1198.99);
        assertEquals(response.getRevenueEconomy(), 45);
        assertEquals(response.getOccupiedPremiumRooms(), 8);
        assertEquals(response.getOccupiedEconomyRooms(), 2);
    }
}