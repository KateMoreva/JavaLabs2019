package task2;

public class Omnivorous extends Animal{
    Omnivorous(String name, int recomfoodAmount, int weight){
        super(name, recomfoodAmount, weight);
    }

    @Override
    public FoodType getFoodType() {
        return FoodType.EVERYTHING;
    }

    @Override
    public String toString(){
        return "Omnivorous" + super.toString();
    }
}
