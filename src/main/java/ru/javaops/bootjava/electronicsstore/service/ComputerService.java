package ru.javaops.bootjava.electronicsstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.bootjava.electronicsstore.dto.ComputerDto;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateComputerDto;
import ru.javaops.bootjava.electronicsstore.dto.converter.ComputerDtoConverter;
import ru.javaops.bootjava.electronicsstore.exception.ComputerNotFoundException;
import ru.javaops.bootjava.electronicsstore.model.entity.ComputerEntity;
import ru.javaops.bootjava.electronicsstore.repository.ComputerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerDto addComputer(CreateUpdateComputerDto createUpdateComputerDto) {
        ComputerEntity computerEntity = ComputerDtoConverter.convertDtoToEntity(createUpdateComputerDto);

        computerEntity = computerRepository.save(computerEntity);

        return ComputerDtoConverter.convertEntityToDto(computerEntity);
    }

    public void deleteComputerById(UUID id) {
        boolean exists = computerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Computer with id " + id + " does not exists");
        }
        computerRepository.deleteById(id);
    }

    public ComputerDto updateComputer(UUID id, CreateUpdateComputerDto createUpdateComputerDto) {
        boolean exists = computerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Computer with id " + id + " does not exists");
        }
        ComputerEntity computerEntity = ComputerDtoConverter.convertDtoToEntityForUpdate(createUpdateComputerDto, id);
        computerEntity = computerRepository.save(computerEntity);
        return ComputerDtoConverter.convertEntityToDto(computerEntity);
    }

    public ComputerDto getComputerDtoById(UUID id) {
        ComputerEntity computerEntity = getComputerEntityById(id);

        return ComputerDtoConverter.convertEntityToDto(computerEntity);
    }

    public ComputerEntity getComputerEntityById(UUID id) {
        return computerRepository.findById(id)
                .orElseThrow(() -> new ComputerNotFoundException("Computer with id " + id + " does not exists"));
    }

    public List<ComputerDto> getAllComputers() {
        List<ComputerEntity> computerEntityList = computerRepository.findAll();
        List<ComputerDto> computerDtoList = new ArrayList<>();

        for (ComputerEntity computerEntity : computerEntityList) {
            computerDtoList.add(ComputerDtoConverter.convertEntityToDto(computerEntity));
        }

        return computerDtoList;
    }

}