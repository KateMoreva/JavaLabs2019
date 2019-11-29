package task2;

public class Herbivorous extends Animal {
    Herbivorous(String name, int recomFoodAmount, int weight){
        super(name, recomFoodAmount, weight);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.PLANTS;
    }
    @Override
    public String toString(){
        return "Herbivorous" + super.toString();
    }
}
