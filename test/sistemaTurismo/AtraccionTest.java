package sistemaTurismo;

import static org.junit.Assert.*;

import org.junit.AssumptionViolatedException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AtraccionTest {
    Atraccion atraccionMoria = new Atraccion("Moira", 10, 2, 6, TipoDeAtraccion.AVENTURA);
    Atraccion atraccionMinasTirith = new Atraccion("Minar Tirith", 5, 2.5, 25, TipoDeAtraccion.PAISAJE);
    Atraccion atraccionLaComarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoDeAtraccion.DEGUSTACION);
    Atraccion atraccionMordor = new Atraccion("Mordor", 25, 3, 4, TipoDeAtraccion.AVENTURA);
    Atraccion atraccionAbismoDeHelm = new Atraccion("Abismo de Helm", 5, 2, 15, TipoDeAtraccion.PAISAJE);
    Atraccion atraccionLothlorien = new Atraccion("Lothorien", 35, 1, 30, TipoDeAtraccion.DEGUSTACION);
    Atraccion atraccionErebor = new Atraccion("Erbor", 12, 3, 32, TipoDeAtraccion.PAISAJE);
    Atraccion atraccionBosqueNegro = new Atraccion("Bosque Negro", 3, 4, 12, TipoDeAtraccion.AVENTURA);


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









}