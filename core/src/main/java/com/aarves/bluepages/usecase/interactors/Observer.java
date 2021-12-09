package com.aarves.bluepages.usecase.interactors;

/**
 * Interface for observer in observer design pattern
 * @param <T> the argument to be passed into observers when updating
 */
public interface Observer<T> {
    /**
     * Update the state of the observer based on changes to observable
     * @param arg the argument related to the changed state of the observable
     */
    void update(T arg);
}
