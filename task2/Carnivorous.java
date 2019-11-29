package task2;

public class Carnivorous extends Animal {
    Carnivorous(String name, int recomFoodAmount, int weight) {
        super(name, recomFoodAmount, weight);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.ANIMALS;
    }

    @Override
    public String toString() {
        return "Carnivore" + super.toString();
    }
}
