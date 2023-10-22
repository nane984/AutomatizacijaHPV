/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcM;

import constant.ConstReg;

/**
 *
 * @author branko.scekic
 */
public class FrElcM {
    private final String tehnoloskaOznaka;
    private final int power;
    private final int run;
    private final int pcUkljuci;
    private final int pcIskljuci;  
    private final int enableUkljuci;
    private final int enableIskljuci;
    private final int lokalnoDaljinski;
    private final String Opis;
    private final int analogValue;
    private final int analogStep;
    private final ExtendedFr vrednosti;
    private final WorkStopwatch timeWork;
  
    
    public FrElcM(String tehOznaka,int run,int lokalno, int  power, int pcUkljuci, int pcIskljuci, int enableOn, int enableOff, String opis, int analogValue, int analogStep){
        this.tehnoloskaOznaka = tehOznaka;
        this.run = run + ConstReg.StartDigitalInput; 
        this.lokalnoDaljinski = lokalno + ConstReg.StartDigitalInput;
        this.power = power + ConstReg.StartDigitalInput;
        this.pcUkljuci = pcUkljuci + ConstReg.StartMX;
        this.pcIskljuci = pcIskljuci + ConstReg.StartMX;
        this.enableUkljuci = enableOn + ConstReg.StartMX;
        this.enableIskljuci = enableOff + ConstReg.StartMX;
        this.Opis = opis;
        this.analogValue = analogValue + ConstReg.StartRegistri;
        this.analogStep = analogStep + ConstReg.StartRegistri;
        this.vrednosti = new ExtendedFr();
        timeWork = new WorkStopwatch();
    }

    public String getTehnoloskaOznaka() {
        return tehnoloskaOznaka;
    }

    public int getPower() {
        return power;
    }

    public int getLokalnoDaljinski() {
        return lokalnoDaljinski;
    }

    public int getPcUkljuci() {
        return pcUkljuci;
    }

    public int getPcIskljuci() {
        return pcIskljuci;
    }

    public int getEnableUkljuci() {
        return enableUkljuci;
    }

    public int getEnableIskljuci() {
        return enableIskljuci;
    }

    public String getOpis() {
        return Opis;
    }

    public ExtendedFr getVrednosti() {
        return vrednosti;
    }

    public int getAnalogValue() {
        return analogValue;
    }

    public int getAnalogStep() {
        return analogStep;
    }
    
     public WorkStopwatch getTimeWork() {
        return timeWork;
    }
}
