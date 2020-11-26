package ProjectPlanning;

import utilities.Input;

import java.io.Serializable;
import java.util.ArrayList;

public class RiskManagement implements Serializable {
    ArrayList<Risk> risks = new ArrayList<>();
    public RiskManagement(){

    }

    Risk createRisk(String name){
        Risk risk = new Risk(name);
        return risk;
    }
    public void addRisk(){
        String name = Input.fetchInputString("Enter risk name: ");
        risks.add(createRisk(name));
    }
    public void riskAssesment(){
        for (Risk r: risks) {
            if(r.getSeverity()<=0){
                System.out.println(r.getName());
                r.setSeverity(Input.fetchInputInt("Enter severity of risk"));
            }
            if(r.getOccurrence()<=0){
                System.out.println(r.getName());
                r.setOccurrence(Input.fetchInputInt("Enter Occurrence of risk"));
            }
        }
    }
}
