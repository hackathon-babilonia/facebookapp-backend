package com.republicababilonia.homin.to;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class UsuarioTO {
	
	
	public UsuarioTO() {
		this.dataCriacao = Calendar.getInstance().getTime();
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;

	@Column(name="NOME")
	private String nome;
	
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Column(name="token")
	private String accessToken;

	@Column(name="NUMERO")
	private Integer universidade;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	@Column(name="URL_FOTO")
	private String urlFoto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Integer universidade) {
		this.universidade = universidade;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}


}
