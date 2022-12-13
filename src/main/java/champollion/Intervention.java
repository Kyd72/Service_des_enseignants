package champollion;

import java.time.LocalDateTime;

public class Intervention {
    private LocalDateTime debut;
    private int duree;
    private boolean annulee;
    private TypeIntervention type;

    private UE ue;

    private Salle salle ;

    public Intervention(LocalDateTime debut, int duree, TypeIntervention type, Salle salle, UE ue) {
        this.debut = debut;
        this.duree = duree;
        this.type = type;
        this.annulee=false;
        this.salle=salle;
        this.ue=ue;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }
}
