package Monsters;
import PolitechnikaDungeon.Player;

public interface Monster {

    public void Sound();

    public int getHealth();

    public void setHealth(int health);

    public int getAttack();

    public void setAttack(int attack);

    public int getDefense();

    public void setDefense(int defense);

    public int getSpeed();

    public void setSpeed(int speed);

    public int getLevel();

    public void setLevel(int level);

    public String getName();

    public boolean isABoss();

    public void setABoss(boolean isABoss);

    public int Attack(Player target);

    public void Defend();

    public void TakeDamage(int damage);

    public int Heal(int health);

    public void LevelUp();

    public void PrintStats();

    public String getCreatedTalk();

    void PrintDeathMessage();

    void PrintItemsDropped();

}
