package ru.javaops.bootjava.electronicsstore.dto;

import lombok.Data;
import ru.javaops.bootjava.electronicsstore.enumeration.LaptopSize;

@Data
public class CreateUpdateLaptopDto {

    private String seriesNumber;
    private String fabricator;
    private Integer price;
    private Integer numberOfUnitsInStock;
    private LaptopSize size;

}
