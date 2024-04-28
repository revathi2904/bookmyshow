package com.example.bookmyshow.services;

import com.example.bookmyshow.Exceptions.ShowException;
import com.example.bookmyshow.Exceptions.UserException;
import com.example.bookmyshow.models.*;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import com.example.bookmyshow.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    PriceCalculator priceCalculator;
    BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, PriceCalculator priceCalculator){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculator = priceCalculator;
    }
//    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(long userId, long showId, List<Long> showIds) throws UserException, ShowException{
        // 1.get user details
        //2.get show with show id
        //3.get showseats with showseatids;
        //4.check if seats are avaiable
        //5.If no throw exception
        //6.If yes mark seat as blocked
        //7 .save updat ed  status in db
        // 8 .Create Booking obj with pending sttaus
        //9. Return booking obj

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserException("Invalid User");
        }
        User user = optionalUser.get();

        Optional<Show>  optionalShow = showRepository.findById(showId);

        if(optionalShow.isEmpty()){
            throw new ShowException("Invalid Show");
        }

        Show show = optionalShow.get();
        List<ShowSeat> showSeatList  = showSeatRepository.findAllById(showIds);
        List<ShowSeat> blockedSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeatList){
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)){
                throw new ShowException("Seat is not available");
            }
        }

        for(ShowSeat showSeat: showSeatList){
            showSeat.setSeatStatus(SeatStatus.BLOCKED);

            blockedSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking = new Booking();

        booking.setShow(show);
        booking.setUser(user);
        booking.setShowSeats(blockedSeats);
        booking.setTimeOfBooking(new Date());
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPayments(new ArrayList<>());
        booking.setPrice(priceCalculator.calculatePrice(show, blockedSeats));

        return null;
    }
}
