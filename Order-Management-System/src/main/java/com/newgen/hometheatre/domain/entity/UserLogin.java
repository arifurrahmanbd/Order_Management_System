package com.newgen.hometheatre.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LOGIN")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String countryName;

	public long getId() {
		return id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
