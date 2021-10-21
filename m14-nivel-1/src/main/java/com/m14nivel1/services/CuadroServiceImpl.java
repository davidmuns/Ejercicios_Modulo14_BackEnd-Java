package com.m14nivel1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m14nivel1.dao.ICuadroDAO;
import com.m14nivel1.entities.Cuadro;


@Service
public class CuadroServiceImpl implements ICuadroService {
	
	@Autowired
	private ICuadroDAO iCuadroDAO;

	@Override
	public List<Cuadro> getCuadros() {
		return iCuadroDAO.findAll();
	}

	@Override
	public void borrarCuadrosPorTienda(List<Cuadro> cuadros) {
		iCuadroDAO.deleteAll(cuadros);
	}
	
	@Override
	public Cuadro addCuadro(Cuadro cuadro) {
		return iCuadroDAO.save(cuadro);
	}

}
