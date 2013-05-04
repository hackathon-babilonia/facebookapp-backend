package com.republicababilonia.homin.to;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="VAGAS")
public class VagaTO {
	
	public VagaTO() {
		this.dataCriacao = Calendar.getInstance().getTime();
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	
	@Column(name="NOME")
	private String descricao;

	@Column(name="ENDERECO")
	private String preco;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCAL_ID", nullable = false)
	private LocalTO local;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getPreco() {
		return preco;
	}


	public void setPreco(String preco) {
		this.preco = preco;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public LocalTO getLocal() {
		return local;
	}


	public void setLocal(LocalTO local) {
		this.local = local;
	}


}
