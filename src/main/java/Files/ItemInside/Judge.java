package Files.ItemInside;

import java.util.List;

public class Judge {
    private String name;
    private String function;
    private List<String> specialRoles;


    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object other) {
        if(this == other) return true;
        if(!(other instanceof Judge))
            return false;
        Judge that = (Judge) other;
        if(that.name==this.name) return true;
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 13;

        return hash;
    }
}