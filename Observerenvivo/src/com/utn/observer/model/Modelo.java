package com.utn.observer.model;

import java.util.List;
import java.util.Observable;

public abstract class Modelo<T>  extends Observable  {

    public abstract void add(T value);
    public abstract void remove(T value);
    public abstract void update(T oldValue, T newValue);
    public abstract List<T> getAll();
}
