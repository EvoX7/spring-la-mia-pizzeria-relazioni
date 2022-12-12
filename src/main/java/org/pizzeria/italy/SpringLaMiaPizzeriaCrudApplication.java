package org.pizzeria.italy;

import java.time.LocalDate;

import org.pizzeria.italy.pojo.Drink;
import org.pizzeria.italy.pojo.Pizza;
import org.pizzeria.italy.pojo.Promotion;
import org.pizzeria.italy.service.PizzaService;
import org.pizzeria.italy.service.PromotionService;
import org.pizzeria.italy.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;

	@Autowired
	private DrinkService drinkService;

	@Autowired
	private PromotionService promotionService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		PIZZAS

		Pizza p1 = new Pizza("Margherita", "Pizza classica", 7);
		Pizza p2 = new Pizza("4 formaggi", "La più buona", 10);
		Pizza p3 = new Pizza("Napoletana", "Per gli amanti", 8);
		Pizza p4 = new Pizza("Calzone", "Ripieno classico", 9);
		Pizza p5 = new Pizza("Bismark", "La tedesca", 11);
		Pizza p6 = new Pizza("Marinara", "La semplice", 4);
		Pizza p7 = new Pizza("Diavola", "La piccante", 7);
		Pizza p8 = new Pizza("Siciliana", "L'isolana", 7);
		Pizza p9 = new Pizza("Boscaiola", "Quella rude", 8);
		Pizza p10 = new Pizza("Prosciutto", "Quello cotto", 8);

		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		pizzaService.save(p5);
		pizzaService.save(p6);
		pizzaService.save(p7);
		pizzaService.save(p8);
		pizzaService.save(p9);
		pizzaService.save(p10);

//		DRINKS

		Drink d1 = new Drink("Negroni", "Un classico", 7);
		Drink d2 = new Drink("Manhattan", "Quello glamour", 10);
		Drink d3 = new Drink("Moscow Mule", "Per i temerari", 8);
		Drink d4 = new Drink("Mojito", "Aria esotica", 7);
		Drink d5 = new Drink("Gin Tonic", "Leggero", 4);
		Drink d6 = new Drink("Blue lagoon", "Azzurro", 7);
		Drink d7 = new Drink("Pina colada", "Spiagga esotica", 10);
		Drink d8 = new Drink("Cosmopolitan", "Internazionale", 8);
		Drink d9 = new Drink("Mulled vine", "Quello ricco", 7);
		Drink d10 = new Drink("Bloody Mary", "Quello strano", 4);

		drinkService.save(d1);
		drinkService.save(d2);
		drinkService.save(d3);
		drinkService.save(d4);
		drinkService.save(d5);
		drinkService.save(d6);
		drinkService.save(d7);
		drinkService.save(d8);
		drinkService.save(d9);
		drinkService.save(d10);

//		PROMOTIONS

		Promotion pro1 = new Promotion("Discount 1 x 2", LocalDate.parse("2022-06-20"), LocalDate.parse("2022-07-01"));
		Promotion pro2 = new Promotion("Discount 2 x 3", LocalDate.parse("2022-07-15"), LocalDate.parse("2022-007-25"));
		Promotion pro3 = new Promotion("Discount 3 x 4", LocalDate.parse("2022-08-14"), LocalDate.parse("2022-08-10"));

		promotionService.save(pro1);
		promotionService.save(pro2);
		promotionService.save(pro3);

	}

}
