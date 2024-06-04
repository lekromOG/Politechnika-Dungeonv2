package PolitechnikaDungeon;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        if (engine.Run() == 0) {
            System.out.println("Thanx for playing Politechnika PolitechnikaDungeon.Dungeon!");
            // No objects here - this is why we have engine.Run()
        } else {
            System.out.println("An error occurred"); // logs?
        }
    }
}

/*
* TODO:
*  First phase (Taking input, setting new game):
* 1. Parsing input by context
*    PolitechnikaDungeon.Main menu (New Game, Load Game, Exit)
*    PolitechnikaDungeon.Parser:
*    Takes String -> input[0].toLower()
*    for option in options:
*       if option[0].toLower() == input[0].toLower()
*           return PolitechnikaDungeon.Action
*
*
* Classes implementing core of the game
*  PolitechnikaDungeon.Dungeon:
*   Holds in:
*   currentLevel
*   dsswewed
*
*
*
* Creature classes:
* PolitechnikaDungeon.Player:
* Monsters.Monster (interface):
* AI (interface)
* Enum AIType:
* PolitechnikaDungeon.Item (interface):
* Spell (interface):
* Level (interface)
*
* General description:
*
*
*
* Classes:
*  - Mage
*  - Warrior
*  - Rogue
*  - Paladin
*  - Ranger
*  - Cleric
*  - Warlock
*  - Necromancer
*  - Barbarian
*  - Bard
*  - Druid
*
* Bosses:
*  - Chris Von Sea (Pirate)
*  - Your Drunken Dad (Barbarian)
*  - Spigniev Coconut (Necromancer)
*  - Christopher Shiffler (Bard)
*  - Pavlik (Ranger)
*  - Mario the Saint (Mage)
*  - Dziekan from Bangladesh (Cleric)
*  - Florg Geoid (Negromancer)
*  - Discrete King (Mage)
*  - Hungarian Mario (Warrior)
*  - The King (Wizard)
*  - Elizabeth Schabat (Orc Warrior)
*  - The judge (Paladin)
*  - Jean Pedo-Feel II (Pope) (throws creampuffs)) if student less than 18 .....
*  -
*
* S U P E R N I G G E R
* ░░░░░░░░░░░░░▄▄▀▀▀▀▀▀▄▄
░░░░░░░░░░▄▄▀▄▄▄█████▄▄▀▄
░░░░░░░░▄█▀▒▀▀▀█████████▄█▄
░░░░░░▄██▒▒▒▒▒▒▒▒▀▒▀▒▀▄▒▀▒▀▄
░░░░▄██▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▄
░░░░██▀▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█▌
░░░▐██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▐█
░▄▄███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒█
▐▒▄▀██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▐▌
▌▒▒▌▒▀▒▒▒▒▒▒▄▀▀▄▄▒▒▒▒▒▒▒▒▒▒▒▒█▌
▐▒▀▒▌▒▒▒▒▒▒▒▄▄▄▄▒▒▒▒▒▒▒▀▀▀▀▄▒▐
░█▒▒▌▒▒▒▒▒▒▒▒▀▀▒▀▒▒▐▒▄▀██▀▒▒▒▌
░░█▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▐▒▒▒▒▒▒▒▒█
░░░▀▌▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▌▒▒▒▒▒▒▄▀
░░░▐▒▒▒▒▒▒▒▒▒▄▀▐▒▒▒▒▒▐▒▒▒▒▄▀
░░▄▌▒▒▒▒▒▒▒▄▀▒▒▒▀▄▄▒▒▒▌▒▒▒▐▀▀▀▄▄▄
▄▀░▀▄▒▒▒▒▒▒▒▒▀▀▄▄▄▒▄▄▀▌▒▒▒▌░░░░░░
▐▌░░░▀▄▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▄▀░░░░░░░
░█░░░░░▀▄▄▒▒▒▒▒▒▒▒▒▒▒▒▄▀░█░░░░░░░
░░█░░░░░░░▀▄▄▄▒▒▒▒▒▒▄▀░░░░█░░░░░░
░░░█░░░░░░░░░▌▀▀▀▀▀▀▐░░░░░▐▌░░░░░
*
* */
