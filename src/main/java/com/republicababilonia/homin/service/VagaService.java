package com.republicababilonia.homin.service;

import java.util.List;

import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.RecomendacaoTO;
import com.republicababilonia.homin.to.VagaTO;

public interface VagaService {
	
	public void save(VagaTO vaga);
	public void remove(Integer id);
	public List<LocalTO> getLocaisByFilters(Long vagatipo, String genero, Double precode, Double precoate, Long veiculo, Double distancia, String faculdade);
	public VagaTO findVagaById(Integer id);
	public void saveRecomendacao(RecomendacaoTO recomendacao);
	public RecomendacaoTO getRecomendacao(String requestId, Long recomendadoId);
}
