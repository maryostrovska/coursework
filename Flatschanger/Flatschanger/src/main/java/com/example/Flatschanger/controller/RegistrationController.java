package com.example.Flatschanger.controller;

import com.example.Flatschanger.model.Apartment;
import com.example.Flatschanger.model.Form;
import com.example.Flatschanger.service.ApartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RegistrationController{
    private final ApartmentService apartmentService;
    public RegistrationController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }
    @GetMapping("/menu")
    private String mainMenu() {
        return "menu";
    }
    @GetMapping("/exchange")
    private String addApartments() {
        return "full-form";
    }
    @PostMapping("/exchange")
    private String addApartments(@Valid @ModelAttribute Form form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "full-form";
        } else {
            Apartment apartment = apartmentService.findFirstApartment(form);
            model.addAttribute("apartment", apartment);
            if(!apartment.getIsExchanged()) {
                return "theExchangeSuccessful";
            } else {
                return "apartmentSuccessfullyAdded";
            }
        }
    }
    @GetMapping("/deleteOrder")
    private String deleteApartment(Apartment apartment){
        apartmentService.delete(apartment);
        return "redirect:/showAllApartments";
    }
    @GetMapping("/showAllApartments")
    private String showApartments(Model model) {
        model.addAttribute("apartments", apartmentService.getAllApartments());
        return "all-apartaments";
    }
    @GetMapping("/findByArea")
    private String findApartmentByArea(){
        return "form-area";
    }
    @PostMapping("/findByArea")
    private String findApartmentByArea(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerArea")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerArea"));
            return "form-area";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByArea(form.getOwnerArea()));
        return "all-apartaments";
    }

    @GetMapping("/findByFloor")
    private String findApartmentByFloor(){
        return "form-floor";
    }
    @PostMapping("/findByFloor")
    private String findApartmentByFloor(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerFloor")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerFloor"));
            return "form-floor";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByFloor(form.getOwnerFloor()));
        return "all-apartaments";
    }
    @GetMapping("/findByRooms")
    private String findApartmentByRooms(){
        return "form-rooms";
    }
    @PostMapping("/findByRooms")
    private String findApartmentByRooms(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerNumberOfRooms")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerNumberOfRooms"));
            return "form-rooms";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByRooms(form.getOwnerNumberOfRooms()));
        return "all-apartaments";
    }
    @GetMapping("/findByDistrict")
    private String findApartmentByDistrict(){
        return "form-district";
    }
    @PostMapping("/findByDistrict")
    private String findApartmentByDistrict(@Valid @ModelAttribute Form form,  BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors("ownerDistrict")) {
            model.addAttribute("error", bindingResult.getFieldError("ownerDistrict"));
            return "form-district";
        }
        model.addAttribute("apartments", apartmentService.findApartmentsByDistrict(form.getOwnerDistrict()));
        return "all-apartaments";
    }
    @PostMapping("/sortByOwnerNameUp")
    private String sortByOwnerNameUp(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream().sorted(Comparator.comparing(Apartment::getOwnerName)).collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    @PostMapping("/sortByOwnerNameReverse")
    private String sortByOwnerNameReverse(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream()
                .sorted(Comparator.comparing(Apartment::getOwnerName).reversed())
                .collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    @PostMapping("/sortByAreaUp")
    private String sortByArea(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream().sorted(Comparator.comparing(Apartment::getOwnerArea)).collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    @PostMapping("/sortByAreaReverse")
    private String sortByAreaReverse(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream()
                .sorted(Comparator.comparing(Apartment::getOwnerArea).reversed())
                .collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    //fff
    @PostMapping("/sortByFloorUp")
    private String sortByFloorUp(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream().sorted(Comparator.comparing(Apartment::getOwnerFloor)).collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    @PostMapping("/sortByFloorReverse")
    private String sortByFloorReverse(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream()
                .sorted(Comparator.comparing(Apartment::getOwnerFloor).reversed())
                .collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    @PostMapping("/sortByRoomsUp")
    private String sortByRoomsUp(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream().sorted(Comparator.comparing(Apartment::getOwnerNumberOfRooms)).collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
    @PostMapping("/sortByRoomsReverse")
    private String sortByRoomsReverse(Model model){
        List<Apartment> apartmentList = apartmentService.getAllApartments();
        apartmentList = apartmentList.stream()
                .sorted(Comparator.comparing(Apartment::getOwnerNumberOfRooms).reversed())
                .collect(Collectors.toList());
        model.addAttribute("apartments", apartmentList);
        return "all-apartaments";
    }
}
