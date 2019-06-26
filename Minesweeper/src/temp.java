import ru.academItSchool.gorbunov.Minesweeper.Model.Timer;

import java.util.LinkedList;
import java.util.Queue;

public class temp {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        thread.start();
        System.out.println(timer.getTime());
        while (timer.getTime() < 50) {
            System.out.println(timer.getTime());
            if (timer.getTime() >= 5) {
                timer.stop();
            }
        }

    }
}
