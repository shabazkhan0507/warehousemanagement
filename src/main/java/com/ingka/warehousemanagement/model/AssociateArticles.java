package com.ingka.warehousemanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by Shabaz Mohsin G 
 */

// TODO (Shabaz Mohsin G ): create a interface for this.
@Entity
@Table(name = "contain_articles")
public class AssociateArticles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(name = "artId")
	private String artId;

	@NotBlank
	@Column(name = "amountOf")
	private String amountOf;

	@NotBlank
	@Column(name = "productId")
	private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtId() {
		return artId;
	}

	public void setArtId(String artId) {
		this.artId = artId;
	}

	public String getAmountOf() {
		return amountOf;
	}

	public void setAmountOf(String amountOf) {
		this.amountOf = amountOf;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
