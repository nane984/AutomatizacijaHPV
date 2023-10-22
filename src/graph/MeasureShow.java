/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import graphOld.SelectedMeasure;

/**
 *
 * @author branko.scekic
 */
public class MeasureShow {

    public static double getMeasure(SelectedMeasure measure, db.Merenjeprotoka as) {
        switch (measure) {
            case f_ulazdl1:
                return as.getUlazdl1();
            case f_ulazdl2:
                return as.getUlazdl2();
            case f_ulazdl3:
                return as.getUlazdl3();
            case f_izlazdl1:
                return as.getIzlazdl1();
            case f_izlazdl2:
                return as.getIzlazdl2();
            case f_izlazdl3:
                return as.getIzlazdl3();
            case f_hclpotispretovarnihpumi:
                return as.getHclpotispretovarnihpumi();
            case f_luzinapotispretovarnihpumi:
                return as.getLuzinapotispretovarnihpumi();
            case f_hclpotisdozirpumpi:
                return as.getHclpotisdozirpumpi();
            case f_sirovavodaureaktor1:
                return as.getSirovavodaureaktor1();
            case f_sirovavodaureaktor2:
                return as.getSirovavodaureaktor2();
            case f_pf1:
                return as.getPf1();
            case f_pf2:
                return as.getPf2();
            case f_pf3:
                return as.getPf3();
            case f_pf4:
                return as.getPf4();
            case f_pf5:
                return as.getPf5();
            case f_pf6:
                return as.getPf6();
            case f_ni1:
                return as.getNi1();
            case f_ni2:
                return as.getNi2();
            case f_ni3:
                return as.getNi3();
            case f_kompenzacionirezervoar:
                return as.getKompenzacionirezervoar();
            default:
                return 0;
        }
    }

    public static double getLevel(SelectedMeasure measure, db.Merenjenivoa as) {
        switch (measure) {
            case l_luzinarezervoar1:
                return as.getLuzinarezervoar1();
            case l_luzinarezervoar2:
                return as.getLuzinarezervoar2();
            case l_demivodarezervoar1:
                return as.getDemivodarezervoar1();
            case l_demivodarezervoar2:
                return as.getDemivodarezervoar2();
            case l_kompenzacionirezerv:
                return as.getKompenzacionirezervoar();
            case l_neutralizacionibazen:
                return as.getNeutralizacionibazen();
            case l_demivodarezervoar150:
                return as.getDemivodarezervoar150();
            case l_dekanefiltriranavoda:
                return as.getDekanefiltriranavoda();
            case l_dekafiltriranavoda:
                return as.getDekafiltriranavoda();
            case l_odpranjapf:
                return as.getOdpranjapf();
            case l_rezervoarfecl:
                return as.getRezervoarfecl();
            default:
                return 0;
        }
    }
    
    public static double getLevel(SelectedMeasure measure, db.Merenjepritiska as) {
        switch(measure){
            case p_dl1ulazjkkf:
                return as.getDl1ulazjkkf();
            case p_dl1izlazjkkf:
                return as.getDl1izlazjkkf();
            case p_dl1ulazsbaf:
                return as.getDl1ulazsbaf();
            case p_dl1izlazsbaf:
                return as.getDl1izlazsbaf();
            case p_dl1ulazjbaf:
                return as.getDl1ulazjbaf();
            case p_dl1izlazjbaf:
                return as.getDl1izlazjbaf();
            case p_dl1ulazmf:
                return as.getDl1ulazmf();
            case p_dl1izlazmf:
                return as.getDl1izlazmf();
                
             
            case p_dl2ulazjkkf:
                return as.getDl2ulazjkkf();
            case p_dl2izlazjkkf:
                return as.getDl2izlazjkkf();
            case p_dl2ulazsbaf:
                return as.getDl2ulazsbaf();
            case p_dl2izlazsbaf:
                return as.getDl2izlazsbaf();
            case p_dl2ulazjbaf:
                return as.getDl2ulazjbaf();
            case p_dl2izlazjbaf:
                return as.getDl2izlazjbaf();
            case p_dl2ulazmf:
                return as.getDl2ulazmf();
            case p_dl2izlazmf:
                return as.getDl2izlazmf();
                
                
            case p_dl3ulazjkkf:
                return as.getDl3ulazjkkf();
            case p_dl3izlazjkkf:
                return as.getDl3izlazjkkf();
            case p_dl3ulazsbaf:
                return as.getDl3ulazsbaf();
            case p_dl3izlazsbaf:
                return as.getDl3izlazsbaf();
            case p_dl3ulazjbaf:
                return as.getDl3ulazjbaf();
            case p_dl3izlazjbaf:
                return as.getDl3izlazjbaf();
            case p_dl3ulazmf:
                return as.getDl3ulazmf();
            case p_dl3izlazmf:
                return as.getDl3izlazmf();
                
            case p_pf1ulaz:
                return as.getPf1ulaz();
            case p_pf2ulaz:
                return as.getPf2ulaz();
            case p_pf3ulaz:
                return as.getPf3ulaz();
            case p_pf4ulaz:
                return as.getPf4ulaz();
            case p_pf5ulaz:
                return as.getPf5ulaz();
            case p_pf6ulaz:
                return as.getPf6ulaz();
                
            case p_pf1izlaz:
                return as.getPf1izlaz();
            case p_pf2izlaz:
                return as.getPf2izlaz();
            case p_pf3izlaz:
                return as.getPf3izlaz();
            case p_pf4izlaz:
                return as.getPf4izlaz();
            case p_pf5izlaz:
                return as.getPf5izlaz();
            case p_pf6izlaz:
                return as.getPf6izlaz();
                
            
            case p_ni1ulaz:
                return as.getNi1ulaz();
            case p_ni2ulaz:
                return as.getNi2ulaz();
            case p_ni3ulaz:
                return as.getNi3ulaz();
            
            case p_ni1izlaz:
                return as.getNi1izlaz();
            case p_ni2izlaz:
                return as.getNi2izlaz();
            case p_ni3izlaz:
                return as.getNi3izlaz();
                
            default:
                return 0;
        }
    }

}
