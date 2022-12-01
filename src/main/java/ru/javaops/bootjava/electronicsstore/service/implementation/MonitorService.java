package ru.javaops.bootjava.electronicsstore.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.bootjava.electronicsstore.model.dto.CreateUpdateMonitorDto;
import ru.javaops.bootjava.electronicsstore.model.dto.MonitorDto;
import ru.javaops.bootjava.electronicsstore.model.converter.MonitorDtoConverter;
import ru.javaops.bootjava.electronicsstore.model.entity.MonitorEntity;
import ru.javaops.bootjava.electronicsstore.exception.NotFoundException;
import ru.javaops.bootjava.electronicsstore.repository.MonitorRepository;
import ru.javaops.bootjava.electronicsstore.service.IMonitorService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MonitorService implements IMonitorService {

    private final MonitorRepository monitorRepository;

    public MonitorDto addMonitor(CreateUpdateMonitorDto createUpdateMonitorDto) {
        MonitorEntity monitorEntity = MonitorDtoConverter.convertDtoToEntity(createUpdateMonitorDto);
        monitorEntity = monitorRepository.save(monitorEntity);

        return MonitorDtoConverter.convertEntityToDto(monitorEntity);
    }

    public void deleteMonitorById(UUID id) {
        boolean exists = monitorRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("Monitor with id " + id + " does not exists");
        }
        monitorRepository.deleteById(id);
    }

    public MonitorDto updateMonitor(UUID id, CreateUpdateMonitorDto createUpdateMonitorDto) {
        boolean exists = monitorRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("Monitor with id " + id + " does not exists");
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
                .orElseThrow(() -> new NotFoundException("Monitor with id " + id + " does not exists"));
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
