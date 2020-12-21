package utilities;

import controllers.ProjectController;
import controllers.TeamController;
import objects.Project;
import objects.Team;
import objects.User;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class IO{

    //public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA= new File("src/main/java/Files/UserData.txt");
    public static final String PROJECT_LOCATION = ("src/main/java/Files/Projects/ProjectREPLACE_WITH_ID.txt");
    public static final String PROJECT_FOLDER = ("src/main/java/Files/Projects");
    public static final File PROJECT_ID = new File("src/main/java/Files/ProjectID.txt");
    public static final String TEAM_LOCATION = ("src/main/java/Files/Teams/TeamREPLACE_WITH_ID.txt");
    public static final String TEAM_FOLDER = ("src/main/java/Files/Teams");
    public static final File TEAM_ID = new File("src/main/java/Files/TeamID.txt");

    public static void saveUsers(HashMap users) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
        oos.writeObject(users);
    }
    public static HashMap<Integer,User> readUsers() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA));
        HashMap<Integer, User> users = null;
        try {
            users = (HashMap<Integer, User>) ois.readObject();
        }catch (Exception e){
            System.out.println("readUsers error xD");
        }
        return users;
    }
    public static ArrayList<Project> loadAllProjects(){
        ArrayList<Project> projects = new ArrayList<>();
        File path = new File(PROJECT_FOLDER);
        File[] fileList = path.listFiles();
            for(File file : fileList) {
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    Project loadedProject = (Project) ois.readObject();
                    ProjectController.addProject(loadedProject);
                    ois.close();
                }catch (Exception e){
                    System.out.println("uh oh error in loadAllTeams");
                }
            }
        return projects;
    }
    public static void saveProject(Project project) throws IOException {
        File saveProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(project.getID())));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveProjectFile));
        oos.writeObject(project);
    }
    public static void saveCurrentProject(){
        Project project = ProjectController.getCurrentProject();
        File saveProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(project.getID())));
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveProjectFile));
            oos.writeObject(project);
        }catch(Exception e){
            System.out.println("SaveCurrentProject Error xD");
        }
    }

    public static Project loadProject(int projectID) throws Exception {
        File loadProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(projectID)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadProjectFile));
        Project loadedProject = (Project) ois.readObject();
        return loadedProject;
    }
    public static int loadProjectID(){
        int loadedID;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROJECT_ID));
            loadedID = (int) ois.readObject();
        }catch(Exception e){
            loadedID = 0;
        }
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
    public static void saveCurrentTeam() throws IOException {
        Team t = TeamController.getTeam();
        File saveTeamFile = new File(TEAM_LOCATION.replace("REPLACE_WITH_ID",Integer.toString(t.getTeamID())));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveTeamFile));
        oos.writeObject(t);
    }
    public static void loadAllTeams(){
            File path = new File(TEAM_FOLDER);
            File[] fileList = path.listFiles();
            for(File file : fileList) {
                try{
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    Team loadedTeam = (Team) ois.readObject();
                    TeamController.addTeam(loadedTeam);
                    ois.close();
                }catch (Exception e){
                    System.out.println("uh oh error in loadAllTeams");
                }
            }
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
    public static int loadTeamID(){
        int loadedID;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEAM_ID));
            loadedID = (int) ois.readObject();
        }catch(Exception e){
            loadedID = 0;
        }

        return loadedID;
    }
}
