package com.example.nice.dao;

import com.example.nice.entity.Height;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeightRepository extends JpaRepository<Height, Long> {
}
