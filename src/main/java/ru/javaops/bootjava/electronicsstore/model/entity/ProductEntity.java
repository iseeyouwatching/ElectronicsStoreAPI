package ru.javaops.bootjava.electronicsstore.model.entity;

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
    @Column(name = "id")
    @GeneratedValue
    private UUID uuid;

    @Column(name = "series_number")
    private String seriesNumber;

    private String fabricator;

    private Integer price;

    @Column(name = "number_of_units_in_stock")
    private Integer numberOfUnitsInStock;
}
