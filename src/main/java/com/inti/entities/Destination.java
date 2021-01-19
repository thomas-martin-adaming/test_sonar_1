package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Destination implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestination;
	@Embedded
	private Adresse adresse;
	private String pays;
	@OneToMany(mappedBy = "destination",fetch=FetchType.EAGER)
	private Set<Hotel> listHotel = new HashSet<Hotel>();
	@OneToMany(mappedBy = "destination",fetch=FetchType.EAGER)
	private Set<Reservation> listReservation = new HashSet<Reservation>();

	public Destination() {

	}

	public Destination(Adresse adresse, String pays) {
		super();
		this.adresse = adresse;
		this.pays = pays;
	}

	public Long getIdDestination() {
		return idDestination;
	}

	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Set<Hotel> getListHotel() {
		return listHotel;
	}

	public void setListHotel(Set<Hotel> listHotel) {
		this.listHotel = listHotel;
	}

	public Set<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(Set<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	@Override
	public String toString() {
		return "Destination [adresse=" + adresse + ", pays=" + pays + ", listHotel=" + listHotel + "]";
	}

}
