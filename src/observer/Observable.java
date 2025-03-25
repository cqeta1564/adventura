package observer;

import player.Hrac;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    //TODO: Propojit tuto metodu s pruchodem pres mistnost "chodba" a pridat nahodne sance na kontrolu
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
