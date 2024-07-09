package com.example.nice.service.impl;

import com.example.nice.dto.HeightDto;
import com.example.nice.entity.Height;
import com.example.nice.service.AreaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nice.dao.HeightRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final HeightRepository heightRepository;

    @Override
    public void addHeight(HeightDto heightDto) {
        Height height = new Height();
        height.setValue(heightDto.getValue());
        heightRepository.save(height);
    }

    @Override
    public int calculateArea(int index1, int index2) {
        List<Height> heights = heightRepository.findAll();
        int area = 0;
        for (int i = index1; i <= index2; i++) {
            area += heights.get(i).getValue();
        }
        return area;
    }

    @Override
    public List<HeightDto> getAllHeights() {
        return heightRepository.findAll().stream()
                .map(height -> new HeightDto(height.getValue()))
                .collect(Collectors.toList());
    }
}
