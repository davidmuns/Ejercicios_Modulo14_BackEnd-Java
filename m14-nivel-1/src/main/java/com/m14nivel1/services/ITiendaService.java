package com.m14nivel1.services;

import java.util.List;
import java.util.Optional;

import com.m14nivel1.entities.Tienda;

public interface ITiendaService {
	public List<Tienda> getTiendas();
	public Tienda addTienda(Tienda tienda);
	public Optional<Tienda> getTienda(Long id);
	public void eliminarTienda(Long id);
	public void modificarTienda(Tienda tienda);

}
