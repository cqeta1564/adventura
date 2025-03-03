import command.konzole.Konzole;

public class Hra {
    private Svet svet;
    public Mistnost currentMistnost;
    private Konzole konzole;

    public Hra() {
        SvetLoader.loadWorld(); //Za pomoci SvetLoaderu nacteme svet

        svet = Svet.getInstance(); //Vpiseme nacteny svet do Svetu
        currentMistnost = svet.getRoom("venku"); //Zacneme ve mistnosti "venku"

        konzole = new Konzole();
        konzole.start();
    }


}
