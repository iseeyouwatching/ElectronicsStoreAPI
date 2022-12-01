package ru.javaops.bootjava.electronicsstore.model.converter;

import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateHardDriveDto;
import ru.javaops.bootjava.electronicsstore.model.dto.HardDriveDto;
import ru.javaops.bootjava.electronicsstore.model.entity.HardDriveEntity;
import ru.javaops.bootjava.electronicsstore.model.entity.ProductEntity;

import java.util.UUID;

public class HardDriveDtoConverter {

    public static HardDriveEntity convertDtoToEntity(CreateUpdateHardDriveDto createUpdateHardDriveDto) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateHardDriveDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateHardDriveDto.getFabricator());
        productEntity.setPrice(createUpdateHardDriveDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateHardDriveDto.getNumberOfUnitsInStock());

        HardDriveEntity hardDriveEntity =  new HardDriveEntity();
        hardDriveEntity.setId(UUID.randomUUID());
        hardDriveEntity.setGeneralProperties(productEntity);
        hardDriveEntity.setCapacity(createUpdateHardDriveDto.getCapacity());

        return hardDriveEntity;
    }

    public static HardDriveEntity convertDtoToEntityForUpdate(CreateUpdateHardDriveDto createUpdateHardDriveDto, UUID id) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateHardDriveDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateHardDriveDto.getFabricator());
        productEntity.setPrice(createUpdateHardDriveDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateHardDriveDto.getNumberOfUnitsInStock());

        HardDriveEntity hardDriveEntity =  new HardDriveEntity();
        hardDriveEntity.setId(id);
        hardDriveEntity.setGeneralProperties(productEntity);
        hardDriveEntity.setCapacity(createUpdateHardDriveDto.getCapacity());

        return hardDriveEntity;
    }

    public static HardDriveDto convertEntityToDto(HardDriveEntity hardDriveEntity) {

        HardDriveDto hardDriveDto = new HardDriveDto();
        hardDriveDto.setId(hardDriveEntity.getId());
        hardDriveDto.setSeriesNumber(hardDriveEntity.getGeneralProperties().getSeriesNumber());
        hardDriveDto.setFabricator(hardDriveEntity.getGeneralProperties().getFabricator());
        hardDriveDto.setPrice(hardDriveEntity.getGeneralProperties().getPrice());
        hardDriveDto.setNumberOfUnitsInStock(hardDriveEntity.getGeneralProperties().getNumberOfUnitsInStock());
        hardDriveDto.setCapacity(hardDriveEntity.getCapacity());

        return hardDriveDto;
    }

}
