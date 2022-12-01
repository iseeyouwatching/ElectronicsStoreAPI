package ru.javaops.bootjava.electronicsstore.model.converter;

import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateMonitorDto;
import ru.javaops.bootjava.electronicsstore.model.dto.MonitorDto;
import ru.javaops.bootjava.electronicsstore.model.entity.MonitorEntity;
import ru.javaops.bootjava.electronicsstore.model.entity.ProductEntity;

import java.util.UUID;

public class MonitorDtoConverter {

    public static MonitorEntity convertDtoToEntity(CreateUpdateMonitorDto createUpdateMonitorDto) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateMonitorDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateMonitorDto.getFabricator());
        productEntity.setPrice(createUpdateMonitorDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateMonitorDto.getNumberOfUnitsInStock());

        MonitorEntity monitorEntity =  new MonitorEntity();
        monitorEntity.setId(UUID.randomUUID());
        monitorEntity.setGeneralProperties(productEntity);
        monitorEntity.setDiagonal(createUpdateMonitorDto.getDiagonal());

        return monitorEntity;
    }

    public static MonitorEntity convertDtoToEntityForUpdate(CreateUpdateMonitorDto createUpdateMonitorDto, UUID id) {

        ProductEntity productEntity = new ProductEntity();
        productEntity.setSeriesNumber(createUpdateMonitorDto.getSeriesNumber());
        productEntity.setFabricator(createUpdateMonitorDto.getFabricator());
        productEntity.setPrice(createUpdateMonitorDto.getPrice());
        productEntity.setNumberOfUnitsInStock(createUpdateMonitorDto.getNumberOfUnitsInStock());

        MonitorEntity monitorEntity =  new MonitorEntity();
        monitorEntity.setId(id);
        monitorEntity.setGeneralProperties(productEntity);
        monitorEntity.setDiagonal(createUpdateMonitorDto.getDiagonal());

        return monitorEntity;
    }

    public static MonitorDto convertEntityToDto(MonitorEntity monitorEntity) {

        MonitorDto monitorDto = new MonitorDto();
        monitorDto.setId(monitorEntity.getId());
        monitorDto.setSeriesNumber(monitorEntity.getGeneralProperties().getSeriesNumber());
        monitorDto.setFabricator(monitorEntity.getGeneralProperties().getFabricator());
        monitorDto.setPrice(monitorEntity.getGeneralProperties().getPrice());
        monitorDto.setNumberOfUnitsInStock(monitorEntity.getGeneralProperties().getNumberOfUnitsInStock());
        monitorDto.setDiagonal(monitorEntity.getDiagonal());

        return monitorDto;
    }

}
