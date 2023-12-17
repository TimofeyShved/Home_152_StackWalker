package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        one().forEach(x -> System.out.println(x));
    }

    private static List<String> one(){
        return two();
    }

    private static List<String> two(){
        // При помощи StackWalker и метода walk, можно проходить и получать весь стек вызовов
        // создаёт map(коллекцию) и закидывает в неё frame(элементы) с названиями методов, до конечного вызова, а потом в главном классе выводит коллекцию на экран
        return StackWalker.getInstance().walk(s -> s.map(frame -> frame.getClassName() +" : "+ frame.getMethodName()).collect(Collectors.toList()));
    }
}
