package com.inti.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateReservation;

	@ManyToOne
	private Destination destination;

	@ManyToOne
	private Type type;

	@ManyToOne
	private Voyageur voyageur;

	public Reservation() {

	}

	public Reservation(Date dateReservation, Destination destination, Type type, Voyageur voyageur) {
		this.dateReservation = dateReservation;
		this.destination = destination;
		this.type = type;
		this.voyageur = voyageur;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Voyageur getVoyageur() {
		return voyageur;
	}

	public void setVoyageur(Voyageur voyageur) {
		this.voyageur = voyageur;
	}

	@Override
	public String toString() {
		return "Reservation [dateReservation=" + dateReservation + ", destination=" + destination + ", type=" + type
				+ "]";
	}

}
