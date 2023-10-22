/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field.merenja.demiLinije;

import field.merenja.Merenja;

/**
 *
 * @author branko.scekic
 */
public class DemiLinijaMerenja {
    
    private final Merenja pritisakDLjkkfIn;
    private final Merenja pritisakDLjkkfOut;
    private final Merenja pritisakDLsbafIn;
    private final Merenja pritisakDLsbafOut;
    private final Merenja pritisakDLjbafIn;
    private final Merenja pritisakDLjbafOut;
    private final Merenja pritisakDLmfIn;
    private final Merenja pritisakDLmfOut;
    
    private final Merenja vodljivostSBA;
    private final Merenja vodljivostJBA;
    private final Merenja vodljivostMF;
    
    public DemiLinijaMerenja(int pritisakjkkIn,int pritisakjkkInmin, int pritisakjkkInmax, int brDecPjkkIn,
                             int pritisakjkkOut,int pritisakjkkOutmin, int pritisakjkkOutmax, int brDecPjkkOut,
                             int pritisaksbaIn,int pritisaksbaInmin, int pritisaksbaInmax, int brDecPsbaIn,
                             int pritisaksbaOut,int pritisaksbaOutmin, int pritisaksbaOutmax, int brDecPsbaOut,
                             int pritisakjbaIn,int pritisakjbaInmin, int pritisakjbaInmax, int brDecPjbaIn,
                             int pritisakjbaOut,int pritisakjbaOutmin, int pritisakjbaOutmax, int brDecPjbaOut,
                             int pritisakmfIn,int pritisakmfInmin, int pritisakmfInmax, int brDecPmfIn,
                             int pritisakmfOut,int pritisakmfOutmin, int pritisakmfOutmax, int brDecPmfOut,
                             
                             int vodljivostSBA,int vodljivostSBAMin, int vodljivostSBAMax, int brDecVodljivostSBA,
                             int vodljivostJBA,int vodljivostJBAMin, int vodljivostJBAMax, int brDecVodljivostJBA,
                             int vodljivostMF,int vodljivostMFMin, int vodljivostMFMax, int brDecVodljivostMF
                             ){
        
        this.pritisakDLjkkfIn = new Merenja(pritisakjkkIn, pritisakjkkInmin, pritisakjkkInmax, brDecPjkkIn);
        this.pritisakDLjkkfOut = new Merenja(pritisakjkkOut, pritisakjkkOutmin, pritisakjkkOutmax, brDecPjkkOut);
        this.pritisakDLsbafIn = new Merenja(pritisaksbaIn, pritisaksbaInmin, pritisaksbaInmax, brDecPsbaIn);
        this.pritisakDLsbafOut = new Merenja(pritisaksbaOut, pritisaksbaOutmin, pritisaksbaOutmax, brDecPsbaOut);
        this.pritisakDLjbafIn = new Merenja(pritisakjbaIn, pritisakjbaInmin, pritisakjbaInmax, brDecPjbaIn);
        this.pritisakDLjbafOut = new Merenja(pritisakjbaOut, pritisakjbaOutmin, pritisakjbaOutmax, brDecPsbaOut);
        this.pritisakDLmfIn = new Merenja(pritisakmfIn, pritisakmfInmin, pritisakmfInmax, brDecPmfIn);
        this.pritisakDLmfOut = new Merenja(pritisakmfOut, pritisakmfOutmin, pritisakmfOutmax, brDecPmfOut);
        this.vodljivostSBA = new Merenja(vodljivostSBA, vodljivostSBAMin, vodljivostSBAMax, brDecVodljivostSBA);
        this.vodljivostJBA = new Merenja(vodljivostJBA, vodljivostJBAMin, vodljivostJBAMax, brDecVodljivostJBA);
        this.vodljivostMF = new Merenja(vodljivostMF, vodljivostMFMin, vodljivostMFMax, brDecVodljivostMF);
    }

    public Merenja getPritisakDLjkkfIn() {
        return pritisakDLjkkfIn;
    }

    public Merenja getPritisakDLjkkfOut() {
        return pritisakDLjkkfOut;
    }

    public Merenja getPritisakDLsbafIn() {
        return pritisakDLsbafIn;
    }

    public Merenja getPritisakDLsbafOut() {
        return pritisakDLsbafOut;
    }

    public Merenja getPritisakDLjbafIn() {
        return pritisakDLjbafIn;
    }

    public Merenja getPritisakDLjbafOut() {
        return pritisakDLjbafOut;
    }

    public Merenja getPritisakDLmfIn() {
        return pritisakDLmfIn;
    }

    public Merenja getPritisakDLmfOut() {
        return pritisakDLmfOut;
    }

    public Merenja getVodljivostSBA() {
        return vodljivostSBA;
    }

    public Merenja getVodljivostJBA() {
        return vodljivostJBA;
    }

    public Merenja getVodljivostMF() {
        return vodljivostMF;
    }

    
}
