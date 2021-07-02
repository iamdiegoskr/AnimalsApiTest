package com.skr.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skr.com.dto.AnimalDTO;
import com.skr.com.entity.AnimalEntity;
import com.skr.com.repository.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository repo;
	
	public List<AnimalDTO> getAllAnimals(){
		
		List<AnimalDTO> animalsDto = new ArrayList<AnimalDTO>();
		
		List<AnimalEntity> Lstanimals = repo.findAll();
		
		
		for(AnimalEntity animal : Lstanimals) {
			
			AnimalDTO animalDTO = new AnimalDTO();
			
			animalDTO.setId(animal.getId());
			animalDTO.setName(animal.getName());
			animalDTO.setDescription(animal.getDescription());
			
			animalsDto.add(animalDTO);
			
			
			
		}
		
		return animalsDto;
		
		
	}

	public AnimalDTO createAnimal(AnimalDTO animalDto) {

		
		AnimalEntity animalEntity = new AnimalEntity();
		
		animalEntity.setName(animalDto.getName());
		animalEntity.setDescription(animalDto.getDescription());
		
		AnimalEntity animal = repo.save(animalEntity);
		
		animalDto.setId(animal.getId());
		
		return  animalDto;
		
	}
	
	public AnimalDTO getAnimalById(int id) {
		
		Optional<AnimalEntity> animalEntity = repo.findById(id);
		
		return new AnimalDTO(animalEntity.get().getId(),
				animalEntity.get().getName(),
				animalEntity.get().getDescription());
	}
	
	public String deleteAnimal(int id) {
		
		Optional<AnimalEntity> animal = repo.findById(id);
		
		if(animal.isPresent()) {
			repo.deleteById(id);
			return "Elemento eliminado con exito";
		}else {
			return "No existe el id que estas tratando de eliminar";
		}
		
	}
	
	public String updateAnimal(AnimalDTO animalDto, int id) {
		
		Optional<AnimalEntity> optionalAnimal = repo.findById(id);
		
		if(optionalAnimal.isPresent()) {
			
			AnimalEntity animal = optionalAnimal.get();
			
			animal.setName(animalDto.getName());
			animal.setDescription(animalDto.getDescription());
			
			repo.save(animal);
			
			return "Animal actualizado con exito";
			
		}else {
			
			return "No existe el id que estas tratando de actualizar";
			
		}
		
		
		
	}
}
