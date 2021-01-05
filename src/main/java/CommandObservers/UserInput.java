package CommandObservers;

import java.util.ArrayList;

public class UserInput implements UserInputBraodcaster {

    private ArrayList<InputObserver> inputObservers= new ArrayList();
    UserInputController userInputController;

    public UserInput(){
        userInputController = new UserInputController(this);
    }

    @Override
    public void addObserver(InputObserver observer) {
        inputObservers.add(observer);

    }

    public void input(String command){
        for(InputObserver o: inputObservers) {
            o.handleInput(command);
        }
    }
}
