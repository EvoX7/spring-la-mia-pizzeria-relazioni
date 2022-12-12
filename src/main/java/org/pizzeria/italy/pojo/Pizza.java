package org.pizzeria.italy.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "name cannot be empty")
	@Column(unique = true)
	private String name;

	@Lob
	private String description;

	@NotNull(message = "price cannot be null")
	@Min(1)
	private int price;

	@ManyToOne
	@JoinColumn(name = "promotion_id", nullable = true)
	private Promotion promotion;

	public Pizza() {
	}

	public Pizza(String name, String description, int price, Promotion promotion) {

		setName(name);
		setDescription(description);
		setPrice(price);
		setPromotion(promotion);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	@Override
	public String toString() {
		return getId() + " - " + getName() + " - " + getDescription() + " - " + getPrice() + "€";
	}

}
