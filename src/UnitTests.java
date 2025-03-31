import command.konzole.Konzole;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    Konzole konzole;

    @org.junit.jupiter.api.BeforeEach
    void init() {
        this.konzole = new Konzole();

    }

    @org.junit.jupiter.api.Test
    void overeniFunkcnostiTestovaniTridy() {
        assertEquals(1, 1);
    }

    @org.junit.jupiter.api.Test
    void overeniVytvoreniKonzole() {
        assertNotNull(konzole);
    }

    //TODO: S timhle neco vymyslet, protoze to bude potreba, ale zatim jak presne to udelat
    @org.junit.jupiter.api.Test
    void overeniSpusteniKonzole() {
        konzole.start();
    }

    @org.junit.jupiter.api.Test
    void overeniVytvoreniHrace() {
        assertNotNull(konzole.getHrac());
    }
}
