package com.vetarinaria.demo.service;

import java.util.List;

import com.vetarinaria.demo.entity.Paciente;
import com.vetarinaria.demo.utils.Sexo;

public interface PacienteService {
	
	Integer guardar(Paciente paciente);
	Integer actualizar(Paciente paciente);
	Paciente consultarPorId(Long idPaciente);
	List<Paciente> consultarGeneral();
	List<Paciente> consultarPorSexo(String sexo);
	Integer eliminar(Long idPaciente);

}
