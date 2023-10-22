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

/**
 *
 * @author Branko
 */
public class KumulativnoService {

    private final String imeBaze;
    private final EntityManagerFactory emf;

    public KumulativnoService() {
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }

    public db.Kumulativno addKumulativno(String tehOznaka1) {
        db.Kumulativno kumulativno = new db.Kumulativno();
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            kumulativno.setTehozn(tehOznaka1);
            kumulativno.setVrednost(0);
            
            em.persist(kumulativno);
            
            em.getTransaction().commit();
            em.close();
            return kumulativno;

        } catch (Exception e) {
            db.Kumulativno kum = new db.Kumulativno();
            kum.setTehozn("__");
            kum.setVrednost(0);
            System.out.println(e);
            return kum;
        }
    }

    public db.Kumulativno getKumulativnoStanje(String tehOzn) {

        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createNamedQuery("Kumulativno.findByTehozn").setParameter("tehozn", tehOzn);
            
            db.Kumulativno result = (db.Kumulativno) q.getSingleResult();
            em.close();

            return result;

        } catch (Exception ex) {
            return addKumulativno(tehOzn);
        }
    }

    public void setKumulativno(String tehOzn, double kum) {
        db.Kumulativno kumul = getKumulativnoStanje(tehOzn);
        if (kumul.getTehozn().equals("__")) {
            addKumulativno(tehOzn);
        } else {
            db.Kumulativno kumulativno = getKumulativnoStanje(tehOzn);
            try {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                kumulativno.setVrednost(kum);

                em.persist(kumulativno);
                em.getTransaction().commit();
                em.close();

            } catch (Exception ex) {

            }
        }
    }
}
