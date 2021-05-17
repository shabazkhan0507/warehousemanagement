package com.ingka.warehousemanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by Shabaz Mohsin G 
 */

// TODO (Shabaz Mohsin G ): create a interface for this.
@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(name = "artId")
	private String artId;

	@NotBlank
	@Column(name = "name")
	private String name;

	@NotBlank
	@Column(name = "stock")
	private String stock;

	public String getArtId() {
		return artId;
	}

	public void setArtId(String artId) {
		this.artId = artId;
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

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
}
