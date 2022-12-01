package ru.javaops.bootjava.electronicsstore.service;

import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateLaptopDto;
import ru.javaops.bootjava.electronicsstore.dto.LaptopDto;
import ru.javaops.bootjava.electronicsstore.entity.LaptopEntity;

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
