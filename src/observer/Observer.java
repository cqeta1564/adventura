package observer;

/**
 * Rozhraní pro pozorovatele v návrhovém vzoru Observer.
 * Objekty implementující toto rozhraní mohou reagovat na oznámené události.
 */
public interface Observer {

    /**
     * Metoda volaná při oznámení události.
     *
     * @param event Název události, na kterou má pozorovatel reagovat.
     */
    void update(String event);
}
