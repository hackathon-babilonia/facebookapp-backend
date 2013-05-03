package com.republicababilonia.homin.to;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PensionatoTO extends LocalTO {
	
	

	@Column(name = "SEXO")
	public String sexo;

}
