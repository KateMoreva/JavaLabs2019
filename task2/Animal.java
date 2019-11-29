package task2;

public abstract class Animal {
    private static int totalNumber = 0;
    private int id;
    private String name;
    private int recomfoodAmount;
    private int weight;

    Animal(String name, int foodAmount, int weight) {
        this.id = totalNumber++;
        this.name = name;
        this.recomfoodAmount = foodAmount;
        this.weight = weight;
    }
    int getId() {
        return id;
    }
    String getName() {
        return name;
    }
    public abstract FoodType getFoodType();
    int getFoodAmount() {
        return recomfoodAmount * weight;
    }

    @Override
    public String toString() {
        return name + " " + recomfoodAmount;
    }
}

