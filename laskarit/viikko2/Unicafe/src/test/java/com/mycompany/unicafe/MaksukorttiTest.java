package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);

        assertEquals(20, kortti.saldo());
    }

    @Test
    public void saldoVaheneeJosRahaaTarpeeksi() {
        kortti.otaRahaa(3);

        assertEquals(7, kortti.saldo());
    }

    @Test
    public void saldoEiMuutuJosNostetaanLiikaa() {
        kortti.otaRahaa(20);

        assertEquals(10, kortti.saldo());
    }

    @Test
    public void trueJosRahatRiittavat() {
        assertEquals(true, kortti.otaRahaa(4));
    }

    @Test
    public void falseJosRahaaEiTarpeeksi() {
        assertEquals(false, kortti.otaRahaa(20));
    }

    @Test
    public void toStringMetodillaOikeaTulostus() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
