package com.m14nivel1.entities;


import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tienda")
public class Tienda {

	@Id
	@Column(name = "id_tienda")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTienda;

	@Column(name = "nombre", columnDefinition = "varchar(255) not null")
	private String nombre;

	@Column(name = "capacidad", columnDefinition = "int(11) NOT NULL DEFAULT 0")
	private int capacidad;

	@OneToMany(mappedBy = "idTienda", cascade = CascadeType.ALL)
	private List<Cuadro> cuadros;

	public Tienda() {

	}

	public List<Cuadro> getCuadros() {
		return cuadros;
	}

	public void setCuadros(List<Cuadro> cuadros) {
		this.cuadros = cuadros;
	}

	public Long getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Tienda [idTienda=" + idTienda + ", nombre=" + nombre + ", capacidad=" + capacidad + ", cuadros="
				+ cuadros + "]";
	}
	

}
