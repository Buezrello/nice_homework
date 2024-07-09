package com.example.nice.service;

import com.example.nice.dto.HeightDto;

import java.util.List;

public interface AreaService {
    void addHeight(HeightDto heightDto);
    int calculateArea(int index1, int index2);
    List<HeightDto> getAllHeights();
}
