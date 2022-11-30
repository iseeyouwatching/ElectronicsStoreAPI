package ru.javaops.bootjava.electronicsstore.dto.converter;

import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateLaptopDto;
import ru.javaops.bootjava.electronicsstore.dto.LaptopDto;
import ru.javaops.bootjava.electronicsstore.entity.LaptopEntity;
import ru.javaops.bootjava.electronicsstore.entity.ProductEntity;

import java.util.UUID;

public class LaptopDtoConverter {

    public static LaptopEntity convertDtoToEntity(CreateUpdateLaptopDto createUpdateLaptopDto) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateLaptopDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateLaptopDto.getFabricator());
        productEntity.setPrice(createUpdateLaptopDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateLaptopDto.getNumberOfUnitsInStock());

        LaptopEntity laptopEntity =  new LaptopEntity();
        laptopEntity.setId(UUID.randomUUID());
        laptopEntity.setGeneralProperties(productEntity);
        laptopEntity.setSize(createUpdateLaptopDto.getSize());

        return laptopEntity;
    }

    public static LaptopEntity convertDtoToEntityForUpdate(CreateUpdateLaptopDto createUpdateLaptopDto, UUID id) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateLaptopDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateLaptopDto.getFabricator());
        productEntity.setPrice(createUpdateLaptopDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateLaptopDto.getNumberOfUnitsInStock());

        LaptopEntity laptopEntity =  new LaptopEntity();
        laptopEntity.setId(id);
        laptopEntity.setGeneralProperties(productEntity);
        laptopEntity.setSize(createUpdateLaptopDto.getSize());

        return laptopEntity;
    }

    public static LaptopDto convertEntityToDto(LaptopEntity laptopEntity) {

        LaptopDto laptopDto = new LaptopDto();
        laptopDto.setId(laptopEntity.getId());
        laptopDto.setSeriesNumber(laptopEntity.getGeneralProperties().getSeriesNumber());
        laptopDto.setFabricator(laptopEntity.getGeneralProperties().getFabricator());
        laptopDto.setPrice(laptopEntity.getGeneralProperties().getPrice());
        laptopDto.setNumberOfUnitsInStock(laptopEntity.getGeneralProperties().getNumberOfUnitsInStock());
        laptopDto.setSize(laptopEntity.getSize());

        return laptopDto;
    }

}
