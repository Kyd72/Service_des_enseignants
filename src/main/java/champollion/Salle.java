package champollion;

import java.util.Objects;

public class Salle {

    public String intitule;
    public int capacite;

    public Salle(String intitule, int capacite) {
        this.intitule = intitule;
        this.capacite = capacite;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return capacite == salle.capacite && intitule.equals(salle.intitule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(intitule, capacite);
    }
}
