package com.m14nivel1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.m14nivel1.entities.Cuadro;
import com.m14nivel1.entities.Tienda;
import com.m14nivel1.services.ICuadroService;
import com.m14nivel1.services.ITiendaService;


// Doumentación de la api en el siguiente enlace:
// https://documenter.getpostman.com/view/18010036/UV5ZAwKY

@RestController
@RequestMapping("collarblanco")
public class TiendaController {

	@Autowired // Inyectar dependencia
	private ITiendaService iTiendaService;
	
	@Autowired
	private ICuadroService iCuadroService;
	
	
	@GetMapping("/tiendas") // localhost:8080/collarblanco/tiendas
	public ResponseEntity<List<Tienda>> getTiendas() {
		return ResponseEntity.ok(iTiendaService.getTiendas());
	}

	@GetMapping("/tienda/{idTienda}") // localhost:8080/collarblanco/tienda/5
	public ResponseEntity<?> getTiendaPorId(@PathVariable("idTienda") Long id) {
		Optional<Tienda> optionalTienda = iTiendaService.getTienda(id);
		if (optionalTienda.isPresent()) {
			return ResponseEntity.ok(optionalTienda.get());
		} else {
			return ResponseEntity.status(404).body("La tienda con id " + id + " no existe. Consultar el listado de tiendas.");
		}

	}

	@PostMapping("/tienda") // localhost:8080/collarblanco/tienda
	public ResponseEntity<Tienda> crearTienda(@RequestBody Tienda tienda) {
		return ResponseEntity.ok(iTiendaService.addTienda(tienda));
	}
	
	@PutMapping("/tienda/{idTienda}") // localhost:8080/collarblanco/tienda/4
	public ResponseEntity<?> modificarTiendaPorId(@PathVariable("idTienda") Long id, @RequestBody Tienda tienda){
		Optional<Tienda> optionalTienda = iTiendaService.getTienda(id);
		if(optionalTienda.isPresent()) {
			Tienda actualizarTienda = optionalTienda.get();
			actualizarTienda.setNombre(tienda.getNombre());
			actualizarTienda.setCapacidad(tienda.getCapacidad());
			iTiendaService.modificarTienda(actualizarTienda);
			return ResponseEntity.ok("Modificada tienda con id " + id);
		}else {
			return ResponseEntity.status(404).body("La tienda con id " + id + " no existe. Consultar el listado de tiendas.");
		}
		
	}
	
	@DeleteMapping("/tienda/{idTienda}") // http://localhost:8080/collarblanco/tienda/3
	public ResponseEntity<?> eliminarTiendaPorId(@PathVariable("idTienda") Long id) {
		Optional<Tienda> optionalTienda = iTiendaService.getTienda(id);
		if (optionalTienda.isPresent()) {
			iTiendaService.eliminarTienda(id);
			return ResponseEntity.ok("Eliminada tienda con id " + id);
		} else {
			return ResponseEntity.status(404).body("La tienda con id " + id + " no existe. Consultar el listado de tiendas.");
		}
	}
	
	@GetMapping("/cuadros") // localhost:8080/collarblanco/cuadros
	public ResponseEntity<List<Cuadro>> getCuadros() {
		return ResponseEntity.ok(iCuadroService.getCuadros());
	}

	@GetMapping("/tienda/{idTienda}/cuadros") // localhost:8080/collarblanco/tienda/4/cuadros
	public ResponseEntity<?> getCuadrosPorIdTienda(@PathVariable("idTienda") Long id) {

		List<Cuadro> cuadrosPorTienda = new ArrayList<>();

		Optional<Tienda> optionalTienda = iTiendaService.getTienda(id);

		if (optionalTienda.isPresent()) {

			for (Cuadro cuadro : iCuadroService.getCuadros()) {

				if (cuadro.getIdTienda() == id) {
					cuadrosPorTienda.add(cuadro);
				}
			}
			return ResponseEntity.ok(cuadrosPorTienda);

		} else {
			return ResponseEntity.status(404).body("La tienda con id " + id + " no existe. Consultar listado de tiendas.");
		}

	}

	@DeleteMapping("/tienda/{idTienda}/cuadros") // localhost:8080/collarblanco/tienda/2/cuadros
	public ResponseEntity<String> eliminarCuadrosPorIdTienda(@PathVariable("idTienda") Long id) {

		Optional<Tienda> optionalTienda = iTiendaService.getTienda(id);

		if (optionalTienda.isPresent()) {

			List<Cuadro> cuadrosPorTienda = new ArrayList<>();
			for (Cuadro cuadro : iCuadroService.getCuadros()) {

				if (cuadro.getIdTienda() == id) {
					cuadrosPorTienda.add(cuadro);
				}
			}
			iCuadroService.borrarCuadrosPorTienda(cuadrosPorTienda);

			return ResponseEntity.ok("Se han eliminado todos los cuadros de la tienda con id " + id);
		}
		return ResponseEntity.status(404).body("La tienda con id " + id + " no existe. Consultar listado de tiendas.");
	}

	@PostMapping("/tienda/{idTienda}/cuadro") // localhost:8080/collarblanco/tienda/4/cuadro
	public ResponseEntity<?> addCuadroAtienda(@RequestBody Cuadro cuadro, @PathVariable("idTienda") Long id) {
		Optional<Tienda> optionalTienda = iTiendaService.getTienda(id);

		if (optionalTienda.isPresent()) {
			cuadro.setIdTienda(id);
			iCuadroService.addCuadro(cuadro);
			return ResponseEntity.ok("Añadido cuadro a tienda con id " + id + ":\n" + cuadro);
		}
		return ResponseEntity.status(404).body("La tienda con id " + id + " no existe. Consultar listado de tiendas.");
	}
}
