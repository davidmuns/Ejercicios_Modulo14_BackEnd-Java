package com.m14nivel1.services;

import java.util.List;
import com.m14nivel1.entities.Cuadro;


public interface ICuadroService {
	public List<Cuadro> getCuadros();
	public void borrarCuadrosPorTienda(List<Cuadro> cuadros);
	public Cuadro addCuadro(Cuadro cuadro);
}
