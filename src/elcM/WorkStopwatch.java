/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elcM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author branko.scekic
 */
public class WorkStopwatch {
    
    long elapsedTime = 0;
    int minutes = 0;
    int hours = 0;

    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);

    private int interval = 60000;

    Timer timer = new Timer(interval, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + interval;
            hours = (int) (elapsedTime / 3600000);
            minutes = (int) ((elapsedTime / 60000) % 60);

            minutesString = String.format("%02d", minutes);
            hoursString = String.format("%02d", hours);
        }
    });

    public WorkStopwatch() {
        minutesString = String.format("%02d", minutes);
        hoursString = String.format("%02d", hours);
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void reset() {
        timer.stop();
        elapsedTime = 0;
        hours = 0;
        minutes = 0;
    }

    public String getMinutesString() {
         minutesString = String.format("%02d", minutes);
        return minutesString;
    }

    public String getHoursString() {
        hoursString = String.format("%02d", hours);
        return hoursString;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
        elapsedTime = elapsedTime + minutes * 60000;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
        elapsedTime = elapsedTime + hours * 3600000;
    }
    
    
}
