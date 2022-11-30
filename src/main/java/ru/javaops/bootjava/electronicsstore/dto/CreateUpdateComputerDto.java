package ru.javaops.bootjava.electronicsstore.dto;

import lombok.Data;
import ru.javaops.bootjava.electronicsstore.enumeration.ComputerFormFactor;

@Data
public class CreateUpdateComputerDto {

    private String seriesNumber;
    private String fabricator;
    private Integer price;
    private Integer numberOfUnitsInStock;
    private ComputerFormFactor formFactor;

}
