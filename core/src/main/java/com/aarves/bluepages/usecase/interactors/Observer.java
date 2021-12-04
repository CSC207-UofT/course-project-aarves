package com.aarves.bluepages.usecase.interactors;

public interface Observer<T> {
    void update(T arg);
}
