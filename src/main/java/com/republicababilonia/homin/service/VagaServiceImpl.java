package com.republicababilonia.homin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.republicababilonia.homin.dao.LocalDAO;
import com.republicababilonia.homin.dao.VagaDAO;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.RecomendacaoTO;
import com.republicababilonia.homin.to.VagaTO;

@Service
public class VagaServiceImpl implements VagaService {

	@Autowired
	private VagaDAO vagaDAO;
	
	@Autowired
	private LocalDAO localDAO;
	
	@Transactional
	public void save(VagaTO vaga) {
		vagaDAO.save(vaga);
	}

	@Transactional
	public void remove(Integer id) {
		vagaDAO.remove(id);
	}
	
	@Transactional
	public List<LocalTO> getLocaisByFilters(String vagatipo, String genero,
			Double precode, Double precoate, Long veiculo, Double tempo, String faculdade) {
		Double velocidade = new Double(0);
		Double distancia = new Double(0);
		
		if(veiculo == 0){
			velocidade = 0.8;
		}else if (veiculo == 1){
			velocidade = 5.5;
		}else if (veiculo == 2){
			velocidade = 11.1;
		}else if (veiculo == 3){
			velocidade = 9.3;
		}else{
			velocidade = 0.0;
		}
		distancia = tempo*velocidade;
		
		return localDAO.getLocaisByFilters(vagatipo, genero,distancia, faculdade);
	}
	
	@Transactional
	public VagaTO findVagaById(Integer id) {
		return vagaDAO.findVagaById(id);
	}
	
	@Transactional
	public void saveRecomendacao(RecomendacaoTO recomendacao) {
		vagaDAO.saveRecomendacao(recomendacao);
	}
	
	@Transactional
	public RecomendacaoTO getRecomendacao(String requestId, Long recomendadoId) {
		return vagaDAO.getRecomendacao(requestId, recomendadoId);
	}
}
