package ru.javaops.bootjava.electronicsstore.service;

import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateMonitorDto;
import ru.javaops.bootjava.electronicsstore.dto.MonitorDto;
import ru.javaops.bootjava.electronicsstore.entity.MonitorEntity;

import java.util.List;
import java.util.UUID;

public interface IMonitorService {

    MonitorDto addMonitor(CreateUpdateMonitorDto createUpdateMonitorDto);

    void deleteMonitorById(UUID id);

    MonitorDto updateMonitor(UUID id, CreateUpdateMonitorDto createUpdateMonitorDto);

    MonitorDto getMonitorDtoById(UUID id);

    MonitorEntity getMonitorEntityById(UUID id);

    List<MonitorDto> getAllMonitors();
}
