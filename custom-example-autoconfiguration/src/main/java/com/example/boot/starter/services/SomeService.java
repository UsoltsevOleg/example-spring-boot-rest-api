package com.example.boot.starter.services;

public interface SomeService {

    default String someMethod() {
        return this.getClass().getCanonicalName();
    }
}
