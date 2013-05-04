package com.republicababilonia.homin.to;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.republicababilonia.homin.utils.Constantes;

@Entity
@Table(name="PLACE")
public class PlaceTO {
	
	public PlaceTO() {
		this.dataCriacao = Calendar.getInstance().getTime();
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;

	@Column(name="CHECKIN_COUNT")
	private Integer checkinCount;
	
	@Column(name="PAGE_ID")
	private Integer pageID;
	
	@Column(name="UNIVERSIDADE")
	private Integer universidade;

	@Column(name="LATITUDE")
	private Double latitude;
	
	@Column(name="LONGITUDE")
	private Double longitude;
	
	@Column(name="TIPO")
	private Integer tipo;
	
	@Column(name="PIC")
	private String pic;
	
	@Column(name="PIC_SMALL")
	private String picSmall;
	
	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPicSmall() {
		return picSmall;
	}

	public void setPicSmall(String picSmall) {
		this.picSmall = picSmall;
	}

	@Column(name="DATA_CRIACAO")
	private Date dataCriacao;

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
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCheckinCount() {
		return checkinCount;
	}

	public void setCheckinCount(Integer checkinCount) {
		this.checkinCount = checkinCount;
	}

	public Integer getPageID() {
		return pageID;
	}

	public void setPageID(Integer pageID) {
		this.pageID = pageID;
	}

	public Integer getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Integer universidade) {
		this.universidade = universidade;
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public static final List<PlaceTO> getHardcodedPlaces(Integer universidade) {
		
		List<PlaceTO> places = new ArrayList<PlaceTO>();
		PlaceTO place = null;
		
		if (universidade.equals(Constantes.UNICAMP)) {
			place = new PlaceTO();
			place.setNome("Universidade Estadual de Campinas");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.UNIVERSIDADE));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(Constantes.UNIVERSIDADE_COORDS.get(Constantes.UNICAMP).get(Constantes.LATITUDE));
			place.setLongitude(Constantes.UNIVERSIDADE_COORDS.get(Constantes.UNICAMP).get(Constantes.LONGITUDE));
			place.setPic("http://i.imgur.com/sHq9udH.png?1");
			place.setPicSmall("http://i.imgur.com/sHq9udH.png?1");
			place.setTipo(Constantes.UNIVERSIDADE);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Aeroporto de Viracopos");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.AEROPORTO));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-23.0077);
			place.setLongitude(-47.14139);
			place.setPic("http://i.imgur.com/7v8TU91.png?1");
			place.setPicSmall("http://i.imgur.com/7v8TU91.png?1");
			place.setTipo(Constantes.AEROPORTO);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Rodoviária");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.TERMINAL_RODOVIARIO));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.90476);
			place.setLongitude(-47.073069);
			place.setPic("http://i.imgur.com/T76ZBQ6.png?1");
			place.setPicSmall("http://i.imgur.com/T76ZBQ6.png?1");
			place.setTipo(Constantes.TERMINAL_RODOVIARIO);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Terminal Barão Geraldo");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.TERMINAL_RODOVIARIO));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.830796);
			place.setLongitude(-47.079613);
			place.setPic("http://i.imgur.com/30HfJPl.png?1");
			place.setPicSmall("http://i.imgur.com/30HfJPl.png?1");
			place.setTipo(Constantes.TERMINAL_RODOVIARIO);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Hospital das Clínicas");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.HOSPITAL));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.824922);
			place.setLongitude(-47.06646);
			place.setPic("http://i.imgur.com/O8QSSyE.png?1");
			place.setPicSmall("http://i.imgur.com/O8QSSyE.png?1");
			place.setTipo(Constantes.HOSPITAL);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Centro Médico");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.HOSPITAL));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.808862);
			place.setLongitude(-47.066588);
			place.setPic("http://i.imgur.com/LEnLcd1.png?1");
			place.setPicSmall("http://i.imgur.com/LEnLcd1.png?1");
			place.setTipo(Constantes.HOSPITAL);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("McDonnald's");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.RESTAURANTE));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.825515);
			place.setLongitude(-47.079581);
			place.setPic("http://i.imgur.com/kHY60Qb.png?1");
			place.setPicSmall("http://i.imgur.com/kHY60Qb.png?1");
			place.setTipo(Constantes.RESTAURANTE);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Subway");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.RESTAURANTE));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.824081);
			place.setLongitude(-47.07942);
			place.setPic("http://i.imgur.com/91sSv17.png?1");
			place.setPicSmall("http://i.imgur.com/91sSv17.png?1");
			place.setTipo(Constantes.RESTAURANTE);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Burger King");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.RESTAURANTE));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.829488);
			place.setLongitude(-47.078806);
			place.setPic("http://i.imgur.com/FVdD5Vh.png?1");
			place.setPicSmall("http://i.imgur.com/FVdD5Vh.png?1");
			place.setTipo(Constantes.RESTAURANTE);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Bardana");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.RESTAURANTE));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.82332);
			place.setLongitude(-47.070601);
			place.setPic("http://i.imgur.com/zeM1V46.png?1?9935");
			place.setPicSmall("http://i.imgur.com/zeM1V46.png?1?9935");
			place.setTipo(Constantes.RESTAURANTE);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Dalben");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.RESTAURANTE));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.833347);
			place.setLongitude(-47.079334);
			place.setPic("http://i.imgur.com/e9Mdt95.png?1");
			place.setPicSmall("http://i.imgur.com/e9Mdt95.png?1");
			place.setTipo(Constantes.RESTAURANTE);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Pão de Açúcar");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.SUPERMERCADO));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.82688);
			place.setLongitude(-47.079206);
			place.setPic("http://i.imgur.com/74DXdHJ.png?1");
			place.setPicSmall("http://i.imgur.com/74DXdHJ.png?1");
			place.setTipo(Constantes.SUPERMERCADO);
			places.add(place);
			
			place = new PlaceTO();
			place.setNome("Supermercado Pague Menos");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.SUPERMERCADO));
			place.setUniversidade(Constantes.UNICAMP);
			place.setLatitude(-22.827918);
			place.setLongitude(-47.080868);
			place.setPic("http://i.imgur.com/lsTHNYr.png?1");
			place.setPicSmall("http://i.imgur.com/lsTHNYr.png?1");
			place.setTipo(Constantes.SUPERMERCADO);
			places.add(place);
			
		} else if (universidade.equals(Constantes.USP)) {
			place = new PlaceTO();
			place.setNome("Universidade de São Paulo");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.UNIVERSIDADE));
			place.setUniversidade(Constantes.USP);
			place.setLatitude(Constantes.UNIVERSIDADE_COORDS.get(Constantes.USP).get(Constantes.LATITUDE));
			place.setLongitude(Constantes.UNIVERSIDADE_COORDS.get(Constantes.USP).get(Constantes.LONGITUDE));
			place.setPic("http://i.imgur.com/CUwF8uo.png?1");
			place.setPicSmall("http://i.imgur.com/CUwF8uo.png?1");
			place.setTipo(Constantes.UNIVERSIDADE);
			places.add(place);
			
		} else if (universidade.equals(Constantes.ITA)) {
			place = new PlaceTO();
			place.setNome("Instituto Tecnológico de Aeronáutica");
			place.setDescricao(Constantes.TIPO_DESCRICAO.get(Constantes.UNIVERSIDADE));
			place.setUniversidade(Constantes.ITA);
			place.setLatitude(Constantes.UNIVERSIDADE_COORDS.get(Constantes.ITA).get(Constantes.LATITUDE));
			place.setLongitude(Constantes.UNIVERSIDADE_COORDS.get(Constantes.ITA).get(Constantes.LONGITUDE));
			place.setPic("http://i.imgur.com/KwnqYRe.png?1?4229");
			place.setPicSmall("http://i.imgur.com/KwnqYRe.png?1?4229");
			place.setTipo(Constantes.UNIVERSIDADE);
			places.add(place);
		}
		
		return places;
	}

}
