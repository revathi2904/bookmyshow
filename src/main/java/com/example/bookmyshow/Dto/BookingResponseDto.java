package com.example.bookmyshow.Dto;

import com.example.bookmyshow.models.ResponseStatus;
import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingResponseDto {
    private  int amount;
    private Long bookingId;
    private ResponseStatus responseStatus;

}
