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
    public void kortinSaldoOnOikein() {
        assertEquals(10, kortti.saldo());
    }
    @Test
    public void kortinSaldoKasvaaOikein() {
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());
    }

    @Test
    public void saldoVaheneeOikeanMaaran() {
        kortti.otaRahaa(4);
        assertEquals(6, kortti.saldo());
    }

    @Test
    public void saldoEiMuutuJosOtetaanLiikaa() {
        kortti.otaRahaa(20);
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void trueJosRahaaRiittaa() {
        assertEquals(true, kortti.otaRahaa(6));
    }

    @Test
    public void falseJosRahaaEiTarpeeksi() {
        assertEquals(false, kortti.otaRahaa(20));
    }
}
