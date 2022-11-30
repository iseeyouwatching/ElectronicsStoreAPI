package ru.javaops.bootjava.electronicsstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javaops.bootjava.electronicsstore.dto.CreateUpdateLaptopDto;
import ru.javaops.bootjava.electronicsstore.dto.LaptopDto;
import ru.javaops.bootjava.electronicsstore.service.LaptopService;

import java.util.List;
import java.util.UUID;

@Tag(name = "Laptops")
@RestController
@RequestMapping("/api/laptops")
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopService laptopService;

    @Operation(summary = "Get all laptops")
    @GetMapping
    public List<LaptopDto> getLaptops() {
        return laptopService.getAllLaptops();
    }

    @Operation(summary = "Add laptop")
    @PostMapping
    public LaptopDto addLaptop(@RequestBody CreateUpdateLaptopDto createUpdateLaptopDto) {
        return laptopService.addLaptop(createUpdateLaptopDto);
    }

    @Operation(summary = "Delete laptop")
    @DeleteMapping(path = "{id}")
    public void deleteLaptop(@PathVariable("id") UUID laptopId) {
        laptopService.deleteLaptopById(laptopId);
    }

    @Operation(summary = "Update laptop properties")
    @PutMapping(path = "{id}")
    public LaptopDto updateDetailsOfLaptop(@PathVariable("id") UUID laptopId, @RequestBody CreateUpdateLaptopDto createUpdateLaptopDto) {
        return laptopService.updateLaptop(laptopId, createUpdateLaptopDto);
    }

    @Operation(summary = "Get laptop by id")
    @GetMapping(path = "{id}")
    public LaptopDto getLaptop(@PathVariable("id") UUID laptopId) {
        return laptopService.getLaptopDtoById(laptopId);
    }

}
