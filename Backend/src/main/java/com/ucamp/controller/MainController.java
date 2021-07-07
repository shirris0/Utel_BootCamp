package com.ucamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ucamp.dto.ProductDto;
import com.ucamp.service.impl.ProductServiceImpl;

/**
 * 
 * @author IrisWilson
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {
	
	@Autowired
	public ProductServiceImpl servicio;
	
	
	@GetMapping({"/search"})
	@ResponseBody
	public List<ProductDto> search(@RequestParam String query) {
		List<ProductDto> respuesta = servicio.search(query);
		return respuesta;
	}

}
