package com.app.efa.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Address {
	@Column(nullable = false, unique = false, length = 30)
	private String city;
	@Column(nullable = false, unique = false, length = 30)
	private String state;
	@Column(nullable = false, unique = false, length = 30)
	private String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
