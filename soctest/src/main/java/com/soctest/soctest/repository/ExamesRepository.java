package com.soctest.soctest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soctest.soctest.model.Exames;

import java.util.List;

@Repository
public interface ExamesRepository extends JpaRepository<Exames, Long> {
    List<Exames> findByNomePaciente(String nomePaciente);

@Query(value="select * from exames order by nome_paciente", nativeQuery = true)
    List<Exames> findAllByNomePacienteDesc();
    
    
}