import java.util.Timer;

public class Player {
    private Timer timer;
    private int remainingTime;
    private String name;

    public Player() {
        this.timer = new Timer();
        this.remainingTime = 0;
    }

    public void MakeTurn() {
    }

    public String GetName() {
        return this.name;
    }

    public String SetName(final String _name) {
        this.name = _name;
        return _name;
    }
}
