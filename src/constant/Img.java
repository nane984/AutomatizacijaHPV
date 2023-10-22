/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import valve.globe.PregradniVentili;

/**
 *
 * @author branko.scekic
 */
public class Img {

    private final ImageIcon horizontalnoGreska;
    private final ImageIcon horizontalnoMedjupolozaj;
    private final ImageIcon horizontalnoOtvoren;
    private final ImageIcon horizontalnoZatvoren;
    private final ImageIcon horizontalnoOtvaranje;
    private final ImageIcon horizontalnoZatvaranje;

    private final ImageIcon vertikalnoGreska;
    private final ImageIcon vertikalnoMedjupolozaj;
    private final ImageIcon vertikalnoOtvoren;
    private final ImageIcon vertikalnoZatvoren;
    private final ImageIcon vertikalnoOtvaranje;
    private final ImageIcon vertikalnoZatvaranje;

    private final ImageIcon pumpaOn;
    private final ImageIcon pumpaOff;
    private final ImageIcon pumpaPowerOff;

    private final ImageIcon pumpaLocal;
    private final ImageIcon pumpaDalj;
    private final ImageIcon pumpaIsklj;

    private final ImageIcon selectOn;
    private final ImageIcon selectOff;
    
    private final ImageIcon zgrtacOn;
    private final ImageIcon zgrtacOff;

    public Img() {
        horizontalnoGreska = new ImageIcon(getClass().getResource(VentHorizontalno.Greska));
        horizontalnoMedjupolozaj = new ImageIcon(getClass().getResource(VentHorizontalno.Medjupolozaj));
        horizontalnoOtvoren = new ImageIcon(getClass().getResource(VentHorizontalno.Otvoren));
        horizontalnoZatvoren = new ImageIcon(getClass().getResource(VentHorizontalno.Zatvoren));
        horizontalnoOtvaranje = new ImageIcon(getClass().getResource(VentHorizontalno.Otvoranje));
        horizontalnoZatvaranje = new ImageIcon(getClass().getResource(VentHorizontalno.Zatvaranje));

        vertikalnoGreska = new ImageIcon(getClass().getResource(VentVertikalno.Greska));
        vertikalnoMedjupolozaj = new ImageIcon(getClass().getResource(VentVertikalno.Medjupolozaj));
        vertikalnoOtvoren = new ImageIcon(getClass().getResource(VentVertikalno.Otvoren));
        vertikalnoZatvoren = new ImageIcon(getClass().getResource(VentVertikalno.Zatvoren));
        vertikalnoOtvaranje = new ImageIcon(getClass().getResource(VentVertikalno.Otvoranje));
        vertikalnoZatvaranje = new ImageIcon(getClass().getResource(VentVertikalno.Zatvaranje));

        pumpaOn = new ImageIcon(getClass().getResource(Pumpa.pumpaOn));
        pumpaOff = new ImageIcon(getClass().getResource(Pumpa.pumpaOff));
        pumpaPowerOff = new ImageIcon(getClass().getResource(Pumpa.pumpaPowerOff));

        pumpaLocal = new ImageIcon(getClass().getResource(Pumpa.pumpaLocal));
        pumpaDalj = new ImageIcon(getClass().getResource(Pumpa.pumpaDalj));
        pumpaIsklj = new ImageIcon(getClass().getResource(Pumpa.pumpaIsklj));

        selectOn = new ImageIcon(getClass().getResource(Doziranje.on));
        selectOff = new ImageIcon(getClass().getResource(Doziranje.off));
        
        zgrtacOn = new ImageIcon(getClass().getResource(Pumpa.zgrtacOn));
        zgrtacOff = new ImageIcon(getClass().getResource(Pumpa.zgrtacOff));
    }

    public JLabel setSelectedIcon(JLabel label, int br, int rbr) {
        if (br == rbr) {
            label.setIcon(selectOn);
        } else if (br != rbr) {
            label.setIcon(selectOff);
        }
        return label;
    }

    public JLabel setSelectedIcon(JLabel label, boolean vrednost, int rbr) {
        if (rbr == 0) {
            if (!vrednost) {
                label.setIcon(selectOn);
            } else if (vrednost) {
                label.setIcon(selectOff);
            }
        }else if(rbr == 1){
            if (vrednost) {
                label.setIcon(selectOn);
            } else if (!vrednost) {
                label.setIcon(selectOff);
            }
        }

        return label;
    }
    
    public JLabel setSelectedIcon(JLabel label, boolean vrednost) {
            if (vrednost) {
                label.setIcon(selectOn);
            } else if (!vrednost) {
                label.setIcon(selectOff);
            }
        

        return label;
    }

    public JLabel setImgHorizontalno(JLabel label, PregradniVentili ventil) {

        if (!ventil.getVrednostiReg().isPolozajVirtualno()) {
            if (ventil.getVrednostiReg().getOtvoren()) {
                label.setIcon(horizontalnoOtvoren);
            } else if (ventil.getVrednostiReg().getZatvoren()) {
                label.setIcon(horizontalnoZatvoren);
            } else if (ventil.getVrednostiReg().getOtvoren() && ventil.getVrednostiReg().getZatvoren()) {
                label.setIcon(horizontalnoGreska);
            } else if (!ventil.getVrednostiReg().getOtvoren() && !ventil.getVrednostiReg().getZatvoren()) {
                label.setIcon(horizontalnoMedjupolozaj);
            }
        } else {
            if (ventil.getVrednostiReg().getEnableZatvori()) {
                label.setIcon(horizontalnoOtvoren);
            } else if (ventil.getVrednostiReg().getEnableOtvori()) {
                label.setIcon(horizontalnoZatvoren);
            }
        }
        return label;
    }

    public JLabel setImgHorizontalno(JLabel label, boolean otvoren, boolean zatvoren) {
        if (otvoren) {
            label.setIcon(horizontalnoOtvoren);
        } else if (zatvoren) {
            label.setIcon(horizontalnoZatvoren);
        } else if (otvoren && zatvoren) {
            label.setIcon(horizontalnoGreska);
        } else if (!otvoren && !zatvoren) {
            label.setIcon(horizontalnoMedjupolozaj);
        }
        return label;
    }

    public JLabel setImgVertikalno(JLabel label, PregradniVentili ventil) {

        if (!ventil.getVrednostiReg().isPolozajVirtualno()) {
            if (ventil.getVrednostiReg().getOtvoren()) {
                label.setIcon(vertikalnoOtvoren);
            } else if (ventil.getVrednostiReg().getZatvoren()) {
                label.setIcon(vertikalnoZatvoren);
            } else if (ventil.getVrednostiReg().getOtvoren() && ventil.getVrednostiReg().getZatvoren()) {
                label.setIcon(vertikalnoGreska);
            } else if (!ventil.getVrednostiReg().getOtvoren() && !ventil.getVrednostiReg().getZatvoren()) {
                label.setIcon(vertikalnoMedjupolozaj);
            }
        } else {
            if (ventil.getVrednostiReg().getEnableZatvori()) {
                label.setIcon(vertikalnoOtvoren);
            } else if (ventil.getVrednostiReg().getEnableOtvori()) {
                label.setIcon(vertikalnoZatvoren);
            }
        }
        return label;
    }

    public JLabel setImgVertikalno(JLabel label, boolean otvoren, boolean zatvoren) {
        if (otvoren) {
            label.setIcon(vertikalnoOtvoren);
        } else if (zatvoren) {
            label.setIcon(vertikalnoZatvoren);
        } else if (otvoren && zatvoren) {
            label.setIcon(vertikalnoGreska);
        } else if (!otvoren && !zatvoren) {
            label.setIcon(vertikalnoMedjupolozaj);
        }
        return label;
    }

     public JLabel setReaktorZgrtac(JLabel label, boolean ukljucen) {
        if (ukljucen) {
            label.setIcon(zgrtacOn);
        } else {
            label.setIcon(zgrtacOff);
        }
        return label;
    }
    
    public JLabel setPumpIcon(JLabel label, boolean ukljucen) {
        if (ukljucen) {
            label.setIcon(pumpaOn);
        } else {
            label.setIcon(pumpaOff);
        }
        return label;
    }

    public ImageIcon getPumpaPowerOff() {
        return pumpaPowerOff;
    }

    public ImageIcon getPumpaOn() {
        return pumpaOn;
    }

    public ImageIcon getPumpaOff() {
        return pumpaOff;
    }

    public JLabel getStanjePumpe(JLabel label, boolean lokalno, boolean daljinski) {
        if (lokalno && !daljinski) {
            label.setText("Lok.");
        } else if (!lokalno && daljinski) {
            label.setText("Dalj.");
        } else if (lokalno && daljinski) {
            label.setText("Greska");
        } else if (!lokalno && !daljinski) {
            label.setText("Isklj.");
        }
        //System.out.println(label.getText());
        return label;
    }

    public JLabel getStanjePumpeImg(JLabel label, boolean lokalno, boolean daljinski) {
        if (lokalno && !daljinski) {
            label.setIcon(pumpaLocal);
        } else if (!lokalno && daljinski) {
            label.setIcon(pumpaDalj);
        } else if (!lokalno && !daljinski) {
            label.setIcon(pumpaIsklj);
        }
        return label;
    }

    public JLabel getStanjeFrPumpeImg(JLabel label, boolean run, boolean power) {
        if (power && run) {
            label.setIcon(pumpaOn);
        } else if (power && !run) {
            label.setIcon(pumpaOff);
        } else if (!power) {
            label.setIcon(pumpaPowerOff);
        }
        return label;
    }

    public JLabel getStanjeVentilacije(JLabel label, boolean a, boolean b) {
        if (!a && !b) {
            label.setIcon(pumpaLocal);
        } else if (a && !b) {
            label.setIcon(pumpaIsklj);
        } else if (!a && b) {
            label.setIcon(pumpaDalj);
        } else if (a && b) {
            label.setIcon(pumpaLocal);
        }
        return label;
    }
}
