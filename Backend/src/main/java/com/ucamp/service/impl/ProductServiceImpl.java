package com.ucamp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ucamp.client.MercadoLibreClient;
import com.ucamp.dto.ProductDto;
import com.ucamp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	MercadoLibreClient cliente;
	
	/**
	 *
	 */
	@Override
	public List<ProductDto> search(String query) {
		List<ProductDto> productList = new ArrayList<ProductDto>();
		ResponseEntity<String> resp = cliente.search(query);

		JSONObject obj = new JSONObject(resp.getBody());
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(obj.get("results"));

		for(int i = 1; i < jsonArray.getJSONArray(0).length() ; i++) {
			ProductDto producto = new ProductDto();
			JSONObject o = jsonArray.getJSONArray(0).getJSONObject(i);
			producto.setId(o.get("id").toString());
			producto.setAvailable_quantity(Long.valueOf(o.get("available_quantity").toString()));
			producto.setCondition(o.get("condition").toString());
			producto.setCurrency_id(o.get("currency_id").toString());
			producto.setPrice(Double.valueOf(o.get("price").toString()));
			producto.setThumbnail(o.get("thumbnail").toString());
			producto.setTitle(o.get("title").toString());
			productList.add(producto);
		}
		
		
		//obj.get("query");
		
		return productList;
	}
}
