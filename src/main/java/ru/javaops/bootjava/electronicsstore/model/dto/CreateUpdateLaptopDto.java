package ru.javaops.bootjava.electronicsstore.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.javaops.bootjava.electronicsstore.model.enumeration.LaptopSize;

@Data
public class CreateUpdateLaptopDto {

    @NotNull(message = "Series number is required")
    @Size(min = 1, message = "Series number should have at least 1 character")
    private String seriesNumber;

    @NotNull(message = "Fabricator is required")
    private String fabricator;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price should be greater than 0")
    private Integer price;

    @NotNull(message = "Number of units in stock is required")
    @Min(value = 0, message = "Number of units in stock should be greater than 0")
    private Integer numberOfUnitsInStock;

    @NotNull(message = "Size is required")
    private LaptopSize size;

}
