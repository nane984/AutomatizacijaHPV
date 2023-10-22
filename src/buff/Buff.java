/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buff;

import constant.ConstReg;
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
import field.ventili.VentiliGrupaPumpi;
import field.ventili.JonskaIzmena;
import field.ventili.PescaniFilteri;
import field.ventili.VentiliPolielektrolit;
import field.ventili.Reaktor;
import field.ventili.Regeneracija;
import field.ventili.VentiliKaPescanimFilterima;
import field.ventili.pescaniFilter.OtpadneVodeOdPescanihFiltera;
import field.ventili.pescaniFilter.PranjePescanihFiltera;
import java.net.InetAddress;
import java.net.UnknownHostException;
import mxl.MXM;
import tools.MutantToDec;
import virtual.doziranje.Doziranje;

/**
 *
 * @author branko.scekic
 */
public class Buff implements Runnable {

    private final MXM mxm;
    private final VentiliFerihlorid ferihlorid;
    private final VentiliPolielektrolit polielektrolit;
    private final VentiliKaPescanimFilterima ventiliKaPescanimFilterima;
    private final VentiliGrupaPumpi ventiliGrupaPumpi;
    private final PescaniFilteri pescaniFilteri;
    private final PescaniFilterMerenjaKonstruktor pfMerenja;
    private final JonskaIzmena jonskaIzmena;
    private final NeutralnaJonskaMerenjaKonstruktor njMerenja;
    private final DemiLinije demiLinije;
    private final Nivoi nivoiMerenja;
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
    private final PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena;
    private final OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera;
    private final PranjePescanihFiltera pranjePescanihFiltera;
    private final ProtociPretovarnaRampa protociPretovarnaRampa;
    private final ReaktorMotori reaktorMotori;
    private final Doziranje doziranje;
    private final Regeneracija regeneracija;
    private final Ventilacija ventilacija;
    private final Reaktor reaktor;
    private final ProtociRegeneracija protociRegeneracija;
    private final Temperature temperature;

    public boolean writeDigital;
    public boolean writeDigitals;
    public boolean writeRegister;
    public int registerValue;
    public boolean mxValue;
    public boolean[] mxValues;
    public int offset;
    public boolean read;
    public boolean writeOutput;

    private boolean[] resultVentili;
    private int[] resMerenja0;
    private int[] resMerenja1;
    private int[] resMerenja2;
    private boolean[] resultStatusiPumpe;
    private boolean[] resultEnablePumpe;

    private final int startStatusiPumpi;
    private final int startEnablePumpi;

    private final int ventiliGrupaPumpi_potisDemi1;
    private final int demiLinijeJkkf01Vent03;

    public Buff(VentiliFerihlorid ferihlorid, VentiliPolielektrolit polielektrolit, VentiliGrupaPumpi ventiliGrupaPumpi,
            VentiliKaPescanimFilterima ventiliKaPescanimFilterima, PescaniFilteri pescaniFilteri,
            PescaniFilterMerenjaKonstruktor pfMerenja, JonskaIzmena jonskaIzmena,
            NeutralnaJonskaMerenjaKonstruktor njMerenja, DemiLinije demiLinije,
            Nivoi nivoiMerenja, DemiLinijaMerenjaKonstruktor demiLinijeMerenja,
            PumpeDekaFiltrKaDemi pumpeDekaFiltriranaKaDemi, PumpeKaPescanimFilterima pumpeKaPescanimFilterima,
            PumpeDekaFiltriraneKaNeutralnojIzmeni pumpeDekaFiltriraneKaNeutralnojIzmeni,
            PumpeOdpadnihVodaOdPranjaPescanihFiltera pumpeOdpadnihVodaOdPranjaPescanihFiltera,
            RezervoariMerenja rezervoariMerenja, PumpeFerihlorid pumpeFerihlorid, PumpePolielektrolit pumpePolielektrolit,
            ProtociPescaniFilteri protociPescaniFilteri, ProtociDemiLinije protociDemiLinije, ProtociNeutralna protociNeutralna,
            ProtociFlokulacija protociFlokulacija, PumpeZaPranjePescanihFiltera pumpeZaPranjePescanihFiltera,
            PumpeNeutralizacionogBazena pumpeNeutralizacionogBazena, OtpadneVodeOdPescanihFiltera otpadneVodeOdPescanihFiltera,
            PranjePescanihFiltera pranjePescanihFiltera, ProtociPretovarnaRampa protociPretovarnaRampa, ReaktorMotori reaktorMotori,
            Doziranje doziranje, Regeneracija regeneracija, Ventilacija ventilacija, Reaktor reaktor, ProtociRegeneracija protociRegeneracija, 
            Temperature temperature) {

        this.ferihlorid = ferihlorid;
        this.polielektrolit = polielektrolit;
        this.ventiliGrupaPumpi = ventiliGrupaPumpi;
        this.ventiliKaPescanimFilterima = ventiliKaPescanimFilterima;
        this.pescaniFilteri = pescaniFilteri;
        this.pfMerenja = pfMerenja;
        this.jonskaIzmena = jonskaIzmena;
        this.njMerenja = njMerenja;
        this.demiLinije = demiLinije;
        this.nivoiMerenja = nivoiMerenja;
        this.pumpeDekaFiltriranaKaDemi = pumpeDekaFiltriranaKaDemi;
        this.demiLinijeMerenja = demiLinijeMerenja;
        this.pumpeKaPescanimFilterima = pumpeKaPescanimFilterima;
        this.pumpeDekaFiltriraneKaNeutralnojIzmeni = pumpeDekaFiltriraneKaNeutralnojIzmeni;
        this.pumpeOdpadnihVodaOdPranjaPescanihFiltera = pumpeOdpadnihVodaOdPranjaPescanihFiltera;
        this.rezervoariMerenja = rezervoariMerenja;
        this.pumpeFerihlorid = pumpeFerihlorid;
        this.pumpePolielektrolit = pumpePolielektrolit;
        this.protociPescaniFilteri = protociPescaniFilteri;
        this.protociDemiLinije = protociDemiLinije;
        this.protociNeutralna = protociNeutralna;
        this.protociFlokulacija = protociFlokulacija;
        this.pumpeZaPranjePescanihFiltera = pumpeZaPranjePescanihFiltera;
        this.pumpeNeutralizacionogBazena = pumpeNeutralizacionogBazena;
        this.otpadneVodeOdPescanihFiltera = otpadneVodeOdPescanihFiltera;
        this.pranjePescanihFiltera = pranjePescanihFiltera;
        this.protociPretovarnaRampa = protociPretovarnaRampa;
        this.reaktorMotori = reaktorMotori;
        this.doziranje = doziranje;
        this.regeneracija = regeneracija;
        this.ventilacija = ventilacija;
        this.reaktor = reaktor;
        this.protociRegeneracija = protociRegeneracija;
        this.temperature = temperature;

        this.resultVentili = new boolean[1000];
        this.resultEnablePumpe = new boolean[510];
        this.startStatusiPumpi = MutantToDec.getValue("530") + ConstReg.StartDigitalInput;
        this.startEnablePumpi = MutantToDec.getValue("2000") + ConstReg.StartMX;

        read = false;
        mxValue = false;
        mxm = new MXM();
        InetAddress ip = null;
        try {
            ip = InetAddress.getByName("192.168.0.10"); //hpv
            // ip = InetAddress.getByName("192.168.0.2");    //kuci plc
        } catch (UnknownHostException ex) {
           
        }
        mxm.setIp(ip);

        ventiliGrupaPumpi_potisDemi1 = ventiliGrupaPumpi.getGP01_potisDemi1().getEnableOtvori();
        demiLinijeJkkf01Vent03 = demiLinije.getJkkf01().getVent03().getEnableOtvori();
    }

    private void getVentiliGrupaPumpi() {

        resultVentili = mxm.readMX(ventiliGrupaPumpi_potisDemi1, 1660);       //enableOtvori, enableZatvori, otvoren, zatvoren

        ventiliGrupaPumpi.getGP01_potisDemi1().getVrednostiReg().setEnableOtvori(resultVentili[0]);
        ventiliGrupaPumpi.getGP01_potisDemi1().getVrednostiReg().setEnableZatvori(resultVentili[1]);
        ventiliGrupaPumpi.getGP01_potisDemi1().getVrednostiReg().setOtvoren(resultVentili[2]);
        ventiliGrupaPumpi.getGP01_potisDemi1().getVrednostiReg().setZatvoren(resultVentili[3]);

        ventiliGrupaPumpi.getGP01_potisDemi2().getVrednostiReg().setEnableOtvori(resultVentili[20]);
        ventiliGrupaPumpi.getGP01_potisDemi2().getVrednostiReg().setEnableZatvori(resultVentili[21]);
        ventiliGrupaPumpi.getGP01_potisDemi2().getVrednostiReg().setOtvoren(resultVentili[22]);
        ventiliGrupaPumpi.getGP01_potisDemi2().getVrednostiReg().setZatvoren(resultVentili[23]);

        ventiliGrupaPumpi.getGP01_potisDemi3().getVrednostiReg().setEnableOtvori(resultVentili[40]);
        ventiliGrupaPumpi.getGP01_potisDemi3().getVrednostiReg().setEnableZatvori(resultVentili[41]);
        ventiliGrupaPumpi.getGP01_potisDemi3().getVrednostiReg().setOtvoren(resultVentili[42]);
        ventiliGrupaPumpi.getGP01_potisDemi3().getVrednostiReg().setZatvoren(resultVentili[43]);

        ventiliGrupaPumpi.getGP01_potisDemi4().getVrednostiReg().setEnableOtvori(resultVentili[60]);
        ventiliGrupaPumpi.getGP01_potisDemi4().getVrednostiReg().setEnableZatvori(resultVentili[61]);
        ventiliGrupaPumpi.getGP01_potisDemi4().getVrednostiReg().setOtvoren(resultVentili[62]);
        ventiliGrupaPumpi.getGP01_potisDemi4().getVrednostiReg().setZatvoren(resultVentili[63]);

        ventiliGrupaPumpi.getGP01_potisDemi5().getVrednostiReg().setEnableOtvori(resultVentili[80]);
        ventiliGrupaPumpi.getGP01_potisDemi5().getVrednostiReg().setEnableZatvori(resultVentili[81]);
        ventiliGrupaPumpi.getGP01_potisDemi5().getVrednostiReg().setOtvoren(resultVentili[82]);
        ventiliGrupaPumpi.getGP01_potisDemi5().getVrednostiReg().setZatvoren(resultVentili[83]);

        ventiliGrupaPumpi.getGP01_potisJonska1().getVrednostiReg().setEnableOtvori(resultVentili[100]);
        ventiliGrupaPumpi.getGP01_potisJonska1().getVrednostiReg().setEnableZatvori(resultVentili[101]);
        ventiliGrupaPumpi.getGP01_potisJonska1().getVrednostiReg().setOtvoren(resultVentili[102]);
        ventiliGrupaPumpi.getGP01_potisJonska1().getVrednostiReg().setZatvoren(resultVentili[103]);

        ventiliGrupaPumpi.getGP01_potisJonska2().getVrednostiReg().setEnableOtvori(resultVentili[120]);
        ventiliGrupaPumpi.getGP01_potisJonska2().getVrednostiReg().setEnableZatvori(resultVentili[121]);
        ventiliGrupaPumpi.getGP01_potisJonska2().getVrednostiReg().setOtvoren(resultVentili[122]);
        ventiliGrupaPumpi.getGP01_potisJonska2().getVrednostiReg().setZatvoren(resultVentili[123]);

        ventiliGrupaPumpi.getGP01_potisJonska3().getVrednostiReg().setEnableOtvori(resultVentili[140]);
        ventiliGrupaPumpi.getGP01_potisJonska3().getVrednostiReg().setEnableZatvori(resultVentili[141]);
        ventiliGrupaPumpi.getGP01_potisJonska3().getVrednostiReg().setOtvoren(resultVentili[142]);
        ventiliGrupaPumpi.getGP01_potisJonska3().getVrednostiReg().setZatvoren(resultVentili[143]);

        pranjePescanihFiltera.getVent01().getVrednostiReg().setEnableOtvori(resultVentili[160]);
        pranjePescanihFiltera.getVent01().getVrednostiReg().setEnableZatvori(resultVentili[161]);
        pranjePescanihFiltera.getVent01().getVrednostiReg().setOtvoren(resultVentili[162]);
        pranjePescanihFiltera.getVent01().getVrednostiReg().setZatvoren(resultVentili[163]);

        pranjePescanihFiltera.getVent02().getVrednostiReg().setEnableOtvori(resultVentili[180]);
        pranjePescanihFiltera.getVent02().getVrednostiReg().setEnableZatvori(resultVentili[181]);
        pranjePescanihFiltera.getVent02().getVrednostiReg().setOtvoren(resultVentili[182]);
        pranjePescanihFiltera.getVent02().getVrednostiReg().setZatvoren(resultVentili[183]);
    }

    private void getVentiliPumpeKaPescanimFilterima() {

        ventiliKaPescanimFilterima.getAPKPF_PotisBr1().getVrednostiReg().setEnableOtvori(resultVentili[200]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr1().getVrednostiReg().setEnableZatvori(resultVentili[201]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr1().getVrednostiReg().setOtvoren(resultVentili[202]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr1().getVrednostiReg().setZatvoren(resultVentili[203]);

        ventiliKaPescanimFilterima.getAPKPF_PotisBr2().getVrednostiReg().setEnableOtvori(resultVentili[220]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr2().getVrednostiReg().setEnableZatvori(resultVentili[221]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr2().getVrednostiReg().setOtvoren(resultVentili[222]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr2().getVrednostiReg().setZatvoren(resultVentili[223]);

        ventiliKaPescanimFilterima.getAPKPF_PotisBr3().getVrednostiReg().setEnableOtvori(resultVentili[240]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr3().getVrednostiReg().setEnableZatvori(resultVentili[241]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr3().getVrednostiReg().setOtvoren(resultVentili[242]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr3().getVrednostiReg().setZatvoren(resultVentili[243]);

        ventiliKaPescanimFilterima.getAPKPF_PotisBr4().getVrednostiReg().setEnableOtvori(resultVentili[260]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr4().getVrednostiReg().setEnableZatvori(resultVentili[261]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr4().getVrednostiReg().setOtvoren(resultVentili[262]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr4().getVrednostiReg().setZatvoren(resultVentili[263]);

        ventiliKaPescanimFilterima.getAPKPF_PotisBr5().getVrednostiReg().setEnableOtvori(resultVentili[280]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr5().getVrednostiReg().setEnableZatvori(resultVentili[281]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr5().getVrednostiReg().setOtvoren(resultVentili[282]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr5().getVrednostiReg().setZatvoren(resultVentili[283]);

        ventiliKaPescanimFilterima.getAPKPF_PotisBr6().getVrednostiReg().setEnableOtvori(resultVentili[300]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr6().getVrednostiReg().setEnableZatvori(resultVentili[301]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr6().getVrednostiReg().setOtvoren(resultVentili[302]);
        ventiliKaPescanimFilterima.getAPKPF_PotisBr6().getVrednostiReg().setZatvoren(resultVentili[303]);

    }

    private void getPolielektrolit() {
       
        polielektrolit.getPE_kompenzaciona1().getVrednostiReg().setEnableOtvori(resultVentili[390]);
        polielektrolit.getPE_kompenzaciona1().getVrednostiReg().setEnableZatvori(resultVentili[391]);
        polielektrolit.getPE_kompenzaciona1().getVrednostiReg().setOtvoren(resultVentili[392]);
        polielektrolit.getPE_kompenzaciona1().getVrednostiReg().setZatvoren(resultVentili[393]);
             
        polielektrolit.getPE_kompenzaciona2().getVrednostiReg().setEnableOtvori(resultVentili[400]);
        polielektrolit.getPE_kompenzaciona2().getVrednostiReg().setEnableZatvori(resultVentili[401]);
        polielektrolit.getPE_kompenzaciona2().getVrednostiReg().setOtvoren(resultVentili[402]);
        polielektrolit.getPE_kompenzaciona2().getVrednostiReg().setZatvoren(resultVentili[403]);

        polielektrolit.getPE_posuda1().getVrednostiReg().setEnableOtvori(resultVentili[310]);
        polielektrolit.getPE_posuda1().getVrednostiReg().setEnableZatvori(resultVentili[311]);
        polielektrolit.getPE_posuda1().getVrednostiReg().setOtvoren(resultVentili[312]);
        polielektrolit.getPE_posuda1().getVrednostiReg().setZatvoren(resultVentili[313]);

        polielektrolit.getPE_posuda2().getVrednostiReg().setEnableOtvori(resultVentili[320]);
        polielektrolit.getPE_posuda2().getVrednostiReg().setEnableZatvori(resultVentili[321]);
        polielektrolit.getPE_posuda2().getVrednostiReg().setOtvoren(resultVentili[322]);
        polielektrolit.getPE_posuda2().getVrednostiReg().setZatvoren(resultVentili[323]);
        
        polielektrolit.getPE_ventil1().getVrednostiReg().setEnableOtvori(resultVentili[340]);
        polielektrolit.getPE_ventil1().getVrednostiReg().setEnableZatvori(resultVentili[341]);
        polielektrolit.getPE_ventil1().getVrednostiReg().setOtvoren(resultVentili[342]);
        polielektrolit.getPE_ventil1().getVrednostiReg().setZatvoren(resultVentili[343]);
        
        polielektrolit.getPE_ventil2().getVrednostiReg().setEnableOtvori(resultVentili[360]);
        polielektrolit.getPE_ventil2().getVrednostiReg().setEnableZatvori(resultVentili[361]);
        polielektrolit.getPE_ventil2().getVrednostiReg().setOtvoren(resultVentili[362]);
        polielektrolit.getPE_ventil2().getVrednostiReg().setZatvoren(resultVentili[363]);
        
        polielektrolit.getPE_ventil3().getVrednostiReg().setEnableOtvori(resultVentili[380]);
        polielektrolit.getPE_ventil3().getVrednostiReg().setEnableZatvori(resultVentili[381]);
        polielektrolit.getPE_ventil3().getVrednostiReg().setOtvoren(resultVentili[382]);
        polielektrolit.getPE_ventil3().getVrednostiReg().setZatvoren(resultVentili[383]);

        polielektrolit.getPE_vodaKaPosudi1().getVrednostiReg().setEnableOtvori(resultVentili[410]);
        polielektrolit.getPE_vodaKaPosudi1().getVrednostiReg().setEnableZatvori(resultVentili[411]);
        polielektrolit.getPE_vodaKaPosudi1().getVrednostiReg().setOtvoren(resultVentili[412]);
        polielektrolit.getPE_vodaKaPosudi1().getVrednostiReg().setZatvoren(resultVentili[413]);

       
        polielektrolit.getPE_vodaKaPosudi2().getVrednostiReg().setEnableOtvori(resultVentili[420]);
        polielektrolit.getPE_vodaKaPosudi2().getVrednostiReg().setEnableZatvori(resultVentili[421]);
        polielektrolit.getPE_vodaKaPosudi2().getVrednostiReg().setOtvoren(resultVentili[422]);
        polielektrolit.getPE_vodaKaPosudi2().getVrednostiReg().setZatvoren(resultVentili[422]);
    }

    private void getFerihlorid() {
        
        ferihlorid.getFCl_kompenzaciona1().getVrednostiReg().setEnableOtvori(resultVentili[510]);
        ferihlorid.getFCl_kompenzaciona1().getVrednostiReg().setEnableZatvori(resultVentili[511]);
        ferihlorid.getFCl_kompenzaciona1().getVrednostiReg().setOtvoren(resultVentili[512]);
        ferihlorid.getFCl_kompenzaciona1().getVrednostiReg().setZatvoren(resultVentili[513]);

        ferihlorid.getFCl_kompenzaciona2().getVrednostiReg().setEnableOtvori(resultVentili[520]);
        ferihlorid.getFCl_kompenzaciona2().getVrednostiReg().setEnableZatvori(resultVentili[521]);
        ferihlorid.getFCl_kompenzaciona2().getVrednostiReg().setOtvoren(resultVentili[522]);
        ferihlorid.getFCl_kompenzaciona2().getVrednostiReg().setZatvoren(resultVentili[523]);

        ferihlorid.getFCl_posuda1().getVrednostiReg().setEnableOtvori(resultVentili[430]);
        ferihlorid.getFCl_posuda1().getVrednostiReg().setEnableZatvori(resultVentili[431]);
        ferihlorid.getFCl_posuda1().getVrednostiReg().setOtvoren(resultVentili[432]);
        ferihlorid.getFCl_posuda1().getVrednostiReg().setZatvoren(resultVentili[433]);

       
        ferihlorid.getFCl_posuda2().getVrednostiReg().setEnableOtvori(resultVentili[440]);
        ferihlorid.getFCl_posuda2().getVrednostiReg().setEnableZatvori(resultVentili[441]);
        ferihlorid.getFCl_posuda2().getVrednostiReg().setOtvoren(resultVentili[442]);
        ferihlorid.getFCl_posuda2().getVrednostiReg().setZatvoren(resultVentili[443]);
        
        
        ferihlorid.getFCl_ventil1().getVrednostiReg().setEnableOtvori(resultVentili[460]);
        ferihlorid.getFCl_ventil1().getVrednostiReg().setEnableZatvori(resultVentili[461]);
        ferihlorid.getFCl_ventil1().getVrednostiReg().setOtvoren(resultVentili[462]);
        ferihlorid.getFCl_ventil1().getVrednostiReg().setZatvoren(resultVentili[463]);

       
        ferihlorid.getFCl_ventil2().getVrednostiReg().setEnableOtvori(resultVentili[480]);
        ferihlorid.getFCl_ventil2().getVrednostiReg().setEnableZatvori(resultVentili[481]);
        ferihlorid.getFCl_ventil2().getVrednostiReg().setOtvoren(resultVentili[482]);
        ferihlorid.getFCl_ventil2().getVrednostiReg().setZatvoren(resultVentili[483]);

        
        ferihlorid.getFCl_ventil3().getVrednostiReg().setEnableOtvori(resultVentili[500]);
        ferihlorid.getFCl_ventil3().getVrednostiReg().setEnableZatvori(resultVentili[501]);
        ferihlorid.getFCl_ventil3().getVrednostiReg().setOtvoren(resultVentili[502]);
        ferihlorid.getFCl_ventil3().getVrednostiReg().setZatvoren(resultVentili[503]);

    }

    private void getPescaniFilter1() {

        pescaniFilteri.getPf1().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[540]);
        pescaniFilteri.getPf1().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[541]);
        pescaniFilteri.getPf1().getVent03().getVrednostiReg().setOtvoren(resultVentili[542]);
        pescaniFilteri.getPf1().getVent03().getVrednostiReg().setZatvoren(resultVentili[543]);

        pescaniFilteri.getPf1().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[550]);
        pescaniFilteri.getPf1().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[551]);
        pescaniFilteri.getPf1().getVent04().getVrednostiReg().setOtvoren(resultVentili[552]);
        pescaniFilteri.getPf1().getVent04().getVrednostiReg().setZatvoren(resultVentili[553]);

        pescaniFilteri.getPf1().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[560]);
        pescaniFilteri.getPf1().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[561]);
        pescaniFilteri.getPf1().getVent05().getVrednostiReg().setOtvoren(resultVentili[562]);
        pescaniFilteri.getPf1().getVent05().getVrednostiReg().setZatvoren(resultVentili[563]);

        pescaniFilteri.getPf1().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[570]);
        pescaniFilteri.getPf1().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[571]);
        pescaniFilteri.getPf1().getVent06().getVrednostiReg().setOtvoren(resultVentili[572]);
        pescaniFilteri.getPf1().getVent06().getVrednostiReg().setZatvoren(resultVentili[573]);

        pescaniFilteri.getPf1().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[580]);
        pescaniFilteri.getPf1().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[581]);
        pescaniFilteri.getPf1().getVent07().getVrednostiReg().setOtvoren(resultVentili[582]);
        pescaniFilteri.getPf1().getVent07().getVrednostiReg().setZatvoren(resultVentili[583]);

        pescaniFilteri.getPf1().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[590]);
        pescaniFilteri.getPf1().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[591]);
        pescaniFilteri.getPf1().getVent08().getVrednostiReg().setOtvoren(resultVentili[592]);
        pescaniFilteri.getPf1().getVent08().getVrednostiReg().setZatvoren(resultVentili[593]);

        pescaniFilteri.getPf1().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[600]);
        pescaniFilteri.getPf1().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[601]);
        pescaniFilteri.getPf1().getVent09().getVrednostiReg().setOtvoren(resultVentili[602]);
        pescaniFilteri.getPf1().getVent09().getVrednostiReg().setZatvoren(resultVentili[603]);

        pescaniFilteri.getPf1().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[610]);
        pescaniFilteri.getPf1().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[611]);
        pescaniFilteri.getPf1().getVent10().getVrednostiReg().setOtvoren(resultVentili[612]);
        pescaniFilteri.getPf1().getVent10().getVrednostiReg().setZatvoren(resultVentili[613]);
        
        //izlaz iz pescanih filtera
        pescaniFilteri.getRegVentIzlazIzPescanih().getVrednosti().setEnableOtvori(resultVentili[1219]);
        pescaniFilteri.getRegVentIzlazIzPescanih().getVrednosti().setEnableZatvori(resultVentili[1220]);
        pescaniFilteri.getRegVentIzlazIzPescanih().getVrednosti().setOtvoren(resultVentili[1217]);
        pescaniFilteri.getRegVentIzlazIzPescanih().getVrednosti().setZatvoren(resultVentili[1218]);
        pescaniFilteri.getRegVentIzlazIzPescanih().getVrednosti().setPolozajVrednost(resMerenja2[98]);  //pozicija
        pescaniFilteri.getRegVentIzlazIzPescanih().setVremePunogHodaVentila(resMerenja2[97]);           //vrednost vremena punog hoda
    }

    private void getPescaniFilter2() {

        pescaniFilteri.getPf2().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[630]);
        pescaniFilteri.getPf2().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[631]);
        pescaniFilteri.getPf2().getVent03().getVrednostiReg().setOtvoren(resultVentili[632]);
        pescaniFilteri.getPf2().getVent03().getVrednostiReg().setZatvoren(resultVentili[633]);

        pescaniFilteri.getPf2().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[640]);
        pescaniFilteri.getPf2().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[641]);
        pescaniFilteri.getPf2().getVent04().getVrednostiReg().setOtvoren(resultVentili[642]);
        pescaniFilteri.getPf2().getVent04().getVrednostiReg().setZatvoren(resultVentili[643]);

        pescaniFilteri.getPf2().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[650]);
        pescaniFilteri.getPf2().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[651]);
        pescaniFilteri.getPf2().getVent05().getVrednostiReg().setOtvoren(resultVentili[652]);
        pescaniFilteri.getPf2().getVent05().getVrednostiReg().setZatvoren(resultVentili[653]);

        pescaniFilteri.getPf2().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[660]);
        pescaniFilteri.getPf2().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[661]);
        pescaniFilteri.getPf2().getVent06().getVrednostiReg().setOtvoren(resultVentili[662]);
        pescaniFilteri.getPf2().getVent06().getVrednostiReg().setZatvoren(resultVentili[663]);

        pescaniFilteri.getPf2().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[670]);
        pescaniFilteri.getPf2().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[671]);
        pescaniFilteri.getPf2().getVent07().getVrednostiReg().setOtvoren(resultVentili[672]);
        pescaniFilteri.getPf2().getVent07().getVrednostiReg().setZatvoren(resultVentili[673]);

        pescaniFilteri.getPf2().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[680]);
        pescaniFilteri.getPf2().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[681]);
        pescaniFilteri.getPf2().getVent08().getVrednostiReg().setOtvoren(resultVentili[682]);
        pescaniFilteri.getPf2().getVent08().getVrednostiReg().setZatvoren(resultVentili[683]);

        pescaniFilteri.getPf2().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[690]);
        pescaniFilteri.getPf2().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[691]);
        pescaniFilteri.getPf2().getVent09().getVrednostiReg().setOtvoren(resultVentili[692]);
        pescaniFilteri.getPf2().getVent09().getVrednostiReg().setZatvoren(resultVentili[693]);

        pescaniFilteri.getPf2().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[700]);
        pescaniFilteri.getPf2().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[701]);
        pescaniFilteri.getPf2().getVent10().getVrednostiReg().setOtvoren(resultVentili[702]);
        pescaniFilteri.getPf2().getVent10().getVrednostiReg().setZatvoren(resultVentili[703]);
    }

    private void getPescaniFilter3() {

        pescaniFilteri.getPf3().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[720]);
        pescaniFilteri.getPf3().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[721]);
        pescaniFilteri.getPf3().getVent03().getVrednostiReg().setOtvoren(resultVentili[722]);
        pescaniFilteri.getPf3().getVent03().getVrednostiReg().setZatvoren(resultVentili[723]);

        pescaniFilteri.getPf3().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[730]);
        pescaniFilteri.getPf3().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[731]);
        pescaniFilteri.getPf3().getVent04().getVrednostiReg().setOtvoren(resultVentili[732]);
        pescaniFilteri.getPf3().getVent04().getVrednostiReg().setZatvoren(resultVentili[733]);

        pescaniFilteri.getPf3().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[740]);
        pescaniFilteri.getPf3().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[741]);
        pescaniFilteri.getPf3().getVent05().getVrednostiReg().setOtvoren(resultVentili[742]);
        pescaniFilteri.getPf3().getVent05().getVrednostiReg().setZatvoren(resultVentili[743]);

        pescaniFilteri.getPf3().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[750]);
        pescaniFilteri.getPf3().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[751]);
        pescaniFilteri.getPf3().getVent06().getVrednostiReg().setOtvoren(resultVentili[752]);
        pescaniFilteri.getPf3().getVent06().getVrednostiReg().setZatvoren(resultVentili[753]);

        pescaniFilteri.getPf3().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[760]);
        pescaniFilteri.getPf3().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[761]);
        pescaniFilteri.getPf3().getVent07().getVrednostiReg().setOtvoren(resultVentili[762]);
        pescaniFilteri.getPf3().getVent07().getVrednostiReg().setZatvoren(resultVentili[763]);

        pescaniFilteri.getPf3().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[770]);
        pescaniFilteri.getPf3().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[771]);
        pescaniFilteri.getPf3().getVent08().getVrednostiReg().setOtvoren(resultVentili[772]);
        pescaniFilteri.getPf3().getVent08().getVrednostiReg().setZatvoren(resultVentili[773]);

        pescaniFilteri.getPf3().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[780]);
        pescaniFilteri.getPf3().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[781]);
        pescaniFilteri.getPf3().getVent09().getVrednostiReg().setOtvoren(resultVentili[782]);
        pescaniFilteri.getPf3().getVent09().getVrednostiReg().setZatvoren(resultVentili[783]);

        pescaniFilteri.getPf3().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[790]);
        pescaniFilteri.getPf3().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[791]);
        pescaniFilteri.getPf3().getVent10().getVrednostiReg().setOtvoren(resultVentili[792]);
        pescaniFilteri.getPf3().getVent10().getVrednostiReg().setZatvoren(resultVentili[793]);
    }

    private void getPescaniFilter4() {

        pescaniFilteri.getPf4().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[810]);
        pescaniFilteri.getPf4().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[811]);
        pescaniFilteri.getPf4().getVent03().getVrednostiReg().setOtvoren(resultVentili[812]);
        pescaniFilteri.getPf4().getVent03().getVrednostiReg().setZatvoren(resultVentili[813]);

        pescaniFilteri.getPf4().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[820]);
        pescaniFilteri.getPf4().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[821]);
        pescaniFilteri.getPf4().getVent04().getVrednostiReg().setOtvoren(resultVentili[822]);
        pescaniFilteri.getPf4().getVent04().getVrednostiReg().setZatvoren(resultVentili[823]);

        pescaniFilteri.getPf4().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[830]);
        pescaniFilteri.getPf4().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[831]);
        pescaniFilteri.getPf4().getVent05().getVrednostiReg().setOtvoren(resultVentili[832]);
        pescaniFilteri.getPf4().getVent05().getVrednostiReg().setZatvoren(resultVentili[833]);

        pescaniFilteri.getPf4().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[840]);
        pescaniFilteri.getPf4().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[841]);
        pescaniFilteri.getPf4().getVent06().getVrednostiReg().setOtvoren(resultVentili[842]);
        pescaniFilteri.getPf4().getVent06().getVrednostiReg().setZatvoren(resultVentili[843]);

        pescaniFilteri.getPf4().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[850]);
        pescaniFilteri.getPf4().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[851]);
        pescaniFilteri.getPf4().getVent07().getVrednostiReg().setOtvoren(resultVentili[852]);
        pescaniFilteri.getPf4().getVent07().getVrednostiReg().setZatvoren(resultVentili[853]);

        pescaniFilteri.getPf4().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[860]);
        pescaniFilteri.getPf4().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[861]);
        pescaniFilteri.getPf4().getVent08().getVrednostiReg().setOtvoren(resultVentili[862]);
        pescaniFilteri.getPf4().getVent08().getVrednostiReg().setZatvoren(resultVentili[863]);

        pescaniFilteri.getPf4().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[870]);
        pescaniFilteri.getPf4().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[871]);
        pescaniFilteri.getPf4().getVent09().getVrednostiReg().setOtvoren(resultVentili[872]);
        pescaniFilteri.getPf4().getVent09().getVrednostiReg().setZatvoren(resultVentili[873]);

        pescaniFilteri.getPf4().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[880]);
        pescaniFilteri.getPf4().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[881]);
        pescaniFilteri.getPf4().getVent10().getVrednostiReg().setOtvoren(resultVentili[882]);
        pescaniFilteri.getPf4().getVent10().getVrednostiReg().setZatvoren(resultVentili[883]);
    }

    private void getPescaniFilter5() {

        pescaniFilteri.getPf5().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[900]);
        pescaniFilteri.getPf5().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[901]);
        pescaniFilteri.getPf5().getVent03().getVrednostiReg().setOtvoren(resultVentili[902]);
        pescaniFilteri.getPf5().getVent03().getVrednostiReg().setZatvoren(resultVentili[903]);

        pescaniFilteri.getPf5().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[910]);
        pescaniFilteri.getPf5().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[911]);
        pescaniFilteri.getPf5().getVent04().getVrednostiReg().setOtvoren(resultVentili[912]);
        pescaniFilteri.getPf5().getVent04().getVrednostiReg().setZatvoren(resultVentili[913]);

        pescaniFilteri.getPf5().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[920]);
        pescaniFilteri.getPf5().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[921]);
        pescaniFilteri.getPf5().getVent05().getVrednostiReg().setOtvoren(resultVentili[922]);
        pescaniFilteri.getPf5().getVent05().getVrednostiReg().setZatvoren(resultVentili[923]);

        pescaniFilteri.getPf5().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[930]);
        pescaniFilteri.getPf5().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[931]);
        pescaniFilteri.getPf5().getVent06().getVrednostiReg().setOtvoren(resultVentili[932]);
        pescaniFilteri.getPf5().getVent06().getVrednostiReg().setZatvoren(resultVentili[933]);

        pescaniFilteri.getPf5().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[940]);
        pescaniFilteri.getPf5().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[941]);
        pescaniFilteri.getPf5().getVent07().getVrednostiReg().setOtvoren(resultVentili[942]);
        pescaniFilteri.getPf5().getVent07().getVrednostiReg().setZatvoren(resultVentili[943]);

        pescaniFilteri.getPf5().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[950]);
        pescaniFilteri.getPf5().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[951]);
        pescaniFilteri.getPf5().getVent08().getVrednostiReg().setOtvoren(resultVentili[952]);
        pescaniFilteri.getPf5().getVent08().getVrednostiReg().setZatvoren(resultVentili[953]);

        pescaniFilteri.getPf5().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[960]);
        pescaniFilteri.getPf5().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[961]);
        pescaniFilteri.getPf5().getVent09().getVrednostiReg().setOtvoren(resultVentili[962]);
        pescaniFilteri.getPf5().getVent09().getVrednostiReg().setZatvoren(resultVentili[963]);

        pescaniFilteri.getPf5().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[970]);
        pescaniFilteri.getPf5().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[971]);
        pescaniFilteri.getPf5().getVent10().getVrednostiReg().setOtvoren(resultVentili[972]);
        pescaniFilteri.getPf5().getVent10().getVrednostiReg().setZatvoren(resultVentili[973]);
    }

    private void getPescaniFilter6() {

        pescaniFilteri.getPf6().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[990]);
        pescaniFilteri.getPf6().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[991]);
        pescaniFilteri.getPf6().getVent03().getVrednostiReg().setOtvoren(resultVentili[992]);
        pescaniFilteri.getPf6().getVent03().getVrednostiReg().setZatvoren(resultVentili[993]);

        pescaniFilteri.getPf6().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[1000]);
        pescaniFilteri.getPf6().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[1001]);
        pescaniFilteri.getPf6().getVent04().getVrednostiReg().setOtvoren(resultVentili[1002]);
        pescaniFilteri.getPf6().getVent04().getVrednostiReg().setZatvoren(resultVentili[1003]);

        pescaniFilteri.getPf6().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[1010]);
        pescaniFilteri.getPf6().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[1011]);
        pescaniFilteri.getPf6().getVent05().getVrednostiReg().setOtvoren(resultVentili[1012]);
        pescaniFilteri.getPf6().getVent05().getVrednostiReg().setZatvoren(resultVentili[1013]);

        pescaniFilteri.getPf6().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[1020]);
        pescaniFilteri.getPf6().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[1021]);
        pescaniFilteri.getPf6().getVent06().getVrednostiReg().setOtvoren(resultVentili[1022]);
        pescaniFilteri.getPf6().getVent06().getVrednostiReg().setZatvoren(resultVentili[1023]);

        pescaniFilteri.getPf6().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[1030]);
        pescaniFilteri.getPf6().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[1031]);
        pescaniFilteri.getPf6().getVent07().getVrednostiReg().setOtvoren(resultVentili[1032]);
        pescaniFilteri.getPf6().getVent07().getVrednostiReg().setZatvoren(resultVentili[1033]);

        pescaniFilteri.getPf6().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[1040]);
        pescaniFilteri.getPf6().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[1041]);
        pescaniFilteri.getPf6().getVent08().getVrednostiReg().setOtvoren(resultVentili[1042]);
        pescaniFilteri.getPf6().getVent08().getVrednostiReg().setZatvoren(resultVentili[1043]);

        pescaniFilteri.getPf6().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[1050]);
        pescaniFilteri.getPf6().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[1051]);
        pescaniFilteri.getPf6().getVent09().getVrednostiReg().setOtvoren(resultVentili[1052]);
        pescaniFilteri.getPf6().getVent09().getVrednostiReg().setZatvoren(resultVentili[1053]);

        pescaniFilteri.getPf6().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[1060]);
        pescaniFilteri.getPf6().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[1061]);
        pescaniFilteri.getPf6().getVent10().getVrednostiReg().setOtvoren(resultVentili[1062]);
        pescaniFilteri.getPf6().getVent10().getVrednostiReg().setZatvoren(resultVentili[1063]);
    }

    private void getOtpadneVodeOdPescanihFiltera() {
        otpadneVodeOdPescanihFiltera.getVent01().getVrednostiReg().setEnableOtvori(resultVentili[1070]);
        otpadneVodeOdPescanihFiltera.getVent01().getVrednostiReg().setEnableZatvori(resultVentili[1071]);
        otpadneVodeOdPescanihFiltera.getVent01().getVrednostiReg().setOtvoren(resultVentili[1072]);
        otpadneVodeOdPescanihFiltera.getVent01().getVrednostiReg().setZatvoren(resultVentili[1073]);

        otpadneVodeOdPescanihFiltera.getVent02().getVrednostiReg().setEnableOtvori(resultVentili[1080]);
        otpadneVodeOdPescanihFiltera.getVent02().getVrednostiReg().setEnableZatvori(resultVentili[1081]);
        otpadneVodeOdPescanihFiltera.getVent02().getVrednostiReg().setOtvoren(resultVentili[1082]);
        otpadneVodeOdPescanihFiltera.getVent02().getVrednostiReg().setZatvoren(resultVentili[1083]);
    }
    
    
     

    private void getJonskaIzmena1() {

        jonskaIzmena.getJonskaIzmena01().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[1400]);
        jonskaIzmena.getJonskaIzmena01().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[1401]);
        jonskaIzmena.getJonskaIzmena01().getVent03().getVrednostiReg().setOtvoren(resultVentili[1402]);
        jonskaIzmena.getJonskaIzmena01().getVent03().getVrednostiReg().setZatvoren(resultVentili[1403]);

        jonskaIzmena.getJonskaIzmena01().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[1410]);
        jonskaIzmena.getJonskaIzmena01().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[1411]);
        jonskaIzmena.getJonskaIzmena01().getVent04().getVrednostiReg().setOtvoren(resultVentili[1412]);
        jonskaIzmena.getJonskaIzmena01().getVent04().getVrednostiReg().setZatvoren(resultVentili[1413]);

        jonskaIzmena.getJonskaIzmena01().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[1420]);
        jonskaIzmena.getJonskaIzmena01().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[1421]);
        jonskaIzmena.getJonskaIzmena01().getVent05().getVrednostiReg().setOtvoren(resultVentili[1422]);
        jonskaIzmena.getJonskaIzmena01().getVent05().getVrednostiReg().setZatvoren(resultVentili[1423]);

        jonskaIzmena.getJonskaIzmena01().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[1430]);
        jonskaIzmena.getJonskaIzmena01().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[1431]);
        jonskaIzmena.getJonskaIzmena01().getVent06().getVrednostiReg().setOtvoren(resultVentili[1432]);
        jonskaIzmena.getJonskaIzmena01().getVent06().getVrednostiReg().setZatvoren(resultVentili[1433]);

        jonskaIzmena.getJonskaIzmena01().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[1440]);
        jonskaIzmena.getJonskaIzmena01().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[1441]);
        jonskaIzmena.getJonskaIzmena01().getVent07().getVrednostiReg().setOtvoren(resultVentili[1442]);
        jonskaIzmena.getJonskaIzmena01().getVent07().getVrednostiReg().setZatvoren(resultVentili[1443]);

        jonskaIzmena.getJonskaIzmena01().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[1450]);
        jonskaIzmena.getJonskaIzmena01().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[1451]);
        jonskaIzmena.getJonskaIzmena01().getVent08().getVrednostiReg().setOtvoren(resultVentili[1452]);
        jonskaIzmena.getJonskaIzmena01().getVent08().getVrednostiReg().setZatvoren(resultVentili[1453]);

        jonskaIzmena.getJonskaIzmena01().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[1460]);
        jonskaIzmena.getJonskaIzmena01().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[1461]);
        jonskaIzmena.getJonskaIzmena01().getVent09().getVrednostiReg().setOtvoren(resultVentili[1462]);
        jonskaIzmena.getJonskaIzmena01().getVent09().getVrednostiReg().setZatvoren(resultVentili[1463]);

        jonskaIzmena.getJonskaIzmena01().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[1470]);
        jonskaIzmena.getJonskaIzmena01().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[1471]);
        jonskaIzmena.getJonskaIzmena01().getVent10().getVrednostiReg().setOtvoren(resultVentili[1472]);
        jonskaIzmena.getJonskaIzmena01().getVent10().getVrednostiReg().setZatvoren(resultVentili[1473]);

    }

    private void getJonskaIzmena2() {

        jonskaIzmena.getJonskaIzmena02().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[1490]);
        jonskaIzmena.getJonskaIzmena02().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[1491]);
        jonskaIzmena.getJonskaIzmena02().getVent03().getVrednostiReg().setOtvoren(resultVentili[1492]);
        jonskaIzmena.getJonskaIzmena02().getVent03().getVrednostiReg().setZatvoren(resultVentili[1493]);

        jonskaIzmena.getJonskaIzmena02().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[1500]);
        jonskaIzmena.getJonskaIzmena02().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[1501]);
        jonskaIzmena.getJonskaIzmena02().getVent04().getVrednostiReg().setOtvoren(resultVentili[1502]);
        jonskaIzmena.getJonskaIzmena02().getVent04().getVrednostiReg().setZatvoren(resultVentili[1503]);

        jonskaIzmena.getJonskaIzmena02().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[1510]);
        jonskaIzmena.getJonskaIzmena02().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[1511]);
        jonskaIzmena.getJonskaIzmena02().getVent05().getVrednostiReg().setOtvoren(resultVentili[1512]);
        jonskaIzmena.getJonskaIzmena02().getVent05().getVrednostiReg().setZatvoren(resultVentili[1513]);

        jonskaIzmena.getJonskaIzmena02().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[1520]);
        jonskaIzmena.getJonskaIzmena02().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[1521]);
        jonskaIzmena.getJonskaIzmena02().getVent06().getVrednostiReg().setOtvoren(resultVentili[1522]);
        jonskaIzmena.getJonskaIzmena02().getVent06().getVrednostiReg().setZatvoren(resultVentili[1523]);

        jonskaIzmena.getJonskaIzmena02().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[1530]);
        jonskaIzmena.getJonskaIzmena02().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[1531]);
        jonskaIzmena.getJonskaIzmena02().getVent07().getVrednostiReg().setOtvoren(resultVentili[1532]);
        jonskaIzmena.getJonskaIzmena02().getVent07().getVrednostiReg().setZatvoren(resultVentili[1533]);

        jonskaIzmena.getJonskaIzmena02().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[1540]);
        jonskaIzmena.getJonskaIzmena02().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[1541]);
        jonskaIzmena.getJonskaIzmena02().getVent08().getVrednostiReg().setOtvoren(resultVentili[1542]);
        jonskaIzmena.getJonskaIzmena02().getVent08().getVrednostiReg().setZatvoren(resultVentili[1543]);

        jonskaIzmena.getJonskaIzmena02().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[1550]);
        jonskaIzmena.getJonskaIzmena02().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[1551]);
        jonskaIzmena.getJonskaIzmena02().getVent09().getVrednostiReg().setOtvoren(resultVentili[1552]);
        jonskaIzmena.getJonskaIzmena02().getVent09().getVrednostiReg().setZatvoren(resultVentili[1553]);

        jonskaIzmena.getJonskaIzmena02().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[1560]);
        jonskaIzmena.getJonskaIzmena02().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[1561]);
        jonskaIzmena.getJonskaIzmena02().getVent10().getVrednostiReg().setOtvoren(resultVentili[1562]);
        jonskaIzmena.getJonskaIzmena02().getVent10().getVrednostiReg().setZatvoren(resultVentili[1563]);
    }

    private void getJonskaIzmena3() {

        jonskaIzmena.getJonskaIzmena03().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[1580]);
        jonskaIzmena.getJonskaIzmena03().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[1581]);
        jonskaIzmena.getJonskaIzmena03().getVent03().getVrednostiReg().setOtvoren(resultVentili[1582]);
        jonskaIzmena.getJonskaIzmena03().getVent03().getVrednostiReg().setZatvoren(resultVentili[1583]);

        jonskaIzmena.getJonskaIzmena03().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[1590]);
        jonskaIzmena.getJonskaIzmena03().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[1591]);
        jonskaIzmena.getJonskaIzmena03().getVent04().getVrednostiReg().setOtvoren(resultVentili[1592]);
        jonskaIzmena.getJonskaIzmena03().getVent04().getVrednostiReg().setZatvoren(resultVentili[1593]);

        jonskaIzmena.getJonskaIzmena03().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[1600]);
        jonskaIzmena.getJonskaIzmena03().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[1601]);
        jonskaIzmena.getJonskaIzmena03().getVent05().getVrednostiReg().setOtvoren(resultVentili[1602]);
        jonskaIzmena.getJonskaIzmena03().getVent05().getVrednostiReg().setZatvoren(resultVentili[1603]);

        jonskaIzmena.getJonskaIzmena03().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[1610]);
        jonskaIzmena.getJonskaIzmena03().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[1611]);
        jonskaIzmena.getJonskaIzmena03().getVent06().getVrednostiReg().setOtvoren(resultVentili[1612]);
        jonskaIzmena.getJonskaIzmena03().getVent06().getVrednostiReg().setZatvoren(resultVentili[1613]);

        jonskaIzmena.getJonskaIzmena03().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[1620]);
        jonskaIzmena.getJonskaIzmena03().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[1621]);
        jonskaIzmena.getJonskaIzmena03().getVent07().getVrednostiReg().setOtvoren(resultVentili[1622]);
        jonskaIzmena.getJonskaIzmena03().getVent07().getVrednostiReg().setZatvoren(resultVentili[1623]);

        jonskaIzmena.getJonskaIzmena03().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[1630]);
        jonskaIzmena.getJonskaIzmena03().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[1631]);
        jonskaIzmena.getJonskaIzmena03().getVent08().getVrednostiReg().setOtvoren(resultVentili[1632]);
        jonskaIzmena.getJonskaIzmena03().getVent08().getVrednostiReg().setZatvoren(resultVentili[1633]);

        jonskaIzmena.getJonskaIzmena03().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[1640]);
        jonskaIzmena.getJonskaIzmena03().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[1641]);
        jonskaIzmena.getJonskaIzmena03().getVent09().getVrednostiReg().setOtvoren(resultVentili[1642]);
        jonskaIzmena.getJonskaIzmena03().getVent09().getVrednostiReg().setZatvoren(resultVentili[1643]);

        jonskaIzmena.getJonskaIzmena03().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[1650]);
        jonskaIzmena.getJonskaIzmena03().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[1651]);
        jonskaIzmena.getJonskaIzmena03().getVent10().getVrednostiReg().setOtvoren(resultVentili[1652]);
        jonskaIzmena.getJonskaIzmena03().getVent10().getVrednostiReg().setZatvoren(resultVentili[1653]);
    }

    private void getProtociDemiLinije() {

        int offsetRead = protociDemiLinije.getProtokDL1in().getProtok().getAdresaRegistra();  //D168 je nulti
        resMerenja0 = mxm.readRegisters(offsetRead, 100);
        resMerenja1 = mxm.readRegisters(offsetRead + 100, 100);
        resMerenja2 = mxm.readRegisters(offsetRead + 200, 100);

        protociDemiLinije.getProtokDL1in().getProtok().setVrednostRegistra(resMerenja0[0]);
        protociDemiLinije.getProtokDL2in().getProtok().setVrednostRegistra(resMerenja0[1]);
        protociDemiLinije.getProtokDL3in().getProtok().setVrednostRegistra(resMerenja0[2]);
        protociDemiLinije.getProtokDL1out().getProtok().setVrednostRegistra(resMerenja0[3]);
        protociDemiLinije.getProtokDL2out().getProtok().setVrednostRegistra(resMerenja0[4]);
        protociDemiLinije.getProtokDL3out().getProtok().setVrednostRegistra(resMerenja1[70]);
        
        
        protociDemiLinije.getProtokDL1in().setKumulativnoNiziVrednost(resMerenja2[54]);
        protociDemiLinije.getProtokDL1in().setKumulativnoVisiVrednost(resMerenja2[55]);        
        protociDemiLinije.getProtokDL2in().setKumulativnoNiziVrednost(resMerenja2[56]);
        protociDemiLinije.getProtokDL2in().setKumulativnoVisiVrednost(resMerenja2[57]);
        protociDemiLinije.getProtokDL3in().setKumulativnoNiziVrednost(resMerenja2[58]);
        protociDemiLinije.getProtokDL3in().setKumulativnoVisiVrednost(resMerenja2[59]);

        protociDemiLinije.getProtokDL1out().setKumulativnoNiziVrednost(resMerenja2[64]);
        protociDemiLinije.getProtokDL1out().setKumulativnoVisiVrednost(resMerenja2[65]);
        protociDemiLinije.getProtokDL2out().setKumulativnoNiziVrednost(resMerenja2[66]);
        protociDemiLinije.getProtokDL2out().setKumulativnoVisiVrednost(resMerenja2[67]);
        protociDemiLinije.getProtokDL3out().setKumulativnoNiziVrednost(resMerenja2[68]);
        protociDemiLinije.getProtokDL3out().setKumulativnoVisiVrednost(resMerenja2[69]);

        protociDemiLinije.getProtokMagistralniVod().getProtok().setVrednostRegistra(resMerenja1[71]);
        protociDemiLinije.getProtokMagistralniVod().setKumulativnoNiziVrednost(resMerenja2[70]);
        protociDemiLinije.getProtokMagistralniVod().setKumulativnoVisiVrednost(resMerenja2[71]);

        demiLinije.getJkkf01().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[52]);
        demiLinije.getJkkf02().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[53]);
        demiLinije.getJkkf03().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[54]);

    }
    
    private void getReaktor(){
        reaktor.getUlazSirVodeR1().getVrednosti().setEnableOtvori(resultVentili[1290]);
        reaktor.getUlazSirVodeR1().getVrednosti().setEnableZatvori(resultVentili[1291]);
        reaktor.getUlazSirVodeR1().getVrednosti().setOtvoren(resultVentili[1292]);
        reaktor.getUlazSirVodeR1().getVrednosti().setZatvoren(resultVentili[1293]);
        
        reaktor.getUlazSirVodeR1().getVrednosti().setPolozajVrednost(resMerenja1[42]);
    }

    private void getProtociPretovarnaRampa() {
        protociPretovarnaRampa.getProtokLuzine().getProtok().setVrednostRegistra(resMerenja0[30]);
        protociPretovarnaRampa.getProtokKiseline().getProtok().setVrednostRegistra(resMerenja0[31]);

        protociPretovarnaRampa.getProtokLuzine().setKumulativnoNiziVrednost(resMerenja2[72]);
        protociPretovarnaRampa.getProtokLuzine().setKumulativnoVisiVrednost(resMerenja2[73]);

        protociPretovarnaRampa.getProtokKiseline().setKumulativnoNiziVrednost(resMerenja2[74]);
        protociPretovarnaRampa.getProtokKiseline().setKumulativnoVisiVrednost(resMerenja2[75]);
    }
    
    private void getProtociRegenracija(){
        protociRegeneracija.getProtokDemiVodeRazblazivanjeHCL().getProtok().setVrednostRegistra(resMerenja1[22]);
        protociRegeneracija.getProtokDemiVodeRazblazivanjeNaOH().getProtok().setVrednostRegistra(resMerenja1[23]);
        protociRegeneracija.getProtokNaOHRegeneracija().getProtok().setVrednostRegistra(resMerenja1[24]);
        protociRegeneracija.getProtokHClPotisDozirPumpi().getProtok().setVrednostRegistra(resMerenja0[21]);
    }

    private void getRezervoariMerenja() {
        rezervoariMerenja.getNivoRezervoarDEMIvode1000m3br1().setVrednostRegistra(resMerenja0[24]);
        rezervoariMerenja.getNivoRezervoarDEMIvode1000m3br2().setVrednostRegistra(resMerenja0[25]);
        rezervoariMerenja.getNivoRezervoarKompenzacioni500m3().setVrednostRegistra(resMerenja0[26]);
        rezervoariMerenja.getNivoRezervoarDEMIvode150m3().setVrednostRegistra(resMerenja0[59]);
    }

    private void getProtociPescaniFilteri() {

        protociPescaniFilteri.getProtokPF1().getProtok().setVrednostRegistra(resMerenja0[66]);
        protociPescaniFilteri.getProtokPF2().getProtok().setVrednostRegistra(resMerenja0[67]);
        protociPescaniFilteri.getProtokPF3().getProtok().setVrednostRegistra(resMerenja0[68]);
        protociPescaniFilteri.getProtokPF4().getProtok().setVrednostRegistra(resMerenja0[69]);
        protociPescaniFilteri.getProtokPF5().getProtok().setVrednostRegistra(resMerenja0[70]);
        protociPescaniFilteri.getProtokPF6().getProtok().setVrednostRegistra(resMerenja0[71]);

        protociPescaniFilteri.getProtokPF1().setKumulativnoNiziVrednost(resMerenja2[42]);
        protociPescaniFilteri.getProtokPF1().setKumulativnoVisiVrednost(resMerenja2[43]);
        protociPescaniFilteri.getProtokPF2().setKumulativnoNiziVrednost(resMerenja2[44]);
        protociPescaniFilteri.getProtokPF2().setKumulativnoVisiVrednost(resMerenja2[45]);
        protociPescaniFilteri.getProtokPF3().setKumulativnoNiziVrednost(resMerenja2[46]);
        protociPescaniFilteri.getProtokPF3().setKumulativnoVisiVrednost(resMerenja2[47]);
        protociPescaniFilteri.getProtokPF4().setKumulativnoNiziVrednost(resMerenja2[48]);
        protociPescaniFilteri.getProtokPF4().setKumulativnoVisiVrednost(resMerenja2[49]);
        protociPescaniFilteri.getProtokPF5().setKumulativnoNiziVrednost(resMerenja2[50]);
        protociPescaniFilteri.getProtokPF5().setKumulativnoVisiVrednost(resMerenja2[51]);
        protociPescaniFilteri.getProtokPF6().setKumulativnoNiziVrednost(resMerenja2[52]);
        protociPescaniFilteri.getProtokPF6().setKumulativnoVisiVrednost(resMerenja2[53]);

        pescaniFilteri.getPf1().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[55]);
        pescaniFilteri.getPf2().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[56]);
        pescaniFilteri.getPf3().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[57]);
        pescaniFilteri.getPf4().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[58]);
        pescaniFilteri.getPf5().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[59]);
        pescaniFilteri.getPf6().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[60]);

    }

    private void getProtociNeutralna() {

        protociNeutralna.getProtokNJ1().getProtok().setVrednostRegistra(resMerenja0[76]);
        protociNeutralna.getProtokNJ2().getProtok().setVrednostRegistra(resMerenja0[77]);
        protociNeutralna.getProtokNJ3().getProtok().setVrednostRegistra(resMerenja0[78]);

        protociNeutralna.getProtokNJ1().setKumulativnoNiziVrednost(resMerenja2[32]);
        protociNeutralna.getProtokNJ1().setKumulativnoVisiVrednost(resMerenja2[33]);
        protociNeutralna.getProtokNJ2().setKumulativnoNiziVrednost(resMerenja2[34]);
        protociNeutralna.getProtokNJ2().setKumulativnoVisiVrednost(resMerenja2[35]);
        protociNeutralna.getProtokNJ3().setKumulativnoNiziVrednost(resMerenja2[36]);
        protociNeutralna.getProtokNJ3().setKumulativnoVisiVrednost(resMerenja2[37]);

        jonskaIzmena.getJonskaIzmena01().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[62]);

        jonskaIzmena.getJonskaIzmena02().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[63]);

        jonskaIzmena.getJonskaIzmena03().getRegVent01().getVrednosti().setPolozajVrednost(resMerenja1[64]);

    }

    private void getProtociFlokulacija() {

        protociFlokulacija.getProtokSiroveVodeR1().getProtok().setVrednostRegistra(resMerenja0[64]);
        protociFlokulacija.getProtokSiroveVodeR2().getProtok().setVrednostRegistra(resMerenja0[65]);

        protociFlokulacija.getProtokSiroveVodeR1().setKumulativnoNiziVrednost(resMerenja2[38]);
        protociFlokulacija.getProtokSiroveVodeR1().setKumulativnoVisiVrednost(resMerenja2[39]);
        protociFlokulacija.getProtokSiroveVodeR2().setKumulativnoNiziVrednost(resMerenja2[40]);
        protociFlokulacija.getProtokSiroveVodeR2().setKumulativnoVisiVrednost(resMerenja2[41]);

    }

    private void getDemiLinijeMerenja() {
        
        demiLinijeMerenja.getDemiLinija01().getVodljivostJBA().setVrednostRegistra(resMerenja0[5]);
        demiLinijeMerenja.getDemiLinija01().getVodljivostSBA().setVrednostRegistra(resMerenja1[28]);
        demiLinijeMerenja.getDemiLinija01().getVodljivostMF().setVrednostRegistra(resMerenja1[29]);

        demiLinijeMerenja.getDemiLinija01().getPritisakDLjkkfIn().setVrednostRegistra(resMerenja0[32]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLjkkfOut().setVrednostRegistra(resMerenja0[33]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLsbafIn().setVrednostRegistra(resMerenja0[34]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLsbafOut().setVrednostRegistra(resMerenja0[35]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLjbafIn().setVrednostRegistra(resMerenja0[36]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLjbafOut().setVrednostRegistra(resMerenja0[37]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLmfIn().setVrednostRegistra(resMerenja0[38]);
        demiLinijeMerenja.getDemiLinija01().getPritisakDLmfOut().setVrednostRegistra(resMerenja0[39]);
        
        demiLinijeMerenja.getDemiLinija02().getVodljivostJBA().setVrednostRegistra(resMerenja0[6]);
        demiLinijeMerenja.getDemiLinija02().getVodljivostSBA().setVrednostRegistra(resMerenja1[30]);
        demiLinijeMerenja.getDemiLinija02().getVodljivostMF().setVrednostRegistra(resMerenja1[31]);
        

        demiLinijeMerenja.getDemiLinija02().getPritisakDLjkkfIn().setVrednostRegistra(resMerenja0[40]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLjkkfOut().setVrednostRegistra(resMerenja0[41]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLsbafIn().setVrednostRegistra(resMerenja0[42]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLsbafOut().setVrednostRegistra(resMerenja0[43]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLjbafIn().setVrednostRegistra(resMerenja0[44]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLjbafOut().setVrednostRegistra(resMerenja0[45]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLmfIn().setVrednostRegistra(resMerenja0[46]);
        demiLinijeMerenja.getDemiLinija02().getPritisakDLmfOut().setVrednostRegistra(resMerenja0[47]);
        
        demiLinijeMerenja.getDemiLinija03().getVodljivostJBA().setVrednostRegistra(resMerenja0[7]);
        demiLinijeMerenja.getDemiLinija03().getVodljivostSBA().setVrednostRegistra(resMerenja1[32]);
        demiLinijeMerenja.getDemiLinija03().getVodljivostMF().setVrednostRegistra(resMerenja1[33]);

        demiLinijeMerenja.getDemiLinija03().getPritisakDLjkkfIn().setVrednostRegistra(resMerenja0[48]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLjkkfOut().setVrednostRegistra(resMerenja0[49]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLsbafIn().setVrednostRegistra(resMerenja0[50]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLsbafOut().setVrednostRegistra(resMerenja0[51]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLjbafIn().setVrednostRegistra(resMerenja0[52]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLjbafOut().setVrednostRegistra(resMerenja0[53]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLmfIn().setVrednostRegistra(resMerenja0[54]);
        demiLinijeMerenja.getDemiLinija03().getPritisakDLmfOut().setVrednostRegistra(resMerenja0[55]);
        
        
        demiLinijeMerenja.getVodljivostKolektor().setVrednostRegistra(resMerenja0[8]);
    }

    private void getPescaniFilteriMerenja() {

        pfMerenja.getPfMerenja().getPritisakInPF1().setVrednostRegistra(resMerenja0[80]);
        pfMerenja.getPfMerenja().getPritisakInPF2().setVrednostRegistra(resMerenja0[81]);
        pfMerenja.getPfMerenja().getPritisakInPF3().setVrednostRegistra(resMerenja0[82]);
        pfMerenja.getPfMerenja().getPritisakInPF4().setVrednostRegistra(resMerenja0[83]);
        pfMerenja.getPfMerenja().getPritisakInPF5().setVrednostRegistra(resMerenja0[84]);
        pfMerenja.getPfMerenja().getPritisakInPF6().setVrednostRegistra(resMerenja0[85]);

        pfMerenja.getPfMerenja().getPritisakOutPF1().setVrednostRegistra(resMerenja0[86]);
        pfMerenja.getPfMerenja().getPritisakOutPF2().setVrednostRegistra(resMerenja0[87]);
        pfMerenja.getPfMerenja().getPritisakOutPF3().setVrednostRegistra(resMerenja0[88]);
        pfMerenja.getPfMerenja().getPritisakOutPF4().setVrednostRegistra(resMerenja0[89]);
        pfMerenja.getPfMerenja().getPritisakOutPF5().setVrednostRegistra(resMerenja0[90]);
        pfMerenja.getPfMerenja().getPritisakOutPF6().setVrednostRegistra(resMerenja0[91]);

    }

    private void getNeutralnaJonskaMerenja() {
        njMerenja.getNjMerenjaL1().getPritisakInNJ().setVrednostRegistra(resMerenja1[14]);
        njMerenja.getNjMerenjaL2().getPritisakInNJ().setVrednostRegistra(resMerenja1[15]);
        njMerenja.getNjMerenjaL3().getPritisakInNJ().setVrednostRegistra(resMerenja1[16]);
        njMerenja.getNjMerenjaL1().getPritisakOutNJ().setVrednostRegistra(resMerenja1[17]);
        njMerenja.getNjMerenjaL2().getPritisakOutNJ().setVrednostRegistra(resMerenja1[18]);
        njMerenja.getNjMerenjaL3().getPritisakOutNJ().setVrednostRegistra(resMerenja1[19]);
        
        protociNeutralna.getMagistralniVod().setKumulativnoNiziVrednost(resMerenja2[60]);       
        protociNeutralna.getMagistralniVod().setKumulativnoVisiVrednost(resMerenja2[61]);
        
        protociNeutralna.getMagistralniVod().getProtok().setVrednostRegistra(resMerenja0[79]);
       
    }

    private void getBazeniMerenja() {
        nivoiMerenja.getBazenNeutralizacioni().setVrednostRegistra(resMerenja0[60]);
        nivoiMerenja.getBazenNeutralizacioni().setVrednostProradeZastite(resMerenja2[96]);
        nivoiMerenja.getBazenDekaNefiltriraneVode().setVrednostRegistra(resMerenja0[61]);
        nivoiMerenja.getBazenDekaFiltriraneVode().setVrednostRegistra(resMerenja0[62]);
        nivoiMerenja.getBazenOtpadneVodeOdPranjaPescanihFiltera().setVrednostRegistra(resMerenja0[63]);
    }

    private void getTemperature(){
        temperature.getTempLuzineRezervoar13a03().setVrednostRegistra(resMerenja1[20]);
        temperature.getTempDemiVodeRezervoar150m3().setVrednostRegistra(resMerenja1[21]);
    }
    
    private void getDemiLinija1JKKF() {

        resultVentili = mxm.readMX(demiLinijeJkkf01Vent03, 1250);       //enableOtvori, enableZatvori, otvoren, zatvoren
        demiLinije.getJkkf01().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[0]);
        demiLinije.getJkkf01().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[1]);
        demiLinije.getJkkf01().getVent03().getVrednostiReg().setOtvoren(resultVentili[2]);
        demiLinije.getJkkf01().getVent03().getVrednostiReg().setZatvoren(resultVentili[3]);

        demiLinije.getJkkf01().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[10]);
        demiLinije.getJkkf01().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[11]);
        demiLinije.getJkkf01().getVent04().getVrednostiReg().setOtvoren(resultVentili[12]);
        demiLinije.getJkkf01().getVent04().getVrednostiReg().setZatvoren(resultVentili[13]);

        demiLinije.getJkkf01().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[20]);
        demiLinije.getJkkf01().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[21]);
        demiLinije.getJkkf01().getVent05().getVrednostiReg().setOtvoren(resultVentili[22]);
        demiLinije.getJkkf01().getVent05().getVrednostiReg().setZatvoren(resultVentili[23]);

        demiLinije.getJkkf01().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[30]);
        demiLinije.getJkkf01().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[31]);
        demiLinije.getJkkf01().getVent06().getVrednostiReg().setOtvoren(resultVentili[32]);
        demiLinije.getJkkf01().getVent06().getVrednostiReg().setZatvoren(resultVentili[33]);

        demiLinije.getJkkf01().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[40]);
        demiLinije.getJkkf01().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[41]);
        demiLinije.getJkkf01().getVent07().getVrednostiReg().setOtvoren(resultVentili[42]);
        demiLinije.getJkkf01().getVent07().getVrednostiReg().setZatvoren(resultVentili[43]);

        demiLinije.getJkkf01().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[50]);
        demiLinije.getJkkf01().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[51]);
        demiLinije.getJkkf01().getVent08().getVrednostiReg().setOtvoren(resultVentili[52]);
        demiLinije.getJkkf01().getVent08().getVrednostiReg().setZatvoren(resultVentili[53]);

        demiLinije.getJkkf01().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[60]);
        demiLinije.getJkkf01().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[61]);
        demiLinije.getJkkf01().getVent09().getVrednostiReg().setOtvoren(resultVentili[62]);
        demiLinije.getJkkf01().getVent09().getVrednostiReg().setZatvoren(resultVentili[63]);

        demiLinije.getJkkf01().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[70]);
        demiLinije.getJkkf01().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[71]);
        demiLinije.getJkkf01().getVent10().getVrednostiReg().setOtvoren(resultVentili[72]);
        demiLinije.getJkkf01().getVent10().getVrednostiReg().setZatvoren(resultVentili[73]);

        demiLinije.getJkkf01().getVent11().getVrednostiReg().setEnableOtvori(resultVentili[80]);
        demiLinije.getJkkf01().getVent11().getVrednostiReg().setEnableZatvori(resultVentili[81]);
        demiLinije.getJkkf01().getVent11().getVrednostiReg().setOtvoren(resultVentili[82]);
        demiLinije.getJkkf01().getVent11().getVrednostiReg().setZatvoren(resultVentili[83]);

        demiLinije.getJkkf01().getVent12().getVrednostiReg().setEnableOtvori(resultVentili[90]);
        demiLinije.getJkkf01().getVent12().getVrednostiReg().setEnableZatvori(resultVentili[91]);
        demiLinije.getJkkf01().getVent12().getVrednostiReg().setOtvoren(resultVentili[92]);
        demiLinije.getJkkf01().getVent12().getVrednostiReg().setZatvoren(resultVentili[93]);

    }

    private void getDemiLinija1SBAF() {

        demiLinije.getSbaf01().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[100]);
        demiLinije.getSbaf01().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[101]);
        demiLinije.getSbaf01().getVent01().getVrednostiReg().setOtvoren(resultVentili[102]);
        demiLinije.getSbaf01().getVent01().getVrednostiReg().setZatvoren(resultVentili[103]);

        demiLinije.getSbaf01().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[110]);
        demiLinije.getSbaf01().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[111]);
        demiLinije.getSbaf01().getVent02().getVrednostiReg().setOtvoren(resultVentili[112]);
        demiLinije.getSbaf01().getVent02().getVrednostiReg().setZatvoren(resultVentili[113]);

        demiLinije.getSbaf01().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[120]);
        demiLinije.getSbaf01().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[121]);
        demiLinije.getSbaf01().getVent03().getVrednostiReg().setOtvoren(resultVentili[122]);
        demiLinije.getSbaf01().getVent03().getVrednostiReg().setZatvoren(resultVentili[123]);

        demiLinije.getSbaf01().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[130]);
        demiLinije.getSbaf01().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[131]);
        demiLinije.getSbaf01().getVent04().getVrednostiReg().setOtvoren(resultVentili[132]);
        demiLinije.getSbaf01().getVent04().getVrednostiReg().setZatvoren(resultVentili[133]);

        demiLinije.getSbaf01().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[140]);
        demiLinije.getSbaf01().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[141]);
        demiLinije.getSbaf01().getVent05().getVrednostiReg().setOtvoren(resultVentili[142]);
        demiLinije.getSbaf01().getVent05().getVrednostiReg().setZatvoren(resultVentili[143]);

        demiLinije.getSbaf01().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[150]);
        demiLinije.getSbaf01().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[151]);
        demiLinije.getSbaf01().getVent06().getVrednostiReg().setOtvoren(resultVentili[152]);
        demiLinije.getSbaf01().getVent06().getVrednostiReg().setZatvoren(resultVentili[153]);
    }

    private void getDemiLinija1JBAF() {
        demiLinije.getJbaf01().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[160]);
        demiLinije.getJbaf01().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[161]);
        demiLinije.getJbaf01().getVent01().getVrednostiReg().setOtvoren(resultVentili[162]);
        demiLinije.getJbaf01().getVent01().getVrednostiReg().setZatvoren(resultVentili[163]);

        demiLinije.getJbaf01().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[170]);
        demiLinije.getJbaf01().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[171]);
        demiLinije.getJbaf01().getVent02().getVrednostiReg().setOtvoren(resultVentili[172]);
        demiLinije.getJbaf01().getVent02().getVrednostiReg().setZatvoren(resultVentili[173]);

        demiLinije.getJbaf01().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[180]);
        demiLinije.getJbaf01().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[181]);
        demiLinije.getJbaf01().getVent03().getVrednostiReg().setOtvoren(resultVentili[182]);
        demiLinije.getJbaf01().getVent03().getVrednostiReg().setZatvoren(resultVentili[183]);

        demiLinije.getJbaf01().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[190]);
        demiLinije.getJbaf01().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[191]);
        demiLinije.getJbaf01().getVent04().getVrednostiReg().setOtvoren(resultVentili[192]);
        demiLinije.getJbaf01().getVent04().getVrednostiReg().setZatvoren(resultVentili[193]);

        demiLinije.getJbaf01().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[200]);
        demiLinije.getJbaf01().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[201]);
        demiLinije.getJbaf01().getVent05().getVrednostiReg().setOtvoren(resultVentili[202]);
        demiLinije.getJbaf01().getVent05().getVrednostiReg().setZatvoren(resultVentili[203]);

        demiLinije.getJbaf01().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[210]);
        demiLinije.getJbaf01().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[211]);
        demiLinije.getJbaf01().getVent06().getVrednostiReg().setOtvoren(resultVentili[212]);
        demiLinije.getJbaf01().getVent06().getVrednostiReg().setZatvoren(resultVentili[213]);

        demiLinije.getJbaf01().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[220]);
        demiLinije.getJbaf01().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[221]);
        demiLinije.getJbaf01().getVent07().getVrednostiReg().setOtvoren(resultVentili[222]);
        demiLinije.getJbaf01().getVent07().getVrednostiReg().setZatvoren(resultVentili[223]);

        demiLinije.getJbaf01().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[230]);
        demiLinije.getJbaf01().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[231]);
        demiLinije.getJbaf01().getVent08().getVrednostiReg().setOtvoren(resultVentili[232]);
        demiLinije.getJbaf01().getVent08().getVrednostiReg().setZatvoren(resultVentili[233]);
    }

    private void getDemiLinija1MF() {

        demiLinije.getMf01().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[240]);
        demiLinije.getMf01().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[241]);
        demiLinije.getMf01().getVent01().getVrednostiReg().setOtvoren(resultVentili[242]);
        demiLinije.getMf01().getVent01().getVrednostiReg().setZatvoren(resultVentili[243]);

        demiLinije.getMf01().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[250]);
        demiLinije.getMf01().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[251]);
        demiLinije.getMf01().getVent02().getVrednostiReg().setOtvoren(resultVentili[252]);
        demiLinije.getMf01().getVent02().getVrednostiReg().setZatvoren(resultVentili[253]);

        demiLinije.getMf01().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[260]);
        demiLinije.getMf01().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[261]);
        demiLinije.getMf01().getVent03().getVrednostiReg().setOtvoren(resultVentili[262]);
        demiLinije.getMf01().getVent03().getVrednostiReg().setZatvoren(resultVentili[263]);

        demiLinije.getMf01().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[270]);
        demiLinije.getMf01().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[271]);
        demiLinije.getMf01().getVent04().getVrednostiReg().setOtvoren(resultVentili[272]);
        demiLinije.getMf01().getVent04().getVrednostiReg().setZatvoren(resultVentili[273]);

        demiLinije.getMf01().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[280]);
        demiLinije.getMf01().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[281]);
        demiLinije.getMf01().getVent05().getVrednostiReg().setOtvoren(resultVentili[282]);
        demiLinije.getMf01().getVent05().getVrednostiReg().setZatvoren(resultVentili[283]);

        demiLinije.getMf01().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[290]);
        demiLinije.getMf01().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[291]);
        demiLinije.getMf01().getVent06().getVrednostiReg().setOtvoren(resultVentili[292]);
        demiLinije.getMf01().getVent06().getVrednostiReg().setZatvoren(resultVentili[293]);

        demiLinije.getMf01().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[300]);
        demiLinije.getMf01().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[301]);
        demiLinije.getMf01().getVent07().getVrednostiReg().setOtvoren(resultVentili[302]);
        demiLinije.getMf01().getVent07().getVrednostiReg().setZatvoren(resultVentili[303]);

        demiLinije.getMf01().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[310]);
        demiLinije.getMf01().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[311]);
        demiLinije.getMf01().getVent08().getVrednostiReg().setOtvoren(resultVentili[312]);
        demiLinije.getMf01().getVent08().getVrednostiReg().setZatvoren(resultVentili[313]);

        demiLinije.getMf01().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[320]);
        demiLinije.getMf01().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[321]);
        demiLinije.getMf01().getVent10().getVrednostiReg().setOtvoren(resultVentili[322]);
        demiLinije.getMf01().getVent10().getVrednostiReg().setZatvoren(resultVentili[323]);

        demiLinije.getMf01().getVent11().getVrednostiReg().setEnableOtvori(resultVentili[330]);
        demiLinije.getMf01().getVent11().getVrednostiReg().setEnableZatvori(resultVentili[331]);
        demiLinije.getMf01().getVent11().getVrednostiReg().setOtvoren(resultVentili[332]);
        demiLinije.getMf01().getVent11().getVrednostiReg().setZatvoren(resultVentili[333]);
    }

    private void getDemiLinija2JKKF() {

        demiLinije.getJkkf02().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[350]);
        demiLinije.getJkkf02().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[351]);
        demiLinije.getJkkf02().getVent03().getVrednostiReg().setOtvoren(resultVentili[352]);
        demiLinije.getJkkf02().getVent03().getVrednostiReg().setZatvoren(resultVentili[353]);

        demiLinije.getJkkf02().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[360]);
        demiLinije.getJkkf02().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[361]);
        demiLinije.getJkkf02().getVent04().getVrednostiReg().setOtvoren(resultVentili[362]);
        demiLinije.getJkkf02().getVent04().getVrednostiReg().setZatvoren(resultVentili[363]);

        demiLinije.getJkkf02().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[370]);
        demiLinije.getJkkf02().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[371]);
        demiLinije.getJkkf02().getVent05().getVrednostiReg().setOtvoren(resultVentili[372]);
        demiLinije.getJkkf02().getVent05().getVrednostiReg().setZatvoren(resultVentili[373]);

        demiLinije.getJkkf02().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[380]);
        demiLinije.getJkkf02().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[381]);
        demiLinije.getJkkf02().getVent06().getVrednostiReg().setOtvoren(resultVentili[382]);
        demiLinije.getJkkf02().getVent06().getVrednostiReg().setZatvoren(resultVentili[383]);

        demiLinije.getJkkf02().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[390]);
        demiLinije.getJkkf02().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[391]);
        demiLinije.getJkkf02().getVent07().getVrednostiReg().setOtvoren(resultVentili[392]);
        demiLinije.getJkkf02().getVent07().getVrednostiReg().setZatvoren(resultVentili[393]);

        demiLinije.getJkkf02().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[400]);
        demiLinije.getJkkf02().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[401]);
        demiLinije.getJkkf02().getVent08().getVrednostiReg().setOtvoren(resultVentili[402]);
        demiLinije.getJkkf02().getVent08().getVrednostiReg().setZatvoren(resultVentili[403]);

        demiLinije.getJkkf02().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[410]);
        demiLinije.getJkkf02().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[411]);
        demiLinije.getJkkf02().getVent09().getVrednostiReg().setOtvoren(resultVentili[412]);
        demiLinije.getJkkf02().getVent09().getVrednostiReg().setZatvoren(resultVentili[413]);

        demiLinije.getJkkf02().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[420]);
        demiLinije.getJkkf02().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[421]);
        demiLinije.getJkkf02().getVent10().getVrednostiReg().setOtvoren(resultVentili[422]);
        demiLinije.getJkkf02().getVent10().getVrednostiReg().setZatvoren(resultVentili[423]);

        demiLinije.getJkkf02().getVent11().getVrednostiReg().setEnableOtvori(resultVentili[430]);
        demiLinije.getJkkf02().getVent11().getVrednostiReg().setEnableZatvori(resultVentili[431]);
        demiLinije.getJkkf02().getVent11().getVrednostiReg().setOtvoren(resultVentili[432]);
        demiLinije.getJkkf02().getVent11().getVrednostiReg().setZatvoren(resultVentili[433]);

        demiLinije.getJkkf02().getVent12().getVrednostiReg().setEnableOtvori(resultVentili[440]);
        demiLinije.getJkkf02().getVent12().getVrednostiReg().setEnableZatvori(resultVentili[441]);
        demiLinije.getJkkf02().getVent12().getVrednostiReg().setOtvoren(resultVentili[442]);
        demiLinije.getJkkf02().getVent12().getVrednostiReg().setZatvoren(resultVentili[443]);
    }

    private void getDemiLinija2SBAF() {

        demiLinije.getSbaf02().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[450]);
        demiLinije.getSbaf02().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[451]);
        demiLinije.getSbaf02().getVent01().getVrednostiReg().setOtvoren(resultVentili[452]);
        demiLinije.getSbaf02().getVent01().getVrednostiReg().setZatvoren(resultVentili[453]);

        demiLinije.getSbaf02().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[460]);
        demiLinije.getSbaf02().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[461]);
        demiLinije.getSbaf02().getVent02().getVrednostiReg().setOtvoren(resultVentili[462]);
        demiLinije.getSbaf02().getVent02().getVrednostiReg().setZatvoren(resultVentili[463]);

        demiLinije.getSbaf02().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[470]);
        demiLinije.getSbaf02().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[471]);
        demiLinije.getSbaf02().getVent03().getVrednostiReg().setOtvoren(resultVentili[472]);
        demiLinije.getSbaf02().getVent03().getVrednostiReg().setZatvoren(resultVentili[473]);

        demiLinije.getSbaf02().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[480]);
        demiLinije.getSbaf02().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[481]);
        demiLinije.getSbaf02().getVent04().getVrednostiReg().setOtvoren(resultVentili[482]);
        demiLinije.getSbaf02().getVent04().getVrednostiReg().setZatvoren(resultVentili[483]);

        demiLinije.getSbaf02().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[490]);
        demiLinije.getSbaf02().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[491]);
        demiLinije.getSbaf02().getVent05().getVrednostiReg().setOtvoren(resultVentili[492]);
        demiLinije.getSbaf02().getVent05().getVrednostiReg().setZatvoren(resultVentili[493]);

        demiLinije.getSbaf02().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[500]);
        demiLinije.getSbaf02().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[501]);
        demiLinije.getSbaf02().getVent06().getVrednostiReg().setOtvoren(resultVentili[502]);
        demiLinije.getSbaf02().getVent06().getVrednostiReg().setZatvoren(resultVentili[503]);
    }

    private void getDemiLinija2JBAF() {

        demiLinije.getJbaf02().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[510]);
        demiLinije.getJbaf02().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[511]);
        demiLinije.getJbaf02().getVent01().getVrednostiReg().setOtvoren(resultVentili[512]);
        demiLinije.getJbaf02().getVent01().getVrednostiReg().setZatvoren(resultVentili[513]);

        demiLinije.getJbaf02().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[520]);
        demiLinije.getJbaf02().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[521]);
        demiLinije.getJbaf02().getVent02().getVrednostiReg().setOtvoren(resultVentili[522]);
        demiLinije.getJbaf02().getVent02().getVrednostiReg().setZatvoren(resultVentili[523]);

        demiLinije.getJbaf02().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[530]);
        demiLinije.getJbaf02().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[531]);
        demiLinije.getJbaf02().getVent03().getVrednostiReg().setOtvoren(resultVentili[532]);
        demiLinije.getJbaf02().getVent03().getVrednostiReg().setZatvoren(resultVentili[533]);

        demiLinije.getJbaf02().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[540]);
        demiLinije.getJbaf02().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[541]);
        demiLinije.getJbaf02().getVent04().getVrednostiReg().setOtvoren(resultVentili[542]);
        demiLinije.getJbaf02().getVent04().getVrednostiReg().setZatvoren(resultVentili[543]);

        demiLinije.getJbaf02().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[550]);
        demiLinije.getJbaf02().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[551]);
        demiLinije.getJbaf02().getVent05().getVrednostiReg().setOtvoren(resultVentili[552]);
        demiLinije.getJbaf02().getVent05().getVrednostiReg().setZatvoren(resultVentili[553]);

        demiLinije.getJbaf02().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[560]);
        demiLinije.getJbaf02().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[561]);
        demiLinije.getJbaf02().getVent06().getVrednostiReg().setOtvoren(resultVentili[562]);
        demiLinije.getJbaf02().getVent06().getVrednostiReg().setZatvoren(resultVentili[563]);

        demiLinije.getJbaf02().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[570]);
        demiLinije.getJbaf02().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[571]);
        demiLinije.getJbaf02().getVent07().getVrednostiReg().setOtvoren(resultVentili[572]);
        demiLinije.getJbaf02().getVent07().getVrednostiReg().setZatvoren(resultVentili[573]);

        demiLinije.getJbaf02().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[580]);
        demiLinije.getJbaf02().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[581]);
        demiLinije.getJbaf02().getVent08().getVrednostiReg().setOtvoren(resultVentili[582]);
        demiLinije.getJbaf02().getVent08().getVrednostiReg().setZatvoren(resultVentili[583]);
    }

    private void getDemiLinija2MF() {

        demiLinije.getMf02().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[590]);
        demiLinije.getMf02().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[591]);
        demiLinije.getMf02().getVent01().getVrednostiReg().setOtvoren(resultVentili[592]);
        demiLinije.getMf02().getVent01().getVrednostiReg().setZatvoren(resultVentili[593]);

        demiLinije.getMf02().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[600]);
        demiLinije.getMf02().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[601]);
        demiLinije.getMf02().getVent02().getVrednostiReg().setOtvoren(resultVentili[602]);
        demiLinije.getMf02().getVent02().getVrednostiReg().setZatvoren(resultVentili[603]);

        demiLinije.getMf02().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[610]);
        demiLinije.getMf02().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[611]);
        demiLinije.getMf02().getVent03().getVrednostiReg().setOtvoren(resultVentili[612]);
        demiLinije.getMf02().getVent03().getVrednostiReg().setZatvoren(resultVentili[613]);

        demiLinije.getMf02().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[620]);
        demiLinije.getMf02().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[621]);
        demiLinije.getMf02().getVent04().getVrednostiReg().setOtvoren(resultVentili[622]);
        demiLinije.getMf02().getVent04().getVrednostiReg().setZatvoren(resultVentili[623]);

        demiLinije.getMf02().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[630]);
        demiLinije.getMf02().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[631]);
        demiLinije.getMf02().getVent05().getVrednostiReg().setOtvoren(resultVentili[632]);
        demiLinije.getMf02().getVent05().getVrednostiReg().setZatvoren(resultVentili[633]);

        demiLinije.getMf02().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[640]);
        demiLinije.getMf02().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[641]);
        demiLinije.getMf02().getVent06().getVrednostiReg().setOtvoren(resultVentili[642]);
        demiLinije.getMf02().getVent06().getVrednostiReg().setZatvoren(resultVentili[643]);

        demiLinije.getMf02().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[650]);
        demiLinije.getMf02().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[651]);
        demiLinije.getMf02().getVent07().getVrednostiReg().setOtvoren(resultVentili[652]);
        demiLinije.getMf02().getVent07().getVrednostiReg().setZatvoren(resultVentili[653]);

        demiLinije.getMf02().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[660]);
        demiLinije.getMf02().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[661]);
        demiLinije.getMf02().getVent08().getVrednostiReg().setOtvoren(resultVentili[662]);
        demiLinije.getMf02().getVent08().getVrednostiReg().setZatvoren(resultVentili[663]);

        demiLinije.getMf02().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[670]);
        demiLinije.getMf02().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[671]);
        demiLinije.getMf02().getVent10().getVrednostiReg().setOtvoren(resultVentili[672]);
        demiLinije.getMf02().getVent10().getVrednostiReg().setZatvoren(resultVentili[673]);

        demiLinije.getMf02().getVent11().getVrednostiReg().setEnableOtvori(resultVentili[680]);
        demiLinije.getMf02().getVent11().getVrednostiReg().setEnableZatvori(resultVentili[681]);
        demiLinije.getMf02().getVent11().getVrednostiReg().setOtvoren(resultVentili[682]);
        demiLinije.getMf02().getVent11().getVrednostiReg().setZatvoren(resultVentili[683]);
    }

    private void getDemiLinija3JKKF() {

        demiLinije.getJkkf03().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[700]);
        demiLinije.getJkkf03().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[701]);
        demiLinije.getJkkf03().getVent03().getVrednostiReg().setOtvoren(resultVentili[702]);
        demiLinije.getJkkf03().getVent03().getVrednostiReg().setZatvoren(resultVentili[703]);

        demiLinije.getJkkf03().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[710]);
        demiLinije.getJkkf03().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[711]);
        demiLinije.getJkkf03().getVent04().getVrednostiReg().setOtvoren(resultVentili[712]);
        demiLinije.getJkkf03().getVent04().getVrednostiReg().setZatvoren(resultVentili[713]);

        demiLinije.getJkkf03().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[720]);
        demiLinije.getJkkf03().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[721]);
        demiLinije.getJkkf03().getVent05().getVrednostiReg().setOtvoren(resultVentili[722]);
        demiLinije.getJkkf03().getVent05().getVrednostiReg().setZatvoren(resultVentili[723]);

        demiLinije.getJkkf03().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[730]);
        demiLinije.getJkkf03().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[731]);
        demiLinije.getJkkf03().getVent06().getVrednostiReg().setOtvoren(resultVentili[732]);
        demiLinije.getJkkf03().getVent06().getVrednostiReg().setZatvoren(resultVentili[733]);

        demiLinije.getJkkf03().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[740]);
        demiLinije.getJkkf03().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[741]);
        demiLinije.getJkkf03().getVent07().getVrednostiReg().setOtvoren(resultVentili[742]);
        demiLinije.getJkkf03().getVent07().getVrednostiReg().setZatvoren(resultVentili[743]);

        demiLinije.getJkkf03().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[750]);
        demiLinije.getJkkf03().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[751]);
        demiLinije.getJkkf03().getVent08().getVrednostiReg().setOtvoren(resultVentili[752]);
        demiLinije.getJkkf03().getVent08().getVrednostiReg().setZatvoren(resultVentili[753]);

        demiLinije.getJkkf03().getVent09().getVrednostiReg().setEnableOtvori(resultVentili[760]);
        demiLinije.getJkkf03().getVent09().getVrednostiReg().setEnableZatvori(resultVentili[761]);
        demiLinije.getJkkf03().getVent09().getVrednostiReg().setOtvoren(resultVentili[762]);
        demiLinije.getJkkf03().getVent09().getVrednostiReg().setZatvoren(resultVentili[763]);

        demiLinije.getJkkf03().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[770]);
        demiLinije.getJkkf03().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[771]);
        demiLinije.getJkkf03().getVent10().getVrednostiReg().setOtvoren(resultVentili[772]);
        demiLinije.getJkkf03().getVent10().getVrednostiReg().setZatvoren(resultVentili[773]);

        demiLinije.getJkkf03().getVent11().getVrednostiReg().setEnableOtvori(resultVentili[780]);
        demiLinije.getJkkf03().getVent11().getVrednostiReg().setEnableZatvori(resultVentili[781]);
        demiLinije.getJkkf03().getVent11().getVrednostiReg().setOtvoren(resultVentili[782]);
        demiLinije.getJkkf03().getVent11().getVrednostiReg().setZatvoren(resultVentili[783]);

        demiLinije.getJkkf03().getVent12().getVrednostiReg().setEnableOtvori(resultVentili[790]);
        demiLinije.getJkkf03().getVent12().getVrednostiReg().setEnableZatvori(resultVentili[791]);
        demiLinije.getJkkf03().getVent12().getVrednostiReg().setOtvoren(resultVentili[792]);
        demiLinije.getJkkf03().getVent12().getVrednostiReg().setZatvoren(resultVentili[793]);
    }

    private void getDemiLinija3SBAF() {

        demiLinije.getSbaf03().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[800]);
        demiLinije.getSbaf03().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[801]);
        demiLinije.getSbaf03().getVent01().getVrednostiReg().setOtvoren(resultVentili[802]);
        demiLinije.getSbaf03().getVent01().getVrednostiReg().setZatvoren(resultVentili[803]);

        demiLinije.getSbaf03().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[810]);
        demiLinije.getSbaf03().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[811]);
        demiLinije.getSbaf03().getVent02().getVrednostiReg().setOtvoren(resultVentili[812]);
        demiLinije.getSbaf03().getVent02().getVrednostiReg().setZatvoren(resultVentili[813]);

        demiLinije.getSbaf03().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[820]);
        demiLinije.getSbaf03().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[821]);
        demiLinije.getSbaf03().getVent03().getVrednostiReg().setOtvoren(resultVentili[822]);
        demiLinije.getSbaf03().getVent03().getVrednostiReg().setZatvoren(resultVentili[823]);

        demiLinije.getSbaf03().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[830]);
        demiLinije.getSbaf03().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[831]);
        demiLinije.getSbaf03().getVent04().getVrednostiReg().setOtvoren(resultVentili[832]);
        demiLinije.getSbaf03().getVent04().getVrednostiReg().setZatvoren(resultVentili[833]);

        demiLinije.getSbaf03().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[840]);
        demiLinije.getSbaf03().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[841]);
        demiLinije.getSbaf03().getVent05().getVrednostiReg().setOtvoren(resultVentili[842]);
        demiLinije.getSbaf03().getVent05().getVrednostiReg().setZatvoren(resultVentili[843]);

        demiLinije.getSbaf03().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[850]);
        demiLinije.getSbaf03().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[851]);
        demiLinije.getSbaf03().getVent06().getVrednostiReg().setOtvoren(resultVentili[852]);
        demiLinije.getSbaf03().getVent06().getVrednostiReg().setZatvoren(resultVentili[853]);
    }

    private void getDemiLinija3JBAF() {

        demiLinije.getJbaf03().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[860]);
        demiLinije.getJbaf03().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[861]);
        demiLinije.getJbaf03().getVent01().getVrednostiReg().setOtvoren(resultVentili[862]);
        demiLinije.getJbaf03().getVent01().getVrednostiReg().setZatvoren(resultVentili[863]);

        demiLinije.getJbaf03().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[870]);
        demiLinije.getJbaf03().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[871]);
        demiLinije.getJbaf03().getVent02().getVrednostiReg().setOtvoren(resultVentili[872]);
        demiLinije.getJbaf03().getVent02().getVrednostiReg().setZatvoren(resultVentili[873]);

        demiLinije.getJbaf03().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[880]);
        demiLinije.getJbaf03().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[881]);
        demiLinije.getJbaf03().getVent03().getVrednostiReg().setOtvoren(resultVentili[882]);
        demiLinije.getJbaf03().getVent03().getVrednostiReg().setZatvoren(resultVentili[883]);

        demiLinije.getJbaf03().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[890]);
        demiLinije.getJbaf03().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[891]);
        demiLinije.getJbaf03().getVent04().getVrednostiReg().setOtvoren(resultVentili[892]);
        demiLinije.getJbaf03().getVent04().getVrednostiReg().setZatvoren(resultVentili[893]);

        demiLinije.getJbaf03().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[900]);
        demiLinije.getJbaf03().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[901]);
        demiLinije.getJbaf03().getVent05().getVrednostiReg().setOtvoren(resultVentili[902]);
        demiLinije.getJbaf03().getVent05().getVrednostiReg().setZatvoren(resultVentili[903]);

        demiLinije.getJbaf03().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[910]);
        demiLinije.getJbaf03().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[911]);
        demiLinije.getJbaf03().getVent06().getVrednostiReg().setOtvoren(resultVentili[912]);
        demiLinije.getJbaf03().getVent06().getVrednostiReg().setZatvoren(resultVentili[913]);

        demiLinije.getJbaf03().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[920]);
        demiLinije.getJbaf03().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[921]);
        demiLinije.getJbaf03().getVent07().getVrednostiReg().setOtvoren(resultVentili[922]);
        demiLinije.getJbaf03().getVent07().getVrednostiReg().setZatvoren(resultVentili[923]);

        demiLinije.getJbaf03().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[930]);
        demiLinije.getJbaf03().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[931]);
        demiLinije.getJbaf03().getVent08().getVrednostiReg().setOtvoren(resultVentili[932]);
        demiLinije.getJbaf03().getVent08().getVrednostiReg().setZatvoren(resultVentili[933]);
    }

    private void getDemiLinija3MF() {

        demiLinije.getMf03().getVent01().getVrednostiReg().setEnableOtvori(resultVentili[940]);
        demiLinije.getMf03().getVent01().getVrednostiReg().setEnableZatvori(resultVentili[941]);
        demiLinije.getMf03().getVent01().getVrednostiReg().setOtvoren(resultVentili[942]);
        demiLinije.getMf03().getVent01().getVrednostiReg().setZatvoren(resultVentili[943]);

        demiLinije.getMf03().getVent02().getVrednostiReg().setEnableOtvori(resultVentili[950]);
        demiLinije.getMf03().getVent02().getVrednostiReg().setEnableZatvori(resultVentili[951]);
        demiLinije.getMf03().getVent02().getVrednostiReg().setOtvoren(resultVentili[952]);
        demiLinije.getMf03().getVent02().getVrednostiReg().setZatvoren(resultVentili[953]);

        demiLinije.getMf03().getVent03().getVrednostiReg().setEnableOtvori(resultVentili[960]);
        demiLinije.getMf03().getVent03().getVrednostiReg().setEnableZatvori(resultVentili[961]);
        demiLinije.getMf03().getVent03().getVrednostiReg().setOtvoren(resultVentili[962]);
        demiLinije.getMf03().getVent03().getVrednostiReg().setZatvoren(resultVentili[963]);

        demiLinije.getMf03().getVent04().getVrednostiReg().setEnableOtvori(resultVentili[970]);
        demiLinije.getMf03().getVent04().getVrednostiReg().setEnableZatvori(resultVentili[971]);
        demiLinije.getMf03().getVent04().getVrednostiReg().setOtvoren(resultVentili[972]);
        demiLinije.getMf03().getVent04().getVrednostiReg().setZatvoren(resultVentili[973]);

        demiLinije.getMf03().getVent05().getVrednostiReg().setEnableOtvori(resultVentili[980]);
        demiLinije.getMf03().getVent05().getVrednostiReg().setEnableZatvori(resultVentili[981]);
        demiLinije.getMf03().getVent05().getVrednostiReg().setOtvoren(resultVentili[982]);
        demiLinije.getMf03().getVent05().getVrednostiReg().setZatvoren(resultVentili[983]);

        demiLinije.getMf03().getVent06().getVrednostiReg().setEnableOtvori(resultVentili[990]);
        demiLinije.getMf03().getVent06().getVrednostiReg().setEnableZatvori(resultVentili[991]);
        demiLinije.getMf03().getVent06().getVrednostiReg().setOtvoren(resultVentili[992]);
        demiLinije.getMf03().getVent06().getVrednostiReg().setZatvoren(resultVentili[993]);

        demiLinije.getMf03().getVent07().getVrednostiReg().setEnableOtvori(resultVentili[1000]);
        demiLinije.getMf03().getVent07().getVrednostiReg().setEnableZatvori(resultVentili[1001]);
        demiLinije.getMf03().getVent07().getVrednostiReg().setOtvoren(resultVentili[1002]);
        demiLinije.getMf03().getVent07().getVrednostiReg().setZatvoren(resultVentili[1003]);

        demiLinije.getMf03().getVent08().getVrednostiReg().setEnableOtvori(resultVentili[1010]);
        demiLinije.getMf03().getVent08().getVrednostiReg().setEnableZatvori(resultVentili[1011]);
        demiLinije.getMf03().getVent08().getVrednostiReg().setOtvoren(resultVentili[1012]);
        demiLinije.getMf03().getVent08().getVrednostiReg().setZatvoren(resultVentili[1013]);

        demiLinije.getMf03().getVent10().getVrednostiReg().setEnableOtvori(resultVentili[1020]);
        demiLinije.getMf03().getVent10().getVrednostiReg().setEnableZatvori(resultVentili[1021]);
        demiLinije.getMf03().getVent10().getVrednostiReg().setOtvoren(resultVentili[1022]);
        demiLinije.getMf03().getVent10().getVrednostiReg().setZatvoren(resultVentili[1023]);

        demiLinije.getMf03().getVent11().getVrednostiReg().setEnableOtvori(resultVentili[1030]);
        demiLinije.getMf03().getVent11().getVrednostiReg().setEnableZatvori(resultVentili[1031]);
        demiLinije.getMf03().getVent11().getVrednostiReg().setOtvoren(resultVentili[1032]);
        demiLinije.getMf03().getVent11().getVrednostiReg().setZatvoren(resultVentili[1033]);
    }

    private void getReaktoriMotori(){
        resultStatusiPumpe = mxm.readDI(startStatusiPumpi, 250);
        resultEnablePumpe = mxm.readMX(startEnablePumpi, 650);
        
        reaktorMotori.getImpelerReaktorBr1().getVrednosti().setLokalno(resultStatusiPumpe[0]);
        reaktorMotori.getImpelerReaktorBr1().getVrednosti().setDaljinski(resultStatusiPumpe[1]);
        reaktorMotori.getImpelerReaktorBr1().getVrednosti().setUkljucen(resultStatusiPumpe[2]);
        reaktorMotori.getImpelerReaktorBr1().getVrednosti().setEnableOn(resultEnablePumpe[6]);
        reaktorMotori.getImpelerReaktorBr1().getVrednosti().setEnableOff(resultEnablePumpe[7]);
        
        reaktorMotori.getZgrtacReaktorBr1().getVrednosti().setLokalno(resultStatusiPumpe[3]);
        reaktorMotori.getZgrtacReaktorBr1().getVrednosti().setDaljinski(resultStatusiPumpe[4]);
        reaktorMotori.getZgrtacReaktorBr1().getVrednosti().setUkljucen(resultStatusiPumpe[5]);
        reaktorMotori.getZgrtacReaktorBr1().getVrednosti().setEnableOn(resultEnablePumpe[14]);
        reaktorMotori.getZgrtacReaktorBr1().getVrednosti().setEnableOff(resultEnablePumpe[15]);

    }
    
    private void getPumpeDekaFiltriranaKaDemi() {

        pumpeDekaFiltriranaKaDemi.getPumpaBr1().getVrednosti().setLokalno(resultStatusiPumpe[78]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr1().getVrednosti().setDaljinski(resultStatusiPumpe[79]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr1().getVrednosti().setUkljucen(resultStatusiPumpe[80]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[214]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[215]);

        pumpeDekaFiltriranaKaDemi.getPumpaBr2().getVrednosti().setLokalno(resultStatusiPumpe[81]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr2().getVrednosti().setDaljinski(resultStatusiPumpe[82]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr2().getVrednosti().setUkljucen(resultStatusiPumpe[83]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[222]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[223]);

        pumpeDekaFiltriranaKaDemi.getPumpaBr3().getVrednosti().setLokalno(resultStatusiPumpe[84]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr3().getVrednosti().setDaljinski(resultStatusiPumpe[85]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr3().getVrednosti().setUkljucen(resultStatusiPumpe[86]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr3().getVrednosti().setEnableOn(resultEnablePumpe[230]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr3().getVrednosti().setEnableOff(resultEnablePumpe[231]);

        pumpeDekaFiltriranaKaDemi.getPumpaBr4().getVrednosti().setLokalno(resultStatusiPumpe[183]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr4().getVrednosti().setDaljinski(resultStatusiPumpe[184]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr4().getVrednosti().setUkljucen(resultStatusiPumpe[185]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr4().getVrednosti().setEnableOn(resultEnablePumpe[494]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr4().getVrednosti().setEnableOff(resultEnablePumpe[495]);

        pumpeDekaFiltriranaKaDemi.getPumpaBr5().getVrednosti().setLokalno(resultStatusiPumpe[186]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr5().getVrednosti().setDaljinski(resultStatusiPumpe[187]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr5().getVrednosti().setUkljucen(resultStatusiPumpe[188]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr5().getVrednosti().setEnableOn(resultEnablePumpe[502]);
        pumpeDekaFiltriranaKaDemi.getPumpaBr5().getVrednosti().setEnableOff(resultEnablePumpe[503]);

    }

    private void getPumpeNeutralizacionogBazena() {
        pumpeNeutralizacionogBazena.getPumpaBr1().getVrednosti().setLokalno(resultStatusiPumpe[6]);
        pumpeNeutralizacionogBazena.getPumpaBr1().getVrednosti().setDaljinski(resultStatusiPumpe[7]);
        pumpeNeutralizacionogBazena.getPumpaBr1().getVrednosti().setUkljucen(resultStatusiPumpe[8]);
        pumpeNeutralizacionogBazena.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[22]);
        pumpeNeutralizacionogBazena.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[23]);

        pumpeNeutralizacionogBazena.getPumpaBr2().getVrednosti().setLokalno(resultStatusiPumpe[9]);
        pumpeNeutralizacionogBazena.getPumpaBr2().getVrednosti().setDaljinski(resultStatusiPumpe[10]);
        pumpeNeutralizacionogBazena.getPumpaBr2().getVrednosti().setUkljucen(resultStatusiPumpe[11]);
        pumpeNeutralizacionogBazena.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[30]);
        pumpeNeutralizacionogBazena.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[31]);

    }

    private void getPumpeKaPescanimFilterima() {
        pumpeKaPescanimFilterima.getPumpaBr1().getVrednosti().setLokalno(resultStatusiPumpe[24]);
        pumpeKaPescanimFilterima.getPumpaBr1().getVrednosti().setDaljinski(resultStatusiPumpe[25]);
        pumpeKaPescanimFilterima.getPumpaBr1().getVrednosti().setUkljucen(resultStatusiPumpe[26]);
        pumpeKaPescanimFilterima.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[70]);
        pumpeKaPescanimFilterima.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[71]);

        pumpeKaPescanimFilterima.getPumpaBr2().getVrednosti().setLokalno(resultStatusiPumpe[21]);
        pumpeKaPescanimFilterima.getPumpaBr2().getVrednosti().setDaljinski(resultStatusiPumpe[22]);
        pumpeKaPescanimFilterima.getPumpaBr2().getVrednosti().setUkljucen(resultStatusiPumpe[23]);
        pumpeKaPescanimFilterima.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[62]);
        pumpeKaPescanimFilterima.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[63]);

        pumpeKaPescanimFilterima.getPumpaBr3().getVrednosti().setLokalno(resultStatusiPumpe[18]);
        pumpeKaPescanimFilterima.getPumpaBr3().getVrednosti().setDaljinski(resultStatusiPumpe[19]);
        pumpeKaPescanimFilterima.getPumpaBr3().getVrednosti().setUkljucen(resultStatusiPumpe[20]);
        pumpeKaPescanimFilterima.getPumpaBr3().getVrednosti().setEnableOn(resultEnablePumpe[54]);
        pumpeKaPescanimFilterima.getPumpaBr3().getVrednosti().setEnableOff(resultEnablePumpe[55]);

        pumpeKaPescanimFilterima.getPumpaBr4().getVrednosti().setLokalno(resultStatusiPumpe[171]);
        pumpeKaPescanimFilterima.getPumpaBr4().getVrednosti().setDaljinski(resultStatusiPumpe[172]);
        pumpeKaPescanimFilterima.getPumpaBr4().getVrednosti().setUkljucen(resultStatusiPumpe[173]);
        pumpeKaPescanimFilterima.getPumpaBr4().getVrednosti().setEnableOn(resultEnablePumpe[462]);
        pumpeKaPescanimFilterima.getPumpaBr4().getVrednosti().setEnableOff(resultEnablePumpe[463]);

        pumpeKaPescanimFilterima.getPumpaBr5().getVrednosti().setLokalno(resultStatusiPumpe[174]);
        pumpeKaPescanimFilterima.getPumpaBr5().getVrednosti().setDaljinski(resultStatusiPumpe[175]);
        pumpeKaPescanimFilterima.getPumpaBr5().getVrednosti().setUkljucen(resultStatusiPumpe[176]);
        pumpeKaPescanimFilterima.getPumpaBr5().getVrednosti().setEnableOn(resultEnablePumpe[470]);
        pumpeKaPescanimFilterima.getPumpaBr5().getVrednosti().setEnableOff(resultEnablePumpe[471]);

        pumpeKaPescanimFilterima.getPumpaBr6().getVrednosti().setLokalno(resultStatusiPumpe[177]);
        pumpeKaPescanimFilterima.getPumpaBr6().getVrednosti().setDaljinski(resultStatusiPumpe[178]);
        pumpeKaPescanimFilterima.getPumpaBr6().getVrednosti().setUkljucen(resultStatusiPumpe[179]);
        pumpeKaPescanimFilterima.getPumpaBr6().getVrednosti().setEnableOn(resultEnablePumpe[478]);
        pumpeKaPescanimFilterima.getPumpaBr6().getVrednosti().setEnableOff(resultEnablePumpe[479]);

    }

    private void getPumpeDekaFiltriraneKaNeutralnojIzmeni() {
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1().getVrednosti().setLokalno(resultStatusiPumpe[117]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1().getVrednosti().setDaljinski(resultStatusiPumpe[118]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1().getVrednosti().setUkljucen(resultStatusiPumpe[119]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[318]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[319]);

        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2().getVrednosti().setLokalno(resultStatusiPumpe[120]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2().getVrednosti().setDaljinski(resultStatusiPumpe[121]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2().getVrednosti().setUkljucen(resultStatusiPumpe[122]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[326]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[327]);

        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3().getVrednosti().setLokalno(resultStatusiPumpe[180]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3().getVrednosti().setDaljinski(resultStatusiPumpe[181]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3().getVrednosti().setUkljucen(resultStatusiPumpe[182]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3().getVrednosti().setEnableOn(resultEnablePumpe[486]);
        pumpeDekaFiltriraneKaNeutralnojIzmeni.getPumpaBr3().getVrednosti().setEnableOff(resultEnablePumpe[487]);
    }

    private void getPumpeOdpadnihVodaOdPranjaPescanihFiltera() {
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1().getVrednosti().setLokalno(resultStatusiPumpe[72]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1().getVrednosti().setDaljinski(resultStatusiPumpe[73]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1().getVrednosti().setUkljucen(resultStatusiPumpe[74]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[198]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[199]);

        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2().getVrednosti().setLokalno(resultStatusiPumpe[75]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2().getVrednosti().setDaljinski(resultStatusiPumpe[76]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2().getVrednosti().setUkljucen(resultStatusiPumpe[77]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[206]);
        pumpeOdpadnihVodaOdPranjaPescanihFiltera.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[207]);
    }

    private void getPumpeZaPranjePescanihFiltera() {
        pumpeZaPranjePescanihFiltera.getPumpaBr1().getVrednosti().setLokalno(resultStatusiPumpe[27]);
        pumpeZaPranjePescanihFiltera.getPumpaBr1().getVrednosti().setDaljinski(resultStatusiPumpe[28]);
        pumpeZaPranjePescanihFiltera.getPumpaBr1().getVrednosti().setUkljucen(resultStatusiPumpe[29]);
        pumpeZaPranjePescanihFiltera.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[78]);
        pumpeZaPranjePescanihFiltera.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[79]);

        pumpeZaPranjePescanihFiltera.getPumpaBr2().getVrednosti().setLokalno(resultStatusiPumpe[30]);
        pumpeZaPranjePescanihFiltera.getPumpaBr2().getVrednosti().setDaljinski(resultStatusiPumpe[31]);
        pumpeZaPranjePescanihFiltera.getPumpaBr2().getVrednosti().setUkljucen(resultStatusiPumpe[32]);
        pumpeZaPranjePescanihFiltera.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[86]);
        pumpeZaPranjePescanihFiltera.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[87]);

    }

    private void getPumpePolielektrolit() {
        pumpePolielektrolit.getPumpaBr1().getVrednosti().setRun(resultStatusiPumpe[33]);
        pumpePolielektrolit.getPumpaBr1().getVrednosti().setRucnoDaljinski(resultStatusiPumpe[34]);
        pumpePolielektrolit.getPumpaBr1().getVrednosti().setPower(resultStatusiPumpe[35]);
        pumpePolielektrolit.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[94]);
        pumpePolielektrolit.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[95]);

        pumpePolielektrolit.getPumpaBr1().getVrednosti().setAnalognaVrednost(resMerenja1[44]);

        pumpePolielektrolit.getPumpaBr2().getVrednosti().setRun(resultStatusiPumpe[36]);
        pumpePolielektrolit.getPumpaBr2().getVrednosti().setRucnoDaljinski(resultStatusiPumpe[37]);
        pumpePolielektrolit.getPumpaBr2().getVrednosti().setPower(resultStatusiPumpe[35]);
        pumpePolielektrolit.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[102]);
        pumpePolielektrolit.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[103]);

        pumpePolielektrolit.getPumpaBr2().getVrednosti().setAnalognaVrednost(resMerenja1[45]);

        pumpePolielektrolit.getPumpaBr3().getVrednosti().setRun(resultStatusiPumpe[159]);
        pumpePolielektrolit.getPumpaBr3().getVrednosti().setRucnoDaljinski(resultStatusiPumpe[160]);
        pumpePolielektrolit.getPumpaBr3().getVrednosti().setPower(resultStatusiPumpe[161]);
        pumpePolielektrolit.getPumpaBr3().getVrednosti().setEnableOn(resultEnablePumpe[430]);
        pumpePolielektrolit.getPumpaBr3().getVrednosti().setEnableOff(resultEnablePumpe[431]);

        pumpePolielektrolit.getPumpaBr3().getVrednosti().setAnalognaVrednost(resMerenja1[46]);
    }

    private void getPumpeFerihlorid() {

        pumpeFerihlorid.getPumpaBr1().getVrednosti().setRun(resultStatusiPumpe[46]);
        pumpeFerihlorid.getPumpaBr1().getVrednosti().setRucnoDaljinski(true);
        pumpeFerihlorid.getPumpaBr1().getVrednosti().setPower(resultStatusiPumpe[47]);
        pumpeFerihlorid.getPumpaBr1().getVrednosti().setEnableOn(resultEnablePumpe[126]);
        pumpeFerihlorid.getPumpaBr1().getVrednosti().setEnableOff(resultEnablePumpe[127]);

        pumpeFerihlorid.getPumpaBr1().getVrednosti().setAnalognaVrednost(resMerenja1[47]);

        pumpeFerihlorid.getPumpaBr2().getVrednosti().setRun(resultStatusiPumpe[48]);
        pumpeFerihlorid.getPumpaBr2().getVrednosti().setRucnoDaljinski(true);
        pumpeFerihlorid.getPumpaBr2().getVrednosti().setPower(resultStatusiPumpe[49]);
        pumpeFerihlorid.getPumpaBr2().getVrednosti().setEnableOn(resultEnablePumpe[134]);
        pumpeFerihlorid.getPumpaBr2().getVrednosti().setEnableOff(resultEnablePumpe[135]);

        pumpeFerihlorid.getPumpaBr2().getVrednosti().setAnalognaVrednost(resMerenja1[48]);

        pumpeFerihlorid.getPumpaBr3().getVrednosti().setRun(resultStatusiPumpe[163]);
        pumpeFerihlorid.getPumpaBr3().getVrednosti().setRucnoDaljinski(true);
        pumpeFerihlorid.getPumpaBr3().getVrednosti().setPower(resultStatusiPumpe[164]);
        pumpeFerihlorid.getPumpaBr3().getVrednosti().setEnableOn(resultEnablePumpe[438]);
        pumpeFerihlorid.getPumpaBr3().getVrednosti().setEnableOff(resultEnablePumpe[439]);

        pumpeFerihlorid.getPumpaBr3().getVrednosti().setAnalognaVrednost(resMerenja1[50]);

    }

    private void getDoziranje() {

        doziranje.getVrednostRegistra().setIzabraniReaktorVrednost(resultEnablePumpe[640]);
        doziranje.getVrednostRegistra().setIzabraniSilosKrecaVrednost(resultEnablePumpe[643]);
        doziranje.getVrednostRegistra().setAutomatskoDoziranje(resultEnablePumpe[646]);

        doziranje.getVrednostRegistra().setIzabranaPumpaFCLVrednost(resMerenja1[81]);
        doziranje.getVrednostRegistra().setRezervnaPumpaFCLVrednost(resMerenja1[82]);
        doziranje.getVrednostRegistra().setIzabranaPumpaPEVrednost(resMerenja1[83]);
        doziranje.getVrednostRegistra().setRezervnaPumpaPEVrednost(resMerenja1[84]);
        doziranje.getVrednostRegistra().setProduvavanjeRad(resMerenja2[12]);
        doziranje.getVrednostRegistra().setProduvavanjePauza(resMerenja2[13]);

        int offtRead = doziranje.getNapajanjePEPumpe();
        boolean[] rReg = mxm.readMX(offtRead, 65);
     
        doziranje.getVrednostRegistra().setNapajanjePEPumpe(rReg[0]);//81b
        
        doziranje.getVrednostRegistra().setNapajanjeFeClPumbaBr1(rReg[4]);//81f
        doziranje.getVrednostRegistra().setNapajanjeFeClPumbaBr2(rReg[5]);//820
        doziranje.getVrednostRegistra().setNapajanjeFeClPumbaBr3(rReg[43]);//846
        
        doziranje.getVrednostRegistra().setSuviKrecniDozatorBr1(rReg[9]); //824
        doziranje.getVrednostRegistra().setSuviKrecniDozatorBr2(rReg[10]); //825
        
        
        doziranje.getVrednostRegistra().setSilos1EMV(rReg[53]);//850
        doziranje.getVrednostRegistra().setKrecSilos1Rastresac(rReg[54]);//851
        doziranje.getVrednostRegistra().setKrecSilos1Mesalica(rReg[55]);//852
        doziranje.getVrednostRegistra().setSilos2EMV(rReg[56]);//853
        doziranje.getVrednostRegistra().setKrecSilos2Rastresac(rReg[57]);//854
        doziranje.getVrednostRegistra().setKrecSilos2Mesalica(rReg[58]);//855
        

   
        ventilacija.getUbacivanjeVazduha().setPozicija1(rReg[59]);
        ventilacija.getUbacivanjeVazduha().setPozicija2(rReg[60]);
        ventilacija.getIzbacivanjeVazduha().setPozicija1(rReg[61]);
        ventilacija.getIzbacivanjeVazduha().setPozicija2(rReg[62]);

    }
    
    private void getRegeneracija(){
        regeneracija.getRegVentHCl().getVrednosti().setPolozajVrednost(resMerenja1[65]);
        regeneracija.getRegVentNaOH().getVrednosti().setPolozajVrednost(resMerenja1[66]);
        
        regeneracija.getVentHCLusisPumpeBr1().getVrednostiReg().setEnableOtvori(resultVentili[1100]);
        regeneracija.getVentHCLusisPumpeBr1().getVrednostiReg().setEnableZatvori(resultVentili[1101]);
        regeneracija.getVentHCLusisPumpeBr1().getVrednostiReg().setOtvoren(resultVentili[1102]);
        regeneracija.getVentHCLusisPumpeBr1().getVrednostiReg().setZatvoren(resultVentili[1103]);
        
        regeneracija.getVentHCLpotisPumpeBr1().getVrednostiReg().setEnableOtvori(resultVentili[1110]);
        regeneracija.getVentHCLpotisPumpeBr1().getVrednostiReg().setEnableZatvori(resultVentili[1111]);
        regeneracija.getVentHCLpotisPumpeBr1().getVrednostiReg().setOtvoren(resultVentili[1112]);
        regeneracija.getVentHCLpotisPumpeBr1().getVrednostiReg().setZatvoren(resultVentili[1113]);
        
        regeneracija.getVentHCLusisPumpeBr2().getVrednostiReg().setEnableOtvori(resultVentili[1120]);
        regeneracija.getVentHCLusisPumpeBr2().getVrednostiReg().setEnableZatvori(resultVentili[1121]);
        regeneracija.getVentHCLusisPumpeBr2().getVrednostiReg().setOtvoren(resultVentili[1122]);
        regeneracija.getVentHCLusisPumpeBr2().getVrednostiReg().setZatvoren(resultVentili[1123]);
        
        regeneracija.getVentHCLpotisPumpeBr2().getVrednostiReg().setEnableOtvori(resultVentili[1130]);
        regeneracija.getVentHCLpotisPumpeBr2().getVrednostiReg().setEnableZatvori(resultVentili[1131]);
        regeneracija.getVentHCLpotisPumpeBr2().getVrednostiReg().setOtvoren(resultVentili[1132]);
        regeneracija.getVentHCLpotisPumpeBr2().getVrednostiReg().setZatvoren(resultVentili[1133]);
        
        regeneracija.getVentHCLzajednickiUsis().getVrednostiReg().setEnableOtvori(resultVentili[1140]);
        regeneracija.getVentHCLzajednickiUsis().getVrednostiReg().setEnableZatvori(resultVentili[1141]);
        regeneracija.getVentHCLzajednickiUsis().getVrednostiReg().setOtvoren(resultVentili[1142]);
        regeneracija.getVentHCLzajednickiUsis().getVrednostiReg().setZatvoren(resultVentili[1143]);
        
        regeneracija.getVentHCLzajednickiPotis().getVrednostiReg().setEnableOtvori(resultVentili[1150]);
        regeneracija.getVentHCLzajednickiPotis().getVrednostiReg().setEnableZatvori(resultVentili[1151]);
        regeneracija.getVentHCLzajednickiPotis().getVrednostiReg().setOtvoren(resultVentili[1152]);
        regeneracija.getVentHCLzajednickiPotis().getVrednostiReg().setZatvoren(resultVentili[1153]);
        //----------------------------------------------------------------------------------------------
        
        regeneracija.getVentNaOHusisPumpeBr1().getVrednostiReg().setEnableOtvori(resultVentili[1160]);
        regeneracija.getVentNaOHusisPumpeBr1().getVrednostiReg().setEnableZatvori(resultVentili[1161]);
        regeneracija.getVentNaOHusisPumpeBr1().getVrednostiReg().setOtvoren(resultVentili[1162]);
        regeneracija.getVentNaOHusisPumpeBr1().getVrednostiReg().setZatvoren(resultVentili[1163]);
        
        regeneracija.getVentNaOHpotisPumpeBr1().getVrednostiReg().setEnableOtvori(resultVentili[1170]);
        regeneracija.getVentNaOHpotisPumpeBr1().getVrednostiReg().setEnableZatvori(resultVentili[1171]);
        regeneracija.getVentNaOHpotisPumpeBr1().getVrednostiReg().setOtvoren(resultVentili[1172]);
        regeneracija.getVentNaOHpotisPumpeBr1().getVrednostiReg().setZatvoren(resultVentili[1173]);
        
        regeneracija.getVentNaOHusisPumpeBr2().getVrednostiReg().setEnableOtvori(resultVentili[1180]);
        regeneracija.getVentNaOHusisPumpeBr2().getVrednostiReg().setEnableZatvori(resultVentili[1181]);
        regeneracija.getVentNaOHusisPumpeBr2().getVrednostiReg().setOtvoren(resultVentili[1182]);
        regeneracija.getVentNaOHusisPumpeBr2().getVrednostiReg().setZatvoren(resultVentili[1183]);
        
        regeneracija.getVentNaOHpotisPumpeBr2().getVrednostiReg().setEnableOtvori(resultVentili[1190]);
        regeneracija.getVentNaOHpotisPumpeBr2().getVrednostiReg().setEnableZatvori(resultVentili[1191]);
        regeneracija.getVentNaOHpotisPumpeBr2().getVrednostiReg().setOtvoren(resultVentili[1192]);
        regeneracija.getVentNaOHpotisPumpeBr2().getVrednostiReg().setZatvoren(resultVentili[1193]);
        
        regeneracija.getVentNaOHzajednickiUsis().getVrednostiReg().setEnableOtvori(resultVentili[1200]);
        regeneracija.getVentNaOHzajednickiUsis().getVrednostiReg().setEnableZatvori(resultVentili[1201]);
        regeneracija.getVentNaOHzajednickiUsis().getVrednostiReg().setOtvoren(resultVentili[1202]);
        regeneracija.getVentNaOHzajednickiUsis().getVrednostiReg().setZatvoren(resultVentili[1203]);
        
        regeneracija.getVentNaOHzajednickiPotis().getVrednostiReg().setEnableOtvori(resultVentili[1210]);
        regeneracija.getVentNaOHzajednickiPotis().getVrednostiReg().setEnableZatvori(resultVentili[1211]);
        regeneracija.getVentNaOHzajednickiPotis().getVrednostiReg().setOtvoren(resultVentili[1212]);
        regeneracija.getVentNaOHzajednickiPotis().getVrednostiReg().setZatvoren(resultVentili[1213]);
        
    }
    
   


    private void getMerenja() {
        getProtociDemiLinije();
        getProtociNeutralna();
        getProtociFlokulacija();
        getProtociPescaniFilteri();
        getDemiLinijeMerenja();
        getRezervoariMerenja();
        getBazeniMerenja();
        getPescaniFilteriMerenja();
        getNeutralnaJonskaMerenja();
        getProtociPretovarnaRampa();
        getProtociRegenracija();
        write();
    }
    
    @Override
    public void run() {
        while (read) {
            getMerenja();
            getTemperature();
            getVentiliGrupaPumpi();                 //1
            getPolielektrolit();
            getFerihlorid(); 
            getVentiliPumpeKaPescanimFilterima();   
            getPescaniFilter1();        
            getPescaniFilter2();        
            getPescaniFilter3();        
            getPescaniFilter4();        
            getPescaniFilter5();        
            getPescaniFilter6();        
            getOtpadneVodeOdPescanihFiltera(); 
            getJonskaIzmena1();         
            getJonskaIzmena2();         
            getJonskaIzmena3();         
            getReaktor();
            write();
            getDemiLinija1JKKF();       //2
            getDemiLinija1SBAF();       
            getDemiLinija1JBAF();       
            getDemiLinija1MF();         
            getDemiLinija2JKKF();       
            getDemiLinija2SBAF();       
            getDemiLinija2JBAF();       
            getDemiLinija2MF();         
            getDemiLinija3JKKF();       
            getDemiLinija3SBAF();       
            getDemiLinija3JBAF();       
            getDemiLinija3MF();         
            getReaktoriMotori();                            //1
            getPumpeDekaFiltriranaKaDemi();                 
            getPumpeKaPescanimFilterima();                  
            getPumpeDekaFiltriraneKaNeutralnojIzmeni();     
            getPumpeOdpadnihVodaOdPranjaPescanihFiltera();  
            getPumpePolielektrolit();                       
            getPumpeFerihlorid();                           
            write();
            getPumpeZaPranjePescanihFiltera();              
            getPumpeNeutralizacionogBazena();               
            getDoziranje();                                 
            getRegeneracija();
        }
    }

    public void openConnection() {
        mxm.openConnection();
    }

    public void closeConnection() {
        mxm.closeConnection();
    }

    public boolean ping() {
        return mxm.ping();
    }
    
    public boolean isConnected(){
        return mxm.isConnected;
    }

    private void write() {
        if (writeDigital) {
            mxm.writeMX(offset, mxValue);
            writeDigital = false;
        }
        if (writeDigitals) {
            mxm.writeMX(offset, mxValues);
            writeDigitals = false;
        }
        if (writeRegister) {
            mxm.writeRegister(offset, registerValue);
            writeRegister = false;
        }
    }

}
