import java.io.*;

public class IO{

    //public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA= new File("Files/UserData.txt");
    public static final String PROJECT_LOCATION = ("Files/ProjectREPLACE_WITH_ID.txt");

    public static void saveUsers() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
     //oos.writeObject(users);
    }
    public static void readUsers() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA));
       //users = (ArrayList<User>) ois.readObject();
    }
    public static void saveProject(Project project) throws IOException {
        File saveProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(project.getID())));
        //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveProjectFile));
        //oos.writeObject(project);
    }
    public static Project loadProject(int projectID) throws Exception {
        File loadProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(projectID)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadProjectFile));
        Project loadedProject = (Project) ois.readObject();
        return loadedProject;
    }
}
