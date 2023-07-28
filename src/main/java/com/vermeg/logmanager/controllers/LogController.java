package com.vermeg.logmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.logmanager.entities.Log;
import com.vermeg.logmanager.repositories.LogRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("log")
public class LogController {
	@Autowired
	private LogRepository logRepository;

	public LogController(LogRepository logRepository) {
		this.logRepository = logRepository;
	}

	@PostMapping("/save")
	public Log save(@RequestBody Log log) {
		return logRepository.save(log);
	}

	@GetMapping("/findById/{id}")
	public Log findById(@PathVariable int id) {
		return logRepository.findById(id).get();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteid(@PathVariable int id) {
		logRepository.deleteById(id);
	}

	@GetMapping("/findAll")
	public List<Log> findall() {
		return logRepository.findAll();
	}

	@PutMapping("/update")
	public Log updateEntity(@RequestBody Log updatedEntity) {
		int entityId = updatedEntity.getId();
		Log existingEntity = logRepository.findById(entityId)
				.orElseThrow(() -> new EntityNotFoundException("Entity not found with ID: " + entityId));

		existingEntity.setName(updatedEntity.getName());
		existingEntity.setPath(updatedEntity.getPath());

		return logRepository.save(existingEntity);
	}
}
