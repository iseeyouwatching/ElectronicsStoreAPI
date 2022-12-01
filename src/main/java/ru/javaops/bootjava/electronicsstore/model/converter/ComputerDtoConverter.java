package ru.javaops.bootjava.electronicsstore.model.converter;

import ru.javaops.bootjava.electronicsstore.model.dto.ComputerDto;
import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateComputerDto;
import ru.javaops.bootjava.electronicsstore.model.entity.ComputerEntity;
import ru.javaops.bootjava.electronicsstore.model.entity.ProductEntity;

import java.util.UUID;

public class ComputerDtoConverter {

    public static ComputerEntity convertDtoToEntity(CreateUpdateComputerDto createUpdateComputerDto) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateComputerDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateComputerDto.getFabricator());
        productEntity.setPrice(createUpdateComputerDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateComputerDto.getNumberOfUnitsInStock());

        ComputerEntity computerEntity =  new ComputerEntity();
        computerEntity.setId(UUID.randomUUID());
        computerEntity.setGeneralProperties(productEntity);
        computerEntity.setFormFactor(createUpdateComputerDto.getFormFactor());

        return computerEntity;
    }

    public static ComputerEntity convertDtoToEntityForUpdate(CreateUpdateComputerDto createUpdateComputerDto, UUID id) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateComputerDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateComputerDto.getFabricator());
        productEntity.setPrice(createUpdateComputerDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateComputerDto.getNumberOfUnitsInStock());

        ComputerEntity computerEntity =  new ComputerEntity();
        computerEntity.setId(id);
        computerEntity.setGeneralProperties(productEntity);
        computerEntity.setFormFactor(createUpdateComputerDto.getFormFactor());

        return computerEntity;
    }

    public static ComputerDto convertEntityToDto(ComputerEntity computerEntity) {

        ComputerDto computerDto = new ComputerDto();
        computerDto.setId(computerEntity.getId());
        computerDto.setSeriesNumber(computerEntity.getGeneralProperties().getSeriesNumber());
        computerDto.setFabricator(computerEntity.getGeneralProperties().getFabricator());
        computerDto.setPrice(computerEntity.getGeneralProperties().getPrice());
        computerDto.setNumberOfUnitsInStock(computerEntity.getGeneralProperties().getNumberOfUnitsInStock());
        computerDto.setFormFactor(computerEntity.getFormFactor());

        return computerDto;
    }


}
