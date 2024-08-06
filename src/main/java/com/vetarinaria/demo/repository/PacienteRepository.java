package com.vetarinaria.demo.repository;

import java.util.List;

import com.vetarinaria.demo.entity.Paciente;
import com.vetarinaria.demo.utils.Sexo;

public interface PacienteRepository {
	
	Integer guardar(Paciente paciente);
	Integer actualizar(Paciente paciente);
	Paciente consultarPorId(Long idPaciente);
	List<Paciente> consultarGeneral();
	List<Paciente> consultarPorSexo(Sexo sexo);
	Integer eliminar(Paciente paciente);

}
