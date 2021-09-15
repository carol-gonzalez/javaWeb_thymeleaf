package com.soctest.soctest.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


@Entity
@Table(name = "exames")
public class Exames {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

	    @NotBlank
		@Column(unique=true, name = "nomePaciente")
	    private String nomePaciente;

	    @NotNull
	    @Past
	    @Column(name = "dataNascimento")
		private LocalDate dataNascimento;
	    
	    @NotNull
	    @Column(name = "contato")
	    private String contato;
	    
	    @NotBlank
	    @Column(name = "nomeExame")
	    private String nomeExame;
	    
	    @NotNull
		@Future
	    @Column(name = "dataExame")
		private LocalDate dataExame;
	    
	    @Column(name = "resultadoExame")
		private String resultadoExame;
	    
	    public Exames() {}

	    public Exames(String nomePaciente, LocalDate dataNascimento, String contato, String nomeExame, LocalDate dataExame) {
	        this.nomePaciente = nomePaciente;
	        this.dataNascimento = dataNascimento;
	        this.contato = contato;
	        this.nomeExame = nomeExame;
	        this.dataExame = dataExame;
	    }

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNomePaciente() {
			return nomePaciente;
		}

		public void setNomePaciente(String nomePaciente) {
			this.nomePaciente = nomePaciente;
		}

		public LocalDate getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}

		public String getContato() {
			return contato;
		}

		public void setContato(String contato) {
			this.contato = contato;
		}

		public String getNomeExame() {
			return nomeExame;
		}

		public void setNomeExame(String nomeExame) {
			this.nomeExame = nomeExame;
		}

		public LocalDate getDataExame() {
			return dataExame;
		}

		public void setDataExame(LocalDate dataExame) {
			this.dataExame = dataExame;
		}

		public String getResultadoExame() {
			return resultadoExame;
		}

		public void setResultadoExame(String resultadoExame) {
			this.resultadoExame = resultadoExame;
		}
	    
	    
}
