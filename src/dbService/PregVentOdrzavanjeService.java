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
public class PregVentOdrzavanjeService {
   
    private final String imeBaze;
    private final EntityManagerFactory emf;
    
    public PregVentOdrzavanjeService() throws IOException {
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }
    
    public List<db.Pregventodrzavanje> getVentil(String tehOzn) {
       
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Pregventodrzavanje.findByTehozn").setParameter("tehozn", tehOzn);
           
            List<db.Pregventodrzavanje> result = q.getResultList();
            em.close();

            return result;

        } catch (Exception ex) {
            db.Pregventodrzavanje ventil = new db.Pregventodrzavanje();
            List<db.Pregventodrzavanje> result = new ArrayList<>();
            result.add(ventil);
            return result;
        }
    }
    
    public void addOdrzavanje(String tehOznaka,String opis) {

        db.Pregventodrzavanje vent = new db.Pregventodrzavanje();

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Date dNow = new Date( );
            
            vent.setTehozn(tehOznaka);
            vent.setOpis(opis);
            vent.setDatum(dNow);

            em.persist(vent);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
   
        }
    }
    
}
