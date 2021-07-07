package com.ucamp.dto;

import java.awt.Image;
import java.io.Serializable;

/**
 * 
 * @author IrisWilson
 *
 */
public class ProductDto implements Serializable {

	private String id;
	
	private String title;
	
	private Double price;
	
	private String currency_id;
	
	private Long available_quantity;
	
	private String thumbnail;
	
	private String condition;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the currency_id
	 */
	public String getCurrency_id() {
		return currency_id;
	}

	/**
	 * @param currency_id the currency_id to set
	 */
	public void setCurrency_id(String currency_id) {
		this.currency_id = currency_id;
	}

	/**
	 * @return the available_quantity
	 */
	public Long getAvailable_quantity() {
		return available_quantity;
	}

	/**
	 * @param available_quantity the available_quantity to set
	 */
	public void setAvailable_quantity(Long available_quantity) {
		this.available_quantity = available_quantity;
	}

	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	
}
