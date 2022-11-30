package ru.javaops.bootjava.electronicsstore.dto;

import lombok.Data;


@Data
public class CreateUpdateMonitorDto {

    private String seriesNumber;
    private String fabricator;
    private Integer price;
    private Integer numberOfUnitsInStock;
    private double diagonal;

}