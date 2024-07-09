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

        if (index1 < 0 || index2 >= heights.size() || index1 >= index2) {
            throw new IllegalArgumentException("Invalid indices for area calculation.");
        }

//        int leftMax = heights.get(index1).getValue();
//        int rightMax = heights.get(index2).getValue();
//        int minHeight = Math.min(leftMax, rightMax);
//
//        int area = 0;
//
//        for (int i = index1 + 1; i < index2; i++) {
//            area += minHeight - heights.get(i).getValue();
//        }

        int width = index2 - index1;
        int height = Math.min(heights.get(index1).getValue(), heights.get(index2).getValue());

        return width * height;
    }

    @Override
    public List<HeightDto> getAllHeights() {
        return heightRepository.findAll().stream()
                .map(height -> new HeightDto(height.getValue()))
                .collect(Collectors.toList());
    }
}
