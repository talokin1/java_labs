import java.util.ArrayList;
import java.util.List;


public abstract class Animal{
    protected String name;
    protected int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void eat(){
        System.out.println(name + "is eating now");
    }

    public abstract void sound();
}



class Dog extends Animal{

    public Dog(String name, int age){
        super(name, age);
    }

    @Override
    public void sound(){
        System.out.println(getName() + " barks");
    }

}


class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }

    @Override
    public void sound(){
        System.out.println(getName() + " Meows");
    }
}


class Zoo{
    public List<Animal> animals;

    public Zoo(){
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
        System.out.println("Animal " + animal.getName() + " added to the zoo");
    }   

    public void makeSounds(){
        for(Animal animal : animals){
            animal.sound();
        }
    }
}