package ve.com.jh.micro.hackaton.hackaton1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ve.com.jh.micro.hackaton.hackaton1.dao.TransaccionesRepository;
import ve.com.jh.micro.hackaton.hackaton1.model.Transacciones;

@RestController
public class TransaccionesController {
	@Autowired
	private TransaccionesRepository repository;
	
	@GetMapping("/transacciones/{id}")
	public Optional<Transacciones> getTransaccion(@PathVariable("id") int id) {
		return repository.findById(id);
	}
	
	@GetMapping("/transacciones")
	public List<Transacciones> getAllTransacciones() {
		return (List<Transacciones>) repository.findAll();
	}
	
	@PostMapping("/transacciones")
	public String agregar(@RequestBody List<Transacciones> transacciones) {
		repository.saveAll(transacciones);
		
		return transacciones.size() + " registros agregados.";
	}
	
	//Put
	@PutMapping("/transacciones/{id}")
	public String actualizar(@RequestBody Transacciones transaccion, @PathVariable("id") int id) {
		Optional<Transacciones> t = repository.findById(id);
		if (t.isPresent()) {
			transaccion.setId(id);
			repository.save(transaccion);
			
			return "Se ha actualizado correctamente " + id;
		}
		return "No se ha actualizado. No se encontro " + id;
	}
	
	@DeleteMapping("/transacciones/{id}")
	public String eliminar(@PathVariable("id") int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			
			return "Eliminado correctamente " + id;
		}
		return "No se ha eliminado. No se encontro " + id;
	}
	
}
