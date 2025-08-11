package Test_ii;

/*
In java covariant return types allow an overriden method in a subclass to return a more specifuc type (subclass of the original return type) instead of exactly the same type
 */

public class Answer5 {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Animal pet = shelter.adoptPet();

        System.out.println(pet.name);

        DogShelter dogShelter = new DogShelter();
        Dog buddy = dogShelter.adoptPet();

        System.out.println(buddy.name);
    }
}

class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class AnimalShelter {
    Animal adoptPet() {
        return new Animal("Generic Animal");
    }
}

class DogShelter extends AnimalShelter {
    @Override
    Dog adoptPet() {
        return new Dog("Buddy");
    }
}


//Why its legal : 
/*
 * Rule: The return type in the overriden method must be the same or a subtype of the superclass method's return type
 * 
 * this is safe because polymorphism ensures that the return type is still an Animal (base type) but it allows developer to use the more specific type without casting when using the subclass
 */