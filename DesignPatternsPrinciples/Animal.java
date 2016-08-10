import java.util.*;

// prevent methods from being overridden by defining final class
public final class Animal {
  // mark all of the instance variable private and final
  private final String species;
  private final int age;
  private final List<String> favoriteFoods;

  // use a constructor to set all properties
  public Animal(String species, int age, List<String> favoriteFoods) {
    this.species = species;
    this.age = age;
    if (favoriteFoods == null) {
      throw new RuntimeException("favoriteFoods is required");
    }
    this.favoriteFoods = new ArrayList<String>(favoriteFoods);
  }

  // don't define any setter methods
  public String getSpecies() {
    return species;
  }

  public int getAge() {
    return age;
  }

  // don't allow referenced mutable objects to be modified or accessed directly
  public int getFavoriteFoodsCount() {
    return favoriteFoods.size();
  }

  public String getFavoriteFood(int index) {
    return favoriteFoods.get(index);
  }
}

