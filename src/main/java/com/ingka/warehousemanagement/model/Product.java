package com.ingka.warehousemanagement.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by Shabaz Mohsin G on 17/05/2021.
 */

// TODO (Shabaz Mohsin G): create a interface for this.
@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String name;
	
	private AssociateArticles associateArticles;
	
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

	public AssociateArticles getAssociateArticles() {
		return associateArticles;
	}

	public void setAssociateArticles(AssociateArticles associateArticles) {
		this.associateArticles = associateArticles;
	}
	
}
