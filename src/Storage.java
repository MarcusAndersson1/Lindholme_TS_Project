package src;

import java.util.HashMap;

public class Storage {

    private static final HashMap <Integer, Project> projectStorage = new HashMap();

    public void addToClass (Integer integer, Project project){
        projectStorage.put(integer, project);
    }




}
