package ru.javaops.bootjava.electronicsstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.javaops.bootjava.electronicsstore.enumeration.ComputerFormFactor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDto {

    private UUID id;
    private String seriesNumber;
    private String fabricator;
    private Integer price;
    private Integer numberOfUnitsInStock;
    private ComputerFormFactor formFactor;

}
