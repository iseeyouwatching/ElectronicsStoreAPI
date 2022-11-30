package ru.javaops.bootjava.electronicsstore.dto;

import lombok.Data;

@Data
public class CreateUpdateHardDriveDto {

    private String seriesNumber;
    private String fabricator;
    private Integer price;
    private Integer numberOfUnitsInStock;
    private String capacity;


}
