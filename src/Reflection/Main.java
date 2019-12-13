package Reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        Hobby hobby = new Hobby(20,"Tennis");
        Class hobbyClass = hobby.getClass();

        Field[] fields = hobbyClass.getDeclaredFields();

        for (Field field: fields) {
            Class fieldType = field.getType();
            System.out.println("Fields name: " + field.getName());
            System.out.println("Fields type: " + fieldType.getName());
            int mod = field.getModifiers();
            System.out.println("Fields modifier: " + Modifier.toString(mod));
            System.out.println("");

        }
        System.out.println("____________________________________________________");

        Constructor[] constructors = hobbyClass.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            System.out.println("Constructor name: " + constructor.getName());
            System.out.println("Constructor types: " + Arrays.toString(constructor.getParameterTypes()));
            int modifier = constructor.getModifiers();
            System.out.println("Constructor modifier: " + Modifier.toString(modifier));
        }
        System.out.println("________________________________________________________________");

        Method[] methods = hobbyClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType().getName());
            int modd = method.getModifiers();
            System.out.println("Method modifier: " + Modifier.toString(modd));

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Method type: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        System.out.println("_____________________________________________________");

        System.out.println("Необходимо вызвать метод test() класса средствами рефлексии c параметрами 10, \"test\", 20.5.");

        Method method1 = Hobby.class.getDeclaredMethod("test", int.class, String.class, double.class);
        method1.setAccessible(true);
        method1.invoke(hobby,10,"test",20.5);

        System.out.println("____________________________________________________");

        System.out.println("Необходимо поменять и вывести на экран значение поля privateField. " +
                "Попробовать сделать это же, если privateField будет также иметь модификатор final.");
        Field field = hobby.getClass().getDeclaredField("privateField");
        field.setAccessible(true);
        field.setInt(hobby,15);
        System.out.println("Changed field: " + field.getInt(hobby));
        System.out.println("Если модификатор доступа поля privateField будет final, то программа отработает точно также ");

    }
}
