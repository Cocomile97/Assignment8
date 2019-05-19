package ac.za.cput.factory;

import ac.za.cput.domain.Class;

public class ClassFactory {


    public static Class getClass(String className,String id) {
        return new Class.Builder().classId(id)
                .className(className)
                .build();
    }
}

