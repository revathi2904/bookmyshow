package com.example.bookmyshow.controllers;

import com.example.bookmyshow.Dto.BookingRequestDto;
import com.example.bookmyshow.Dto.BookingResponseDto;
import com.example.bookmyshow.models.Booking;
import com.example.bookmyshow.models.ResponseStatus;
import com.example.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookingController {
    BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }


    public BookingResponseDto bookMovie(BookingRequestDto bookingRequestDto){
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        try{
            Long userId = bookingRequestDto.getUserId();
            Long showId = bookingRequestDto.getShowId();
            List<Long> showSeatIds = bookingRequestDto.getShowSeatList();
            Booking booking = bookingService.bookMovie(userId, showId, showSeatIds);
            bookingResponseDto.setBookingId(booking.getId());
            bookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            bookingResponseDto.setAmount(booking.getPrice());
        }catch(Exception e){
            bookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return bookingResponseDto;
    }
}
