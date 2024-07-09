package com.example.nice.controller;

import com.example.nice.dto.AreaRequest;
import com.example.nice.dto.HeightDto;
import com.example.nice.service.AreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AreaController {

    private final AreaService areaService;

    @PostMapping("/heights")
    public ResponseEntity<Void> addHeight(@RequestBody HeightDto heightDto) {
        areaService.addHeight(heightDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/calculateArea")
    public ResponseEntity<Integer> calculateArea(@RequestBody AreaRequest areaRequest) {
        return ResponseEntity.ok(areaService.calculateArea(areaRequest.getIndex1(), areaRequest.getIndex2()));
    }

    @GetMapping("/heights")
    public ResponseEntity<List<HeightDto>> getAllHeights() {
        return ResponseEntity.ok(areaService.getAllHeights());
    }
}
