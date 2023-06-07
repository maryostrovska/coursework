package com.example.Flatschanger.repository;

import com.example.Flatschanger.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
    @Query("SELECT a FROM Apartment a WHERE a.ownerArea >= :minArea AND a.ownerArea <= :maxArea AND a.ownerFloor = :floor AND a.ownerDistrict = :district AND a.ownerNumberOfRooms = :orderNumberOfRooms")
    List<Apartment> findFirstApartment(@Param("minArea") Integer minArea, @Param("maxArea") Integer maxArea, @Param("floor") Integer floor, @Param("district") String district, @Param("orderNumberOfRooms") Integer orderNumberOfRooms);
    List<Apartment> findApartmentsByOwnerArea(Integer area);
    List<Apartment> findApartmentsByOwnerFloor(Integer floor);
    List<Apartment> findApartmentsByOwnerNumberOfRooms(Integer rooms);
    List<Apartment> findApartmentsByOwnerDistrict(String district);
}

