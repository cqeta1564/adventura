package command;

import item.Item;
import item.ItemFactory;
import player.Hrac;
import singleton.Mistnost;

import java.util.Random;
import java.util.Scanner;

public class Krast extends Command {

    private static final Random random = new Random();

    @Override
    public String execute(Hrac hrac, Mistnost currentMistnost, Scanner scanner) {
        // Možnost krádeže je dostupná jen v určitých místnostech
        if (!isStealAllowed(currentMistnost)) {
            return "Zde není co ukrást.\n";
        }

        System.out.println("Chceš ukrást něco? (ano/ne)");
        String odpoved = scanner.nextLine().trim().toLowerCase();
        if (!odpoved.equals("ano")) {
            return "Rozmyslel sis to.\n";
        }

        if (random.nextInt(100) < 30) { // 30% šance, že hráč bude přistižen
            return "Byl jsi přistižen při krádeži! Šatnář má podezření.\n";
        }

        Item ukradenyItem = ItemFactory.createItem("cigarety"); // Lze rozšířit o různé předměty
        hrac.getInventar().addItem(ukradenyItem);
        return "Ukradl jsi: " + ukradenyItem.getNazev() + "\n";
    }

    private boolean isStealAllowed(Mistnost mistnost) {
        return mistnost.getName().equals("sklad") || mistnost.getName().equals("trida") || mistnost.getName().equals("chodba");
    }

    @Override
    public Mistnost move(Mistnost currentMistnost, String nextMistnostName) {
        return currentMistnost;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
