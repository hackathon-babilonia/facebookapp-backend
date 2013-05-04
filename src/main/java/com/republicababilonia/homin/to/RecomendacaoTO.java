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
@Table(name="RECOMENDACAO")
public class RecomendacaoTO {
	
	public RecomendacaoTO() {
		this.dataCriacao = Calendar.getInstance().getTime();
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	@Column(name="REQUEST_ID")
	private String requestId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RECOMENDADOR_ID")
	private UsuarioTO recomendador;
	
	@Column(name="RECOMENDADO_UID")
	private Long recomendadoUId;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LOCAL_ID", nullable = false)
	private VagaTO vaga;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public String getRequestId() {
		return requestId;
	}


	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public UsuarioTO getRecomendador() {
		return recomendador;
	}


	public void setRecomendador(UsuarioTO recomendador) {
		this.recomendador = recomendador;
	}


	public Long getRecomendadoUId() {
		return recomendadoUId;
	}


	public void setRecomendadoUId(Long recomendadoUId) {
		this.recomendadoUId = recomendadoUId;
	}


	public VagaTO getVaga() {
		return vaga;
	}


	public void setVaga(VagaTO vaga) {
		this.vaga = vaga;
	}
	
}
