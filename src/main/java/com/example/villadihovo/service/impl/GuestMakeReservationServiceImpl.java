package com.example.villadihovo.service.impl;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.reservations.Reservation;
import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.repository.GuestMakeReservationRepository;
import com.example.villadihovo.repository.ReservationRepository;
import com.example.villadihovo.repository.RoomRepository;
import com.example.villadihovo.service.GuestMakeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<ReservationForRoomDto> findAllRoomReservations() {
        return guestMakeReservationRepository.findAllRoomReservationsDTO();
    }

    @Override
    public ReservationForRoomDto findRoomReservationByReservationId(Integer id) {
        return guestMakeReservationRepository.findRoomReservationsDTOById(id);
    }

    @Override
    public ReservationForRoomDto updateRoomReservationById(Integer roomReservationId , ReservationForRoomDto roomReservationDto) {
        ReservationForRoomDto roomReservationsDTOById = guestMakeReservationRepository.findRoomReservationsDTOById(roomReservationId);
        Optional<Reservation> reservation = reservationRepository.findById(roomReservationId);
        Optional<Rooms> roomsOptional = null;
        if (reservation.isPresent()) {
            reservation.get().setStart_date(roomReservationDto.getStart_date());
            reservation.get().setEnd_date(roomReservationDto.getEnd_date());
            reservation.get().setNumber_guests(roomReservationDto.getNumber_guests());
            reservation.get().setAdults(roomReservationDto.getAdults());
            reservation.get().setChildren(roomReservationDto.getChildren());

            int room_id = reservation.get().getRoom_id().getRoom_id();
            roomsOptional = roomRepository.findById(room_id);
            roomsOptional.ifPresent(room -> room.setRoom_type(roomReservationDto.getRoom_type()));
            roomsOptional.ifPresent(room -> reservation.get().setRoom_id(room));
            roomRepository.save(roomsOptional.get());
            reservationRepository.save(reservation.get());
        }
        return guestMakeReservationRepository.findRoomReservationsDTOById(roomReservationId);
    }
}
