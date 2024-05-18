public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        if (engine.Run() == 0) {
            System.out.println("Thanx for playing Politechnika Dungeon!");
        } else {
            System.out.println("An error occurred"); // logs?
        }
    }
}
