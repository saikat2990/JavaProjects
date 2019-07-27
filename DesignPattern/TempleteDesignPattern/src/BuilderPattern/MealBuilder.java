package BuilderPattern;

public class MealBuilder {
	
	
	public Meal adultMeal() {
		
		Meal meal = new Meal();
		meal.addMenu(new Pizza());
		meal.addMenu(new chessCake());
		meal.addMenu(new Fanta());
		meal.addMenu(new Ring());
		return meal;
	}
	
	public Meal kidsMeal() {
		
		Meal meal = new Meal();
		meal.addMenu(new Burger());
		meal.addMenu(new Donut());
		meal.addMenu(new Pepsi());
		meal.addMenu(new Car());
		return meal;
	}
	
}
