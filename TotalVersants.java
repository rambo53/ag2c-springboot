package com.mycompany.ag2c.entity;


import com.mycompany.ag2c.service.MateriauxService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class TotalVersants {

    @Autowired
    private MateriauxService materiauxService;

    public TotalVersants() {
    }

    public MateriauxService getMateriauxService() {
        return materiauxService;
    }

    public void setMateriauxService(MateriauxService materiauxService) {
        this.materiauxService = materiauxService;
    }

    public ArrayList<Toiture> versants = new ArrayList<>();

    final static int NB_HEURES_TRAVAILLE_JOURNALIERE = 8;

    final float TVA = 0.8f;

    private Map<Integer,Float> totalMateriaux=new HashMap<>();
    int lastId=1;
    private List<Materiaux> materiauxes;
    private float totalArdoisesChantier;
    private float coutTotalArdoises;
    private float totalJoursChantier;
    private float coutTotalHoraire;
    private float coutTotalRepas;
    private float totalVoligeChantier;
    private float coutTotalvolige;
    private float totalMetresLiteauChantier;
    private float coutTotalLiteau;
    private float totalSurfaceChantier;
    private float coutTotalCarburant;
    private float coutArdoiseMarge;
    private float coutVoligeMarge;
    private float coutLiteauMarge;
    private float distanceTotaleChantier;
    private float noueTotal;
    private float coutNoue;
    private float arretierTotal;
    private float coutArretier;

    private float coutTotalChantier;


    public float getTotalArdoisesChantier() {
        return totalArdoisesChantier;
    }


    public float getCoutTotalArdoises() {

        return coutTotalArdoises;
    }


    public float getTotalJoursChantier() {

        return totalJoursChantier;
    }

    public float getTotalVoligeChantier() {
        return totalVoligeChantier;
    }

    public float getCoutTotalvolige() {
        return coutTotalvolige;
    }

    public float getTotalMetresLiteauChantier() {
        return totalMetresLiteauChantier;
    }

    public float getCoutTotalLiteau() {return coutTotalLiteau;}

    public float getTotalSurfaceChantier() {
        return totalSurfaceChantier;
    }

    public ArrayList<Toiture> getVersants() {
        return versants;
    }

    public float getCoutTotalHoraire() {return coutTotalHoraire;}

    public float getCoutTotalRepas() {return coutTotalRepas;}

    public float getCoutTotalCarburant() {return coutTotalCarburant;}

    public float getCoutTotalChantier() {
        coutTotalChantier=coutTotalChantier();
        return coutTotalChantier;
    }

    public float getCoutArdoiseMarge() {
        return coutArdoiseMarge;
    }

    public float getCoutVoligeMarge() {
        return coutVoligeMarge;
    }

    public float getCoutLiteauMarge() {
        return coutLiteauMarge;
    }

    public float getDistanceTotaleChantier() {
        return distanceTotaleChantier;
    }

    public float getNoueTotal() {
        return noueTotal;
    }

    public float getCoutNoue() {
        return coutNoue;
    }

    public float getArretierTotal() {
        return arretierTotal;
    }

    public float getCoutArretier() {
        return coutArretier;
    }

    //SETTERS


    public void setTotalArdoisesChantier(float totalArdoisesChantier) {
        this.totalArdoisesChantier = totalArdoisesChantier;
    }

    public void setCoutTotalArdoises(float coutTotalArdoises) {
        this.coutTotalArdoises = coutTotalArdoises;
    }

    public void setTotalJoursChantier(float totalJoursChantier) {
        this.totalJoursChantier = totalJoursChantier;
    }

    public void setCoutTotalHoraire(float coutTotalHoraire) {
        this.coutTotalHoraire = coutTotalHoraire;
    }

    public void setCoutTotalRepas(float coutTotalRepas) {
        this.coutTotalRepas = coutTotalRepas;
    }

    public void setTotalVoligeChantier(float totalVoligeChantier) {
        this.totalVoligeChantier = totalVoligeChantier;
    }

    public void setCoutTotalvolige(float coutTotalvolige) {
        this.coutTotalvolige = coutTotalvolige;
    }

    public void setTotalMetresLiteauChantier(float totalMetresLiteauChantier) {this.totalMetresLiteauChantier = totalMetresLiteauChantier;}

    public void setCoutTotalLiteau(float coutTotalLiteau) {
        this.coutTotalLiteau = coutTotalLiteau;
    }

    public void setTotalSurfaceChantier(float totalSurfaceChantier) { this.totalSurfaceChantier = totalSurfaceChantier; }

    public void setCoutTotalCarburant(float coutTotalCarburant) {
        this.coutTotalCarburant = coutTotalCarburant;
    }

    public void setCoutArdoiseMarge(float coutArdoiseMarge) {
        this.coutArdoiseMarge = coutArdoiseMarge;
    }

    public void setCoutVoligeMarge(float coutVoligeMarge) {
        this.coutVoligeMarge = coutVoligeMarge;
    }

    public void setCoutLiteauMarge(float coutLiteauMarge) {
        this.coutLiteauMarge = coutLiteauMarge;
    }

    public void setCoutTotalChantier(float coutTotalChantier) {
        this.coutTotalChantier = coutTotalChantier;
    }

    public void setVersants(ArrayList<Toiture> versants) {
        this.versants = versants;
    }

    public void setMateriauxes(List<Materiaux> materiauxes) {
        this.materiauxes = materiauxes;
    }

    public List<Materiaux> getMateriauxes() {
        return materiauxes;
    }

    public void setDistanceTotaleChantier(float distanceTotaleChantier) {this.distanceTotaleChantier = distanceTotaleChantier;}

    public void setNoueTotal(float noueTotal) {
        this.noueTotal = noueTotal;
    }

    public void setCoutNoue(float coutNoue) {
        this.coutNoue = coutNoue;
    }

    public void setArretierTotal(float arretierTotal) {
        this.arretierTotal = arretierTotal;
    }

    public void setCoutArretier(float coutArretier) {
        this.coutArretier = coutArretier;
    }

    //METHODES


    public void calculsTotal() {

        for (Toiture toiture : versants) {

            totalArdoisesChantier += toiture.nbTotalArdoise();
            totalJoursChantier+=toiture.getJourDeTravail();
            totalVoligeChantier+=toiture.getLongueurVolige();
            totalMetresLiteauChantier+=toiture.getMetreLiteau();
            totalSurfaceChantier+=toiture.getSurfaceToiture();
            distanceTotaleChantier+=toiture.getDistanceTotale();
            noueTotal+=toiture.getNoue();
            arretierTotal+=toiture.getArretier();
        }

        totalMateriaux.put(lastId,totalArdoisesChantier);
        setCoutTotalArdoises(cherchePrix(lastId));
        lastId++;

        totalMateriaux.put(lastId,totalVoligeChantier);
        setCoutTotalvolige(cherchePrix(lastId));
        lastId++;

        totalMateriaux.put(lastId,totalMetresLiteauChantier);
        setCoutTotalLiteau(cherchePrix(lastId));
        lastId++;

        coutTotalHoraire=(totalJoursChantier*NB_HEURES_TRAVAILLE_JOURNALIERE)*cherchePrix(lastId);
        setCoutTotalHoraire(coutTotalHoraire);
        lastId++;

        coutTotalRepas=totalJoursChantier*cherchePrix(lastId);
        setCoutTotalRepas(coutTotalRepas);
        lastId++;

        coutArdoiseMarge=totalArdoisesChantier*cherchePrix(lastId);
        setCoutArdoiseMarge(coutArdoiseMarge);
        coutVoligeMarge=totalVoligeChantier*cherchePrix(lastId);
        setCoutVoligeMarge(coutVoligeMarge);
        coutLiteauMarge=totalMetresLiteauChantier*cherchePrix(lastId);
        setCoutLiteauMarge(coutLiteauMarge);
        lastId++;

        float prixCarburant=cherchePrix(lastId);
        System.out.println("le prix carbu est "+prixCarburant);
        lastId++;
        System.out.println("la distance chantier est "+distanceTotaleChantier);
        coutTotalCarburant=distanceTotaleChantier*prixCarburant/cherchePrix(lastId);
        setCoutTotalCarburant(coutTotalCarburant);
        lastId++;

        totalMateriaux.put(lastId,noueTotal);
        setCoutNoue(cherchePrix(lastId));
        lastId++;

        totalMateriaux.put(lastId,arretierTotal);
        setCoutArretier(cherchePrix(lastId));

    }


    public float cherchePrix(int lastId){
        System.out.println(lastId);
        float cout=0;
        if(totalMateriaux.containsKey(lastId)){
            for(Materiaux materiaux:materiauxes){
                if(materiaux.getId()==lastId) {
                    System.out.println(materiaux.getPrix());
                    cout = totalMateriaux.get(lastId) * materiaux.getPrix();
                }
            }
        }
        else{
            for(Materiaux materiaux:materiauxes){
                if(materiaux.getId()==lastId){
                    cout=materiaux.getPrix();
                    System.out.println(cout);
                }
            }
        }
        return cout;
    }

    public float coutTotalChantier(){

        coutTotalChantier=(float) Math.ceil(coutTotalArdoises+coutTotalCarburant+coutTotalHoraire+coutTotalLiteau+coutTotalRepas+coutTotalvolige+coutTotalCarburant);

        return coutTotalChantier;
    }


}
