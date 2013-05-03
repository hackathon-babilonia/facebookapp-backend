package com.republicababilonia.homin.to;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class RepublicaTO extends LocalTO{


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name="SEXO")
	private String sexo;
	
	
}
