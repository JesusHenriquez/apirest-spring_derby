package ve.com.jh.micro.hackaton.hackaton1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transacciones {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int peticion;
	private Date desde;
	private Date hasta;
	
	public Transacciones() { }
	
	public Transacciones(int peticion, Date desde, Date hasta) {
		super();
		this.peticion = peticion;
		this.desde = desde;
		this.hasta = hasta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPeticion() {
		return peticion;
	}

	public void setPeticion(int peticion) {
		this.peticion = peticion;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}
	
	
	
	
}
