/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.util.ArrayList;
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
public class PregVentService {

    private final String imeBaze;
    private final EntityManagerFactory emf;

    
    public PregVentService() {
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }

    public db.Pregvent getVentil(String tehOzn) {
        
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Pregvent.findByTehozn").setParameter("tehozn", tehOzn);
            //Query q = em.createQuery("SELECT p FROM Pregvent p WHERE p.tehozn = :tehOz");
            //q.setParameter("tehOz", str);

            db.Pregvent result = (db.Pregvent) q.getSingleResult();
            em.close();

            return result;

        } catch (Exception ex) {
            db.Pregvent ventil = new db.Pregvent();
            ventil.setVirtualno(true);
            return ventil;
        }
    }

    public db.Pregvent getVentil(String titl, String opis) {
       
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Pregvent.findByTitleAndOpis").setParameter("title", titl).setParameter("opis", opis);

            db.Pregvent result = (db.Pregvent) q.getSingleResult();
            em.close();

            return result;

        } catch (Exception ex) {
            db.Pregvent ventil = new db.Pregvent();
            ventil.setVirtualno(true);
            return ventil;
        }
    }

    public List<db.Pregvent> getAllVentili() {
        
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Pregvent.findAll");

            List<db.Pregvent> result = q.getResultList();
            em.close();

            return result;

        } catch (Exception ex) {
            db.Pregvent ventil = new db.Pregvent();
            List<db.Pregvent> result = new ArrayList<>();
            result.add(ventil);
            return result;
        }
    }

    public void addNewVentil(String tehOznaka, String title, String opis) {

        db.Pregvent vent = new db.Pregvent();

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            vent.setTehozn(tehOznaka);
            vent.setTitle(title);
            vent.setOpis(opis);
            vent.setVirtualno(true);

            em.persist(vent);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
   
        }
    }

    public void updateVent(String tehOzn, boolean ocitavanje) {
        try {
            EntityManager em = emf.createEntityManager();
            db.Pregvent ventil = em.find(db.Pregvent.class, tehOzn);
            em.getTransaction().begin();

            ventil.setVirtualno(ocitavanje);

            em.persist(ventil);
            em.getTransaction().commit();
            em.close();

        } catch (Exception ex) {
           
        }
    }
}
