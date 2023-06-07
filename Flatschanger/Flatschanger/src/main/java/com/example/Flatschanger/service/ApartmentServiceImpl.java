package com.example.Flatschanger.service;

import com.example.Flatschanger.model.Apartment;
import com.example.Flatschanger.model.Form;
import com.example.Flatschanger.model.Order;
import com.example.Flatschanger.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService{
    final private ApartmentRepository apartmentRepository;
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }
    @Override
    public void save(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public void delete(Apartment apartment) {
        apartmentRepository.delete(apartment);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public Apartment findFirstApartment(Form form) {
        Integer minArea = (int) (form.getOrderArea() - form.getOrderArea().intValue() * 0.1);
        Integer maxArea =  (int) (form.getOrderArea() + form.getOrderArea().intValue() * 0.1);
        List<Apartment> apartments = apartmentRepository.findFirstApartment(minArea,maxArea, form.getOrderFloor(),form.getOrderDistrict(),form.getOrderNumberOfRooms());

        if (apartments.isEmpty()) {
            Apartment apartment = new Apartment(form.getOwnerName(), form.getOwnerSurname(),
                    form.getOwnerNumberOfRooms(), form.getOwnerArea(), form.getOwnerFloor(), form.getOwnerDistrict(),
                    new Order(form.getOrderNumberOfRooms(), form.getOrderArea(), form.getOrderFloor(), form.getOrderDistrict()), true);
            save(apartment);
            return apartment;
        }

        for (Apartment apartment : apartments) {
            Order order = apartment.getOrder();
            minArea = (int) (apartment.getOrder().getOrderArea() - (apartment.getOrder().getOrderArea() * 0.1));
            maxArea = (int) (apartment.getOrder().getOrderArea() + (apartment.getOrder().getOrderArea() * 0.1));

            if(form.getOwnerArea() > maxArea || form.getOwnerArea() < minArea)
                continue;

            if ((order.getOrderNumberOfRooms()).equals(form.getOwnerNumberOfRooms())
                    && order.getOrderFloor().equals(form.getOwnerFloor())
                    && order.getOrderDistrict().equals(form.getOwnerDistrict())) {
                delete(apartment);
                apartment.setIsExchanged(false);
                return apartment;
            }
        }
        Apartment apartment = new Apartment(form.getOwnerName(), form.getOwnerSurname(),
                form.getOwnerNumberOfRooms(), form.getOwnerArea(), form.getOwnerFloor(), form.getOwnerDistrict(),
                new Order(form.getOrderNumberOfRooms(), form.getOrderArea(), form.getOrderFloor(), form.getOrderDistrict()), true);
        return apartment;
    }
    public List<Apartment> findApartmentsByArea(Integer area){
        return apartmentRepository.findApartmentsByOwnerArea(area);
    }
    public List<Apartment> findApartmentsByFloor(Integer floor){
        return apartmentRepository.findApartmentsByOwnerFloor(floor);
    }
    public List<Apartment> findApartmentsByRooms(Integer rooms){
        return apartmentRepository.findApartmentsByOwnerNumberOfRooms(rooms);
    }
    public List<Apartment> findApartmentsByDistrict(String district){
        return apartmentRepository.findApartmentsByOwnerDistrict(district);
    }
}
