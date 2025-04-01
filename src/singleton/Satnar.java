package singleton;

import observer.Observer;
import player.Hrac;

/**
 * Třída Satnar reprezentuje školního šatnáře, který sleduje hráče a reaguje na určité události.
 * Implementuje rozhraní Observer pro sledování akcí hráče.
 */
public class Satnar implements Observer {
    private boolean podezreni = false;

    private Hrac hrac;

    /**
     * Vytvoří instanci šatnáře a přiřadí mu referenci na hráče.
     *
     * @param hrac Hráč, kterého šatnář sleduje.
     */
    public Satnar(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Reaguje na události ve hře.
     * Pokud hráč krade nebo vstoupí do chodby, šatnář provede kontrolu.
     *
     * @param event Název události (např. "kradez" nebo "chodba").
     */
    @Override
    public void update(String event) {
        switch (event) { //projistotu nechavam rozdelene pro budouci vyvoj
            case "kradez":
                kontrola();
                break;

            case "chodba":
                kontrola();
                break;

            default:
                System.out.println("Pokud tohle vidis, je neco spatne :(");
                break;
        }
    }

    /**
     * Provede kontrolu inventáře hráče.
     * Pokud už bylo dříve podezření, šatnář prohledá hráčův inventář a může ho poslat k řediteli.
     * Jinak si šatnář hráče pouze zapamatuje jako podezřelého.
     */
    private void kontrola() {
        if (podezreni) {
            if (this.hrac.getInventar().zkontrolovatInventar()) {
                System.out.println(">Šatnář: A mám tě! Tohle ti zabavím a padej za ředitelem.");
                this.hrac.setQuestReditelna(true);
            } else {
                System.out.println(">Šatnář: Tentokrát si měl štěstí, ale příště ho mít nebudeš.");
            }

        } else {
            System.out.println(">Šatnář na tebe má teď podezření");
            podezreni = true; //priste budeme kontrolovat inventar
        }
    }

    /**
     * Zjistí, zda má šatnář podezření na hráče.
     *
     * @return `true`, pokud má šatnář podezření, jinak `false`.
     */
    public boolean maPodezreni() {
        return podezreni;
    }
}
