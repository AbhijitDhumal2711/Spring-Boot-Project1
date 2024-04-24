package edu.jsp.ProjectSpringBoot.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Traveller {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TId;
	
	private String fullName;
	
	private String address;
	
	private String email;
	
	private String password;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Country> countries;
	

	
	
	
	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public int getTId() {
		return TId;
	}

	public void setTId(int tId) {
		TId = tId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Traveller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Traveller [TId=" + TId + ", fullName=" + fullName + ", address=" + address + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	
	
}
