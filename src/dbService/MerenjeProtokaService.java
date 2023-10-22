/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

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
public class MerenjeProtokaService {
    private final String imeBaze;
    private final EntityManagerFactory emf;
    
    public MerenjeProtokaService(){
        imeBaze = "AutomatizacijaHPVPU";
        emf = Persistence.createEntityManagerFactory(imeBaze);
    }
    
    //Kiselina je hcl
    public void addMerenjeProtoka(
                double protokDL1in, double protokDL2in, double protokDL3in,
                double protokDL1out, double protokDL2out, double protokDL3out,
                double protociPretovarnaRampaKiseline,
                double protociPretovarnaRampaLuzine,
                double protociKiselinaPotisDozirPumpi,
                double protociSiroveVodeR1,
                double protociSiroveVodeR2,
                double protociPescaniFilteri1, 
                double protociPescaniFilteri2,
                double protociPescaniFilteri3,
                double protociPescaniFilteri4,
                double protociPescaniFilteri5,
                double protociPescaniFilteri6,
                double protociNJ1,
                double protociNJ2,
                double protociNJ3,
                double kompenzRezervoar){   
        
        db.Merenjeprotoka protok = new db.Merenjeprotoka();
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Date dNow = new Date( );
            
            protok.setDate(dNow);
            
            protok.setUlazdl1(protokDL1in);
            protok.setUlazdl1(protokDL2in);
            protok.setUlazdl1(protokDL3in);
            protok.setIzlazdl1(protokDL1out);
            protok.setIzlazdl2(protokDL2out);
            protok.setIzlazdl3(protokDL3out);
            protok.setHclpotispretovarnihpumi(protociPretovarnaRampaKiseline);
            protok.setLuzinapotispretovarnihpumi(protociPretovarnaRampaLuzine);
            protok.setSirovavodaureaktor1(protociSiroveVodeR1);
            protok.setSirovavodaureaktor2(protociSiroveVodeR2);
            protok.setPf1(protociPescaniFilteri1);
            protok.setPf2(protociPescaniFilteri2);
            protok.setPf3(protociPescaniFilteri3);
            protok.setPf4(protociPescaniFilteri4);
            protok.setPf5(protociPescaniFilteri5);
            protok.setPf6(protociPescaniFilteri6);
            protok.setNi1(protociNJ1);
            protok.setNi2(protociNJ2);
            protok.setNi3(protociNJ3);
            protok.setKompenzacionirezervoar(kompenzRezervoar);
            
            em.persist(protok);
            em.getTransaction().commit();
            em.close();
   
        } catch (Exception e) {
          
        }
    }
    
    public List<db.Merenjeprotoka> getProtokLastHour(String measure){
        EntityManager em = emf.createEntityManager();
        Date date = new Date();  
        Date minutesBefore = new Date(System.currentTimeMillis() - 900 * 1000);
        Query q = em.createQuery("SELECT m FROM Merenjeprotoka m WHERE m.date <= :datum AND m.date >= :minutesBefore");
        q.setParameter("datum", date);
        q.setParameter("minutesBefore", minutesBefore);
        List<db.Merenjeprotoka> result = q.getResultList();
        em.close();
        return result;
    }
}
