package com.example.Flatschanger.service;

import com.example.Flatschanger.model.Apartment;
import com.example.Flatschanger.model.Form;

import java.util.List;

public interface ApartmentService {
    void save(Apartment apartment);
    void delete(Apartment apartment);
    List<Apartment> getAllApartments();
    Apartment findFirstApartment(Form form);
    List<Apartment> findApartmentsByArea(Integer area);
    List<Apartment> findApartmentsByFloor(Integer floor);
    List<Apartment> findApartmentsByRooms(Integer rooms);
    List<Apartment> findApartmentsByDistrict(String district);
}
