/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcM;

/**
 *
 * @author branko.scekic
 */
public class ExtendedFr {
    private boolean rucnoDaljinski;
    private boolean power;
    private boolean run;
    private boolean enableOn;
    private boolean enableOff;
    private int analognaVrednost;

    public boolean isRucnoDaljinski() {
        return rucnoDaljinski;
    }

    public void setRucnoDaljinski(boolean rucnoDaljinski) {
        this.rucnoDaljinski = rucnoDaljinski;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean isEnableOn() {
        return enableOn;
    }

    public void setEnableOn(boolean enableOn) {
        this.enableOn = enableOn;
    }

    public boolean isEnableOff() {
        return enableOff;
    }

    public void setEnableOff(boolean enableOff) {
        this.enableOff = enableOff;
    }

    public int getAnalognaVrednost() {
        return analognaVrednost;
    }

    public void setAnalognaVrednost(int analognaVrednost) {
        this.analognaVrednost = analognaVrednost;
    } 
}
