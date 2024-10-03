public class Main_1 {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Cat cat = new Cat("Vladick", 4);
        Dog dog = new Dog("Bobik", 2);

        zoo.addAnimal(cat);
        System.out.println(cat.getName() + " added to zoo");
        cat.sound();

        zoo.addAnimal(dog);
        System.out.println(dog.getName() + " added to zoo");
        dog.sound();        
    }
}