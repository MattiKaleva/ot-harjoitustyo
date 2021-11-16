package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void uudellaPaatteellaOikeaMaaraRahaa() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void uudellaPaatteellaOikeaMaaraMyytyjaEdullisiaLounaita() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void uudellaPaatteellaOikeaMaaraMyytyjaMaukkaitaLounaita() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kassanSaldoKasvaaOikeinEdullisenLounaanKateisostolla() {
        paate.syoEdullisesti(500);
        assertEquals(100240, paate.kassassaRahaa());
    }

    @Test
    public void edullisenLounaanKateisostoAntaaOikeanVaihtorahan() {
        assertEquals(260, paate.syoEdullisesti(500));
    }

    @Test
    public void edullisenLounaanKateisostoKasvattaaMyytyjenMaaraa() {
        paate.syoEdullisesti(500);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void riittamatonKateisostoEiKasvataMyytyjenEdullistenLounaidenMaaraa() {
        paate.syoEdullisesti(10);
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void riittamatonEdullisenLounaanKateisostoEiMuutaKassanSaldoa() {
        paate.syoEdullisesti(10);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void riittamatonEdullisenLounaanKateisostoPalauttaaKaikkiRahat() {
        assertEquals(10, paate.syoEdullisesti(10));
    }

    @Test
    public void kassanSaldoKasvaaOikeinMaukkaanLounaanKateisostolla() {
        paate.syoMaukkaasti(1000);
        assertEquals(100400, paate.kassassaRahaa());
    }

    @Test
    public void maukkaanLounaanKateisostoAntaaOikeanVaihtorahan() {
        assertEquals(600, paate.syoMaukkaasti(1000));
    }

    @Test
    public void maukkaanLounaanKateisostoKasvattaaMyytyjenMaaraa() {
        paate.syoMaukkaasti(1000);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void riittamatonKateisostoEiKasvataMyytyjenMaukkaidenLounaidenMaaraa() {
        paate.syoMaukkaasti(10);
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void riittamatonMaukkaanLounaanKateisostoEiMuutaKassanSaldoa() {
        paate.syoMaukkaasti(10);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void riittamatonMaukkaanLounaanKateisostoPalauttaaKaikkiRahat() {
        assertEquals(10, paate.syoMaukkaasti(10));
    }

    @Test
    public void edullisenLounaanKorttiostoPalauttaaTrue() {
        assertTrue(paate.syoEdullisesti(kortti));
    }

    @Test
    public void maukkaanLounaanKorttiostoPalauttaaTrue() {
        assertTrue(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void edullisenLounaanKorttiostoVeloittaaKortiltaOikeanSumman() {
        paate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void maukkaanLounaanKorttiostoVeloittaaKortiltaOikeanSumman() {
        paate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void edullisenLounaanKorttiostoKasvattaaMyytyjenMaaraa() {
        paate.syoEdullisesti(kortti);
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaanLounaanKorttiostoKasvattaaMyytyjenMaaraa() {
        paate.syoMaukkaasti(kortti);
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void metodiPalauttaaFalseJosKortillaEiVaraaEdulliseenLounaaseen() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertFalse(paate.syoEdullisesti(kortti));
    }

    @Test
    public void metodiPalauttaaFalseJosKortillaEiVaraaMaukkaaseenLounaaseen() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertFalse(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void korttiaEiVeloitetaJosRahatEivatRiitaEdulliseenLounaaseen() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);

        assertEquals(200, kortti.saldo());
    }

    @Test
    public void korttiaEiVeloitetaJosRahatEivatRiitaMaukkaaseenLounaaseen() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertEquals(200, kortti.saldo());
    }

    @Test
    public void myytyjenEdullistenLounaidenMaaraMuuttumatonRiittamattomallaKorttiostolla() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);

        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void myytyjenMaukkaidenLounaidenMaaraMuuttumatonRiittamattomallaKorttiostolla() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void metodiPalauttaaFalseRiittamattomallaEdullisenLounaanKorttiostolla() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertFalse(paate.syoEdullisesti(kortti));
    }

    @Test
    public void metodiPalauttaaFalseRiittamattomallaMaukkaanLounaanKorttiostolla() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);

        assertFalse(paate.syoMaukkaasti(kortti));
    }

    @Test
    public void kassanRahamaaraEiMuutuEdullisenLounaanKorttiostolla() {
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void kassanRahamaaraEiMuutuMaukkaanLounaanKorttiostolla() {
        paate.syoMaukkaasti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void kortinSaldoaLadattaessaKortinSaldoKasvaa() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(1100, kortti.saldo());
    }

    @Test
    public void kassanRahamaaraKasvaaKortilleSaldoaLadattaessa() {
        paate.lataaRahaaKortille(kortti, 100);
        assertEquals(100100, paate.kassassaRahaa());
    }

    @Test
    public void negatiivinenSummaEiLataaKortilleRahaa() {
        paate.lataaRahaaKortille(kortti, -10);
        assertEquals(1000, kortti.saldo());
    }

}