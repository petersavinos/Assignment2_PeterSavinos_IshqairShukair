import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TextUI {
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public void play(Dungeon d) {
        while (!d.isFinished()){
            print(d);
            Action a = ask(d);
            a.execute();
        }
        System.out.println("Game Over!");
    }

    private void print(Dungeon d){
        Chamber c = d.getCurrentChamber();
        System.out.println("You are in a chamber with " + c.getDoors().size() + " doors.");
        System.out.println("There are " + c.getItems().size() + " items in this chamber!");
        int idx = 1;
        for (Door door : c.getDoors()) {
            Monster m = door.getGuard();
            System.out.printf(" Door %d: %s%n", idx++, m==null? "unguarded" : m.toString());
        }
        System.out.println();
    }

    private Action ask (Dungeon d) {
        List<Action> actions = d.getActions();
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("[%d] %s%n", i, actions.get(i).description());
        }
        System.out.print("Choose> ");
        try {
            int cmd = Integer.parseInt(in.readLine());
            return actions.get(cmd);
        } catch (Exception e) {
            System.out.println("Invalid Choice!");
            return ask(d);
        }
    }
}
