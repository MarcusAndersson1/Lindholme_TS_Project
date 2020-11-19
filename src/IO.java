import java.io.*;

public class IO{

    public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA= new File("Files/UserData.txt");

    public void importUser() {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(USER_DATA));
            String data = "";
            int[] count = new int[4];
            while ((data = myReader.readLine()) != null) {
                String[] objects = data.split("[;]");
                String type = objects[0];
                switch (type.toLowerCase()) {
                    case "1": {

                        break;
                    }
                    case "2": {

                        break;
                    }
                    case "3": {

                        break;
                    }
                    case "4": {

                        break;

                    }
                }
            }
            System.out.println("successfully imported: \n" +
                    count[0]+" Employees\n" +
                    count[1]+" Customers\n" +
                    count[2]+" Games\n" +
                    count[3]+" Albums");
            myReader.close();

        } catch (IOException e) {
            System.out.println("Error while reading.");
            e.printStackTrace();// Its printing like a error message
        }
        }

    public void importProject(int projectID) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(PROJECT_DATA));
            String data = "";
            int[] count = new int[4];
            while ((data = myReader.readLine()) != null) {
                String[] objects = data.split("[;]");
                String type = objects[0];
                switch (type.toLowerCase()) {
                    case "1": {

                        break;
                    }
                    case "2": {

                        break;
                    }
                    case "3": {

                        break;
                    }
                    case "4": {

                        break;

                    }
                }
            }
            System.out.println("successfully imported: \n" +
                    count[0]+" Employees\n" +
                    count[1]+" Customers\n" +
                    count[2]+" Games\n" +
                    count[3]+" Albums");
            myReader.close();

        } catch (IOException e) {
            System.out.println("Error while reading.");
            e.printStackTrace();// Its printing like a error message
        }
    }

    public static void saveObject(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(PROJECT_DATA, true));
            writer.flush(); // we dont need this but better safe then sorry
            writer.write("\n" );
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing");
            e.printStackTrace();
        }
    }
}
