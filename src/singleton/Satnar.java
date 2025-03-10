package singleton;

import observer.Observer;

public class Satnar implements Observer {
    private boolean podezreni = false;

    @Override
    public void update(String event) {
        switch (event) {
            case "nahodnaProhlidka":
                if (podezreni) {
                    inventar.zkontrolovatInventar(); //TODO: Opravit parsovani teto metody
                } else {
                    System.out.println("Šatnář: Hej! Co to tam máš.");
                }

            case "neprezuto":
                podezreni = true;
                break;

            case "prezuto":
                podezreni = false;
                break;

            default:
                break;
        }
    }

    public boolean maPodezreni() {
        return podezreni;
    }
}
