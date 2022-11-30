package ru.javaops.bootjava.electronicsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javaops.bootjava.electronicsstore.entity.ComputerEntity;

import java.util.UUID;

@Repository
public interface ComputerRepository extends JpaRepository<ComputerEntity, UUID> {
}
