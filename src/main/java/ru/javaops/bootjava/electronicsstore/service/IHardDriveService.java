package ru.javaops.bootjava.electronicsstore.service;

import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateHardDriveDto;
import ru.javaops.bootjava.electronicsstore.model.dto.HardDriveDto;
import ru.javaops.bootjava.electronicsstore.model.entity.HardDriveEntity;

import java.util.List;
import java.util.UUID;

public interface IHardDriveService {

    HardDriveDto addHardDrive(CreateUpdateHardDriveDto createUpdateHardDriveDto);

    void deleteHardDriveById(UUID id);

    HardDriveDto updateHardDrive(UUID id, CreateUpdateHardDriveDto createUpdateHardDriveDto);

    HardDriveDto getHardDriveDtoById(UUID id);

    HardDriveEntity getHardDriveEntityById(UUID id);

    List<HardDriveDto> getAllHardDrives();

}
