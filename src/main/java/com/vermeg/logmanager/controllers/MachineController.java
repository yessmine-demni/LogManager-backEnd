package com.vermeg.logmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.logmanager.entities.Machine;
import com.vermeg.logmanager.repositories.MachineRepository;

@RestController
@CrossOrigin
@RequestMapping("machine")
public class MachineController {

	@Autowired
	private MachineRepository machineRepository;

	public MachineController(MachineRepository machineRepository) {
		this.machineRepository = machineRepository;
	}

	@PostMapping("/save")
	public Machine save(@RequestBody Machine machine) {
		return machineRepository.save(machine);
	}
	@GetMapping("/findById/{id}")
	public Machine findById(@PathVariable int id ) {
		return machineRepository.findById(id).get();
	}
	@DeleteMapping("/delete/{id}")
	public void deleteid(@PathVariable int id) {
		machineRepository.deleteById(id);
	}
	@GetMapping("/findAll")
	public List<Machine> findAll() {
		return machineRepository.findAll();
	}

}
