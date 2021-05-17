package com.ingka.warehousemanagement.controller;

import com.ingka.warehousemanagement.exception.WarehouseNotFoundException;
import com.ingka.warehousemanagement.model.*;
import com.ingka.warehousemanagement.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Shabaz Mohsin G  on 01/03/18.
 */
@RestController
@RequestMapping("/api/v1.0")
public class WarehouseManagementController {

	/** REST Services for Product --START */
	@Autowired
	private ProductRepository productRepository;
	private AssociateArticlesRepository associateArticlesRepository;
	
	@GetMapping("/warehouseamanagement/getProductsList")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/warehouseamanagement/getProducts/{id}")
	public Product getProductById(@PathVariable(value = "id") Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("Product"));
	}

	@PostMapping("/warehouseamanagement/manageProducts")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/warehouseamanagement/manageProducts/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long id, @Valid @RequestBody Product productDetails) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("Product"));

		product.setName(productDetails.getName());
		product.getAssociateArticles().setArtId(productDetails.getAssociateArticles().getArtId());
		product.getAssociateArticles().setAmountOf(productDetails.getAssociateArticles().getAmountOf());
		//product.getAssociateArticles().setProductId(productDetails.getId());

		Product updatedProduct = productRepository.save(product);
		return updatedProduct;
	}
	

	@DeleteMapping("/warehouseamanagement/deleteProducts/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Long id) {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("Product"));
		
		associateArticlesRepository.delete(product.getAssociateArticles());
		productRepository.delete(product);
		return ResponseEntity.ok().build();
	}
	/** REST Services for Product --END */
	
	/** REST Services for Inventory --START */
	
	@Autowired
	private InventoryRepository inventoryRepository;
	//private AssociateArticlesRepository associateArticlesRepository;
	
	@GetMapping("/warehouseamanagement/getInventoryList")
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

	@GetMapping("/warehouseamanagement/getInventory/{id}")
	public Inventory getInventoryById(@PathVariable(value = "id") Long id) {
		return inventoryRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("Inventory"));
	}

	@PostMapping("/warehouseamanagement/manageInventory")
	public Inventory createInventory(@Valid @RequestBody Inventory inventory) {
		return inventoryRepository.save(inventory);
	}
	

	@PutMapping("/warehouseamanagement/manageInventory/{id}")
	public Inventory updateInventory(@PathVariable(value = "id") Long id, @Valid @RequestBody Inventory inventoryDetails) {

		Inventory inventory = inventoryRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("Inventory"));

		inventory.setName(inventoryDetails.getName());
		inventory.setArtId(inventoryDetails.getArtId());
		inventory.setStock(inventoryDetails.getStock());

		Inventory updatedInventory = inventoryRepository.save(inventory);
		return updatedInventory;
	}
	

	@DeleteMapping("/warehouseamanagement/deleteInventory/{id}")
	public ResponseEntity<Inventory> deleteInventory(@PathVariable(value = "id") Long id) {

		Inventory inventory = inventoryRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("Inventory"));
		
		//associateArticlesRepository.delete(product.getAssociateArticles());
		inventoryRepository.delete(inventory);
		return ResponseEntity.ok().build();
	}
	/** REST Services for Inventory --END */
	
	/** REST Services for Associate Articles --START */
	@GetMapping("/warehouseamanagement/getAllAssociateArticles")
	public List<AssociateArticles> getAllAssociateArticles() {
		return associateArticlesRepository.findAll();
	}

	@GetMapping("/warehouseamanagement/getAssociateArticles/{id}")
	public AssociateArticles getAssociateArticlesById(@PathVariable(value = "id") Long id) {
		return associateArticlesRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("AssociateArticles"));
	}

	@PostMapping("/warehouseamanagement/manageAssociateArticles")
	public AssociateArticles createAssociateArticles(@Valid @RequestBody AssociateArticles associateArticles) {
		return associateArticlesRepository.save(associateArticles);
	}

	@PutMapping("/warehouseamanagement/manageAssociateArticles/{id}")
	public AssociateArticles updateAssociateArticles(@PathVariable(value = "id") Long id, @Valid @RequestBody AssociateArticles associateArticlesDetails) {

		AssociateArticles associateArticles = associateArticlesRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("AssociateArticles"));

		associateArticles.setProductId(associateArticlesDetails.getProductId());
		associateArticles.setArtId(associateArticlesDetails.getArtId());
		associateArticles.setAmountOf(associateArticlesDetails.getAmountOf());
		
		AssociateArticles updateAssociateArticles = associateArticlesRepository.save(associateArticles);
		return updateAssociateArticles;
	}

	@DeleteMapping("/warehouseamanagement/deleteAssociateArticles/{id}")
	public ResponseEntity<AssociateArticles> deleteAssociateArticles(@PathVariable(value = "id") Long id) {

		AssociateArticles associateArticles = associateArticlesRepository.findById(id)
				.orElseThrow(() -> new WarehouseNotFoundException("AssociateArticles"));
		
		associateArticlesRepository.delete(associateArticles);
		return ResponseEntity.ok().build();
	}
	
	/** REST Services for Associate Articles --END */
}
