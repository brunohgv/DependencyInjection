package com.brunohgv.injector;

import com.brunohgv.annotations.Link;
import com.brunohgv.exceptions.LinkException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DependencyInjector implements Injector {
    @Override
    public <T> T inject(Class<T> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, LinkException, NoSuchMethodException {
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();
        for(Constructor<T> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if(parameterTypes.length > 0) {
                if (constructor.isAnnotationPresent(Link.class)) {

                    List<Object> dependenciesInstances = new ArrayList<>();
                    for (Class<?> parameter : parameterTypes) {
                        Object parameterInstance = this.inject(parameter);
                        dependenciesInstances.add(parameterInstance);
                    }
                    return constructor.newInstance(dependenciesInstances.toArray());
                } else {
                    throw new LinkException(clazz);
                }
            } else {
                return constructor.newInstance();
            }
        }
        throw new NoSuchMethodException("No constructor defined for this class");
    }
}
