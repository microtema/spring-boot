package de.seven.fate.util;

import java.lang.annotation.Annotation;

public final class ClassUtil {

    private ClassUtil() {
    }

    public static int getIndexOfParameter(Annotation[][] annotations, Class<?> annotationType) {

        for (int index = 0; index < annotations.length; index++) {

            Annotation[] subAnnotations = annotations[index];

            for (Annotation annotation : subAnnotations) {
                if (annotation.annotationType() == annotationType) {
                    return index;
                }
            }
        }

        return -1;
    }
}