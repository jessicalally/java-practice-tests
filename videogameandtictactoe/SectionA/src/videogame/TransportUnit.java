package videogame;

// TODO: complete this class as part of Section A Question 4

import java.util.HashSet;
import java.util.Set;

public class TransportUnit extends Entity {

  private Set<Entity> transportUnit;
  private static final double DAMAGE_SF = 0.5;

  public TransportUnit(String name, int lifePoints) {
    super(name, lifePoints);
    this.transportUnit = new HashSet<>();
  }

  public void add(Entity entity){
    transportUnit.add(entity);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    if (damageAmount > lifePoints){
      damageAmount = lifePoints;
    }
    lifePoints -= damageAmount;
    int totalDamage = damageAmount;
    for (Entity entity : transportUnit){
      totalDamage += entity.propagateDamage((int) (damageAmount * DAMAGE_SF));
    }
    return totalDamage;
  }

  @Override
  public int minimumStrikeToDestroy() {
    int total = lifePoints;
    for (Entity entity : transportUnit){
      total += 2 * entity.minimumStrikeToDestroy();
    }
    return total;
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append(name + "(" + lifePoints + ") transporting: [");
    for (Entity entity : transportUnit){
      sb.append(entity.toString() + " ");
    }
    sb.append("]");
    return sb.toString();
  }
}
