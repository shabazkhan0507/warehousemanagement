package com.ingka.warehousemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ingka.warehousemanagement.model.Product;

/**
 * Created by Shabaz Mohsin G on 01/03/18.
 * This use JpaRepository that extends the PagingAndSortingRepository that extends CRUDRepository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
