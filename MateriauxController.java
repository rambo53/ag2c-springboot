package com.mycompany.ag2c.controller;

import com.mycompany.ag2c.entity.Materiaux;
import com.mycompany.ag2c.entity.Toiture;
import com.mycompany.ag2c.entity.TotalVersants;
import com.mycompany.ag2c.service.MateriauxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Scanner;

@Controller
public class MateriauxController {

    @Autowired
    private MateriauxService materiauxService;

    public MateriauxService getMateriauxService() {
        return materiauxService;
    }

    public void setMateriauxService(MateriauxService materiauxService) {
        this.materiauxService = materiauxService;
    }

   @RequestMapping
    public String displayAccueil(){
        System.out.println("display accueil OK");
        return "index";
    }

   @RequestMapping("/liste")
    public  String displayListe(HttpServletRequest request){
       List<Materiaux> materiauxes=materiauxService.list();
       request.setAttribute("materiauxes",materiauxes);
       System.out.println("liste ok");
       return "liste";
    }

    @RequestMapping("/ajout")
    public  String ajoutMateriaux(HttpServletRequest request){
        Materiaux materiau=new Materiaux();
        String nom=request.getParameter("nom");
        materiau.setNom(nom);
        float prix=Float.parseFloat(request.getParameter("prix"));
        materiau.setPrix(prix);
        int stock=Integer.parseInt(request.getParameter("stock"));
        materiau.setStock(stock);
        materiauxService.registerMateriau(materiau);
        System.out.println("ajout ok");
        return "ok-ajout";
    }

    @RequestMapping("/calculs-toiture")
    public String displayCalculsToiture(){
        System.out.println("calculs toiture ok");
        return "calculs-toiture";
    }

    @RequestMapping("/calculs")
    public String displayCalculsResults(HttpServletRequest request){
        System.out.println("debut calculs");

        HttpSession session=request.getSession();
        Toiture toiture=new Toiture();

        float rampant=Float.parseFloat(request.getParameter("rampant"));
        float facade=Float.parseFloat(request.getParameter("facade"));
        float faitage=Float.parseFloat(request.getParameter("faitage"));
        float noue=Float.parseFloat(request.getParameter("noue"));
        float arretier=Float.parseFloat(request.getParameter("arretier"));
        String nomVersant=request.getParameter("nomVersant");
        String forme=request.getParameter("forme");
        String volige=request.getParameter("volige");
        float hauteurArdoise=Float.parseFloat(request.getParameter("hauteurArdoise"));
        float largeurArdoise=Float.parseFloat(request.getParameter("largeurArdoise"));
        float longueurCrochet=Float.parseFloat(request.getParameter("longueurCrochet"));
        float diametreCrochet=Float.parseFloat(request.getParameter("diametreCrochet"));
        float distance=Float.parseFloat(request.getParameter("distance"));
        int nbVelux=Integer.parseInt(request.getParameter("nbVelux"));
        String hauteurVeluxEnString=request.getParameter("hauteurVelux");
        String largeurVeluxEnString=request.getParameter("largeurVelux");

        toiture.setLargeurToiture(rampant);
        toiture.setLongueurToiture(facade);
        toiture.setForme(forme);
        toiture.setVolige(volige);
        toiture.setLongueurFaitage(faitage);
        toiture.setNoue(noue);
        toiture.setArretier(arretier);
        toiture.setHauteurArdoise(hauteurArdoise);
        toiture.setLargeurArdoise(largeurArdoise);
        toiture.setLongueurCrochet(longueurCrochet);
        toiture.setDiametreCrochet(diametreCrochet);
        toiture.setNbVelux(nbVelux);
        toiture.setHauteurVeluxEnString(hauteurVeluxEnString);
        toiture.setLargeurVeluxEnString(largeurVeluxEnString);
        toiture.setDistance(distance);

        float surface=toiture.getSurfaceToiture();
        float pureau=toiture.getPureau();
        float nbLiteau=toiture.getNbLiteau();
        float nbArdoiseAuM2=toiture.getArdoiseAuM2();
        float nbTotalArdoise=toiture.getTotalArdoise();
        float jourDeChantier=toiture.getJourDeTravail();
        float metreLiteau=toiture.getMetreLiteau();
        float longueurVolige=toiture.getLongueurVolige();
        float distanceTotal=toiture.getDistanceTotale();

        request.setAttribute("nomVersant", nomVersant);
        request.setAttribute("surface", surface);
        request.setAttribute("pureau", pureau);
        request.setAttribute("nbLiteau",nbLiteau );
        request.setAttribute("nbArdoiseAuM2",nbArdoiseAuM2 );
        request.setAttribute("nbTotalArdoise",nbTotalArdoise );
        request.setAttribute("jourDeChantier",jourDeChantier );
        request.setAttribute("metreLiteau",metreLiteau );
        request.setAttribute("longueurVolige", longueurVolige);
        request.setAttribute("volige", volige);
        request.setAttribute("distanceTotal", distanceTotal);
        System.out.println("calculs ok");

        TotalVersants versants=(TotalVersants)request.getSession().getAttribute("versants");

        if(versants==null){
            versants = new TotalVersants();
            session.setAttribute("versants", versants);
        }
        versants.getVersants().add(toiture);

        return "calculs-toiture";
    }


    @RequestMapping("/total")
    public String dysplayTotal(HttpServletRequest request){

        TotalVersants versants=(TotalVersants)request.getSession().getAttribute("versants");

        if(versants!=null){

        List<Materiaux> materiauxes=materiauxService.list();
        versants.setMateriauxes(materiauxes);
        versants.calculsTotal();

        float surfaceTotal=versants.getTotalSurfaceChantier();
        float nbArdoisesTotal=versants.getTotalArdoisesChantier();
        float metreLiteauTotal=versants.getTotalMetresLiteauChantier();
        float metreVoligeTotal=versants.getTotalVoligeChantier();
        float joursDeChantierTotal=versants.getTotalJoursChantier();
        float coutTotalArdoises=versants.getCoutTotalArdoises();
        float coutTotalVolige=versants.getCoutTotalvolige();
        float coutTotalLiteau=versants.getCoutTotalLiteau();
        float coutTotalCarburant=versants.getCoutTotalCarburant();
        float coutTotalHoraire=versants.getCoutTotalHoraire();
        float coutTotalRepas=versants.getCoutTotalRepas();
        float coutNoue=versants.getCoutNoue();
        float coutArretier=versants.getCoutArretier();
        float coutTotalChantier=versants.getCoutTotalChantier();
        float coutArdoiseMarge=versants.getCoutArdoiseMarge();
        float coutVoligeMarge=versants.getCoutVoligeMarge();
        float coutLiteauMarge=versants.getCoutLiteauMarge();

        request.setAttribute("surfaceTotal", surfaceTotal);
        request.setAttribute("nbArdoisesTotal", nbArdoisesTotal);
        request.setAttribute("metreLiteauTotal", metreLiteauTotal);
        request.setAttribute("metreVoligeTotal", metreVoligeTotal);
        request.setAttribute("joursDeChantierTotal", joursDeChantierTotal);
        request.setAttribute("coutTotalArdoises", coutTotalArdoises);
        request.setAttribute("coutTotalVolige", coutTotalVolige);
        request.setAttribute("coutTotalLiteau", coutTotalLiteau);
        request.setAttribute("coutTotalCarburant", coutTotalCarburant);
        request.setAttribute("coutTotalHoraire", coutTotalHoraire);
        request.setAttribute("coutTotalRepas", coutTotalRepas);
        request.setAttribute("coutNoue",coutNoue);
        request.setAttribute("coutArretier",coutArretier);
        request.setAttribute("coutTotalChantier", coutTotalChantier);
        request.setAttribute("coutArdoiseMarge", coutArdoiseMarge);
        request.setAttribute("coutVoligeMarge", coutVoligeMarge);
        request.setAttribute("coutLiteauMarge", coutLiteauMarge);


        HttpSession session=request.getSession();
        versants=null;
        session.setAttribute("versants", versants);
        }

        return "total";
    }

    @RequestMapping("/{id}")
    public ModelAndView displayModifier(@PathVariable("id") int id){
        System.out.println("ok modifier");
        ModelAndView mv=new ModelAndView("modifier");
        mv.addObject("materiau",materiauxService.getById(id));
        return mv;
    }

    @RequestMapping("/modifier/{id}")
    public String displayModifier(@PathVariable("id") int id,HttpServletRequest request){
        System.out.println("modif entrée");

        Materiaux materiau=new Materiaux();
        String nom=request.getParameter("nom");
        float prix=Float.parseFloat(request.getParameter("prix"));
        int stock=Integer.parseInt(request.getParameter("stock"));
        materiau.setId(id);
        materiau.setNom(nom);
        materiau.setPrix(prix);
        materiau.setStock(stock);
        materiauxService.updateMateriaux(materiau);
        return "ok-ajout";
    }
}
