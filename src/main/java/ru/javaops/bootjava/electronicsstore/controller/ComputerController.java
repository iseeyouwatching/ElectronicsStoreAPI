    package ru.javaops.bootjava.electronicsstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javaops.bootjava.electronicsstore.dto.ComputerDto;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateComputerDto;
import ru.javaops.bootjava.electronicsstore.service.ComputerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/computers")
@RequiredArgsConstructor
public class ComputerController {

    private final ComputerService computerService;

    @GetMapping
    public List<ComputerDto> getComputers() {
        return computerService.getAllComputers();
    }

    @PostMapping
    public ComputerDto addComputer(@RequestBody CreateUpdateComputerDto createUpdateComputerDto) {
        return computerService.addComputer(createUpdateComputerDto);
    }

    @DeleteMapping(path = "{id}")
    public void deleteComputer(@PathVariable("id") UUID computerId) {
        computerService.deleteComputerById(computerId);
    }

    @PutMapping(path = "{id}")
    public ComputerDto updateDetailsOfComputer(@PathVariable("id") UUID computerId, @RequestBody CreateUpdateComputerDto createUpdateComputerDto) {
        return computerService.updateComputer(computerId, createUpdateComputerDto);
    }

    @GetMapping(path = "{id}")
    public ComputerDto getComputer(@PathVariable("id") UUID computerId) {
        return computerService.getComputerDtoById(computerId);
    }
}
