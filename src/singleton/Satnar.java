package singleton;

import observer.Observer;
import player.Hrac;

public class Satnar implements Observer {
    private boolean podezreni = false;

    private Hrac hrac;

    public Satnar(Hrac hrac) {
        this.hrac = hrac;
    }

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

    public boolean maPodezreni() {
        return podezreni;
    }
}
