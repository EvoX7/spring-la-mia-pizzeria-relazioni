package org.pizzeria.italy;

import java.time.LocalDate;

import java.util.List;
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

//		Promotions

		Promotion prom1 = new Promotion("Discount 1 x 2", LocalDate.parse("2022-06-20"), LocalDate.parse("2022-07-01"));
		Promotion prom2 = new Promotion("Discount 2 x 3", LocalDate.parse("2022-07-15"), LocalDate.parse("2022-07-25"));
		Promotion prom3 = new Promotion("Discount 3 x 4", LocalDate.parse("2022-08-14"), LocalDate.parse("2022-08-10"));

		promotionService.save(prom1);
		promotionService.save(prom2);
		promotionService.save(prom3);

		System.out.println(prom1);
		System.out.println(prom2);
		System.out.println(prom3);

//		Pizzas

		Pizza p1 = new Pizza("Margherita", "Pizza classica", 7, prom1);
		Pizza p2 = new Pizza("4 formaggi", "La più buona", 10, prom1);
		Pizza p3 = new Pizza("Napoletana", "Per gli amanti", 8, prom2);
		Pizza p4 = new Pizza("Calzone", "Ripieno classico", 9, prom1);
		Pizza p5 = new Pizza("Bismark", "La tedesca", 11, prom3);
		Pizza p6 = new Pizza("Marinara", "La semplice", 4, prom2);
		Pizza p7 = new Pizza("Diavola", "La piccante", 7, prom3);
		Pizza p8 = new Pizza("Siciliana", "L'isolana", 7, prom1);
		Pizza p9 = new Pizza("Boscaiola", "Quella rude", 8, prom3);
		Pizza p10 = new Pizza("Prosciutto", "Quello cotto", 8, prom2);

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

//		Drinks

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

//		Deleting promotions

		promotionService.deletePromotionById(3);
		System.out.println("---------------------------");

//		Pizza with promotions
		List<Pizza> pizzas = pizzaService.findAll();
		for (Pizza pizza : pizzas) {
			System.err.println(pizza + "\n\t" + pizza.getPromotion());
		}

		System.out.println("---------------------------");
		List<Promotion> promotions = promotionService.findAllPizza();

		for (Promotion promotion : promotions) {
			System.err.println(promotion);
			for (Pizza pizza : promotion.getPizzas()) {
				System.err.println("\t" + pizza);
			}
		}

	}

}
