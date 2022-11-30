package ru.javaops.bootjava.electronicsstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "series_number", unique = true)
    private String seriesNumber;

    private String fabricator;
    private Integer price;

    @Column(name = "number_of_units_in_stock")
    private Integer numberOfUnitsInStock;
}
