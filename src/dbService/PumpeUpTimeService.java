/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import up.StartApp;

/**
 *
 * @author branko.scekic
 */
public class PumpeUpTimeService {
   

    private final String imeBaze;
    private final EntityManagerFactory emf;

    
    public PumpeUpTimeService(){
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }
    
    public db.Pumpeuptime getPumpaRadniSati(String tehOzn) {
       
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Pumpeuptime.findByTehozn").setParameter("tehozn", tehOzn);
            
            db.Pumpeuptime result = (db.Pumpeuptime) q.getSingleResult();
            em.close();

            return result;

        } catch (Exception ex) {
           
            db.Pumpeuptime pumpa = new db.Pumpeuptime();
            return pumpa;
        }
    }
    
    public void addPumpaRadniSati(String tehOzn, int hh, int mm) {

        db.Pumpeuptime pumpa = new db.Pumpeuptime();

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Date dNow = new Date();
            pumpa.setTehozn(tehOzn);
            pumpa.setHh(hh);
            pumpa.setMm(mm);
            pumpa.setDatum(dNow);

            em.persist(pumpa);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            
        }
    }
    
    public void updatePumpaRadniSati(String tehOzn, int hh, int mm) {

        try {
            EntityManager em = emf.createEntityManager();
            db.Pumpeuptime pumpa = em.find(db.Pumpeuptime.class, tehOzn);
            em.getTransaction().begin();

            pumpa.setHh(hh);
            pumpa.setMm(mm);

            em.persist(pumpa);
            em.getTransaction().commit();
            em.close();

        } catch (Exception ex) {
           
        }
    }
}
