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
public class Product {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String name;
	@Persistent private double precio;
	@Persistent private String date;
	@Persistent private String idUser;

	public Product(String name, double precio, String idUser){
		super();
		this.name = name;
		this.precio = precio;
		this.idUser = idUser;
		Locale l = new Locale("es","PE");
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Lima"),l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMMM d HH:mm:ss yyyy");
		this.date = dateFormat.format(cal.getTime());
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


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
}

