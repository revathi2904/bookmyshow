package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Show;
import com.example.bookmyshow.models.ShowSeat;
import com.example.bookmyshow.models.ShowSeatType;
import com.example.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;
    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculatePrice(Show show, List<ShowSeat> showSeats){
        int amount = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }

        return amount;
    }
}
