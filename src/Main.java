

public class Main {
    public static void main(String[] args) {

        Main main = new Main();
        main.runController();


    }

    protected void runController (){
        Controller controller = new Controller();
        controller.controllerMenu();
    }
}
