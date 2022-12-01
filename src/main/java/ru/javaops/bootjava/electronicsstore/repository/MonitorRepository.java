package ru.javaops.bootjava.electronicsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javaops.bootjava.electronicsstore.model.entity.MonitorEntity;

import java.util.UUID;

@Repository
public interface MonitorRepository extends JpaRepository<MonitorEntity, UUID> {
}
