package ru.javaops.bootjava.electronicsstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateLaptopDto;
import ru.javaops.bootjava.electronicsstore.dto.LaptopDto;
import ru.javaops.bootjava.electronicsstore.dto.converter.LaptopDtoConverter;
import ru.javaops.bootjava.electronicsstore.entity.LaptopEntity;
import ru.javaops.bootjava.electronicsstore.exception.LaptopNotFoundException;
import ru.javaops.bootjava.electronicsstore.repository.LaptopRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public LaptopDto addLaptop(CreateUpdateLaptopDto createUpdateLaptopDto) {
        LaptopEntity laptopEntity = LaptopDtoConverter.convertDtoToEntity(createUpdateLaptopDto);
        laptopEntity = laptopRepository.save(laptopEntity);

        return LaptopDtoConverter.convertEntityToDto(laptopEntity);
    }

    public void deleteLaptopById(UUID id) {
        boolean exists = laptopRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Laptop with id " + id + " does not exists");
        }
        laptopRepository.deleteById(id);
    }

    public LaptopDto updateLaptop(UUID id, CreateUpdateLaptopDto createUpdateLaptopDto) {
        boolean exists = laptopRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Laptop with id " + id + " does not exists");
        }
        LaptopEntity laptopEntity = LaptopDtoConverter.convertDtoToEntityForUpdate(createUpdateLaptopDto, id);
        laptopEntity = laptopRepository.save(laptopEntity);

        return LaptopDtoConverter.convertEntityToDto(laptopEntity);
    }

    public LaptopDto getLaptopDtoById(UUID id) {
        LaptopEntity laptopEntity = getLaptopEntityById(id);

        return LaptopDtoConverter.convertEntityToDto(laptopEntity);
    }

    public LaptopEntity getLaptopEntityById(UUID id) {
        return laptopRepository.findById(id)
                .orElseThrow(() -> new LaptopNotFoundException("Laptop with id " + id + " does not exists"));
    }

    public List<LaptopDto> getAllLaptops() {
        List<LaptopEntity> laptopEntityList = laptopRepository.findAll();
        List<LaptopDto> laptopDtoList = new ArrayList<>();

        for (LaptopEntity laptopEntity : laptopEntityList) {
            laptopDtoList.add(LaptopDtoConverter.convertEntityToDto(laptopEntity));
        }

        return laptopDtoList;
    }


}
