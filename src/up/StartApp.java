/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up;

import buff.Buff;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import constant.Img;
import dbService.KumulativnoService;
import dbService.MerenjeNivoaService;
import dbService.MerenjeProtokaService;
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
import field.ventili.VentiliFerihlorid;
import field.ventili.JonskaIzmena;
import field.ventili.PescaniFilteri;
import field.ventili.VentiliPolielektrolit;
import field.ventili.Reaktor;
import field.ventili.Regeneracija;
import field.ventili.VentiliGrupaPumpi;
import field.ventili.VentiliKaPescanimFilterima;
import field.ventili.pescaniFilter.OtpadneVodeOdPescanihFiltera;
import field.ventili.pescaniFilter.PranjePescanihFiltera;
import inicijalizacija.pregVent.IncPregVent;
import inicijalizacija.pumpeUpTime.IncPumpeUpTime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import popup.Privremeno;
import tools.ShiftPoint;
import viewScreen.MainFrame;
import virtual.doziranje.Doziranje;

/**
 *
 * @author branko.scekic
 */
public class StartApp {

    /**
     * @param args the command line arguments
     */
    //private static boolean restartConn = false;
    private final VentiliFerihlorid FeCl;
    private final VentiliPolielektrolit PE;
    private final VentiliGrupaPumpi ventiliGP01;
    private final VentiliKaPescanimFilterima ventiliKaPescanimFilterima;
    private final PescaniFilteri pescaniFilteri;
    private final PescaniFilterMerenjaKonstruktor pfMerenja;
    private final JonskaIzmena jonskaIzmena;
    private final NeutralnaJonskaMerenjaKonstruktor njMerenja;
    private final DemiLinije demiLinije;
    private final Nivoi bazeniMerenja;
    private final DemiLinijaMerenjaKonstruktor demiLinijeMerenja;
    private final PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi;
    private final PumpeKaPescanimFilterima pumpeKaPescanimFilterima;
    private final PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni;
    private final PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera;
    private final RezervoariMerenja rezervoariMerenja;
    private final PumpeFerihlorid pumpeFerihlorid;
    private final PumpePolielektrolit pumpePolielektrolit;
    private final ProtociPescaniFilteri protociPescaniFilteri;
    private final ProtociDemiLinije protociDemiLinije;
    private final ProtociNeutralna protociNeutralna;
    private final ProtociFlokulacija protociFlokulacija;
    private final PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera;
    private final OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera;
    private final PranjePescanihFiltera pranjePescanihFiltera;
    private final PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena;
    private final ProtociPretovarnaRampa protociPretovarnaRampa;
    private final ReaktorMotori reaktorMotori;
    private final Doziranje doziranje;
    private final Regeneracija regeneracija;
    private final Ventilacija ventilacija;
    private final Reaktor reaktor;
    private final Temperature temperature;
    private final ProtociRegeneracija protociRegeneracija;
    private final MerenjeNivoaService merenjeNivoaService;
    private final MerenjeProtokaService merenjeProtokaService;
    private Thread t1;
    public static Buff comm;
    private final Img img;
    private Timer timerResetComm;
    private Timer timerWriteInDb;
    private final Privremeno ProzorPrivremeno;
    private float privremenoIspiranjeMulja = 0;
    
    private final IncPregVent incPregVent;
    private final IncPumpeUpTime incPumpeUpTime;

    //db
    private final PumpeUpTimeService pumpeUpTimeService;
    private final PregVentService pregVentService;
    private final KumulativnoService kumulativnoService;
    //thread
    private final ExecutorService es;
    

    public StartApp(){
        this.FeCl = new VentiliFerihlorid();
        this.PE = new VentiliPolielektrolit();
        this.ventiliGP01 = new VentiliGrupaPumpi();
        this.ventiliKaPescanimFilterima = new VentiliKaPescanimFilterima();
        this.pescaniFilteri = new PescaniFilteri();
        this.pfMerenja = new PescaniFilterMerenjaKonstruktor();
        this.jonskaIzmena = new JonskaIzmena();
        this.njMerenja = new NeutralnaJonskaMerenjaKonstruktor();
        this.demiLinije = new DemiLinije();
        this.bazeniMerenja = new Nivoi();
        this.pumpeDekaFiltriranaKaDemi = new PumpeDekaFiltrKaDemi();
        this.demiLinijeMerenja = new DemiLinijaMerenjaKonstruktor();
        this.pumpeKaPescanimFilterima = new PumpeKaPescanimFilterima();
        this.pumpeDekaFiltriraneKaNeutralnojIzmeni = new PumpeDekaFiltriraneKaNeutralnojIzmeni();
        this.pumpeOdpadnihVodaOdPranjaPescanihFiltera = new PumpeOdpadnihVodaOdPranjaPescanihFiltera();
        this.rezervoariMerenja = new RezervoariMerenja();
        this.pumpeFerihlorid = new PumpeFerihlorid();
        this.pumpePolielektrolit = new PumpePolielektrolit();
        this.protociPescaniFilteri = new ProtociPescaniFilteri();
        this.protociDemiLinije = new ProtociDemiLinije();
        this.protociNeutralna = new ProtociNeutralna();
        this.protociFlokulacija = new ProtociFlokulacija();
        this.pumpeZaPranjePescanihFiltera = new PumpeZaPranjePescanihFiltera();
        this.pumpeNeutralizacionogBazena = new PumpeNeutralizacionogBazena();
        this.otpadneVodeOdPescanihFiltera = new OtpadneVodeOdPescanihFiltera();
        this.pranjePescanihFiltera = new PranjePescanihFiltera();
        this.protociPretovarnaRampa = new ProtociPretovarnaRampa();
        this.reaktorMotori = new ReaktorMotori();
        this.ventilacija = new Ventilacija();
        this.doziranje = new Doziranje();
        this.regeneracija = new Regeneracija();
        this.reaktor = new Reaktor();
        this.protociRegeneracija = new ProtociRegeneracija();
        this.temperature = new Temperature();
        this.pumpeUpTimeService = new PumpeUpTimeService();
        this.merenjeProtokaService = new MerenjeProtokaService();
        this.merenjeNivoaService = new MerenjeNivoaService();
        //this.merenjePritiskaService = new MerenjePritiskaService(emf, fileHandler);
        this.pregVentService = new PregVentService();
        this.kumulativnoService = new KumulativnoService();
        this.es = Executors.newFixedThreadPool(2);

        this.ProzorPrivremeno = new Privremeno();

        comm = new Buff(FeCl, PE, ventiliGP01, ventiliKaPescanimFilterima, pescaniFilteri, pfMerenja,
                jonskaIzmena, njMerenja, demiLinije, bazeniMerenja, demiLinijeMerenja, pumpeDekaFiltriranaKaDemi,
                pumpeKaPescanimFilterima, pumpeDekaFiltriraneKaNeutralnojIzmeni, pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                rezervoariMerenja, pumpeFerihlorid, pumpePolielektrolit, protociPescaniFilteri, protociDemiLinije, protociNeutralna,
                protociFlokulacija, pumpeZaPranjePescanihFiltera, pumpeNeutralizacionogBazena, otpadneVodeOdPescanihFiltera,
                pranjePescanihFiltera, protociPretovarnaRampa, reaktorMotori, doziranje, regeneracija, ventilacija,
                reaktor, protociRegeneracija, temperature);
        img = new Img();

        this.incPregVent = new IncPregVent(
                demiLinije,
                FeCl,
                ventiliGP01,
                jonskaIzmena,
                pescaniFilteri,
                PE,
                reaktor,
                regeneracija,
                ventiliKaPescanimFilterima,
                otpadneVodeOdPescanihFiltera,
                pranjePescanihFiltera,
                pregVentService);
        
        this.incPumpeUpTime = new IncPumpeUpTime(  
                pumpeDekaFiltriranaKaDemi,
                pumpeKaPescanimFilterima,
                pumpeDekaFiltriraneKaNeutralnojIzmeni,
                pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                pumpeFerihlorid,
                pumpePolielektrolit,
                pumpeZaPranjePescanihFiltera,
                pumpeNeutralizacionogBazena);
        
    }

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

 /*try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }*/
        //try {
        //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        //} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
        //    ex.printStackTrace();
        //}
        //</editor-fold>
        try {
            //here you can put the selected theme class name in JTattoo
            Properties p = new Properties();
            p.put("windowTitleFont", "Ebrima PLAIN 15");
            p.put("logoString", "");
            p.put("windowDecoration", "off");
            AluminiumLookAndFeel.setCurrentTheme(p);
            ///UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
              
                
                StartApp osn = new StartApp();
 
         
                osn.startConnection();
                osn.incPregVent.inicVentile();
                osn.incPumpeUpTime.inicPumpeVreme();
                osn.initKumulatinvniProtok();
                
         
                //ovo je za thread kada budem grafikone uzimao od merenja
                //ExecutorService es = Executors.newFixedThreadPool(2);
                //ThreadProba thr = new ThreadProba();
                //es.submit(thr);
                osn.timerResetComm = new Timer(1000, new ActionListener() {  //1000 1 sec
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        osn.privremenoIspiranjeMulja();
                        if (!StartApp.comm.isConnected()) {
                            comm.read = false;
                            osn.restartConnection();
                        }
                    }
                });
                osn.timerResetComm.start();

                
                osn.timerWriteInDb = new Timer(2000, new ActionListener() {  //1000 1 sec
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                        osn.writeInDbMerenjeProtoka();
                        osn.writeInDbMerenjeNivoa();
                        //osn.writeInDbMerenjePritiska();
                        osn.writeInDbKumulativnoProtok();
                        }catch(Exception ex){
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                });
                osn.timerWriteInDb.start();
                
               
   
                MainFrame mf1 = new MainFrame(
                        osn.FeCl,
                        osn.PE,
                        osn.bazeniMerenja,
                        osn.rezervoariMerenja,
                        osn.demiLinijeMerenja,
                        osn.njMerenja,
                        osn.ventiliGP01,
                        osn.ventiliKaPescanimFilterima,
                        osn.pumpeFerihlorid,
                        osn.pumpePolielektrolit,
                        osn.pumpeDekaFiltriranaKaDemi,
                        osn.pumpeKaPescanimFilterima,
                        osn.pumpeDekaFiltriraneKaNeutralnojIzmeni,
                        osn.pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                        osn.pumpeZaPranjePescanihFiltera,
                        osn.pumpeNeutralizacionogBazena,
                        osn.protociFlokulacija,
                        osn.protociPescaniFilteri,
                        osn.protociNeutralna,
                        osn.protociDemiLinije,
                        osn.protociPretovarnaRampa,
                        osn.protociRegeneracija,
                        osn.pescaniFilteri,
                        osn.jonskaIzmena,
                        osn.otpadneVodeOdPescanihFiltera,
                        osn.pranjePescanihFiltera,
                        osn.pfMerenja,
                        osn.demiLinije,
                        osn.doziranje,
                        osn.reaktor,
                        osn.reaktorMotori,
                        osn.regeneracija,
                        osn.temperature,
                        osn.ventilacija,
                        osn.img,
                        osn.pumpeUpTimeService,
                        osn.es,
                        osn.pregVentService);
                MainFrame.showOnScreen(1, mf1);
                mf1.setVisible(true);
                
                
                MainFrame mf2 = new MainFrame(
                        osn.FeCl,
                        osn.PE,
                        osn.bazeniMerenja,
                        osn.rezervoariMerenja,
                        osn.demiLinijeMerenja,
                        osn.njMerenja,
                        osn.ventiliGP01,
                        osn.ventiliKaPescanimFilterima,
                        osn.pumpeFerihlorid,
                        osn.pumpePolielektrolit,
                        osn.pumpeDekaFiltriranaKaDemi,
                        osn.pumpeKaPescanimFilterima,
                        osn.pumpeDekaFiltriraneKaNeutralnojIzmeni,
                        osn.pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                        osn.pumpeZaPranjePescanihFiltera,
                        osn.pumpeNeutralizacionogBazena,
                        osn.protociFlokulacija,
                        osn.protociPescaniFilteri,
                        osn.protociNeutralna,
                        osn.protociDemiLinije,
                        osn.protociPretovarnaRampa,
                        osn.protociRegeneracija,
                        osn.pescaniFilteri,
                        osn.jonskaIzmena,
                        osn.otpadneVodeOdPescanihFiltera,
                        osn.pranjePescanihFiltera,
                        osn.pfMerenja,
                        osn.demiLinije,
                        osn.doziranje,
                        osn.reaktor,
                        osn.reaktorMotori,
                        osn.regeneracija,
                        osn.temperature,
                        osn.ventilacija,
                        osn.img,
                        osn.pumpeUpTimeService,
                        osn.es,
                        osn.pregVentService);
                MainFrame.showOnScreen(2, mf2);
                mf2.setVisible(true);

                
                MainFrame mf3 = new MainFrame(
                        osn.FeCl,
                        osn.PE,
                        osn.bazeniMerenja,
                        osn.rezervoariMerenja,
                        osn.demiLinijeMerenja,
                        osn.njMerenja,
                        osn.ventiliGP01,
                        osn.ventiliKaPescanimFilterima,
                        osn.pumpeFerihlorid,
                        osn.pumpePolielektrolit,
                        osn.pumpeDekaFiltriranaKaDemi,
                        osn.pumpeKaPescanimFilterima,
                        osn.pumpeDekaFiltriraneKaNeutralnojIzmeni,
                        osn.pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                        osn.pumpeZaPranjePescanihFiltera,
                        osn.pumpeNeutralizacionogBazena,
                        osn.protociFlokulacija,
                        osn.protociPescaniFilteri,
                        osn.protociNeutralna,
                        osn.protociDemiLinije,
                        osn.protociPretovarnaRampa,
                        osn.protociRegeneracija,
                        osn.pescaniFilteri,
                        osn.jonskaIzmena,
                        osn.otpadneVodeOdPescanihFiltera,
                        osn.pranjePescanihFiltera,
                        osn.pfMerenja,
                        osn.demiLinije,
                        osn.doziranje,
                        osn.reaktor,
                        osn.reaktorMotori,
                        osn.regeneracija,
                        osn.temperature,
                        osn.ventilacija,
                        osn.img,
                        osn.pumpeUpTimeService,
                        osn.es,
                        osn.pregVentService);
                MainFrame.showOnScreen(3, mf3);
                mf3.setVisible(true);
            }
        });
    }

    
    private void writeInDbMerenjeProtoka() {
        merenjeProtokaService.addMerenjeProtoka(
                protociDemiLinije.getProtokDL1in().getProtok().getVrednostRegistra(),
                protociDemiLinije.getProtokDL2in().getProtok().getVrednostRegistra(),
                protociDemiLinije.getProtokDL3in().getProtok().getVrednostRegistra(),
                protociDemiLinije.getProtokDL1out().getProtok().getVrednostRegistra(),
                protociDemiLinije.getProtokDL2out().getProtok().getVrednostRegistra(),
                protociDemiLinije.getProtokDL3out().getProtok().getVrednostRegistra(),
                protociPretovarnaRampa.getProtokKiseline().getProtok().getVrednostRegistra(),
                protociPretovarnaRampa.getProtokLuzine().getProtok().getVrednostRegistra(),
                0,
                protociFlokulacija.getProtokSiroveVodeR1().getProtok().getVrednostRegistra(),
                protociFlokulacija.getProtokSiroveVodeR2().getProtok().getVrednostRegistra(),
                ShiftPoint.shiftonePointDouble(protociPescaniFilteri.getProtokPF1().getProtok().getVrednostRegistra(), protociPescaniFilteri.getProtokPF1().getProtok().getBrDec()),
                ShiftPoint.shiftonePointDouble(protociPescaniFilteri.getProtokPF2().getProtok().getVrednostRegistra(), protociPescaniFilteri.getProtokPF2().getProtok().getBrDec()),
                ShiftPoint.shiftonePointDouble(protociPescaniFilteri.getProtokPF3().getProtok().getVrednostRegistra(), protociPescaniFilteri.getProtokPF3().getProtok().getBrDec()),
                ShiftPoint.shiftonePointDouble(protociPescaniFilteri.getProtokPF4().getProtok().getVrednostRegistra(), protociPescaniFilteri.getProtokPF4().getProtok().getBrDec()),
                ShiftPoint.shiftonePointDouble(protociPescaniFilteri.getProtokPF5().getProtok().getVrednostRegistra(), protociPescaniFilteri.getProtokPF5().getProtok().getBrDec()),
                ShiftPoint.shiftonePointDouble(protociPescaniFilteri.getProtokPF6().getProtok().getVrednostRegistra(), protociPescaniFilteri.getProtokPF6().getProtok().getBrDec()),
                protociNeutralna.getProtokNJ1().getProtok().getVrednostRegistra(),
                protociNeutralna.getProtokNJ2().getProtok().getVrednostRegistra(),
                protociNeutralna.getProtokNJ3().getProtok().getVrednostRegistra(),
                0);
    }
    
    private void writeInDbKumulativnoProtok() {
        if(protociDemiLinije.getProtokDL1in().isPromena()){
            kumulativnoService.setKumulativno("demi1In", protociDemiLinije.getProtokDL1in().getKumulativnoRucno());
            protociDemiLinije.getProtokDL1in().setPromena(false);
        }
    }
    
    private void initKumulatinvniProtok() {
        
        protociDemiLinije.getProtokDL1in().setKumulativnoRucno(kumulativnoService.getKumulativnoStanje("demi1In").getVrednost());
        protociDemiLinije.getProtokDL1in().setPromena(false);
        
    }
    

    private void writeInDbMerenjeNivoa() {
        merenjeNivoaService.addMerenjeNivoa(0, 0,
                rezervoariMerenja.getNivoRezervoarDEMIvode1000m3br1().getVrednostRegistra(),
                rezervoariMerenja.getNivoRezervoarDEMIvode1000m3br2().getVrednostRegistra(),
                rezervoariMerenja.getNivoRezervoarKompenzacioni500m3().getVrednostRegistra(),
                bazeniMerenja.getBazenNeutralizacioni().getVrednostRegistra(),
                rezervoariMerenja.getNivoRezervoarDEMIvode150m3().getVrednostRegistra(),
                bazeniMerenja.getBazenDekaNefiltriraneVode().getVrednostRegistra(),
                bazeniMerenja.getBazenDekaFiltriraneVode().getVrednostRegistra(),
                bazeniMerenja.getBazenOtpadneVodeOdPranjaPescanihFiltera().getVrednostRegistra(),
                0);
    }
    
    
/*
    private void writeInDbMerenjePritiska() {
        merenjePritiskaService.setMerenjePritiska(
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLjkkfIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLjkkfOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLsbafIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLsbafOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLjbafIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLjbafOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLmfIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija01().getPritisakDLmfOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLjkkfIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLjkkfOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLsbafIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLsbafOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLjbafIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLjbafOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLmfIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija02().getPritisakDLmfOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLjkkfIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLjkkfOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLsbafIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLsbafOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLjbafIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLjbafOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLmfIn().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(demiLinijeMerenja.getDemiLinija03().getPritisakDLmfOut().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakInPF1().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakInPF2().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakInPF3().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakInPF4().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakInPF5().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakInPF6().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakOutPF1().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakOutPF2().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakOutPF3().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakOutPF4().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakOutPF5().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(pfMerenja.getPfMerenja().getPritisakOutPF6().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(njMerenja.getNjMerenjaL3().getPritisakInNJ().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(njMerenja.getNjMerenjaL2().getPritisakInNJ().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(njMerenja.getNjMerenjaL1().getPritisakInNJ().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(njMerenja.getNjMerenjaL3().getPritisakOutNJ().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(njMerenja.getNjMerenjaL2().getPritisakOutNJ().getVrednostRegistra(), 2),
                ShiftPoint.shiftonePointDouble(njMerenja.getNjMerenjaL1().getPritisakOutNJ().getVrednostRegistra(), 2));
    }
     */
    private void startConnection() {
        comm.openConnection();
        comm.read = true;
        t1 = new Thread(comm);
        t1.start();
    }

    private void restartConnection() {
        comm = null;
        comm = new Buff(FeCl, PE, ventiliGP01, ventiliKaPescanimFilterima, pescaniFilteri, pfMerenja,
                jonskaIzmena, njMerenja, demiLinije, bazeniMerenja, demiLinijeMerenja, pumpeDekaFiltriranaKaDemi,
                pumpeKaPescanimFilterima, pumpeDekaFiltriraneKaNeutralnojIzmeni, pumpeOdpadnihVodaOdPranjaPescanihFiltera,
                rezervoariMerenja, pumpeFerihlorid, pumpePolielektrolit, protociPescaniFilteri, protociDemiLinije, protociNeutralna,
                protociFlokulacija, pumpeZaPranjePescanihFiltera, pumpeNeutralizacionogBazena, otpadneVodeOdPescanihFiltera,
                pranjePescanihFiltera, protociPretovarnaRampa, reaktorMotori, doziranje, regeneracija,
                ventilacija, reaktor, protociRegeneracija, temperature);
        
        comm.openConnection();
        comm.read = true;
        t1 = new Thread(comm);
        //MainFrame.comm = comm;
        t1.start();
    }

    public VentiliFerihlorid getFeCl() {
        return FeCl;
    }

    public VentiliPolielektrolit getPE() {
        return PE;
    }

    public VentiliGrupaPumpi getVentiliGP01() {
        return ventiliGP01;
    }

    public VentiliKaPescanimFilterima getVentiliKaPescanimFilterima() {
        return ventiliKaPescanimFilterima;
    }

    public PescaniFilteri getPescaniFilteri() {
        return pescaniFilteri;
    }

    public PescaniFilterMerenjaKonstruktor getPfMerenja() {
        return pfMerenja;
    }

    public JonskaIzmena getJonskaIzmena() {
        return jonskaIzmena;
    }

    public NeutralnaJonskaMerenjaKonstruktor getNjMerenja() {
        return njMerenja;
    }

    public DemiLinije getDemiLinije() {
        return demiLinije;
    }

    public Nivoi getBazeniMerenja() {
        return bazeniMerenja;
    }

    public DemiLinijaMerenjaKonstruktor getDemiLinijeMerenja() {
        return demiLinijeMerenja;
    }

    public PumpeDekaFiltrKaDemi getPumpeDekaFiltriranaKaDemi() {
        return pumpeDekaFiltriranaKaDemi;
    }

    public PumpeKaPescanimFilterima getPumpeKaPescanimFilterima() {
        return pumpeKaPescanimFilterima;
    }

    public PumpeDekaFiltriraneKaNeutralnojIzmeni getPumpeDekaFiltriraneKaNeutralnojIzmeni() {
        return pumpeDekaFiltriraneKaNeutralnojIzmeni;
    }

    public PumpeOdpadnihVodaOdPranjaPescanihFiltera getPumpeOdpadnihVodaOdPranjaPescanihFiltera() {
        return pumpeOdpadnihVodaOdPranjaPescanihFiltera;
    }

    public Buff getComm() {
        return comm;
    }

    public Img getImg() {
        return img;
    }

    //privremeno za ispiranje 
    private void privremenoIspiranjeMulja() {
        float kumulativno = Float.parseFloat(intToLongPrivremeno(protociFlokulacija.getProtokSiroveVodeR1().getKumulativnoVisiVrednost(), protociFlokulacija.getProtokSiroveVodeR1().getKumulativnoNiziVrednost()));
        if (kumulativno > (privremenoIspiranjeMulja + 400)) {

            ProzorPrivremeno.setVisible(true);
            privremenoIspiranjeMulja = kumulativno;
        }
    }

    private String intToLongPrivremeno(int visi, int nizi) {
        int a = 0;
        try {
            a = visi << 16 | nizi & 0xFFFF;
            return ShiftPoint.shiftonePoint(a, 1);
        } catch (Exception e) {

        }
        return "*";
    }
}
