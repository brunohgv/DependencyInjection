package com.brunohgv;

import com.brunohgv.exceptions.LinkException;
import com.brunohgv.injector.DependencyInjector;
import com.brunohgv.injector.Injector;
import com.brunohgv.models.SimpleController;

import java.lang.reflect.InvocationTargetException;

public class Program {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, LinkException {
        Injector dependencyInjector = new DependencyInjector();

        SimpleController simpleController = dependencyInjector.inject(SimpleController.class);
        simpleController.getService().doTheServiceStuff();

    }
}
