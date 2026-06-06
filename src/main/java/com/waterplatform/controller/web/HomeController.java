package com.waterplatform.controller.web;

import com.waterplatform.dto.*;
import com.waterplatform.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final UserService userService;
    private final EventService eventService;
    private final BoatService boatService;
    private final RentalService rentalService;
    private final RouteService routeService;
    private final TournamentService tournamentService;
    private final InclusiveService inclusiveService;

    public HomeController(UserService userService, EventService eventService, BoatService boatService,
                          RentalService rentalService, RouteService routeService,
                          TournamentService tournamentService, InclusiveService inclusiveService) {
        this.userService = userService; this.eventService = eventService;
        this.boatService = boatService; this.rentalService = rentalService;
        this.routeService = routeService; this.tournamentService = tournamentService;
        this.inclusiveService = inclusiveService;
    }

    @GetMapping("/healthz")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("userCount", userService.findAll().size());
        model.addAttribute("eventCount", eventService.findAll().size());
        model.addAttribute("boatCount", boatService.findAll().size());
        model.addAttribute("rentalCount", rentalService.findAll().size());
        model.addAttribute("routeCount", routeService.findAll().size());
        model.addAttribute("tournamentCount", tournamentService.findAll().size());
        model.addAttribute("inclusiveCount", inclusiveService.findAll().size());
        model.addAttribute("events", eventService.findAll());
        return "dashboard";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping("/events")
    public String events(Model model) {
        model.addAttribute("events", eventService.findAll());
        return "events";
    }

    @GetMapping("/events/{id}")
    public String eventDetail(@PathVariable String id, Model model) {
        EventDto event = eventService.findById(id);
        if (event == null) return "redirect:/events";
        model.addAttribute("event", event);
        return "event-detail";
    }

    @GetMapping("/boats")
    public String boats(Model model) {
        model.addAttribute("boats", boatService.findAll());
        return "boats";
    }

    @GetMapping("/rentals")
    public String rentals(Model model) {
        model.addAttribute("rentals", rentalService.findAll());
        return "rentals";
    }

    @GetMapping("/routes")
    public String routes(Model model) {
        model.addAttribute("routes", routeService.findAll());
        return "routes";
    }

    @GetMapping("/routes/{id}")
    public String routeDetail(@PathVariable String id, Model model) {
        RouteDto route = routeService.findById(id);
        if (route == null) return "redirect:/routes";
        model.addAttribute("route", route);
        model.addAttribute("points", routeService.getPoints(id));
        return "route-detail";
    }

    @GetMapping("/tournaments")
    public String tournaments(Model model) {
        model.addAttribute("tournaments", tournamentService.findAll());
        model.addAttribute("teams", tournamentService.findAllTeams());
        return "tournaments";
    }

    @GetMapping("/inclusive")
    public String inclusive(Model model) {
        model.addAttribute("profiles", inclusiveService.findAll());
        return "inclusive";
    }
}
