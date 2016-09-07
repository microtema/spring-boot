package de.seven.fate.event;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class CreationEvent<T> {

    private final T source;

    public CreationEvent(final T source) {
        this.source = source;
    }

    public final T getSourceObject() {
        return source;
    }


    public Class<T> getGenericType() {

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();

        return (Class<T>) actualTypeArguments[0];
    }
}
