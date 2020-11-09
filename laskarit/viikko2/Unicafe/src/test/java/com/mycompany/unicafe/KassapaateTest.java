package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    @Before
    public void setUp(){paate = new Kassapaate(); kortti = new Maksukortti(1000);}

    @Test
    public void konstruktoriAsettaaOikeanRahamaaran() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void uudessaPaatteessaEiMyytyjaEdullisiaLounaita() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void uudessaPaatteessaEiMyytyjaMaukkaitaLounaita() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullinenKateisostoVahentaaPaatteenSaldoaOikein() {
        paate.syoEdullisesti(300);
        assertEquals(100240, paate.kassassaRahaa());
    }

    @Test
    public void edullinenKateisostoPalauttaaOikeanVaihtorahan() {assertEquals(60, paate.syoEdullisesti(300));}

    @Test
    public void kateisostoKasvattaaMyytyjenLounaidenMaaraa() {
        paate.syoEdullisesti(240);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukasKateisostoVahentaaPaatteenSaldoaOikein() {
        paate.syoMaukkaasti(500);
        assertEquals(100400, paate.kassassaRahaa());
    }

    @Test
    public void maukasKateisostoPalauttaaOikeanVaihtorahan() {assertEquals(60, paate.syoMaukkaasti(460));}

    @Test
    public void maukasKateisostoKasvattaaMyytyjenLounaidenMaaraa() {
        paate.syoMaukkaasti(500);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void riittamatonEdullinenMaksuPalauttaaRahat(){assertEquals(50, paate.syoEdullisesti(50));}

    @Test
    public void riittamatonMaukasMaksuPalauttaaRahat(){assertEquals(50, paate.syoMaukkaasti(50));}

    @Test
    public void riittamatonEdullinenMaksuEiMuutaMyytyjaLounaita(){
        paate.syoEdullisesti(50);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void riittamatonMaukasMaksuEiMuutaMyytyjaLounaita() {
        paate.syoMaukkaasti(50);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void edullinenKorttimaksaminenVahentaaKortinSaldoa() {
        paate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void onnistunutEdullinenKorttimaksaminenPalauttaaTrue(){assertEquals(true, paate.syoEdullisesti(kortti));}

    @Test
    public void edullinenKorttimaksuLisaaMyytyjenLounaidenMaaraa(){
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void riittamatonSaldoPalauttaaFalseEdullisellaOstolla() {
        Maksukortti eiSaldoa = new Maksukortti(0);
        assertEquals(false, paate.syoEdullisesti(eiSaldoa));
    }

    @Test
    public void maukasKorttimaksaminenVahentaaKortinSaldoa() {
        paate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void onnistunutMaukasKorttimaksaminenPalauttaaTrue(){assertEquals(true, paate.syoMaukkaasti(kortti));}

    @Test
    public void maukasKorttimaksuLisaaMyytyjenLounaidenMaaraa(){
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void riittamatonSaldoPalauttaaFalseMaukkaallaOstolla() {
        Maksukortti eiSaldoa = new Maksukortti(0);
        assertEquals(false, paate.syoMaukkaasti(eiSaldoa));
    }

    @Test
    public void negatiivisenSummanLataaminenEiMuutaPaatteenSaldoa() {
        paate.lataaRahaaKortille(kortti, -40);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void negatiivisenSummanLataaminenEiMuutaKortinSaldoa() {
        paate.lataaRahaaKortille(kortti, -40);
        assertEquals(1000, kortti.saldo());
    }

    @Test
    public void rahanLataaminenLisaaPaatteenSaldoa() {
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, paate.kassassaRahaa());
    }

    @Test
    public void rahanLataaminenLisaaKortinSaldoa() {
        paate.lataaRahaaKortille(kortti, 1000);
        assertEquals(2000, kortti.saldo());
    }

}
