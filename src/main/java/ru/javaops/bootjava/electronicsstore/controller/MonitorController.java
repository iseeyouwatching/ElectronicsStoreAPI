package ru.javaops.bootjava.electronicsstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateMonitorDto;
import ru.javaops.bootjava.electronicsstore.dto.MonitorDto;
import ru.javaops.bootjava.electronicsstore.service.implementation.MonitorService;

import java.util.List;
import java.util.UUID;

@Tag(name = "Monitors")
@RestController
@RequestMapping("/api/monitors")
@RequiredArgsConstructor
public class MonitorController {

    private final MonitorService monitorService;

    @Operation(summary = "Get all monitors")
    @GetMapping
    public List<MonitorDto> getMonitors() {
        return monitorService.getAllMonitors();
    }

    @Operation(summary = "Add monitor")
    @PostMapping
    public MonitorDto addMonitor(@RequestBody @Valid CreateUpdateMonitorDto createUpdateMonitorDto) {
        return monitorService.addMonitor(createUpdateMonitorDto);
    }

    @Operation(summary = "Delete monitor")
    @DeleteMapping(path = "{id}")
    public void deleteMonitor(@PathVariable("id") UUID monitorId) {
        monitorService.deleteMonitorById(monitorId);
    }

    @Operation(summary = "Update monitor properties")
    @PutMapping(path = "{id}")
    public MonitorDto updateDetailsOfMonitor(@PathVariable("id") UUID monitorId, @RequestBody @Valid CreateUpdateMonitorDto createUpdateMonitorDto) {
        return monitorService.updateMonitor(monitorId, createUpdateMonitorDto);
    }

    @Operation(summary = "Get monitor by id")
    @GetMapping(path = "{id}")
    public MonitorDto getMonitor(@PathVariable("id") UUID monitorId) {
        return monitorService.getMonitorDtoById(monitorId);
    }

}
