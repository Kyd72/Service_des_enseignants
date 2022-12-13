package champollion;

import java.util.*;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    private final Map<UE,ServicePrevu> mapServicePrevu;
    private List<Intervention> listeInterventions;

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.mapServicePrevu=new HashMap<>();
        this.listeInterventions=new ArrayList<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {

        double heuresCmEquivalentTD=0;
        double heuresTPequivalentTD=0;
        double heuresTD=0;
        ServicePrevu s;

        for (Map.Entry<UE,ServicePrevu> service : mapServicePrevu.entrySet()){
            s= service.getValue();
            heuresCmEquivalentTD=heuresCmEquivalentTD+(s.getVolumeCM()*1.5);
            heuresTPequivalentTD=heuresTPequivalentTD+(s.getVolumeTP()*0.75);
            heuresTD=heuresTD+(s.getVolumeTD());

        }

        return (int) (heuresCmEquivalentTD+heuresTD+heuresTPequivalentTD);

    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {

        double heuresCmEquivalentTD;
        double heuresTPequivalentTD;
        double heuresTD;
        ServicePrevu s;
        if (mapServicePrevu.containsKey(ue)){
             s = mapServicePrevu.get(ue);
            heuresCmEquivalentTD=(s.getVolumeCM()*1.5);
            heuresTPequivalentTD=(s.getVolumeTP()*0.75);
            heuresTD=(s.getVolumeTD());

            return (int) (heuresCmEquivalentTD+heuresTD+heuresTPequivalentTD);

        }

        else return 0;

    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        if (mapServicePrevu.containsKey(ue)){
            mapServicePrevu.get(ue).addVolume(volumeCM,volumeTD,volumeTP);
        }

        else {mapServicePrevu.put(ue,new ServicePrevu(volumeCM,volumeTD,volumeTP));}
    }

    public void ajouteIntervention(Intervention inter){
        this.listeInterventions.add(inter);
    }

    public int resteAPlanifier(UE ue, TypeIntervention type){

        double heureEffectuees =0;
        int resteAPlanifier =0;

        for (Intervention intervention : listeInterventions){
            if (intervention.getUe().equals(ue) && intervention.getType().equals(type)){

                switch (type) {
                    case CM :heureEffectuees+=intervention.getDuree()*1.5; break;
                    case TP :heureEffectuees+=intervention.getDuree()*0.75; break;
                    case TD : heureEffectuees+=intervention.getDuree();break;
                }





            }
        }



        switch (type) {
            case CM :resteAPlanifier = mapServicePrevu.get(ue).getVolumeCM() - ((int)heureEffectuees); break;
            case TP :resteAPlanifier = mapServicePrevu.get(ue).getVolumeTP() - ((int)heureEffectuees); break;
            case TD :resteAPlanifier = mapServicePrevu.get(ue).getVolumeTD() - ((int)heureEffectuees); break;
        }

        return resteAPlanifier;

    }

    public boolean enSousService (){

        return 192-this.heuresPrevues()<0;

    };

}
