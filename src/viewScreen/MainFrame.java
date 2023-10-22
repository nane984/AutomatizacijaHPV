/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewScreen;

import constant.Img;
import dbService.PregVentService;
import dbService.PumpeUpTimeService;
import field.merenja.bazeni.Nivoi;
import field.merenja.demiLinije.DemiLinijaMerenjaKonstruktor;
import field.merenja.neutralnaJonska.NeutralnaJonskaMerenjaKonstruktor;
import field.merenja.pescaniFilteri.PescaniFilterMerenjaKonstruktor;
import field.merenja.protoci.ProtociDemiLinije;
import field.merenja.protoci.ProtociFlokulacija;
import field.merenja.protoci.ProtociNeutralna;
import field.merenja.protoci.ProtociPescaniFilteri;
import field.merenja.protoci.ProtociPretovarnaRampa;
import field.merenja.protoci.ProtociRegeneracija;
import field.merenja.rezervoari.RezervoariMerenja;
import field.merenja.temperature.Temperature;
import field.pumpe.PumpeDekaFiltrKaDemi;
import field.pumpe.PumpeDekaFiltriraneKaNeutralnojIzmeni;
import field.pumpe.PumpeFerihlorid;
import field.pumpe.PumpeKaPescanimFilterima;
import field.pumpe.PumpeNeutralizacionogBazena;
import field.pumpe.PumpeOdpadnihVodaOdPranjaPescanihFiltera;
import field.pumpe.PumpePolielektrolit;
import field.pumpe.PumpeZaPranjePescanihFiltera;
import field.pumpe.ReaktorMotori;
import field.ventilacija.Ventilacija;
import field.ventili.DemiLinije;
import field.ventili.JonskaIzmena;
import field.ventili.PescaniFilteri;
import field.ventili.VentiliFerihlorid;
import field.ventili.VentiliPolielektrolit;
import field.ventili.Reaktor;
import field.ventili.Regeneracija;
import field.ventili.VentiliGrupaPumpi;
import field.ventili.VentiliKaPescanimFilterima;
import field.ventili.pescaniFilter.OtpadneVodeOdPescanihFiltera;
import field.ventili.pescaniFilter.PranjePescanihFiltera;
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import javax.swing.JFrame;
import javax.swing.Timer;
import popup.AllPopUpWindow;
import screen.frame.OmeksavanjeFrame;
import screen.frame.BilansFrame;
import screen.frame.DemiAllFrame;
import screen.frame.DemiL1Frame;
import screen.frame.DemiL2Frame;
import screen.frame.DemiL3Frame;
import screen.frame.FeCL3PE;
import screen.frame.Flokulacija;
import screen.frame.DoziranjeFrame;
import screen.frame.FiltracijaFrame;
import screen.frame.PescaniFilteriFrame;
import screen.frame.RegeneracijaFrame;
import screen.frame.VentilacijaFrame;
import up.StartApp;
import virtual.doziranje.Doziranje;

/**
 *
 * @author branko.scekic
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     *
     * @param FeCl
     * @param PE
     * @param bazeniMerenja
     * @param rezervoariMerenja
     * @param demiLinijeMerenja
     * @param njMerenja
     * @param ventiliGP01
     * @param ventiliKaPescanimFilterima
     * @param pumpeDekaFiltriranaKaDemi
     * @param pumpeKaPescanimFilterima
     * @param pumpeFerihlorid
     * @param pumpePolielektrolit
     * @param pumpeDekaFiltriraneKaNeutralnojIzmeni
     * @param pumpeOdpadnihVodaOdPranjaPescanihFiltera
     * @param protociFlokulacija
     * @param pumpeZaPranjePescanihFiltera
     * @param pumpeNeutralizacionogBazena
     * @param otpadneVodeOdPescanihFiltera
     * @param protociNeutralna
     * @param protociDemiLinije
     * @param protociPretovarnaRampa
     * @param protociRegeneracija
     * @param reaktor
     * @param jonskaIzmena
     * @param protociPescaniFilteri
     * @param pescaniFilteri
     * @param pfMerenja
     * @param demiLinije
     * @param img
     * @param pranjePescanihFiltera
     * @param reaktorMotori
     * @param regeneracija
     * @param temperature
     * @param ventilacija
     * @param doziranje
     * @param pumpeUpTimeService
     * @param es
     * @param fileHandler
     * @param pregVentService
     */
    public MainFrame(
            VentiliFerihlorid FeCl, 
            VentiliPolielektrolit PE,
            Nivoi bazeniMerenja,
            RezervoariMerenja rezervoariMerenja,
            DemiLinijaMerenjaKonstruktor demiLinijeMerenja,
            NeutralnaJonskaMerenjaKonstruktor njMerenja,
            VentiliGrupaPumpi ventiliGP01,
            VentiliKaPescanimFilterima ventiliKaPescanimFilterima,
            PumpeFerihlorid pumpeFerihlorid,
            PumpePolielektrolit pumpePolielektrolit,
            PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi,
            PumpeKaPescanimFilterima pumpeKaPescanimFilterima,
            PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni,
            PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera,
            PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera,
            PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena,
            ProtociFlokulacija protociFlokulacija,
            ProtociPescaniFilteri protociPescaniFilteri,
            ProtociNeutralna protociNeutralna,
            ProtociDemiLinije protociDemiLinije,
            ProtociPretovarnaRampa protociPretovarnaRampa,
            ProtociRegeneracija protociRegeneracija,
            PescaniFilteri pescaniFilteri,
            JonskaIzmena jonskaIzmena,
            OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera,
            PranjePescanihFiltera pranjePescanihFiltera,
            PescaniFilterMerenjaKonstruktor pfMerenja,
            DemiLinije demiLinije,
            Doziranje doziranje,
            Reaktor reaktor,
            ReaktorMotori reaktorMotori,
            Regeneracija regeneracija,
            Temperature temperature,
            Ventilacija ventilacija,
            Img img,
            PumpeUpTimeService pumpeUpTimeService,
            ExecutorService es,
            PregVentService pregVentService) {
        initComponents();

        this.bazeniMerenja = bazeniMerenja;
        this.rezervoariMerenja = rezervoariMerenja;
        this.demiLinijeMerenja = demiLinijeMerenja;
        this.njMerenja = njMerenja;
        this.ventiliFerihlorid = FeCl;
        this.ventiliPolielektrolit = PE;
        this.ventiliGP01 = ventiliGP01;
        this.ventiliKaPescanimFilterima = ventiliKaPescanimFilterima;
        this.pumpeDekaFiltriranaKaDemi = pumpeDekaFiltriranaKaDemi;
        this.pumpeFerihlorid = pumpeFerihlorid;
        this.pumpePolielektrolit = pumpePolielektrolit;
        this.pumpeKaPescanimFilterima = pumpeKaPescanimFilterima;
        this.pumpeDekaFiltriraneKaNeutralnojIzmeni = pumpeDekaFiltriraneKaNeutralnojIzmeni;
        this.pumpeOdpadnihVodaOdPranjaPescanihFiltera = pumpeOdpadnihVodaOdPranjaPescanihFiltera;
        this.protociFlokulacija = protociFlokulacija;
        this.protociNeutralna = protociNeutralna;
        this.pumpeZaPranjePescanihFiltera = pumpeZaPranjePescanihFiltera;
        this.pumpeNeutralizacionogBazena = pumpeNeutralizacionogBazena;
        this.otpadneVodeOdPescanihFiltera = otpadneVodeOdPescanihFiltera;
        this.protociPescaniFilteri = protociPescaniFilteri;
        this.protociDemiLinije = protociDemiLinije;
        this.protociPretovarnaRampa = protociPretovarnaRampa;
        this.protociRegeneracija = protociRegeneracija;
        this.pescaniFilteri = pescaniFilteri;
        this.demiLinije = demiLinije;
        this.jonskaIzmena = jonskaIzmena;
        this.pranjePescanihFiltera = pranjePescanihFiltera;
        this.pfMerenja = pfMerenja;
        this.reaktor = reaktor;
        this.reaktorMotori = reaktorMotori;
        this.regeneracija = regeneracija;
        this.temperature = temperature;
        this.ventilacija = ventilacija;
        this.doziranje = doziranje;
        this.img = img;
        this.es = es;
        this.pregVentService = pregVentService;

        allPopUpWindow = new AllPopUpWindow(
                this.ventiliFerihlorid,
                this.ventiliPolielektrolit,
                this.ventiliGP01,
                this.ventiliKaPescanimFilterima,
                this.pumpeFerihlorid,
                this.pumpePolielektrolit,
                this.pumpeDekaFiltriranaKaDemi,
                this.pumpeKaPescanimFilterima,
                this.pumpeDekaFiltriraneKaNeutralnojIzmeni,
                this.pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                this.pumpeZaPranjePescanihFiltera,
                this.pumpeNeutralizacionogBazena,
                this.protociFlokulacija,
                this.protociPescaniFilteri,
                this.protociNeutralna,
                this.protociDemiLinije,
                this.protociRegeneracija,
                this.pescaniFilteri,
                this.jonskaIzmena,
                this.otpadneVodeOdPescanihFiltera,
                this.pranjePescanihFiltera,
                this.demiLinije,
                this.doziranje,
                this.reaktor,
                this.regeneracija,
                this.img,
                this.bazeniMerenja.getBazenNeutralizacioni(),
                this.pregVentService,
                pumpeUpTimeService);

        timeFormat = new SimpleDateFormat("HH:mm:ss  dd/MM/yyyy");
        screenRefresh();  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonBilans = new javax.swing.JButton();
        jButtonFlokulacija = new javax.swing.JButton();
        jButtonDoziranje = new javax.swing.JButton();
        jButtonFeCL3Pe = new javax.swing.JButton();
        jButtonFiltracija = new javax.swing.JButton();
        jButtonPescaniFilteri = new javax.swing.JButton();
        jButtonOmeksavanje = new javax.swing.JButton();
        jButtonDemineralizacija = new javax.swing.JButton();
        jButtonDemiL1 = new javax.swing.JButton();
        jButtonDemiL2 = new javax.swing.JButton();
        jButtonDemiL3 = new javax.swing.JButton();
        jButtonVentilacija = new javax.swing.JButton();
        lightBulbAlarmi = new eu.hansolo.steelseries.extras.LightBulb();
        jButtonRegeneracija = new javax.swing.JButton();
        jLabelObavestenje = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MainFrame"); // NOI18N
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jButtonBilans.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonBilans.setText("Bilans");
        jButtonBilans.setPreferredSize(new java.awt.Dimension(63, 40));
        jButtonBilans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBilansActionPerformed(evt);
            }
        });

        jButtonFlokulacija.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFlokulacija.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonFlokulacija.setText("Flokulacija");
        jButtonFlokulacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFlokulacijaActionPerformed(evt);
            }
        });

        jButtonDoziranje.setBackground(new java.awt.Color(102, 102, 102));
        jButtonDoziranje.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonDoziranje.setText("Doziranje");
        jButtonDoziranje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDoziranjeActionPerformed(evt);
            }
        });

        jButtonFeCL3Pe.setBackground(new java.awt.Color(102, 102, 102));
        jButtonFeCL3Pe.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonFeCL3Pe.setText("FeCL3 PE");
        jButtonFeCL3Pe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFeCL3PeActionPerformed(evt);
            }
        });

        jButtonFiltracija.setBackground(new java.awt.Color(255, 255, 0));
        jButtonFiltracija.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonFiltracija.setText("Filtracija");
        jButtonFiltracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltracijaActionPerformed(evt);
            }
        });

        jButtonPescaniFilteri.setBackground(new java.awt.Color(255, 255, 0));
        jButtonPescaniFilteri.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonPescaniFilteri.setText("Pescani filteri");
        jButtonPescaniFilteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPescaniFilteriActionPerformed(evt);
            }
        });

        jButtonOmeksavanje.setBackground(new java.awt.Color(0, 255, 51));
        jButtonOmeksavanje.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonOmeksavanje.setText("Omeksavanje");
        jButtonOmeksavanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOmeksavanjeActionPerformed(evt);
            }
        });

        jButtonDemineralizacija.setBackground(new java.awt.Color(0, 102, 255));
        jButtonDemineralizacija.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonDemineralizacija.setText("Demineralizacija");
        jButtonDemineralizacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDemineralizacijaActionPerformed(evt);
            }
        });

        jButtonDemiL1.setBackground(new java.awt.Color(0, 102, 255));
        jButtonDemiL1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonDemiL1.setText("Demi L1");
        jButtonDemiL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDemiL1ActionPerformed(evt);
            }
        });

        jButtonDemiL2.setBackground(new java.awt.Color(0, 102, 255));
        jButtonDemiL2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonDemiL2.setText("Demi L2");
        jButtonDemiL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDemiL2ActionPerformed(evt);
            }
        });

        jButtonDemiL3.setBackground(new java.awt.Color(0, 102, 255));
        jButtonDemiL3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonDemiL3.setText("Demi L3");
        jButtonDemiL3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDemiL3ActionPerformed(evt);
            }
        });

        jButtonVentilacija.setBackground(new java.awt.Color(153, 255, 255));
        jButtonVentilacija.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonVentilacija.setText("Ventilacija");
        jButtonVentilacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVentilacijaActionPerformed(evt);
            }
        });

        jButtonRegeneracija.setBackground(new java.awt.Color(102, 153, 255));
        jButtonRegeneracija.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButtonRegeneracija.setText("Regeneracija");
        jButtonRegeneracija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegeneracijaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBilans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFeCL3Pe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFlokulacija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDoziranje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonFiltracija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPescaniFilteri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOmeksavanje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDemineralizacija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDemiL1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDemiL2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDemiL3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonVentilacija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lightBulbAlarmi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRegeneracija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButtonBilans, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFlokulacija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDoziranje, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFeCL3Pe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFiltracija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPescaniFilteri, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOmeksavanje, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDemineralizacija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDemiL1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDemiL2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDemiL3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegeneracija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonVentilacija, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addComponent(lightBulbAlarmi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jLabelObavestenje.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabelObavestenje.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelObavestenje.setText("Scada HPV Novi Sad");

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelObavestenje, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1760, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelObavestenje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabelObavestenje, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1920, 1080));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonBilansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBilansActionPerformed
        removeFrame();
        bilansFrame = new BilansFrame(
                bazeniMerenja,
                rezervoariMerenja,
                ventiliGP01,
                ventiliKaPescanimFilterima,
                pumpeDekaFiltriranaKaDemi,
                pumpeKaPescanimFilterima,
                pumpeDekaFiltriraneKaNeutralnojIzmeni,
                pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                protociFlokulacija,
                protociNeutralna,
                protociDemiLinije,
                protociPescaniFilteri,
                pumpeZaPranjePescanihFiltera,
                pumpeNeutralizacionogBazena,
                otpadneVodeOdPescanihFiltera,
                reaktor,
                reaktorMotori,
                img,
                es,
                allPopUpWindow);
        jDesktopPane1.add(bilansFrame);
        bilansFrame.timer.start();
        bilansFrame.show();
        
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonBilansActionPerformed

    private void jButtonFeCL3PeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFeCL3PeActionPerformed
        removeFrame();
        feCL3PEFrame = new FeCL3PE(ventiliFerihlorid, ventiliPolielektrolit,
                pumpeFerihlorid, pumpePolielektrolit, img, allPopUpWindow);
        jDesktopPane1.add(feCL3PEFrame);
        feCL3PEFrame.timer.start();
        feCL3PEFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonFeCL3PeActionPerformed

    private void jButtonFlokulacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFlokulacijaActionPerformed
        removeFrame();
        flokulacijaFrame = new Flokulacija(pumpeFerihlorid,
                pumpePolielektrolit,
                pumpeKaPescanimFilterima,
                bazeniMerenja,
                ventiliKaPescanimFilterima,
                ventiliFerihlorid,
                ventiliPolielektrolit,
                protociFlokulacija,
                reaktor,
                img,
                allPopUpWindow);
        jDesktopPane1.add(flokulacijaFrame);
        flokulacijaFrame.timer.start();
        flokulacijaFrame.show();
        
        bilansFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonFlokulacijaActionPerformed

    private void jButtonDoziranjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDoziranjeActionPerformed
        removeFrame();
        doziranjeFrame = new DoziranjeFrame(doziranje, img);
        jDesktopPane1.add(doziranjeFrame);
        doziranjeFrame.timer.start();
        doziranjeFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonDoziranjeActionPerformed

    private void jButtonFiltracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltracijaActionPerformed
        removeFrame();
        filtracijaFrame = new FiltracijaFrame(ventiliKaPescanimFilterima,
                pumpeKaPescanimFilterima,
                pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                pumpeZaPranjePescanihFiltera,
                otpadneVodeOdPescanihFiltera,
                protociPescaniFilteri,
                bazeniMerenja,
                pescaniFilteri,
                pfMerenja,
                pranjePescanihFiltera,
                img, allPopUpWindow);
        jDesktopPane1.add(filtracijaFrame);
        filtracijaFrame.timer.start();
        filtracijaFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonFiltracijaActionPerformed

    private void jButtonPescaniFilteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPescaniFilteriActionPerformed
        removeFrame();
        pescaniFilteriFrame = new PescaniFilteriFrame(protociPescaniFilteri,
                bazeniMerenja,
                pfMerenja,
                ventiliKaPescanimFilterima,
                pumpeZaPranjePescanihFiltera,
                pumpeKaPescanimFilterima,
                pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                pescaniFilteri,
                pranjePescanihFiltera,
                otpadneVodeOdPescanihFiltera,
                img, allPopUpWindow);
        jDesktopPane1.add(pescaniFilteriFrame);
        pescaniFilteriFrame.jTabbedPane2.setSelectedIndex(brTabaPF);
        pescaniFilteriFrame.timer.start();
        pescaniFilteriFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonPescaniFilteriActionPerformed

    private void jButtonOmeksavanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOmeksavanjeActionPerformed
        removeFrame();
        omeksavanjeFrame = new OmeksavanjeFrame(protociNeutralna, rezervoariMerenja, njMerenja,
                ventiliGP01, pumpeDekaFiltriraneKaNeutralnojIzmeni, jonskaIzmena, allPopUpWindow, img);
        jDesktopPane1.add(omeksavanjeFrame);
        omeksavanjeFrame.timer.start();
        omeksavanjeFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonOmeksavanjeActionPerformed

    private void jButtonDemineralizacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDemineralizacijaActionPerformed
        removeFrame();
        demiAllFrame = new DemiAllFrame(protociDemiLinije, protociPretovarnaRampa, bazeniMerenja,
                rezervoariMerenja, demiLinijeMerenja, ventiliGP01, pumpeDekaFiltriranaKaDemi,
                pumpeNeutralizacionogBazena, demiLinije, img, temperature, allPopUpWindow);
        jDesktopPane1.add(demiAllFrame);
        demiAllFrame.timer.start();
        demiAllFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonDemineralizacijaActionPerformed

    private void jButtonDemiL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDemiL1ActionPerformed
        removeFrame();
        demiL1Frame = new DemiL1Frame(protociDemiLinije, bazeniMerenja, rezervoariMerenja,
                demiLinijeMerenja, ventiliGP01,
                demiLinije, pumpeDekaFiltriranaKaDemi, pumpeNeutralizacionogBazena,
                img, allPopUpWindow);
        jDesktopPane1.add(demiL1Frame);
        demiL1Frame.timer.start();
        demiL1Frame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonDemiL1ActionPerformed

    private void jButtonDemiL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDemiL2ActionPerformed
        removeFrame();
        demiL2Frame = new DemiL2Frame(protociDemiLinije, bazeniMerenja, rezervoariMerenja,
                demiLinijeMerenja, ventiliGP01,
                demiLinije, pumpeDekaFiltriranaKaDemi, pumpeNeutralizacionogBazena,
                img, allPopUpWindow);
        jDesktopPane1.add(demiL2Frame);
        demiL2Frame.timer.start();
        demiL2Frame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonDemiL2ActionPerformed

    private void jButtonDemiL3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDemiL3ActionPerformed
        removeFrame();
        demiL3Frame = new DemiL3Frame(protociDemiLinije, bazeniMerenja, rezervoariMerenja,
                demiLinijeMerenja, ventiliGP01,
                demiLinije, pumpeDekaFiltriranaKaDemi, pumpeNeutralizacionogBazena,
                img, allPopUpWindow);
        jDesktopPane1.add(demiL3Frame);
        demiL3Frame.timer.start();
        demiL3Frame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        regeneracijaFrame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonDemiL3ActionPerformed

    private void jButtonVentilacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVentilacijaActionPerformed
        removeFrame();
        ventilacijaFrame = new VentilacijaFrame(ventilacija, img);
        jDesktopPane1.add(ventilacijaFrame);
        ventilacijaFrame.timer.start();
        ventilacijaFrame.show();
        
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        regeneracijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonVentilacijaActionPerformed

    private void jButtonRegeneracijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegeneracijaActionPerformed
        removeFrame();
        regeneracijaFrame = new RegeneracijaFrame(regeneracija, protociRegeneracija, img, allPopUpWindow);
        jDesktopPane1.add(regeneracijaFrame);
        regeneracijaFrame.timer.start();
        regeneracijaFrame.show();
       
        bilansFrame.timer.stop();
        flokulacijaFrame.timer.stop();
        doziranjeFrame.timer.stop();
        feCL3PEFrame.timer.stop();
        filtracijaFrame.timer.stop();
        pescaniFilteriFrame.timer.stop();
        omeksavanjeFrame.timer.stop();
        demiAllFrame.timer.stop();
        demiL1Frame.timer.stop();
        demiL2Frame.timer.stop();
        demiL3Frame.timer.stop();
        ventilacijaFrame.timer.stop();
    }//GEN-LAST:event_jButtonRegeneracijaActionPerformed

    private void removeFrame() {
        if (bilansFrame != null) {
            bilansFrame.dispose();
        }
        if (feCL3PEFrame != null) {
            feCL3PEFrame.dispose();
        }
        if (flokulacijaFrame != null) {
            flokulacijaFrame.dispose();
        }
        if (doziranjeFrame != null) {
            doziranjeFrame.dispose();
        }
        if (filtracijaFrame != null) {
            filtracijaFrame.dispose();
        }
        if (pescaniFilteriFrame != null) {
            pescaniFilteriFrame.dispose();
        }
        if (omeksavanjeFrame != null) {
            omeksavanjeFrame.dispose();
        }
        if (demiAllFrame != null) {
            demiAllFrame.dispose();
        }
        if (demiL1Frame != null) {
            demiL1Frame.dispose();
        }
        if (demiL2Frame != null) {
            demiL2Frame.dispose();
        }
        if (demiL3Frame != null) {
            demiL3Frame.dispose();
        }
        if (regeneracijaFrame != null) {
            regeneracijaFrame.dispose();
        }
        if (ventilacijaFrame != null) {
            ventilacijaFrame.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBilans;
    private javax.swing.JButton jButtonDemiL1;
    private javax.swing.JButton jButtonDemiL2;
    private javax.swing.JButton jButtonDemiL3;
    private javax.swing.JButton jButtonDemineralizacija;
    private javax.swing.JButton jButtonDoziranje;
    private javax.swing.JButton jButtonFeCL3Pe;
    private javax.swing.JButton jButtonFiltracija;
    private javax.swing.JButton jButtonFlokulacija;
    private javax.swing.JButton jButtonOmeksavanje;
    private javax.swing.JButton jButtonPescaniFilteri;
    private javax.swing.JButton jButtonRegeneracija;
    private javax.swing.JButton jButtonVentilacija;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabelObavestenje;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private eu.hansolo.steelseries.extras.LightBulb lightBulbAlarmi;
    // End of variables declaration//GEN-END:variables

    private Timer timer;
    private final Img img;
   
    public static int brTabaPF = 1;
    private final PregVentService pregVentService;

    private Calendar cal = Calendar.getInstance();
    private final SimpleDateFormat timeFormat;
    private Date date;
    
    private final Nivoi bazeniMerenja;
    private final RezervoariMerenja rezervoariMerenja;
    private final DemiLinijaMerenjaKonstruktor demiLinijeMerenja;
    private final NeutralnaJonskaMerenjaKonstruktor njMerenja;

    //ovo je za thread kada budem grafikone uzimao od merenja
    private final ExecutorService es;

    private final VentiliFerihlorid ventiliFerihlorid;
    private final VentiliPolielektrolit ventiliPolielektrolit;
    private final VentiliGrupaPumpi ventiliGP01;
    private final VentiliKaPescanimFilterima ventiliKaPescanimFilterima;

    private final PumpeFerihlorid pumpeFerihlorid;
    private final PumpePolielektrolit pumpePolielektrolit;
    private final PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi;
    private final PumpeKaPescanimFilterima pumpeKaPescanimFilterima;
    private final PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni;
    private final PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera;
    private final PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera;
    private final PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena;

    private final ProtociFlokulacija protociFlokulacija;
    private final ProtociPescaniFilteri protociPescaniFilteri;
    private final ProtociNeutralna protociNeutralna;
    private final ProtociDemiLinije protociDemiLinije;
    private final ProtociPretovarnaRampa protociPretovarnaRampa;
    private final ProtociRegeneracija protociRegeneracija;

    private final OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera;
    private final Doziranje doziranje;
    private final Reaktor reaktor;
    private final ReaktorMotori reaktorMotori;
    private final DemiLinije demiLinije;
    private final Regeneracija regeneracija;
    private final PescaniFilteri pescaniFilteri;
    private final JonskaIzmena jonskaIzmena;
    private final PranjePescanihFiltera pranjePescanihFiltera;
    private final PescaniFilterMerenjaKonstruktor pfMerenja;

    private final Ventilacija ventilacija;

    private BilansFrame bilansFrame;
    private FeCL3PE feCL3PEFrame;
    private Flokulacija flokulacijaFrame;
    private DoziranjeFrame doziranjeFrame;
    private FiltracijaFrame filtracijaFrame;
    private PescaniFilteriFrame pescaniFilteriFrame;
    private OmeksavanjeFrame omeksavanjeFrame;
    private DemiAllFrame demiAllFrame;
    private DemiL1Frame demiL1Frame;
    private DemiL2Frame demiL2Frame;
    private DemiL3Frame demiL3Frame;
    private VentilacijaFrame ventilacijaFrame;
    private RegeneracijaFrame regeneracijaFrame;
    
    
    private final Temperature temperature;
    private final AllPopUpWindow allPopUpWindow;

    private void screenRefresh() {
        timer = new Timer(500, new ActionListener() {  //1000 1 sec
            @Override
            public void actionPerformed(ActionEvent e) {
                getDisplayClock();
                alarmCommunication();
            }
        });

        timer.start();
    }
    
    private void alarmCommunication(){
        
                if (!StartApp.comm.isConnected()) {
                    StartApp.comm.read = false;
                    lightBulbAlarmi.setGlowColor(Color.RED);
                    lightBulbAlarmi.setOn(true);
                    //System.out.println("Prekid kom");
                }
                if (StartApp.comm.isConnected()) {
                    lightBulbAlarmi.setOn(false);
                    //System.out.println("kom ok");
                }
    }
    
    private void getDisplayClock() {
        cal = Calendar.getInstance();
        date = cal.getTime();
        String time = timeFormat.format(date);
        jLabelObavestenje.setText(time);

    }

    public static void showOnScreen(int screen, JFrame frame) {
        //za prikaz na displeju kod multidispleja
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        if (screen > -1 && screen < gd.length) {
            frame.setLocation(gd[screen].getDefaultConfiguration().getBounds().x, frame.getY());
        } else if (gd.length > 0) {
            frame.setLocation(gd[0].getDefaultConfiguration().getBounds().x, frame.getY());
        } else {
            throw new RuntimeException("No Screens Found");
        }
    }
}
