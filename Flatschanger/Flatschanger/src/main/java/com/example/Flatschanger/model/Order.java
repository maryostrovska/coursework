package com.example.Flatschanger.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_number_of_rooms")
    private Integer orderNumberOfRooms;
    @Column(name = "order_area")
    private Integer orderArea;
    @Column(name = "order_floor")
    private Integer orderFloor;
    @Column(name = "order_district")
    private String orderDistrict;

    public Order() {
    }
    public Order(Integer orderNumberOfRooms, Integer orderArea, Integer orderFloor, String orderDistrict) {
//        this.id = 1;
        this.orderNumberOfRooms = orderNumberOfRooms;
        this.orderArea = orderArea;
        this.orderFloor = orderFloor;
        this.orderDistrict = orderDistrict;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumberOfRooms=" + orderNumberOfRooms +
                ", orderArea=" + orderArea +
                ", orderFloor=" + orderFloor +
                ", orderDistrict='" + orderDistrict + '\'' +
                '}';
    }
}
