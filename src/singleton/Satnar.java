package singleton;

import observer.Observer;

public class Satnar implements Observer {
    private boolean podezreni = false;

    @Override
    public void update(String event) {
        if (event.equals("kradez")) {
            podezreni = true;
            System.out.println("Šatnář: Vidím, že tu někdo krade!");
        }
    }

    public boolean maPodezreni() {
        return podezreni;
    }
}
