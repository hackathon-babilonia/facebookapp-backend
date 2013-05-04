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

import com.republicababilonia.homin.utils.Constantes;

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
	public LocalTO() {
		this.dataCriacao = Calendar.getInstance().getTime();
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
	
	@Column(name="LATITUDE")
	private Double latitude;
	
	@Column(name="LONGITUDE")
	private Double longitude;
	
	@Column(name="UNIVERSIDADE")
	private String universidade;
	
	@Column(name="DISTANCIA")
	private Double distance;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="local")
	private List<VagaTO> vagas;
	
	public String getUniversidade() {
		return universidade;
	}

	public void setUniversidade(String universidade) {
		this.universidade = universidade;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	
	public void setDistanceFromUniversity(){
		Double latitude = new Double(0);
		Double longitude= new Double(0);
		Double distancia= new Double(0);
		universidade = "UNICAMP";
		if(universidade.equals("UNICAMP")){
			latitude = Constantes.UNIVERSIDADE_COORDS.get(Constantes.UNICAMP).get(Constantes.LATITUDE);
			longitude = Constantes.UNIVERSIDADE_COORDS.get(Constantes.UNICAMP).get(Constantes.LONGITUDE);
		}else if (universidade.equals("ITA")){
			latitude = Constantes.UNIVERSIDADE_COORDS.get(Constantes.ITA).get(Constantes.LATITUDE);
			longitude = Constantes.UNIVERSIDADE_COORDS.get(Constantes.ITA).get(Constantes.LONGITUDE);
		}else if (universidade.equals("USP")){
			latitude = Constantes.UNIVERSIDADE_COORDS.get(Constantes.USP).get(Constantes.LATITUDE);
			longitude = Constantes.UNIVERSIDADE_COORDS.get(Constantes.USP).get(Constantes.LONGITUDE);
		}
		distancia = Math.sqrt((latitude  - this.latitude)*(latitude  - this.latitude) + (longitude  - this.longitude)*(longitude - this.longitude)); 
		distancia = distancia * 111200.0;
		this.distance = distancia;
	}
	
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


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
