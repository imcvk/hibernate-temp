package single_table_per_hierarchy.model;

import com.github.javafaker.Faker;


public class ForgeModelObjects {
    public static Animal animal;
    public static Mammals mammal;

    public static Reptiles reptile;

    public static Animal createAnimal() {
        animal = new Animal();
        animal.setName("Animal");
        return animal;
    }

    public static Reptiles createReptiles() {

        reptile = new Reptiles();
        reptile.setName(new Faker().animal().name());
        reptile.setBreed("German");
        reptile.setNoOfLegs("4");
        return reptile;
    }

    public static Mammals createMammals() {
        mammal = new Mammals();
        mammal.setName(new Faker().animal().name());
        mammal.setBreed("MammalBreed");
        mammal.setNoOfLegs("4");
        return mammal;
    }
    public void test(){

    }
}
