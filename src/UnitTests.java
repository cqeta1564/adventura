import command.konzole.Konzole;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    Konzole konzole;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        this.konzole = new Konzole();

    }

    @org.junit.jupiter.api.Test
    void overeniFunkcnostiTestu() {
        assertEquals(1, 1);
    }

    @org.junit.jupiter.api.Test
    void overeniUlozPrikaz() {
        konzole.getUlozPrikaz("");
    }

    @org.junit.jupiter.api.Test
    void overeniInicializaceSveta() {
        konzole.getInicializaceSveta();
    }

    @org.junit.jupiter.api.Test
    void overeniInicializaceObjektu() {
        konzole.getInicializaceObjektu();
    }

    @org.junit.jupiter.api.Test
    void overeniInicializacePrikazu() {
        konzole.getInicializacePrikazu();
    }

    @org.junit.jupiter.api.Test
    void overeniInicializaceHistoriePrikazu() {
        konzole.getInicializaceHistoriePrikazu();
    }
}
