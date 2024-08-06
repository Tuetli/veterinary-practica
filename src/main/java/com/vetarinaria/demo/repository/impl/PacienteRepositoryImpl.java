package com.vetarinaria.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vetarinaria.demo.entity.Paciente;
import com.vetarinaria.demo.repository.PacienteRepository;
import com.vetarinaria.demo.utils.Sexo;

import jakarta.persistence.EntityManager;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {
	
	@Autowired
	EntityManager em;

	@Override
	@Transactional
	public Integer guardar(Paciente paciente) {
		em.persist(paciente);
		return 1;
	}

	@Override
	@Transactional
	public Integer actualizar(Paciente paciente) {
		em.merge(paciente);
		return 1;
	}

	@Override
	@Transactional
	public Paciente consultarPorId(Long idPaciente) {
		return em.createQuery("FROM Paciente p WHERE p.id = :idPaciente", Paciente.class)
				.setParameter("idPaciente", idPaciente).getSingleResult();
	}

	@Override
	@Transactional
	public List<Paciente> consultarGeneral() {
		return em.createQuery("FROM Paciente", Paciente.class)
				.getResultList();
	}

	@Override
	@Transactional
	public List<Paciente> consultarPorSexo(Sexo sexo) {
		return em.createQuery("FROM Paciente WHERE sexo = :sexo", Paciente.class)
				.setParameter("sexo", sexo).getResultList();
	}

	@Override
	@Transactional
	public Integer eliminar(Paciente paciente) {
		em.remove(paciente);
		return 1;
	}
	
	

}
