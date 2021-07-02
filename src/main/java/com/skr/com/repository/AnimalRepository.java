package com.skr.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skr.com.entity.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Integer> {

}
