package player;

import java.util.Scanner;

/**
 * Třída reprezentující quest (úkol) v ředitelně, který se spustí, když hráč
 * je přistižen šatnářem s kontrabandem.
 */
public class QuestReditelna {

    private Hrac hrac;
    private Scanner sc;

    /**
     * Vytvoří novou instanci questu v ředitelně.
     *
     * @param sc   Scanner pro čtení vstupu od hráče
     * @param hrac Hráč, který bude potrestán
     */
    public QuestReditelna(Scanner sc, Hrac hrac) {
        this.sc = sc;
        this.hrac = hrac;
        spustitQuest();
    }

    /**
     * Spustí interakci s ředitelem a potrestá hráče.
     */
    private void spustitQuest() {
        System.out.println("> Ředitel: Hele koho to tu máme! (stiskni enter pro pokračování)");
        sc.nextLine();

        System.out.println("> Ředitel: Tak ty se tu budeš poflakovat a krást školní vybavení?");
        sc.nextLine();

        System.out.println("> Ředitel: Všechno ti zabavím a ještě dostaneš důtku!");
        sc.nextLine();

        // Ztráta peněz jako pokuta
        int pokuta = hrac.getInventar().getPenize() / 2;
        hrac.getInventar().addPenize(hrac.getInventar().getPenize() - pokuta);

        System.out.println("> Ředitel zabavil všechny tvoje ukradené předměty!");
        System.out.println("> Zaplatil jsi pokutu " + pokuta + " Kč");
        System.out.println("> Prohrál jsi a hra končí.");
        sc.nextLine();

        sc.close();
        System.exit(0);
    }
}

