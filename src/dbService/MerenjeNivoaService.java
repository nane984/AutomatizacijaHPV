/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.time.LocalDateTime;
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
public class MerenjeNivoaService {
    
    private final String imeBaze;
    private final EntityManagerFactory emf;
    
    public MerenjeNivoaService(){
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }
    
    
    public void addMerenjeNivoa(int luzinarez1, int luzinarez2,
                int rezervoarDEMIvode1000m3br1,
                int rezervoarDEMIvode1000m3br2,
                int rezervoarKompenzacioni500m3,
                int bazenNeutralizacioni,
                int rezervoarDEMIvode150m3,
                int bazenDekaNefiltriraneVode,
                int bazenDekaFiltriraneVode,
                int bazenOtpadneVodeOdPranjaPescanihFiltera,
                int rezervoarFeCl){
        
        db.Merenjenivoa nivoi = new db.Merenjenivoa();
        
         try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Date dNow = new Date( );
            nivoi.setLuzinarezervoar1(luzinarez1);
            nivoi.setLuzinarezervoar2(luzinarez2);
            nivoi.setDemivodarezervoar1(rezervoarDEMIvode1000m3br1);
            nivoi.setDemivodarezervoar2(rezervoarDEMIvode1000m3br2);
            nivoi.setKompenzacionirezervoar(rezervoarKompenzacioni500m3);
            nivoi.setNeutralizacionibazen(bazenNeutralizacioni);
            nivoi.setDemivodarezervoar150(rezervoarDEMIvode150m3);
            nivoi.setDekanefiltriranavoda(bazenDekaNefiltriraneVode);
            nivoi.setDekafiltriranavoda(bazenDekaFiltriraneVode);
            nivoi.setOdpranjapf(bazenOtpadneVodeOdPranjaPescanihFiltera);
            nivoi.setRezervoarfecl(rezervoarFeCl);
            nivoi.setDatum(dNow);
            em.persist(nivoi);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            
        }
    }
    
    public List<db.Merenjenivoa> getNivoiLastHour(){
        EntityManager em = emf.createEntityManager();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneOureMinus = LocalDateTime.now().minusHours(1);
        Query q = em.createQuery("select m.=:merenje from db.Merenjenivoa m WHERE m.datum <= :datum AND m.datum >= :oneOureMinus");
        q.setParameter("datum", now);
        q.setParameter("oneOureMinus", oneOureMinus);
        List<db.Merenjenivoa> result = q.getResultList();
        em.close();
        return result;
    }
}
