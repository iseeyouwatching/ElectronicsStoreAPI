package ru.javaops.bootjava.electronicsstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.javaops.bootjava.electronicsstore.enumeration.ComputerFormFactor;

import java.util.UUID;

@Entity
@Table(name = "computer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputerEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "form_factor")
    private ComputerFormFactor formFactor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity generalProperties;

}
