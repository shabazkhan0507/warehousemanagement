package com.ingka.warehousemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WarehouseNotFoundException extends RuntimeException {
	private String name;

	public WarehouseNotFoundException(String warehouseManagementService){
		super(String.format("%s not found with %s : '%s'", warehouseManagementService));
		this.name = name;
	}

	public String getName() {
		return name;
	}
}