package objects;

import java.io.Serializable;

public class Manager extends User implements Serializable {

    public Manager(String name, int id, String createdDate){
        super(name,id,createdDate,"password123","", "");

    }
}
