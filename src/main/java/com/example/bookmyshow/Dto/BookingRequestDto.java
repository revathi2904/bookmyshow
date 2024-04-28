package com.example.bookmyshow.Dto;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingRequestDto {
    private Long userId;
    private Long showId;
    private List<Long> showSeatList;
}
