package Utilities;

import Controllers.ProjectController;
import Controllers.TeamController;
import Objects.Project.Project;
import Objects.Project.Risk;
import Objects.Project.UserStory;
import Objects.Team.Team;
import Objects.User.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class IO {

    //public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA = new File("src/main/java/Files/UserData.txt");
    public static final String PROJECT_LOCATION = ("src/main/java/Files/Projects/ProjectREPLACE_WITH_ID.txt");
    public static final String PROJECT_FOLDER = ("src/main/java/Files/Projects");
    public static final File PROJECT_ID = new File("src/main/java/Files/ProjectID.txt");
    public static final String TEAM_LOCATION = ("src/main/java/Files/Teams/TeamREPLACE_WITH_ID.txt");
    public static final String TEAM_FOLDER = ("src/main/java/Files/Teams");
    public static final File TEAM_ID = new File("src/main/java/Files/TeamID.txt");
    private static final String IMPORT_OBJECTS = "src/main/java/Files/userStories.txt";
    private static final String IMPORT_RISK ="src/main/java/Files/risk.txt";

    public static void saveUsers(HashMap<Integer, User> users) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA));
            oos.writeObject(users);
        } catch (Exception e) {
            System.out.println("Save users error");
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, User> readUsers() {
        HashMap<Integer, User> users = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA));
            users = (HashMap<Integer, User>) ois.readObject();
        } catch (Exception e) {
            System.out.println("readUsers error xD");
        }
        return users;
    }

    public static ArrayList<Project> loadAllProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        File path = new File(PROJECT_FOLDER);
        File[] fileList = path.listFiles();
        for (File file : fileList) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Project loadedProject = (Project) ois.readObject();
                ProjectController.addProject(loadedProject);
                ois.close();
            } catch (Exception e) {
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

    public static void saveCurrentProject() {
        Project project = ProjectController.getCurrentProject();
        File saveProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(project.getID())));
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveProjectFile));
            oos.writeObject(project);
        } catch (Exception e) {
            System.out.println("SaveCurrentProject Error xD");
        }
    }

    public static Project loadProject(int projectID) throws Exception {
        File loadProjectFile = new File(PROJECT_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(projectID)));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(loadProjectFile));
        Project loadedProject = (Project) ois.readObject();
        return loadedProject;
    }

    public static int loadProjectID() {
        int loadedID;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PROJECT_ID));
            loadedID = (int) ois.readObject();
        } catch (Exception e) {
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
        File saveTeamFile = new File(TEAM_LOCATION.replace("REPLACE_WITH_ID", Integer.toString(t.getTeamID())));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveTeamFile));
        oos.writeObject(t);
    }

    public static void loadAllTeams() {
        File path = new File(TEAM_FOLDER);
        File[] fileList = path.listFiles();

        for (File file : fileList) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                Team loadedTeam = (Team) ois.readObject();
                TeamController.addTeam(loadedTeam);
                ois.close();
            } catch (Exception e) {
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

    public static int loadTeamID() {
        int loadedID;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TEAM_ID));
            loadedID = (int) ois.readObject();
        } catch (Exception e) {
            loadedID = 0;
        }

        return loadedID;
    }

    public static void importObject() {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(IMPORT_OBJECTS));
            String data = "";
            while ((data = myReader.readLine()) != null) {
                String[] objects = data.split("[;]");
                String name = objects[0];
                String createdDate = objects[1];
                String endDate = objects[2];
                int point = Integer.parseInt(objects[3]);
                int hours = Integer.parseInt(objects[4]);
                UserStory u = ProjectController.createUserStory(name, ProjectController.getCurrentProject());
                u.setCreatedDate(LocalDate.parse(createdDate, DateHandler.format()));
                u.setDoneDate(LocalDate.parse(endDate, DateHandler.format()));
                u.setPoints(point);
                u.overRideHours(hours);
            }
        } catch (IOException e) {
            System.out.println("Error while reading.");
            e.printStackTrace();// Its printing like a error message
        }
        System.out.println("User stories loaded succesfully");
    }

    public static void importRisk() {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(IMPORT_RISK));
            String data = "";
            while ((data = myReader.readLine()) != null) {
                String[] objects = data.split("[;]");
                String name = objects[0];
                int severity = Integer.parseInt(objects[1]);
                int occurrence = Integer.parseInt(objects[2]);
                int impact = Integer.parseInt(objects[3]);
                Risk r = ProjectController.createRisk(name);
                r.setSeverity(severity);
                r.setOccurrence(occurrence);
                r.setImpact(impact);
            }
        } catch (IOException e) {
            System.out.println("Error while reading.");
            e.printStackTrace();// Its printing like a error message
        }
    }
}

