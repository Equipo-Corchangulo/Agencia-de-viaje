package sistemaTurismo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class AtraccionTest {
    Atraccion atraccionMoria = new Atraccion("Aventura", 10, 2, 6, TipoDeAtraccion.AVENTURA,0);
    Atraccion atraccionMinasTirith = new Atraccion("Paisaje", 5, 2.5, 25, TipoDeAtraccion.PAISAJE,1);
    Atraccion atraccionLaComarca = new Atraccion("Degustacion", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION,2);
    Atraccion atraccionMordor = new Atraccion("Aventura", 25, 3, 4, TipoDeAtraccion.AVENTURA,3);
    Atraccion atraccionAbismoDeHelm = new Atraccion("Paisaje", 5, 2, 15, TipoDeAtraccion.PAISAJE,4);
    Atraccion atraccionLothlorien = new Atraccion("Degustacion", 35, 1, 30, TipoDeAtraccion.DEGUSTACION,5);
    Atraccion atraccionErebor = new Atraccion("Paisaje", 12, 3, 32, TipoDeAtraccion.PAISAJE,6);
    Atraccion atraccionBosqueNegro = new Atraccion("Aventura", 3, 4, 12, TipoDeAtraccion.AVENTURA,7);

    public List<Facturable> promoP1 = new ArrayList<Facturable>();
    public List<Facturable> promoP2 = new ArrayList<Facturable>();
    public List<Facturable> promoP3 = new ArrayList<Facturable>();
    
    PromoAbsoluta p1 = new PromoAbsoluta(promoP1, TipoDeAtraccion.AVENTURA, "Promocion Absoluta", 10);
    PromoPorcentual p2 = new PromoPorcentual(promoP2, TipoDeAtraccion.AVENTURA, "Pack Aventura", 30);
	PromoAxB p3 = new PromoAxB(promoP3, TipoDeAtraccion.AVENTURA, "Promo AxB", atraccionErebor);

    @Test
    public void crearAtraccion() {
        assertNotNull(atraccionMoria);
        assertNotNull(atraccionMinasTirith);
        assertNotNull(atraccionLaComarca);
        assertNotNull(atraccionMordor);
        assertNotNull(atraccionAbismoDeHelm);
        assertNotNull(atraccionLothlorien);
        assertNotNull(atraccionErebor);
        assertNotNull(atraccionBosqueNegro);
    }

    @Test
    public void obtenerCostoTotalTest() {
        assertEquals(10, atraccionMoria.obtenerCostoTotal(),0);
        assertEquals(5, atraccionMinasTirith.obtenerCostoTotal(),0);
        assertEquals(3, atraccionLaComarca.obtenerCostoTotal(),0);
        assertEquals(25, atraccionMordor.obtenerCostoTotal(),0);
        assertEquals(5, atraccionAbismoDeHelm.obtenerCostoTotal(),0);
        assertEquals(35, atraccionLothlorien.obtenerCostoTotal(),0);
        assertEquals(12, atraccionErebor.obtenerCostoTotal(),0);
        assertEquals(3, atraccionBosqueNegro.obtenerCostoTotal(),0);
    }
    
    @Test
    public void obtenerTiempoTotalTest() {
        assertEquals(2, atraccionMoria.obtenerTiempoTotal(),0);
        assertEquals(2.5, atraccionMinasTirith.obtenerTiempoTotal(),0);
        assertEquals(6.5, atraccionLaComarca.obtenerTiempoTotal(),0);
        assertEquals(3, atraccionMordor.obtenerTiempoTotal(),0);
        assertEquals(2, atraccionAbismoDeHelm.obtenerTiempoTotal(),0);
        assertEquals(1, atraccionLothlorien.obtenerTiempoTotal(),0);
        assertEquals(3, atraccionErebor.obtenerTiempoTotal(),0);
        assertEquals(4, atraccionBosqueNegro.obtenerTiempoTotal(),0);
    }

    @Test
    public void hayCupoTest() {
        assertTrue(atraccionMoria.hayCupo());
        assertTrue(atraccionMinasTirith.hayCupo());
        assertTrue(atraccionLaComarca.hayCupo());
        assertTrue(atraccionMordor.hayCupo());
        assertTrue(atraccionAbismoDeHelm.hayCupo());
        assertTrue(atraccionLothlorien.hayCupo());
        assertTrue(atraccionErebor.hayCupo());
        assertTrue(atraccionBosqueNegro.hayCupo());
    }

    @Test
    public void restarCupoTest() {
        atraccionMoria.restarCupo();
    	assertEquals(5, atraccionMoria.getCupo());
    	atraccionMinasTirith.restarCupo();
        assertEquals(24, atraccionMinasTirith.getCupo());
        atraccionLaComarca.restarCupo();
        assertEquals(149, atraccionLaComarca.getCupo());
        atraccionMordor.restarCupo();
        assertEquals(3, atraccionMordor.getCupo());
        atraccionAbismoDeHelm.restarCupo();
        assertEquals(14, atraccionAbismoDeHelm.getCupo());
        atraccionLothlorien.restarCupo();
        assertEquals(29, atraccionLothlorien.getCupo());
        atraccionErebor.restarCupo();
        assertEquals(31, atraccionErebor.getCupo());
        atraccionBosqueNegro.restarCupo();
        assertEquals(11, atraccionBosqueNegro.getCupo());
    }
    
    @Test
    public void getCupoTest() {
        assertEquals(6, atraccionMoria.getCupo(),0);
        assertEquals(25, atraccionMinasTirith.getCupo(),0);
        assertEquals(150, atraccionLaComarca.getCupo(),0);
        assertEquals(4, atraccionMordor.getCupo(),0);
        assertEquals(15, atraccionAbismoDeHelm.getCupo(),0);
        assertEquals(30, atraccionLothlorien.getCupo(),0);
        assertEquals(32, atraccionErebor.getCupo(),0);
        assertEquals(12, atraccionBosqueNegro.getCupo(),0);
    }
    
    @Test
    public void getTipoTest() {    	
    	assertEquals(TipoDeAtraccion.AVENTURA, atraccionMoria.getTipo());
    	assertEquals(TipoDeAtraccion.PAISAJE, atraccionMinasTirith.getTipo());
    	assertEquals(TipoDeAtraccion.DEGUSTACION, atraccionLaComarca.getTipo());
    	assertEquals(TipoDeAtraccion.AVENTURA, atraccionMordor.getTipo());
    	assertEquals(TipoDeAtraccion.PAISAJE, atraccionAbismoDeHelm.getTipo());
    	assertEquals(TipoDeAtraccion.DEGUSTACION, atraccionLothlorien.getTipo());
    	assertEquals(TipoDeAtraccion.PAISAJE, atraccionErebor.getTipo());
    	assertEquals(TipoDeAtraccion.AVENTURA, atraccionBosqueNegro.getTipo());
    }
    
    @Test
    public void seEncuentraEnElFacturableTest() {
    	/*****Testea si las promociones se encuentran en Facturable*****/
    	
    	promoP1.add(atraccionMoria);
    	promoP1.add(atraccionBosqueNegro);
    	assertTrue(atraccionMoria.seEncuentraEnElFacturable(p1));
    	assertFalse(atraccionAbismoDeHelm.seEncuentraEnElFacturable(p1));
    	
    	promoP2.add(atraccionAbismoDeHelm);
    	promoP2.add(atraccionLaComarca);
    	assertTrue(atraccionLaComarca.seEncuentraEnElFacturable(p2));
    	assertFalse(atraccionMoria.seEncuentraEnElFacturable(p2));
    	
    	promoP3.add(atraccionLothlorien);
    	promoP3.add(atraccionMordor);
    	assertTrue(atraccionMordor.seEncuentraEnElFacturable(p3));
    	assertTrue(atraccionErebor.seEncuentraEnElFacturable(p3));
    	assertFalse(atraccionLaComarca.seEncuentraEnElFacturable(p3));

    	
    	/*****Testea si las atracciones se encuentran en Facturable*****/
    	
    	assertTrue(atraccionMoria.seEncuentraEnElFacturable(atraccionMoria));
    	assertTrue(atraccionMinasTirith.seEncuentraEnElFacturable(atraccionMinasTirith));
    	assertTrue(atraccionLaComarca.seEncuentraEnElFacturable(atraccionLaComarca));
    	assertTrue(atraccionMordor.seEncuentraEnElFacturable(atraccionMordor));
    	assertTrue(atraccionAbismoDeHelm.seEncuentraEnElFacturable(atraccionAbismoDeHelm));
    	assertTrue(atraccionLothlorien.seEncuentraEnElFacturable(atraccionLothlorien));
    	assertTrue(atraccionErebor.seEncuentraEnElFacturable(atraccionErebor));
    	assertTrue(atraccionBosqueNegro.seEncuentraEnElFacturable(atraccionBosqueNegro));
    }

    @Test
    public void esPromocionTest() {
    	 assertFalse(atraccionMoria.esPromocion());
    	 assertFalse(atraccionMinasTirith.esPromocion());
    	 assertFalse(atraccionLaComarca.esPromocion());
    	 assertFalse(atraccionMordor.esPromocion());
    	 assertFalse(atraccionAbismoDeHelm.esPromocion());
    	 assertFalse(atraccionLothlorien.esPromocion());
    	 assertFalse(atraccionErebor.esPromocion());
    	 assertFalse(atraccionBosqueNegro.esPromocion());
    }
}
