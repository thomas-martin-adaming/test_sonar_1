package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	private String nomHotel;
	private int nbretoile;
	@ManyToOne
	private Destination destination;

	public Hotel() {

	}

	public Hotel(String nomHotel, int nbretoile, Destination destination) {
		this.nomHotel = nomHotel;
		this.nbretoile = nbretoile;
		this.destination = destination;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNomHotel() {
		return nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public int getNbretoile() {
		return nbretoile;
	}

	public void setNbretoile(int nbretoile) {
		this.nbretoile = nbretoile;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Hotel [nomHotel=" + nomHotel + ", nbretoile=" + nbretoile + "]";
	}

}
