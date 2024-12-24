import javax.swing.*;
import java.util.Vector;




public class Main {
    public static void to_eat(Vector<Food> breakfast){

        for(Food item : breakfast){
            if(item != null){
                item.consume();
            }
        }
    }
    public static Vector<Food> createBreakfastItems(String[] args){
        int count_apple = 0;
        int count_cheese = 0;
        int count_egg = 0;

        Vector<Food> breakfast = new Vector<>();

        for (String arg : args) {
            String[] parts = arg.split("/");

            // Определение, какой класс создавать, основываясь на `parts[0]`
            if (parts[0].equals("Cheese")) {
                breakfast.add(new Cheese());
            }
            else if (parts[0].equals("Apple")) {
                if (parts.length == 2) {
                    breakfast.add(new Apple(parts[1]));   // "small", "medium", "big"
                }
                else {
                    System.out.println("не введён аргумент");
                }
            }
            else if (parts[0].equals("Eggs") || parts[0].equals("Egg")) {
                if (parts.length == 2) {
                    int number = Integer.parseInt(parts[1]);
                    breakfast.add(new Eggs(number)); // 1, 2, или 3
                }
                else {
                    System.out.println("не введён аргумент");
                }
            }
        }


        return breakfast;
    }

    public static Vector<Integer> creat_count_items(Vector<Food> breakfast){
        int count_apple = 0;
        int count_cheese = 0;
        int count_egg = 0;

        Vector<Integer> number_products = new Vector<Integer>(3);
        number_products.add(0);  // для яблок
        number_products.add(0);  // для сыра
        number_products.add(0);  // для яиц

        Apple apple1 = new Apple("small");
        Apple apple3 = new Apple("big");
        Apple apple2 = new Apple("medium");
        Cheese cheese = new Cheese();
        Eggs egg1 = new Eggs(1);
        Eggs egg2 = new Eggs(2);
        Eggs egg3 = new Eggs(3);



        for (Food item : breakfast) {

            // Определение, какой класс создавать, основываясь на `parts[0]`
            if (cheese.equals(item)) {
                int currentValue = number_products.get(1);
                currentValue += 1;
                number_products.set(1, currentValue);
            }
            else if ((apple1.equals(item) || apple3.equals(item)) || apple2.equals(item)) {
                 int currentValue = number_products.get(0);
                 currentValue += 1;
                 number_products.set(0, currentValue);

            }
            else if (egg1.equals(item)) {

                int currentValue = number_products.get(2);
                currentValue += 1;
                number_products.set(2, currentValue);

            }
            else if (egg2.equals(item)) {
                int currentValue = number_products.get(2);
                currentValue += 2;
                number_products.set(2, currentValue);
            }
            else if (egg3.equals(item)) {
                int currentValue = number_products.get(2);
                currentValue += 3;
                number_products.set(2, currentValue);
            }

        }


        return number_products;
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {


        Vector<Food> breakfast = createBreakfastItems(args);
        Vector<Integer> number_products = creat_count_items(breakfast);

        to_eat(breakfast);

        System.out.println();
        System.out.println();
        int count_apple = number_products.get(0) ;
        int count_cheese = number_products.get(1) ;
        int count_egg = number_products.get(2) ;
        System.out.println("Яблоко съедено в количестве "+count_apple);
        System.out.println("Сыра съедено в количестве "+count_cheese);
        System.out.println("Яиц съедено в количестве "+count_egg);



    }
}