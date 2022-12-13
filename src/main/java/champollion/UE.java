package champollion;

import java.util.Objects;

public class UE {
    private final String myIntitule;

    public UE(String intitule) {
        myIntitule = intitule;
    }

    public String getIntitule() {
        return myIntitule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UE ue = (UE) o;
        return myIntitule.equals(ue.myIntitule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myIntitule);
    }
}
