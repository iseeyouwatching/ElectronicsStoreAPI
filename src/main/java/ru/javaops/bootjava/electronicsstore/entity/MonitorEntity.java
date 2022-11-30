package ru.javaops.bootjava.electronicsstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "monitor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonitorEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private double diagonal;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity generalProperties;

}
