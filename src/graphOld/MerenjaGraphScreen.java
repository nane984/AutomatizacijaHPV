/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphOld;

import graph.MeasureShow;
import com.github.lgooddatepicker.components.DateTimePicker;
import dbService.MerenjeNivoaService;
import dbService.MerenjePritiskaService;
import dbService.MerenjeProtokaService;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author branko.scekic
 */
public class MerenjaGraphScreen extends JFrame implements Runnable {

    private TypeOfMeasurment type;
    private SelectedMeasure measure;
    private String opis;

    private Timer timer;
    TimeSeries series;
    private ChartPanel chartPanel;

    private final MerenjeProtokaService merenjeProtoka;
    private final MerenjeNivoaService merenjeNivoa;
    private final MerenjePritiskaService merenjePritiska;

    private final DateTimePicker dateTimeOd;
    private final DateTimePicker dateTimeDo;

    private static final Logger LOGGER = Logger.getLogger(MerenjeProtokaService.class.getName());

    public MerenjaGraphScreen(MerenjeProtokaService merenjeProtoka, MerenjeNivoaService merenjeNivoa, MerenjePritiskaService merenjePritiska, Handler fileHandler) {
        initComponents();
        dateTimeOd = new com.github.lgooddatepicker.components.DateTimePicker();
        dateTimeDo = new com.github.lgooddatepicker.components.DateTimePicker();

        series = new TimeSeries("");

        this.merenjeProtoka = merenjeProtoka;
        this.merenjeNivoa = merenjeNivoa;
        this.merenjePritiska = merenjePritiska;
        
        this.setVisible(true);

        //Assigning handlers to LOGGER object
        //LOGGER.addHandler(fileHandler);
        //Setting levels to handlers and LOGGER
        //fileHandler.setLevel(Level.SEVERE);
        //LOGGER.setLevel(Level.SEVERE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void run() {
        paintGraph();
        setSize(700, 450);
        timer = new Timer(5000, new ActionListener() {  //1000 1 sec
            @Override
            public void actionPerformed(ActionEvent e) {
                XYDataset dataset = createDataset();
                JFreeChart chart = createChart(dataset);
                chartPanel = new ChartPanel(chart);
                chartPanel.repaint();
            }
        });
        timer.start();
    }

    private void setXY(int x, int y) {
        this.setLocation(x - 85, y - 45);
    }

    public void setTypeOfMeasure(int x, int y, TypeOfMeasurment type, SelectedMeasure measure, String opis) {
        setXY(x, y);
        this.type = type;
        this.measure = measure;
        this.opis = opis;
    }

    private void paintGraph() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.UTILITY);

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        setLayout(new BorderLayout(0, 5));
        add(chartPanel, BorderLayout.CENTER);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);

        JLabel Od = new JLabel();
        JLabel Do = new JLabel();

        Od.setText("Od ");
        Do.setText("Do ");

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(Od);
        panel.add(dateTimeOd);
        panel.add(Do);
        panel.add(dateTimeDo);
        panel.add(reloadGraphic());
        add(panel, BorderLayout.SOUTH);
        pack();

        setDateToDataPicker();
        setVisible(true);

    }

    private void setDateToDataPicker() {
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime dateFrom = dateNow.minusMinutes(15);

        dateTimeDo.setDateTimePermissive(dateNow);
        dateTimeOd.setDateTimePermissive(dateFrom);
    }

    private XYDataset createDataset() {

        series.clear();

        if (type == TypeOfMeasurment.Flow) {
            series = getFlow();

        }
        if (type == TypeOfMeasurment.Level) {
            series = getLevel();
        }

        if (type == TypeOfMeasurment.Pressure) {
            series = getPressure();
        }

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(series);
        return dataset;

    }

    private TimeSeries getFlow() {

        String datum = "dd,MM,yyyy,ss,mm,HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datum);

        List<db.Merenjeprotoka> result = merenjeProtoka.getProtokLastHour("123");

        for (db.Merenjeprotoka as : result) {

            String date = simpleDateFormat.format(as.getDate());
            String[] dateFormated = date.split(",");

            try {
                series.addOrUpdate(new Second(Integer.parseInt(dateFormated[3]), Integer.parseInt(dateFormated[4]), Integer.parseInt(dateFormated[5]),
                        Integer.parseInt(dateFormated[0]), Integer.parseInt(dateFormated[1]), Integer.parseInt(dateFormated[2])), MeasureShow.getMeasure(measure, as));

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "greska prilikom ocitavanja merenjeProtoka ", e);
            }
        }

        return series;
    }

    private TimeSeries getLevel() {

        String datum = "dd,MM,yyyy,ss,mm,HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datum);

        List<db.Merenjenivoa> result = merenjeNivoa.getNivoiLastHour();

        for (db.Merenjenivoa as : result) {

            String date = simpleDateFormat.format(as.getDatum());
            String[] dateFormated = date.split(",");

            try {
                series.addOrUpdate(new Second(Integer.parseInt(dateFormated[3]), Integer.parseInt(dateFormated[4]), Integer.parseInt(dateFormated[5]),
                        Integer.parseInt(dateFormated[0]), Integer.parseInt(dateFormated[1]), Integer.parseInt(dateFormated[2])), MeasureShow.getLevel(measure, as));

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "greska prilikom ocitavanja merenjeNivoa ", e);
            }
        }

        return series;
    }

    private TimeSeries getPressure() {

        String datum = "dd,MM,yyyy,ss,mm,HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datum);

        List<db.Merenjepritiska> result = merenjePritiska.getPritisciLastHour();

        for (db.Merenjepritiska as : result) {

            String date = simpleDateFormat.format(as.getDatum());
            String[] dateFormated = date.split(",");

            try {
                series.addOrUpdate(new Second(Integer.parseInt(dateFormated[3]), Integer.parseInt(dateFormated[4]), Integer.parseInt(dateFormated[5]),
                        Integer.parseInt(dateFormated[0]), Integer.parseInt(dateFormated[1]), Integer.parseInt(dateFormated[2])), MeasureShow.getLevel(measure, as));

            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "greska prilikom ocitavanja merenjePritiska ", e);
            }
        }

        return series;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Time Series Chart Example", // Chart  
                "", // X-Axis Label  
                "", // Y-Axis Label  
                dataset);

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(opis,
                new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );

        return chart;
    }

    private JButton reloadGraphic() {
        final JButton auto = new JButton(new AbstractAction("Ucitaj") {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();

                Date date = new Date();

                date.setYear(dateTimeOd.getDatePicker().getDate().getYear() - 1900);
                date.setMonth(dateTimeOd.getDatePicker().getDate().getMonth().getValue() - 1);
                date.setDate(dateTimeOd.getDatePicker().getDate().getDayOfMonth());
                date.setHours(dateTimeOd.getTimePicker().getTime().getHour());
                date.setMinutes(dateTimeOd.getTimePicker().getTime().getMinute());

                Date date2 = new Date();
                date2.setYear(dateTimeDo.getDatePicker().getDate().getYear() - 1900);
                date2.setMonth(dateTimeDo.getDatePicker().getDate().getMonth().getValue() - 1);
                date2.setDate(dateTimeDo.getDatePicker().getDate().getDayOfMonth());
                date2.setHours(dateTimeDo.getTimePicker().getTime().getHour());
                date2.setMinutes(dateTimeDo.getTimePicker().getTime().getMinute());

                if (type == TypeOfMeasurment.Flow) {
                    getFlowRepaint(date, date2);
                }
                if (type == TypeOfMeasurment.Level) {
                    getLevelRepaint(date, date2);
                }
                if (type == TypeOfMeasurment.Pressure) {
                    getPressureRepaint(date, date2);
                }
            }
        });
        return auto;
    }

    private void getFlowRepaint(Date date, Date date2) {
        /*
        List<db.Merenjeprotoka> result = merenjeProtoka.getProtokFromTo(date, date, date2, date2);

        String datum = "dd,MM,yyyy,ss,mm,HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datum);

        series.clear();

        for (db.Merenjeprotoka as : result) {
            try {

                String dateF = simpleDateFormat.format(as.getDate());
                String[] dateFormated = dateF.split(",");

                series.addOrUpdate(new Second(Integer.parseInt(dateFormated[3]), Integer.parseInt(dateFormated[4]), Integer.parseInt(dateFormated[5]),
                        Integer.parseInt(dateFormated[0]), Integer.parseInt(dateFormated[1]), Integer.parseInt(dateFormated[2])), MeasureShow.getMeasure(measure, as));

            } catch (Exception en) {
                LOGGER.log(Level.SEVERE, "greska prilikom ocitavanja merenjeProtoka ", en);
            }
        }

        chartPanel.repaint();
         */
    }

    private void getLevelRepaint(Date date, Date date2) {
        /*
        List<db.Merenjenivoa> result = merenjeNivoa.getNivoFromTo(date, date, date2, date2);

        String datum = "dd,MM,yyyy,ss,mm,HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datum);

        series.clear();

        for (db.Merenjenivoa as : result) {
            try {

                String dateF = simpleDateFormat.format(as.getDatum());
                String[] dateFormated = dateF.split(",");

                series.addOrUpdate(new Second(Integer.parseInt(dateFormated[3]), Integer.parseInt(dateFormated[4]), Integer.parseInt(dateFormated[5]),
                        Integer.parseInt(dateFormated[0]), Integer.parseInt(dateFormated[1]), Integer.parseInt(dateFormated[2])), MeasureShow.getLevel(measure, as));

            } catch (Exception en) {
                LOGGER.log(Level.SEVERE, "greska prilikom ocitavanja merenjeProtoka ", en);
            }
        }

        chartPanel.repaint();
         */
    }

    private void getPressureRepaint(Date date, Date date2) {
        /*
        List<db.Merenjepritiska> result = merenjePritiska.getPressureFromTo(date, date, date2, date2);

        String datum = "dd,MM,yyyy,ss,mm,HH";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datum);

        series.clear();

        for (db.Merenjepritiska as : result) {
            try {

                String dateF = simpleDateFormat.format(as.getDatum());
                String[] dateFormated = dateF.split(",");

                series.addOrUpdate(new Second(Integer.parseInt(dateFormated[3]), Integer.parseInt(dateFormated[4]), Integer.parseInt(dateFormated[5]),
                        Integer.parseInt(dateFormated[0]), Integer.parseInt(dateFormated[1]), Integer.parseInt(dateFormated[2])), MeasureShow.getLevel(measure, as));

            } catch (Exception en) {
                LOGGER.log(Level.SEVERE, "greska prilikom ocitavanja merenjePritiska ", en);
            }
        }

        chartPanel.repaint();
         */
    }
}
