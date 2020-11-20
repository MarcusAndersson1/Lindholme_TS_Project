import java.io.*;

public class IO{

    public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA= new File("Files/UserData.txt");

    public static void saveUsers() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
        oos.writeObject(users);
    }
    public static void readUsers() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA));
        users = (ArrayList<User>) ois.readObject();
    }
}
