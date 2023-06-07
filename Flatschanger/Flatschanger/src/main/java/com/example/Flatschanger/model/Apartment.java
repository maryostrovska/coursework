package com.example.Flatschanger.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "apartments")
@Data
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ownerName;
    private String ownerSurname;
    @Column(name = "numbers_of_rooms")
    private Integer ownerNumberOfRooms;
    @Column(name = "area")
    private Integer ownerArea;
    @Column(name = "floor")
    private Integer ownerFloor;
    @Column(name = "district")
    private String ownerDistrict;
    @OneToOne(cascade = CascadeType.ALL)
    private Order order;
    @Transient
    private Boolean isExchanged = false;
public Apartment() {

}

    public Apartment(String ownerName, String ownerSurname, Integer ownerNumberOfRooms, Integer ownerArea, Integer ownerFloor, String ownerDistrict, Order order, Boolean isExchanged) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerNumberOfRooms = ownerNumberOfRooms;
        this.ownerArea = ownerArea;
        this.ownerFloor = ownerFloor;
        this.ownerDistrict = ownerDistrict;
        this.order = order;
        this.isExchanged = isExchanged;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", ownerSurname='" + ownerSurname + '\'' +
                ", ownerNumberOfRooms=" + ownerNumberOfRooms +
                ", ownerArea=" + ownerArea +
                ", ownerFloor=" + ownerFloor +
                ", ownerDistrict='" + ownerDistrict + '\''+
                '}';
    }
}
