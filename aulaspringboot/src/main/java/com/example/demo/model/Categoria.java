package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoriaID")
	private Integer categoriaId;
	
	@Column(name = "Descricao")
	private String descricao;
	
	@Column(name = "Dt_Inclusao")
	@Temporal(TemporalType.DATE)
	private Date dataDeInclusao;
	
	public Categoria() {

	}

	public Categoria(Integer categoriaId, String descricao, Date dataDeInclusao) {
		super();
		this.categoriaId = categoriaId;
		this.descricao = descricao;
		this.dataDeInclusao = dataDeInclusao;
	}

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataDeInsercao() {
		return dataDeInclusao;
	}

	public void setDataDeInsercao(Date dataDeInclusao) {
		this.dataDeInclusao = dataDeInclusao;
	}

	@Override
	public String toString() {
		return "Categoria [categoriaId=" + categoriaId 
				+ ", descricao=" + descricao 
				+ ", dataDeInclusao=" + dataDeInclusao + "]";
	}
	
}

