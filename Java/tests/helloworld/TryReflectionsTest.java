package helloworld;

import org.junit.Test;

import java.lang.reflect.*;

public class TryReflectionsTest {

    @Test
    public void testReflections() {
        Class<TryReflections> myReflectionsReflection = TryReflections.class;
        TryReflections tryReflectionsObj = new TryReflections(10, "Objectification");

        Constructor<?>[] myRefeflectionsContructor = myReflectionsReflection.getConstructors();

        System.out.println("\nConstructors:");
        for (Constructor<?> eachConstructor : myRefeflectionsContructor) {
            System.out.println(eachConstructor.getName() + " " + eachConstructor.getModifiers());
        }

        System.out.println("\nMethods:");
        Method[] myReflectedMethods = myReflectionsReflection.getMethods();
        for (Method eachMethod : myReflectedMethods) {
            System.out.println(eachMethod.getName() + " " + eachMethod.getModifiers());
        }

        System.out.println("\nFields:");
        Field[] declaredFields = myReflectionsReflection.getDeclaredFields();
        for (Field eachField : declaredFields) {
            System.out.println(eachField.getName() + " " + eachField.getModifiers());
        }

        try {

            /*
            java.lang.IllegalArgumentException: object is not an instance of declaring class
                at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
                at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
                at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
                at java.lang.reflect.Method.invoke(Method.java:498)
                at HelloWorld.TryReflectionsTest.testReflections(TryReflectionsTest.java:33)
             */
            /*Method privateMethod = myReflectionsReflection.getDeclaredMethod("myPrivateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(myReflectionsReflection);*/

            Method privateClassMethod = TryReflections.class.getDeclaredMethod("myPrivateMethod");
            privateClassMethod.setAccessible(true);
            privateClassMethod.invoke(tryReflectionsObj);

            Method privateClassMethodWithParams = TryReflections.class.getDeclaredMethod("myPrivateMethodWithParams", int.class);
            privateClassMethodWithParams.setAccessible(true);
            privateClassMethodWithParams.invoke(tryReflectionsObj, 2000);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}