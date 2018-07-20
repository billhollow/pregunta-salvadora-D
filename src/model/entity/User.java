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
public class User {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String organizacion;
	@Persistent private String email;
	@Persistent private String date;

	
	public User(String organizacion, String email){
		this.organizacion = organizacion;
		this.email = email;
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
	public String getOrganizacion() {
		return organizacion;
	}
	public void setName(String organizacion) {
		this.organizacion = organizacion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}

