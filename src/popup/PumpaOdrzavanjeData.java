/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popup;

import dbService.PumpeOdrzavanjeService;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import utilise.Convert;

/**
 *
 * @author branko.scekic
 */
public class PumpaOdrzavanjeData {

    public PumpaOdrzavanjeData(JTable jTable1, JTextArea jTextArea1, JLabel pumpa, PumpeOdrzavanjeService pumpeOdrzavanjeService) {
        this.jTable1 = jTable1;
        this.pumpeOdrzavanjeService = pumpeOdrzavanjeService;
        this.jTextArea1 = jTextArea1;
        this.pumpa = pumpa;
    }

    private final JTextArea jTextArea1;
    private int hh;
    private int mm;

    private final JTable jTable1;
    private final JLabel pumpa;
    private final PumpeOdrzavanjeService pumpeOdrzavanjeService;

    private int x;
    private int y;

    private double v1 = 0;
    private double h1 = 0;
    private double a1 = 0;

    private double v2 = 0;
    private double h2 = 0;
    private double a2 = 0;

    private double v3 = 0;
    private double h3 = 0;
    private double a3 = 0;

    private double v4 = 0;
    private double h4 = 0;
    private double a4 = 0;

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public void setH1(double h1) {
        this.h1 = h1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }

    public void setH2(double h2) {
        this.h2 = h2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public void setV3(double v3) {
        this.v3 = v3;
    }

    public void setH3(double h3) {
        this.h3 = h3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    public void setV4(double v4) {
        this.v4 = v4;
    }

    public void setH4(double h4) {
        this.h4 = h4;
    }

    public void setA4(double a4) {
        this.a4 = a4;
    }

    public double getV1() {
        return v1;
    }

    public double getH1() {
        return h1;
    }

    public double getA1() {
        return a1;
    }

    public double getV2() {
        return v2;
    }

    public double getH2() {
        return h2;
    }

    public double getA2() {
        return a2;
    }

    public double getV3() {
        return v3;
    }

    public double getH3() {
        return h3;
    }

    public double getA3() {
        return a3;
    }

    public double getV4() {
        return v4;
    }

    public double getH4() {
        return h4;
    }

    public double getA4() {
        return a4;
    }

    public JLabel getPumpa() {
        return pumpa;
    }

    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public PumpeOdrzavanjeService getPumpeOdrzavanjeService() {
        return pumpeOdrzavanjeService;
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void fillTable() {
        List<db.Pumpeodrzavanje> proba = pumpeOdrzavanjeService.getPumpa(pumpa.getText());
        int i = 0;
        Object[][] obj = new Object[proba.size()][16];
        for (db.Pumpeodrzavanje auto : proba) {
            obj[i][0] = i + 1;
            obj[i][1] = auto.getOpis();
            obj[i][2] = Convert.convertDateToStringDate(auto.getDatum());
            obj[i][3] = auto.getRadhh() + ":" + auto.getRadmm();

            obj[i][4] = auto.getV1();
            obj[i][5] = auto.getH1();
            obj[i][6] = auto.getA1();

            obj[i][7] = auto.getV2();
            obj[i][8] = auto.getH2();
            obj[i][9] = auto.getA2();

            obj[i][10] = auto.getV3();
            obj[i][11] = auto.getH3();
            obj[i][12] = auto.getA3();

            obj[i][13] = auto.getV4();
            obj[i][14] = auto.getH4();
            obj[i][15] = auto.getA4();

            i++;
        }
        DefaultTableModel model = new DefaultTableModel(obj, new Object[]{"r.b.", "Opis", "Datum", "u radu",
            "v1", "h1", "a1",
            "v2", "h2", "a2",
            "v3", "h3", "a3",
            "v4", "h4", "a4"});
        jTable1.setModel(model);
        jTable1.setRowMargin(4);
        jTable1.setRowHeight(40);
        jTable1.setShowGrid(true);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(1).setMinWidth(200);
        jTable1.getColumnModel().getColumn(2).setMinWidth(70);

        jTable1.getColumnModel().getColumn(4).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(8).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(9).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(10).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(11).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(12).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(45);
        jTable1.getColumnModel().getColumn(15).setMaxWidth(45);
        jTable1.setDefaultEditor(Object.class, null);
    }

    public void save() {
            if (!jTextArea1.getText().isEmpty() && !jTextArea1.getText().matches("Nije popunjen text")) {
                pumpeOdrzavanjeService.addOdrzavanje(pumpa.getText(), jTextArea1.getText(),
                        hh, mm,
                        v1, h1, a1,
                        v2, h2, a2,
                        v3, h3, a3,
                        v4, h4, a4);
                fillTable();
                jTextArea1.setText("");
            } else {
                jTextArea1.setText("Nije popunjen text");
            }
        }
}
