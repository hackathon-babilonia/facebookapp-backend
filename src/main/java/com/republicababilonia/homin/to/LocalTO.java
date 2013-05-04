package com.republicababilonia.homin.to;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOCAL")
public class LocalTO {
	
	public static String REPUBLICA = "REPUBLICA";
	public static String PENSIONATO = "PENSIONATO";
	public static String APARTAMENTO = "APARTAMENTO";
	
	public LocalTO(String tipo) {
		this.dataCriacao = Calendar.getInstance().getTime();
		this.tipo = tipo;
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOME")
	private String nome;

	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="NUMERO")
	private Integer numero;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="COMPL")
	private String complemento;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;
	
	@Column(name="SEXO")
	private String sexo;
	
	@Column(name="TIPO")
	private String tipo;
	

	@OneToMany(fetch = FetchType.EAGER)
	private List<VagaTO> vagas;
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public List<VagaTO> getVagas() {
		return vagas;
	}

	public void setVagas(List<VagaTO> vagas) {
		this.vagas = vagas;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
