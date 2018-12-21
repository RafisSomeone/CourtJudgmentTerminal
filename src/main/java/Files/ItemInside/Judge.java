package Files.ItemInside;

import java.util.LinkedList;
import java.util.List;

import static Files.ItemInside.SpecialRoles.PRESIDING_JUDGE;
import static Files.ItemInside.SpecialRoles.REPORTING_JUDGE;


public class Judge {
    private String name;
    private String function;
    private List<SpecialRoles> specialRoles;

    public Judge(String name, String role) {
        this.name = name;
        List<SpecialRoles> specialRolesList = new LinkedList<>();
        SpecialRoles specialRoles = null;

        switch (role) {
            case "przewodniczący":
                specialRoles = PRESIDING_JUDGE;
                break;
            case "sprawozdawca":
                specialRoles = REPORTING_JUDGE;
                break;
            default:
                specialRoles = null;
                break;
        }

        if(specialRoles!=null){specialRolesList.add(specialRoles); this.specialRoles = specialRolesList;}
        else this.specialRoles=null;


    }

    public String getName() {
        return this.name;
    }

    public String getSpecialRoles() {
        if (this.specialRoles.size() != 0) return specialRoles.get(0).toString();
        else return null;
    }
}