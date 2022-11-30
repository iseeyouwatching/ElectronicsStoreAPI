package ru.javaops.bootjava.electronicsstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.javaops.bootjava.electronicsstore.enumeration.LaptopSize;

import java.util.UUID;

@Entity
@Table(name = "laptop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaptopEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private LaptopSize size;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity generalProperties;

}
