import command.konzole.Konzole;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Třída obsahující unit testy.
 */
public class UnitTests {

    /**
     * Instance třídy Konzole pro testování.
     */
    Konzole konzole;

    /**
     * Inicializace instance konzole před každým testem.
     */
    @org.junit.jupiter.api.BeforeEach
    void init() {
        this.konzole = new Konzole();
    }

    /**
     * Ověření základní funkčnosti testovacího frameworku.
     */
    @org.junit.jupiter.api.Test
    void overeniFunkcnostiTestu() {
        assertEquals(1, 1);
    }

    /**
     * Ověření, zda metoda getUlozPrikaz vrací očekávanou hodnotu.
     */
    @org.junit.jupiter.api.Test
    void overeniUlozPrikaz() {
        assertTrue(konzole.getUlozPrikaz(""));
    }

    /**
     * Ověření správné inicializace světa.
     */
    @org.junit.jupiter.api.Test
    void overeniInicializaceSveta() {
        assertTrue(konzole.getInicializaceSveta());
    }

    /**
     * Ověření správné inicializace objektů.
     */
    @org.junit.jupiter.api.Test
    void overeniInicializaceObjektu() {
        assertTrue(konzole.getInicializaceObjektu());
    }

    /**
     * Ověření správné inicializace příkazů.
     */
    @org.junit.jupiter.api.Test
    void overeniInicializacePrikazu() {
        assertTrue(konzole.getInicializacePrikazu());
    }

    /**
     * Ověření správné inicializace historie příkazů.
     */
    @org.junit.jupiter.api.Test
    void overeniInicializaceHistoriePrikazu() {
        assertTrue(konzole.getInicializaceHistoriePrikazu());
    }

// Nelze overit z duvodu neinicializovaneho scanneru. Tato funkce probiha v private metode
//    @org.junit.jupiter.api.Test
//    void overeniZiskatText() {
//        assertEquals("", konzole.getZiskatText());
//    }

    /**
     * Ověření normalizace textu - odstranění mezer a převedení na malá písmena.
     */
    @org.junit.jupiter.api.Test
    void overeniNormalizovatText() {
        assertEquals("test123 a b c 214d", konzole.getNormalizovatText("  test123 A b C 214D  "));
    }

    /**
     * Ověření rozdělení textu na jednotlivá slova.
     */
    @org.junit.jupiter.api.Test
    void overeniRozdelitText() {
        String[] expected = {"test123", "a", "b", "c", "214d"};
        String[] actual = konzole.getRozdelitText("test123 a b c 214d");
        assertArrayEquals(expected, actual);
    }
}
