package ru.geekbrains.hw.level3.lesson7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        start(TestApp.class);
    }

    public static <T> void start(Class<T> testClass) {
        try {
            Constructor<T> constructor = testClass.getConstructor();
            T instance = constructor.newInstance();
            Method[] methods = testClass.getMethods();
            toRerunAnatation(methods);
            for (Method method : methods) {
                BeforeSuite beforeSuite = method.getAnnotation(BeforeSuite.class);
                if (beforeSuite != null) {
                    method.invoke(instance);
                }
            }
            ArrayList<Integer> values = new ArrayList<>();
            for (Method method : methods) {
                Test test = method.getAnnotation(Test.class);
                if (test != null) values.add(test.priority());
                else values.add(0);
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < values.size(); j++) {
                    if (values.get(j) == i+1) methods[j].invoke(instance);
                }
            }
            for (Method method : methods) {
                AfterSuite afterSuite = method.getAnnotation(AfterSuite.class);
                if (afterSuite != null) {
                    method.invoke(instance);
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void toRerunAnatation(Method[] methods) {
        boolean before = false;
        boolean after = false;
        for (Method method : methods) {
            BeforeSuite beforeSuite = method.getAnnotation(BeforeSuite.class);
            AfterSuite afterSuite = method.getAnnotation(AfterSuite.class);
            if (beforeSuite != null && !before) before = true;
            else if (beforeSuite != null) throw new RuntimeException("Повторное использование аннотации BeforeSuite");
            if (afterSuite != null && !after) after = true;
            else if (afterSuite != null) throw new RuntimeException("Повторное использование аннотации AfterSuite");
        }
    }
}
