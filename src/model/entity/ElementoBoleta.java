package model.entity;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class ElementoBoleta {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String name;
	@Persistent private double precio;
	@Persistent private int cantidad;
	@Persistent private String idUser;

	public ElementoBoleta(String name, double precio, int cantidad,String idUser){
		super();
		this.name = name;
		this.precio = precio;
		this.cantidad = cantidad;
		this.idUser = idUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	public int getCantidad(){
		return cantidad;
	}
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

}