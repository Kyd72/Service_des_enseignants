package champollion;

import java.util.Objects;

public class UE {
    private final String myIntitule;
    private int heuresCM=0;
    private int heuresTD=0;
    private int heuresTP=0;


    public UE(String intitule) {
        myIntitule = intitule;
    }

    public UE(String myIntitule, int heuresCM, int heuresTD, int heuresTP) {
        this.myIntitule = myIntitule;
        this.heuresCM = heuresCM;
        this.heuresTD = heuresTD;
        this.heuresTP = heuresTP;
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
