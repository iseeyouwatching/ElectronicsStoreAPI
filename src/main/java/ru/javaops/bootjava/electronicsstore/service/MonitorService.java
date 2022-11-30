package ru.javaops.bootjava.electronicsstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateMonitorDto;
import ru.javaops.bootjava.electronicsstore.dto.MonitorDto;
import ru.javaops.bootjava.electronicsstore.dto.converter.MonitorDtoConverter;
import ru.javaops.bootjava.electronicsstore.entity.MonitorEntity;
import ru.javaops.bootjava.electronicsstore.exception.MonitorNotFoundException;
import ru.javaops.bootjava.electronicsstore.repository.MonitorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorDto addMonitor(CreateUpdateMonitorDto createUpdateMonitorDto) {
        MonitorEntity monitorEntity = MonitorDtoConverter.convertDtoToEntity(createUpdateMonitorDto);
        monitorEntity = monitorRepository.save(monitorEntity);

        return MonitorDtoConverter.convertEntityToDto(monitorEntity);
    }

    public void deleteMonitorById(UUID id) {
        boolean exists = monitorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Monitor with id " + id + " does not exists");
        }
        monitorRepository.deleteById(id);
    }

    public MonitorDto updateMonitor(UUID id, CreateUpdateMonitorDto createUpdateMonitorDto) {
        boolean exists = monitorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Monitor with id " + id + " does not exists");
        }
        MonitorEntity monitorEntity = MonitorDtoConverter.convertDtoToEntityForUpdate(createUpdateMonitorDto, id);
        monitorEntity = monitorRepository.save(monitorEntity);

        return MonitorDtoConverter.convertEntityToDto(monitorEntity);
    }

    public MonitorDto getMonitorDtoById(UUID id) {
        MonitorEntity monitorEntity = getMonitorEntityById(id);

        return MonitorDtoConverter.convertEntityToDto(monitorEntity);
    }

    public MonitorEntity getMonitorEntityById(UUID id) {
        return monitorRepository.findById(id)
                .orElseThrow(() -> new MonitorNotFoundException("Monitor with id " + id + " does not exists"));
    }

    public List<MonitorDto> getAllMonitors() {
        List<MonitorEntity> monitorEntityList = monitorRepository.findAll();
        List<MonitorDto> monitorDtoList = new ArrayList<>();

        for (MonitorEntity monitorEntity : monitorEntityList) {
            monitorDtoList.add(MonitorDtoConverter.convertEntityToDto(monitorEntity));
        }

        return monitorDtoList;
    }

}
