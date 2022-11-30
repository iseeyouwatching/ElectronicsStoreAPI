package ru.javaops.bootjava.electronicsstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateHardDriveDto;
import ru.javaops.bootjava.electronicsstore.dto.HardDriveDto;
import ru.javaops.bootjava.electronicsstore.dto.converter.HardDriveDtoConverter;
import ru.javaops.bootjava.electronicsstore.entity.HardDriveEntity;
import ru.javaops.bootjava.electronicsstore.exception.NotFoundException;
import ru.javaops.bootjava.electronicsstore.repository.HardDriveRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HardDriveService {

    private final HardDriveRepository hardDriveRepository;

    public HardDriveDto addHardDrive(CreateUpdateHardDriveDto createUpdateHardDriveDto) {
        HardDriveEntity hardDriveEntity = HardDriveDtoConverter.convertDtoToEntity(createUpdateHardDriveDto);
        hardDriveEntity = hardDriveRepository.save(hardDriveEntity);

        return HardDriveDtoConverter.convertEntityToDto(hardDriveEntity);
    }

    public void deleteHardDriveById(UUID id) {
        boolean exists = hardDriveRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Hard drive with id " + id + " does not exists");
        }
        hardDriveRepository.deleteById(id);
    }

    public HardDriveDto updateHardDrive(UUID id, CreateUpdateHardDriveDto createUpdateHardDriveDto) {
        boolean exists = hardDriveRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Hard drive with id " + id + " does not exists");
        }
        HardDriveEntity hardDriveEntity = HardDriveDtoConverter.convertDtoToEntityForUpdate(createUpdateHardDriveDto, id);
        hardDriveEntity = hardDriveRepository.save(hardDriveEntity);

        return HardDriveDtoConverter.convertEntityToDto(hardDriveEntity);
    }

    public HardDriveDto getHardDriveDtoById(UUID id) {
        HardDriveEntity hardDriveEntity = getHardDriveEntityById(id);

        return HardDriveDtoConverter.convertEntityToDto(hardDriveEntity);
    }

    public HardDriveEntity getHardDriveEntityById(UUID id) {
        return hardDriveRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hard drive with id " + id + " does not exists"));
    }

    public List<HardDriveDto> getAllHardDrives() {
        List<HardDriveEntity> hardDriveEntityList = hardDriveRepository.findAll();
        List<HardDriveDto> hardDriveDtoList = new ArrayList<>();

        for (HardDriveEntity hardDriveEntity : hardDriveEntityList) {
            hardDriveDtoList.add(HardDriveDtoConverter.convertEntityToDto(hardDriveEntity));
        }

        return hardDriveDtoList;
    }

}
