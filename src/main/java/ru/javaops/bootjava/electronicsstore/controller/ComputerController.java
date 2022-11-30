    package ru.javaops.bootjava.electronicsstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javaops.bootjava.electronicsstore.dto.ComputerDto;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateComputerDto;
import ru.javaops.bootjava.electronicsstore.service.ComputerService;

import java.util.List;
import java.util.UUID;

@Tag(name = "Computers")
@RestController
@RequestMapping("/api/computers")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @Operation(summary = "Get all computers")
    @GetMapping
    public List<ComputerDto> getComputers() {
        return computerService.getAllComputers();
    }

    @Operation(summary = "Add computer")
    @PostMapping
    public ComputerDto addComputer(@RequestBody CreateUpdateComputerDto createUpdateComputerDto) {
        return computerService.addComputer(createUpdateComputerDto);
    }

    @Operation(summary = "Delete computer")
    @DeleteMapping(path = "{id}")
    public void deleteComputer(@PathVariable("id") UUID computerId) {
        computerService.deleteComputerById(computerId);
    }

    @Operation(summary = "Update computer properties")
    @PutMapping(path = "{id}")
    public ComputerDto updateDetailsOfComputer(@PathVariable("id") UUID computerId, @RequestBody CreateUpdateComputerDto createUpdateComputerDto) {
        return computerService.updateComputer(computerId, createUpdateComputerDto);
    }

    @Operation(summary = "Get computer by id")
    @GetMapping(path = "{id}")
    public ComputerDto getComputer(@PathVariable("id") UUID computerId) {
        return computerService.getComputerDtoById(computerId);
    }
}
