package com.m14nivel1.entities;

import java.util.Date;
import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "cuadro")
public class Cuadro {

	@Id
	@Column(name = "id_cuadro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuadro;

	@NotNull
	@Column(name = "nombre", columnDefinition = "varchar(255) not null")
	private String nombre;

	@Column(name = "autor", columnDefinition = "varchar(255) not null default 'Anonimo'")
	private String autor;

	@Column(name = "precio", columnDefinition = "decimal(15,2) NOT NULL DEFAULT 0.00")
	private double precio;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "fecha_entrada", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Date fechaEntrada;

	@Column(name = "id_tienda")
	private long idTienda;

	public Cuadro() {

	}

	public long getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(long idTienda) {
		this.idTienda = idTienda;
	}

	public Long getIdCuadro() {
		return idCuadro;
	}

	public void setIdCuadro(Long idCuadro) {
		this.idCuadro = idCuadro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	@Override
	public String toString() {
		return "Cuadro [idCuadro=" + idCuadro + ", nombre=" + nombre + ", autor=" + autor + ", precio=" + precio
				+ ", fechaEntrada=" + fechaEntrada + ", idTienda=" + idTienda + "]";
	}

	

}
