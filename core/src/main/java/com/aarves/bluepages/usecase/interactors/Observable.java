package com.aarves.bluepages.usecase.interactors;

public interface Observable<T> {
    void addObserver(Observer<T> observer);
    void deleteObserver(Observer<T> observer);
    void clearObservers();

    void notifyObservers();
}
