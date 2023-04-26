package com.devsuperior.userdept.entitiesDTO;



import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;

	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	@Column(name = "date_created")
	private String dataAtual;

	
	@ManyToOne
	@JoinColumn(name = "id_contato")
	private Contato contato;

	public Cliente() {

	}
	
	public String getDataAtual() {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		String dataformatada = formatar.format(data);
		
		dataAtual = dataformatada;
		return dataAtual;
	}

	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
