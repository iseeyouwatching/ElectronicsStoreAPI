package ru.javaops.bootjava.electronicsstore.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "hard_drive")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardDriveEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String capacity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity generalProperties;

}
