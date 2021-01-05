package CommandObservers;

public class UserInputController implements InputObserver {

    public UserInputController(UserInputBraodcaster b) {
        b.addObserver(this);
    }

    @Override
    public void handleInput(String command) {
        if (command.equalsIgnoreCase("Hej")) {
            System.out.println("körv");
        }
        if (command.equalsIgnoreCase("q")) {
            System.out.println("krister");
        }
    }
}