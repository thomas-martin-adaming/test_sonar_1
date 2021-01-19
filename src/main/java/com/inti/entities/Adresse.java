package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rue;
	private String ville;

	public Adresse() {
	}

	public Adresse(String rue, String ville) {
		this.rue = rue;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", ville=" + ville + "]";
	}

}
