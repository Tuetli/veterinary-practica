package com.vetarinaria.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetarinaria.demo.entity.Paciente;
import com.vetarinaria.demo.service.PacienteService;

@RestController
@RequestMapping(value = "paciente")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@PostMapping("/registros")
	public Integer guardar(@RequestBody Paciente paciente) {
		return pacienteService.guardar(paciente);
	}
	
	@PutMapping("/actualizaciones")
	Integer actualizar(@RequestBody Paciente paciente) {
		return pacienteService.actualizar(paciente);
	}
	
	@GetMapping("/consultas-id/{idPaciente}")
	Paciente consultarPorId(@PathVariable Long idPaciente) {
		return pacienteService.consultarPorId(idPaciente);
	}
	
	@GetMapping("/consultas-general")
	List<Paciente> consultarGeneral() {
		return pacienteService.consultarGeneral();
	}
	
	@GetMapping("/consultas-sexo")
	List<Paciente> consultarPorSexo(@RequestParam String sexo) {
		return pacienteService.consultarPorSexo(sexo);
	}
	
	@DeleteMapping("/eliminaciones/{idPaciente}")
	Integer eliminar(@PathVariable Long idPaciente) {
		return pacienteService.eliminar(idPaciente);
	}

}
