package com.m14nivel1.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.m14nivel1.dao.ITiendaDAO;
import com.m14nivel1.entities.Tienda;

@Service
public class TiendaServiceImpl implements ITiendaService {
	
	@Autowired
	private ITiendaDAO iTiendaDAO;

	@Override
	public List<Tienda> getTiendas() {
		return iTiendaDAO.findAll();
	}

	@Override
	public Tienda addTienda(Tienda tienda) {	
		return iTiendaDAO.save(tienda);
	}

	@Override
	public Optional<Tienda> getTienda(Long id){
		return iTiendaDAO.findById(id);
	}

	@Override
	public void eliminarTienda(Long id) {
		iTiendaDAO.deleteById(id);
	}

	@Override
	public void modificarTienda(Tienda tienda) {
		iTiendaDAO.save(tienda);
		
	}

}
