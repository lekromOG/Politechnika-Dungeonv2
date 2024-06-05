package Monsters;

import Monsters.Monster;
import PolitechnikaDungeon.Player;

public class BasicMonster implements Monster {
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int level;
    private String name;
    private boolean isABoss;

    private String description;

    public BasicMonster(int health, int attack, int defense, int speed, int level, String name) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.name = name;
    }

    public BasicMonster() {

    }

    public void Act(Player player) {


    }

    public void PrintStats() {

    }

    public void LevelUp() {

    }

    public void setABoss(boolean isABoss) {

    }

    public void Attack(Player target) {

    }

    public void Defend() {

    }

    public void TakeDamage(int damage) {

    }

    public void Heal(int health) {

    }

    public boolean isABoss() {
        return false;
    }

    public void Sound() {

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }



}
