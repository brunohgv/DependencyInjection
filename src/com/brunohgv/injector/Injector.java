package com.brunohgv.injector;

import com.brunohgv.exceptions.LinkException;

import java.lang.reflect.InvocationTargetException;

public interface Injector {
    <T> T inject(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, LinkException, NoSuchMethodException;
}
