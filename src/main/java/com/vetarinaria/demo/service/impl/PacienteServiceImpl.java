package com.vetarinaria.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vetarinaria.demo.entity.Paciente;
import com.vetarinaria.demo.repository.PacienteRepository;
import com.vetarinaria.demo.service.PacienteService;
import com.vetarinaria.demo.utils.Sexo;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	@Transactional
	public Integer guardar(Paciente paciente) {
		return pacienteRepository.guardar(paciente);
	}

	@Override
	@Transactional
	public Integer actualizar(Paciente paciente) {
		return pacienteRepository.actualizar(paciente);
	}

	@Override
	@Transactional
	public Paciente consultarPorId(Long idPaciente) {
		return pacienteRepository.consultarPorId(idPaciente);
	}

	@Override
	@Transactional
	public List<Paciente> consultarGeneral() {
		return pacienteRepository.consultarGeneral();
	}

	@Override
	@Transactional
	public List<Paciente> consultarPorSexo(String sexo) {
		Sexo sex = Sexo.valueOf(sexo);
		return pacienteRepository.consultarPorSexo(sex);
	}

	@Override
	@Transactional
	public Integer eliminar(Long idPaciente) {
		Paciente paciente = pacienteRepository.consultarPorId(idPaciente);
		return pacienteRepository.eliminar(paciente);
	}

}
