package com.example.Flatschanger.model;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Form {
    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must be only alph symb")
    private String ownerName;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "surname must be only alph symb")
    private String ownerSurname;
    @DecimalMin(value = "1", message = "owner number of rooms must be min 1")
    @NotNull(message = "order number of rooms must be fill")
    private Integer ownerNumberOfRooms;
    @DecimalMin(value = "10", message = "owner area must be min 10")
    @NotNull(message = "owner area must be fill")
    private Integer ownerArea;
    @Min(value = 1, message = "owner floor must be min 1")
    @NotNull(message = "owner floor must be fill")
    private Integer ownerFloor;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "owner district must be only alph symb")
    private String ownerDistrict;
    @Min(value = 1, message = "order number of rooms must be min 1")
    @NotNull(message = "order number of rooms must be fill")
    private Integer orderNumberOfRooms;
    @DecimalMin(value = "1", message = "owner floor must be min 1")
    @NotNull(message = "orderArea must be fill")
    private Integer orderArea;
    @DecimalMin(value = "1", message = "owner floor must be min 1")
    @NotNull(message = "order floor must be fill")
    private Integer orderFloor;
    @Pattern(regexp = "^[a-zA-Z]+$", message = "order district must be only alph symb")
    private String orderDistrict;
}
