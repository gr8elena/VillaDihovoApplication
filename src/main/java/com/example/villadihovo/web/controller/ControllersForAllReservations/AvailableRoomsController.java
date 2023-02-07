package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.model.users.UserTable;
import com.example.villadihovo.service.reservation.ReservationService;
import com.example.villadihovo.service.offers.RoomsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/rooms/available")
public class AvailableRoomsController {

    private RoomsService roomsService;
    private ReservationService reservationService;

    @GetMapping
    public String listAllAvailableRooms(Model model){
        List<Rooms> availableRooms = this.roomsService.getAvailableRooms();
        model.addAttribute("availableRooms",  availableRooms);
        return "available-rooms";
    }

    @PostMapping("/reserve")
    public String getReservePage(@RequestParam LocalDate start_date,
                                       @RequestParam LocalDate end_date,
                                       @RequestParam Integer room_id,
                                       Model model){
        Optional<Rooms> chosenRoom = roomsService.findRoomById(room_id);
        Rooms rooms = chosenRoom.get();
        model.addAttribute("start_date", start_date);
        model.addAttribute("end_date", end_date);
        model.addAttribute("roomChosen", rooms);
        return "reservation-form-rooms";
    }
    @PostMapping("/reserve/room")
    public String reserveRoomUsingPost(@RequestParam LocalDate start_date,
                                             @RequestParam LocalDate end_date,
                                             @RequestParam Integer number_guests,
                                             @RequestParam Integer adults,
                                             @RequestParam Integer children,
                                             @RequestParam Integer room_id,
                                             @RequestParam String payment_method,
                                             @RequestParam String card_number,
                                             @RequestParam Integer price,
                                             HttpServletRequest request){
        UserTable userTable = (UserTable) request.getSession().getAttribute("user");
            reservationService.addReservation(start_date, end_date, number_guests, adults, children, payment_method, card_number, room_id, userTable, price);
        return "payment-confirmed";
    }
}
