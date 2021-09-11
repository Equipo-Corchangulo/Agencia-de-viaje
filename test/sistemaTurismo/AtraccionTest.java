package sistemaTurismo;

import static org.junit.Assert.*;

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
    public void compareToTest() {
    	
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