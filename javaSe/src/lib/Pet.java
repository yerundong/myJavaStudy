package lib;

/**
 * @Description 宠物类
 */
public class Pet {
    private String name;
    private Species species;

    public Pet() {
        this.name = "";
        this.species = Species.UNKNOWN;
    }

    public Pet(String name) {
        this.name = name;
        this.species = Species.UNKNOWN;
    }

    public Pet(String name, Species species) {
        this.name = name;
        this.species = species;
    }
}
