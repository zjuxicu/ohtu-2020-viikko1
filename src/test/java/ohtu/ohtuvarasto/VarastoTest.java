package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiLaittaaNega() {
        varasto.lisaaVarastoon(-100);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);

    }
    @Test
    public void eiVoiOttaaNega(){
        varasto.otaVarastosta(-100);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiLaittaaLiikaa() {
        varasto.lisaaVarastoon(100);
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);

    }
    @Test
    public void eiVoiOttaaLiikaa(){
        varasto.otaVarastosta(100);
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void vaaraVarast(){
        Varasto v = new Varasto(-3);
        assertEquals(0, v.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void customVarastoHetiTaysi(){
        Varasto cv = new Varasto(10,10);
        assertEquals(0, cv.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void customVarastoVaara(){
        Varasto va = new Varasto(-1, 3);
        assertEquals(0, va.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void tulostusSkulaa(){
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }    
    @Test
    public void alkuSaldoNeg(){
        Varasto b = new Varasto(10, -2);
        assertEquals(0, b.getSaldo(), vertailuEpaTarkkuus);
    }
}