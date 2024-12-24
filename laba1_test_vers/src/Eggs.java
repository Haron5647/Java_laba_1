public class Eggs extends Food {
    private int number;

    public Eggs(int number) {
        if (number < 0 || number > 3) {
            System.out.println("неверно введены входные параметры ");
            System.exit(0);
        }
        String eggDescription = (number == 1) ? number + " Egg" : number + " Eggs";

        // Вызываем конструктор родительского класса
        super(eggDescription);


        this.number = number;
    }
    public void consume() {
        System.out.println(this + " съеден");
    }

    public  boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Eggs)) return false; // Шаг 2
            //return size.equals(((Eggs)arg0).size); // Шаг 3
            if (number == ((Eggs) arg0).number) return true;
        }
        return false;
    }

}
