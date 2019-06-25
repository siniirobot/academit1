import ru.academItSchool.gorbunov.Minesweeper.Model.Timer;

import java.util.LinkedList;
import java.util.Queue;

public class temp {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        Thread thread = new Thread(timer);
        boolean iter = false;
        thread.start();
        System.out.println(timer.getTime());
        while (timer.getTime() < 50) {
            System.out.println(timer.getTime());
            Thread.sleep(500);
            if (timer.getTime() > 3){
                thread.interrupt();
            }
            if (thread.isInterrupted()) {
                System.exit(-1);
            }
        }

    }
}
