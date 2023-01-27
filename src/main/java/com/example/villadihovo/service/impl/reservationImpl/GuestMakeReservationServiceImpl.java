package com.example.villadihovo.service.impl.reservationImpl;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.reservations.Reservation;
import com.example.villadihovo.repository.reservation.GuestMakeReservationRepository;
import com.example.villadihovo.repository.reservation.ReservationRepository;
import com.example.villadihovo.repository.offers.RoomRepository;
import com.example.villadihovo.repository.offers.VillaRepository;
import com.example.villadihovo.service.reservation.GuestMakeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GuestMakeReservationServiceImpl implements GuestMakeReservationService {

    @Autowired
    private GuestMakeReservationRepository guestMakeReservationRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private VillaRepository villaRepository;

    @Override
    public List<ReservationForRoomDto> findAllRoomReservations() {
        return guestMakeReservationRepository.findAllRoomReservationsDTO();
    }

    @Override
    public ReservationForRoomDto findRoomReservationByReservationId(Integer id) {
        return guestMakeReservationRepository.findRoomReservationsDTOById(id);
    }

    @Override
    public ReservationForRoomDto updateRoomReservationById(Integer roomReservationId, LocalDate start_date, LocalDate end_date, Integer adults, Integer children, Integer number_guests) {
        Optional<Reservation> reservation = reservationRepository.findById(roomReservationId);
        if (reservation.isPresent()) {

            reservation.get().setStart_date(start_date);
            reservation.get().setEnd_date(end_date);
            reservation.get().setNumber_guests(number_guests);
            reservation.get().setAdults(adults);
            reservation.get().setChildren(children);

            reservationRepository.save(reservation.get());
        }
        return guestMakeReservationRepository.findRoomReservationsDTOById(roomReservationId);
    }

    @Override
    public void deleteReservationById(Integer reservation_id) {
        reservationRepository.deleteById(reservation_id);
    }
}
