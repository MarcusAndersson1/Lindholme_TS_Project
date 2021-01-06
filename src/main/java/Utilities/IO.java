package Utilities;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import Controllers.ProjectController;
import Controllers.TeamController;
import Utilities.DateHandler;
import javafx.collections.ObservableList;
import Objects.Project.*;
import Objects.Team.Team;
import Objects.User.User;


public class IO {

    //public static final File PROJECT_DATA= new File("Files/ProjectData.txt");
    public static final File USER_DATA = new File("src/main/java/Files/UserData.txt");
    public static final String PROJECT_LOCATION = ("src/main/java/Files/Projects/ProjectREPLACE_WITH_ID.txt");
    public static final String PROJECT_FOLDER = ("src/main/java/Files/Projects");
    public static final File PROJECT_ID = new File("src/main/java/Files/ProjectID.txt");
    public static final String TEAM_LOCATION = ("src/main/java/Files/Teams/TeamREPLACE_WITH_ID.txt");
    public static final String TEAM_FOLDER = ("src/main/java/Files/Teams");
    public static final File TEAM_ID = new File("src/main/java/Files/TeamID.txt");
    // private static final String IMPORT_OBJECTS = "src/main/java/Files/userStories.txt";
    // private static final String IMPORT_RISK ="src/main/java/Files/risk.txt";

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
            BufferedReader myReader = new BufferedReader(new FileReader("src/main/java/Files/" + ProjectController.getCurrentProject().getName() + "/userStory.txt"));
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
            BufferedReader myReader = new BufferedReader(new FileReader("src/main/java/Files/" + ProjectController.getCurrentProject().getName() + "/risks.txt"));
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

    public static void importActivity() {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("src/main/java/Files/"+ ProjectController.getCurrentProject().getName() + "/activities.txt"));
            String data = "";
            while ((data = myReader.readLine()) != null) {
                String[] objects = data.split("[;]");
                String name = objects[0];
                int duration = Integer.parseInt(objects[1]);
                Activity a = ProjectController.createActivity(name,duration);
            }
        } catch (IOException e) {
            System.out.println("Error while reading.");
            e.printStackTrace();// Its printing like a error message
        }
    }
    public static void importMilestone() {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader("src/main/java/Files/"+ ProjectController.getCurrentProject().getName() + "/milestones.txt"));
            String data = "";
            while ((data = myReader.readLine()) != null) {
                String[] objects = data.split("[;]");
                String name = objects[0];
                String deadLine = objects[1];
                Milestone m = ProjectController.createMilestone(name,LocalDate.parse(deadLine, DateHandler.format()));
            }
        } catch (IOException e) {
            System.out.println("Error while reading.");
            e.printStackTrace();// Its printing like a error message
        }
    }

    public static void writeProject (Project p){

        String directoryName = "src/main/java/Files/" + p.getName();
        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
        }
        ArrayList<Risk> risks =  p.getRisks();
        ArrayList<Activity> activities = p.getActivities();
        ArrayList<Milestone> milestones =  p.getMilestones();
        ObservableList<UserStory> userStories = p.getUserStories();

        BufferedWriter writer;
        try {
            int count = 0;
            writer = new BufferedWriter(new FileWriter(directoryName + "/risks.txt", true));
            writer.flush();
            for (Risk r : risks) {
                if (count != 0) {
                    writer.newLine();
                }
                writer.write(r.getName() + ";" + r.getSeverity() + ";" + r.getOccurrence() + ";" + r.getImpact());
                count ++;
            }
            count = 0;
            writer = new BufferedWriter(new FileWriter(directoryName + "/activities.txt", true));
            writer.flush();
            for (Activity a : activities) {
                if (count != 0) {
                    writer.newLine();
                }
                writer.write(a.getName() + ";" + a.getDuration());
                count++;
            }

            count = 0;
            writer = new BufferedWriter(new FileWriter(directoryName + "/milestones.txt", true));
            writer.flush();
            for (Milestone m : milestones) {
                if (count != 0) {
                    writer.newLine();
                }
                writer.write(m.getName() + ";" + m.getMilestoneDate().format(DateHandler.format()));
                count ++;
            }
            count = 0;
            writer = new BufferedWriter(new FileWriter(directoryName + "/userStory.txt", false));
            writer.flush();
            for (UserStory u : userStories) {
                if (count != 0) {
                    writer.newLine();
                }
                writer.write(u.getDescription() + ";" + u.getCreatedDate().format(DateHandler.format()) + ";" + u.getDoneDate().format(DateHandler.format()) + ";" + u.getPoints() + ";" + u.getHours());
                count++;
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing");
            e.printStackTrace();
        }
    }
}

