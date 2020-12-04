package utilities;

import objects.Project;
import objects.Team;

import java.io.*;

public class IO{

    //public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA= new File("src/Files/UserData.txt");
    public static final String PROJECT_LOCATION = ("src/Files/ProjectREPLACE_WITH_ID.txt");
    public static final File PROJECT_ID = new File("src/Files/ProjectID.txt");
    public static final String TEAM_LOCATION = ("src/Files/TeamREPLACE_WITH_ID.txt");
    public static final File TEAM_ID = new File("src/Files/TeamID.txt");

    public static void saveUsers() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
     //oos.writeObject(users);
    }
    public static void readUsers() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA));
       //users = (ArrayList<objects.User>) ois.readObject();
    }
    public static void saveProject(Project project) throws IOException {
        //File saveProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(project.getID())));
        File saveProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", "1"));
        saveProjectFile.createNewFile(); //if else här kanske
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveProjectFile));
        oos.writeObject(project);
    }
    public static Project loadProject(int projectID) throws Exception {
        File loadProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(projectID)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadProjectFile));
        Project loadedProject = (Project) ois.readObject();
        return loadedProject;
    }
    public static int loadProjectID() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROJECT_ID));
        int loadedID = (int) ois.readObject();
        return loadedID;
    }
    public static void saveProjectID(int projectID) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROJECT_ID));
        oos.writeObject(projectID);
    }
    public static void saveTeamID(int teamID) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TEAM_ID));
        oos.writeObject(teamID);
    }


    public static void saveTeam(Team team) throws IOException {
        File saveTeamFile = new File(TEAM_LOCATION.replace("REPLACE_WITH_ID", "1"));
        saveTeamFile.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveTeamFile));
        oos.writeObject(team);
    }
    public static Team loadTeam(int teamID) throws Exception {
        File loadTeamFile = new File(TEAM_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(teamID)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadTeamFile));
        Team loadedTeam = (Team) ois.readObject();
        return loadedTeam;
    }
    public static int loadTeamID() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEAM_ID));
        int loadedID = (int) ois.readObject();
        return loadedID;
    }
}
