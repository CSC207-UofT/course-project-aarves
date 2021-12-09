package com.aarves.bluepages.usecase.interactors;

/**
 * Interface for observable in observer design pattern
 * @param <T> the argument to be passed into observers when updating
 */
public interface Observable<T> {
    /**
     * Add given observer.
     * @param observer the observer to be added
     */
    void addObserver(Observer<T> observer);

    /**
     * Delete given observer.
     * @param observer the observer to be deleted
     */
    void deleteObserver(Observer<T> observer);

    /**
     * Clears all observers.
     */
    void clearObservers();

    /**
     * Notify observers of new changes.
     */
    void notifyObservers();
}
