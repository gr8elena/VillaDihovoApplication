package com.example.villadihovo.service.impl;

import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.model.payments.OnSite;
import com.example.villadihovo.model.payments.Online;
import com.example.villadihovo.model.payments.Payment;
import com.example.villadihovo.model.reservations.GuestsMakeReservation;
import com.example.villadihovo.model.reservations.Reservation;
import com.example.villadihovo.model.users.Guests;
import com.example.villadihovo.model.users.UserTable;
import com.example.villadihovo.repository.*;
import com.example.villadihovo.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;
    RoomRepository roomRepository;
    VillaRepository villaRepository;
    PaymentRepository paymentRepository;
    UserRepository userRepository;
    OnSiteRepository onSiteRepository;
    OnlineRepository onlineRepository;
    GuestRepository guestRepository;
    GuestMakeReservationRepository guestMakeReservationRepository;

    @Override
    public List<Reservation> allReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(LocalDate start_date, LocalDate end_date, Integer number_guests, Integer adults, Integer children,String payment_method, String card_number, Integer room_id, UserTable user, Integer price) {

        Reservation reservation = new Reservation();

        Optional<Rooms> roomsOptional = roomRepository.findById(room_id);
        roomsOptional.ifPresent(room -> {
            reservation.setVilla_id(room.getVilla_id());
            reservation.setRoom_id(room);
            room.setAvailability(false);
            roomRepository.save(room);
        });


        Period period = Period.between(start_date, end_date);
        int days = period.getDays();

        Payment payment = new Payment();
        payment.setTotal_payment(days * price);
        payment.setPay_date(LocalDate.now());
        payment.setRec_id("12345678910");
        payment.setCustomer_id(user.getUser_id() + "22");
        payment.setUser_id(user);
        paymentRepository.save(payment);

        if(payment_method == "creditCard")
        {
            Online online = new Online();
            online.setPayment_id(payment.getPayment_id());
            online.setCard_number(card_number);
            onlineRepository.save(online);
        }else if(payment_method == "onSite")
        {
            OnSite onSite = new OnSite();
            onSite.setPayment_id(payment.getPayment_id());
            onSite.setCurrency("euros");
            onSite.setPayment_type("cash");
            onSite.setUser_id(user);
            onSiteRepository.save(onSite);
        }
        reservation.setPayment_id(payment);
        reservation.setStart_date(start_date);
        reservation.setEnd_date(end_date);
        reservation.setNumber_guests(number_guests);
        reservation.setAdults(adults);
        reservation.setChildren(children);

        int reservation_id = reservationRepository.save(reservation).getReservation_id();

        GuestsMakeReservation guestsMakeReservation = new GuestsMakeReservation();
        guestsMakeReservation.setReservation_id(reservation_id);
        guestsMakeReservation.setUser_id(user.getUser_id());
        guestMakeReservationRepository.save(guestsMakeReservation);

        return reservation;
    }


}
