/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilise;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author branko.scekic
 */
public class Stopwatch implements ActionListener {
    
    // ne koristim klasu nego je drzim kao primer

    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel timeLabel = new JLabel();
    long elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    String hoursString = String.format("%02d", hours);
    
    private int interval = 1000;

    Timer timer = new Timer(interval, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + interval;
            hours = (int) (elapsedTime / 3600000);
            minutes = (int) ((elapsedTime / 60000) % 60);
            seconds = (int) ((elapsedTime / 1000) % 60);

            secondsString = String.format("%02d", seconds);
            minutesString = String.format("%02d", minutes);
            hoursString = String.format("%02d", hours);

            timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        }
    });

    public Stopwatch() {
        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Vedrana", Font.PLAIN, 35));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(100, 200, 100, 50);
        startButton.setFocusable(false);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        startButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFocusable(false);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.addActionListener(this);

        frame.add(startButton);
        frame.add(resetButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {

            if (started == false) {
                started = true;
                startButton.setText("Stop");
                start();
            } else {
                started = false;
                startButton.setText("Start");
                stop();
            }
        }

        if (e.getSource() == resetButton) {
            reset();
        }
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
        seconds = 0;

        secondsString = String.format("%02d", seconds);
        minutesString = String.format("%02d", minutes);
        hoursString = String.format("%02d", hours);

        timeLabel.setText(hoursString + ":" + minutesString + ":" + secondsString);
    }
}
