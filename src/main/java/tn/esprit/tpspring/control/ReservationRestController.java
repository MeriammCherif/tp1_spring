package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Reservation;
import tn.esprit.tpspring.service.interfaces.IReservationService;

import java.util.List;

@Tag(name = "Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private IReservationService reservationService;

    // http://localhost:8089/autoloc/reservation/retrieve-all-reservations
    @Operation(description = "Recuperer tous les reservations de la base de donnees")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }

    // http://localhost:8089/autoloc/reservation/retrieve-reservation/8
    @Operation(description = "Recuperer un reservation par son identifiant")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
        Reservation reservation = reservationService.retrieveReservation(reservationId);
        return reservation;
    }

    // http://localhost:8089/autoloc/reservation/add-reservation
    @Operation(description = "Ajouter un nouveau reservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.addReservation(c);
        return reservation;
    }

    // http://localhost:8089/autoloc/reservation/remove-reservation/8
    @Operation(description = "Supprimer un reservation par son identifiant")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long reservationId) {
        reservationService.removeReservation(reservationId);
    }

    // http://localhost:8089/autoloc/reservation/modify-reservation
    @Operation(description = "Modifier un reservation existant (envoyer son identifiant)")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.modifyReservation(c);
        return reservation;
    }
}
