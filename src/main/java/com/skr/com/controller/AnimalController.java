package com.skr.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skr.com.dto.AnimalDTO;
import com.skr.com.entity.AnimalEntity;
import com.skr.com.service.AnimalService;


@RestController
@RequestMapping("animals")
public class AnimalController {
	
	@Autowired
	private AnimalService service;
	
	@GetMapping
	public List<AnimalDTO> getAnimals(){
		return service.getAllAnimals();
	}
	
	@GetMapping("/find/{id}")
	public AnimalDTO getAnimal(@PathVariable("id") int id) {
		return service.getAnimalById(id);
	}
	
	
	@PostMapping
	public AnimalDTO createAnimal(@RequestBody AnimalDTO animal) {
		return service.createAnimal(animal);
	}
	
	
	 @DeleteMapping(value="{idDelete}")
	 public String deleteAnimal(@PathVariable("idDelete") int id) {
		 return service.deleteAnimal(id);
	 }
	 
	 @PutMapping("{id}")
	 public String updateAnimal(@RequestBody AnimalDTO animal, @PathVariable("id") int id) {
		 return service.updateAnimal(animal,id);
	 }
	 
	 

}
