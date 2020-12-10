package objects;

import java.io.Serializable;

public class ManagerUser extends User implements Serializable {

    public ManagerUser(String name, int id, String createdDate){
        super(name,id,createdDate,"password123","", "");

    }
}
