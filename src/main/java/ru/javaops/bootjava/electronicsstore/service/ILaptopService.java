package ru.javaops.bootjava.electronicsstore.service;

import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateLaptopDto;
import ru.javaops.bootjava.electronicsstore.model.dto.LaptopDto;
import ru.javaops.bootjava.electronicsstore.model.entity.LaptopEntity;

import java.util.List;
import java.util.UUID;

public interface ILaptopService {

    LaptopDto addLaptop(CreateUpdateLaptopDto createUpdateLaptopDto);

    void deleteLaptopById(UUID id);

    LaptopDto updateLaptop(UUID id, CreateUpdateLaptopDto createUpdateLaptopDto);

    LaptopDto getLaptopDtoById(UUID id);

    LaptopEntity getLaptopEntityById(UUID id);

    List<LaptopDto> getAllLaptops();


}
