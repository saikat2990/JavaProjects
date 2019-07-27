package BuilderPattern;

public class BuilderPattern {
	public static void main(String[] args) {
		
		
		MealBuilder mealbuilder = new MealBuilder();
		
		Meal  adultMeal = mealbuilder.adultMeal();
		System.out.println("Adult meal cost"+adultMeal.totalCost());
		
		Meal  KidsMeal = mealbuilder.kidsMeal();
		System.out.println("Kids meal cost"+KidsMeal.totalCost());
		
	}
}
