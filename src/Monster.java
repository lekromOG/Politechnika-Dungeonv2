public interface Monster {
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

    public void Attack(Monster target);

    public void Defend();

    public void TakeDamage(int damage);

    public void Heal(int health);

    public void LevelUp();

    public void PrintStats();
}
