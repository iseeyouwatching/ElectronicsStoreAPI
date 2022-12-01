package ru.javaops.bootjava.electronicsstore.service;

import ru.javaops.bootjava.electronicsstore.model.dto.ComputerDto;
import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateComputerDto;
import ru.javaops.bootjava.electronicsstore.model.entity.ComputerEntity;

import java.util.List;
import java.util.UUID;

public interface IComputerService {

    ComputerDto addComputer(CreateUpdateComputerDto createUpdateComputerDto);

    void deleteComputerById(UUID id);

    ComputerDto updateComputer(UUID id, CreateUpdateComputerDto createUpdateComputerDto);

    ComputerDto getComputerDtoById(UUID id);

    ComputerEntity getComputerEntityById(UUID id);

    List<ComputerDto> getAllComputers();

}
