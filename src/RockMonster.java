class RockMonster extends BasicMonster {

    public RockMonster() {
        super(100, 10, 10, 10, 1, "Rock Monster");
    }

    @Override
    public void Sound() {
        System.out.println("Rock Monster: I am a rock monster!");
    }

    @Override
    public boolean isABoss() {
        // Implement the method here. For example, return false if this monster is not a boss.
        return false;
    }

    @Override
    public void setABoss(boolean isABoss) {

    }

    @Override
    public void Attack(Monster target) {

    }

    @Override
    public void Defend() {

    }

    @Override
    public void TakeDamage(int damage) {

    }

    @Override
    public void Heal(int health) {

    }

    @Override
    public void LevelUp() {

    }

    @Override
    public void PrintStats() {

    }
}
