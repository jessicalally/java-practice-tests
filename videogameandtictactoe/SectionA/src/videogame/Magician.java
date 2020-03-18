package videogame;

// TODO: complete this class as part of Section A Question 3

public class Magician extends Entity implements SpellCaster{

  private static final int SCALE_FACTOR = 2;

  public Magician(String name, int lifePoints) {
    super(name, lifePoints);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    if (damageAmount > lifePoints){
      damageAmount = lifePoints;
    }
    lifePoints -= damageAmount;
    return damageAmount;
  }

  @Override
  public int minimumStrikeToDestroy() {
    return lifePoints;
  }

  @Override
  public int getStrength() {
    return SCALE_FACTOR * lifePoints;
  }

  @Override
  public String toString(){
    return name + "(" + lifePoints + ")";
  }

}