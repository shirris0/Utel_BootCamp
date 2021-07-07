package com.ucamp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mercadolibre" , url = "https://api.mercadolibre.com", configuration = FeignConfig.class)
public interface MercadoLibreClient {


	@GetMapping(value = "/sites/MLA/search?q={query}")
	//@RequestMapping(value = "/sites/MLA/search?q={query}", method = RequestMethod.GET)
    public ResponseEntity<String> search(@PathVariable("query") String query);
}
