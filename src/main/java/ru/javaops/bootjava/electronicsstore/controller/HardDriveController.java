package ru.javaops.bootjava.electronicsstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateHardDriveDto;
import ru.javaops.bootjava.electronicsstore.dto.HardDriveDto;
import ru.javaops.bootjava.electronicsstore.service.HardDriveService;

import java.util.List;
import java.util.UUID;

@Tag(name = "Hard drives")
@RestController
@RequestMapping("/api/hard_drives")
@RequiredArgsConstructor
public class HardDriveController {

    private final HardDriveService hardDriveService;

    @Operation(summary = "Get all hard drives")
    @GetMapping
    public List<HardDriveDto> getHardDrives() {
        return hardDriveService.getAllHardDrives();
    }

    @Operation(summary = "Add hard drive")
    @PostMapping
    public HardDriveDto addHardDrive(@RequestBody @Valid CreateUpdateHardDriveDto createUpdateHardDriveDto) {
        return hardDriveService.addHardDrive(createUpdateHardDriveDto);
    }

    @Operation(summary = "Delete hard drive")
    @DeleteMapping(path = "{id}")
    public void deleteComputer(@PathVariable("id") UUID hardDriveId) {
        hardDriveService.deleteHardDriveById(hardDriveId);
    }

    @Operation(summary = "Update hard drive properties")
    @PutMapping(path = "{id}")
    public HardDriveDto updateDetailsOfHardDrive(@PathVariable("id") UUID hardDriveId, @RequestBody @Valid CreateUpdateHardDriveDto createUpdateHardDriveDto) {
        return hardDriveService.updateHardDrive(hardDriveId, createUpdateHardDriveDto);
    }

    @Operation(summary = "Get hard drive by id")
    @GetMapping(path = "{id}")
    public HardDriveDto getHardDrive(@PathVariable("id") UUID hardDriveId) {
        return hardDriveService.getHardDriveDtoById(hardDriveId);
    }

}
