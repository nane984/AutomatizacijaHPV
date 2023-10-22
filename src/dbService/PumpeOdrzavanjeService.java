/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import up.StartApp;

/**
 *
 * @author branko.scekic
 */
public class PumpeOdrzavanjeService {
    private final String imeBaze;
    private final EntityManagerFactory emf;
    
    public PumpeOdrzavanjeService() throws IOException {
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }
    
    public List<db.Pumpeodrzavanje> getPumpa(String tehOzn) {
       
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Pumpeodrzavanje.findByTehozn").setParameter("tehozn", tehOzn);
           
            List<db.Pumpeodrzavanje> result = q.getResultList();
            em.close();

            return result;

        } catch (Exception ex) {
            db.Pumpeodrzavanje pumpa = new db.Pumpeodrzavanje();
            List<db.Pumpeodrzavanje> result = new ArrayList<>();
            result.add(pumpa);
            return result;
        }
    }
    
     public void addOdrzavanje(String tehOznaka, String opis, int hh, int mm, 
             double v1, double h1, double a1, 
             double v2, double h2, double a2,
             double v3, double h3, double a3,
             double v4, double h4, double a4) {

        db.Pumpeodrzavanje pumpa = new db.Pumpeodrzavanje();

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Date dNow = new Date( );
            
            pumpa.setTehozn(tehOznaka);
            pumpa.setOpis(opis);
            pumpa.setDatum(dNow);
            
            pumpa.setRadhh(hh);
            pumpa.setRadmm(mm);
            
            pumpa.setV1(v1);
            pumpa.setH1(h1);
            pumpa.setA1(a1);
            
            pumpa.setV2(v2);
            pumpa.setH2(h2);
            pumpa.setA2(a2);
            
            pumpa.setV3(v3);
            pumpa.setH3(h3);
            pumpa.setA3(a3);
            
            pumpa.setV4(v4);
            pumpa.setH4(h4);
            pumpa.setA4(a4);

            em.persist(pumpa);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
           
        }
    }
}
