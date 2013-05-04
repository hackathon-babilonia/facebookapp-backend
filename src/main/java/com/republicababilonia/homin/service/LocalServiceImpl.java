package com.republicababilonia.homin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.republicababilonia.homin.dao.LocalDAO;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.VagaTO;
import com.republicababilonia.homin.utils.Constantes;

@Service
public class LocalServiceImpl implements LocalService {

	@Autowired
	private LocalDAO localDAO;
	
	@Transactional
	public void save(LocalTO local) {
		localDAO.save(local);
	}

	@Transactional
	public List<LocalTO> getTodosLocais() {
		return localDAO.getTodosLocais();
	}

	@Transactional
	public void remove(Integer id) {
		localDAO.remove(id);
	}
	
	@Transactional
	public LocalTO findLocalById(Integer id) {
		return localDAO.findLocalById(id);
	}
	
	@Transactional
	public List<LocalTO> getLocaisByFilters(Long vagatipo, String genero,
			Double precode, Double precoate, Long veiculo, Double tempo, String faculdade) {
		Double velocidade = new Double(0);
		Double distancia = new Double(0);
		Constantes constante = new Constantes();
		List<LocalTO> lista;
		List<LocalTO> responseList = new ArrayList<LocalTO>();
		List<VagaTO> listvaga = new ArrayList<VagaTO>();
		
		if(veiculo!=null){
			if(veiculo == 0){
				velocidade = 0.8;
			}else if (veiculo == 1){
				velocidade = 5.5;
			}else if (veiculo == 2){
				velocidade = 11.1;
			}else if (veiculo == 3){
				velocidade = 9.3;
			}
			distancia = tempo*velocidade;
		}else{
			distancia = null;
		}
		
		lista = localDAO.getLocaisByFilters(vagatipo, genero, distancia, faculdade);
		
		if(precode!=null && precoate!=null){
			for(LocalTO local : lista){
				for(VagaTO vaga : local.getVagas()){
					if(vaga.getPreco()>precode && vaga.getPreco()<precoate){
						listvaga.add(vaga);
					}
				}
				local.setVagas(listvaga);
				if(!listvaga.isEmpty())
					responseList.add(local);
			}
		}else{
			responseList=lista;
		}
		return responseList;
	}

}
