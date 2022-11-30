package ru.javaops.bootjava.electronicsstore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUpdateHardDriveDto {

    @NotNull(message = "Series number should not be null")
    @Size(min = 1, message = "Series number should have at least 1 character")
    private String seriesNumber;

    private String fabricator;

    @Min(value = 0, message = "Price should be greater than 0")
    private Integer price;

    @Min(value = 0, message = "Number of units in stock should be greater than 0")
    private Integer numberOfUnitsInStock;

    private String capacity;


}
