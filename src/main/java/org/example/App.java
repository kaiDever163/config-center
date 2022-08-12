package org.example;

import org.example.pojo.ParamName;
import org.example.pojo.UnlucklyDuck;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        testConsumer();
    }

    public static void filedMethod() throws IllegalAccessException, NoSuchFieldException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }
        Integer remove = list.remove(0);
        System.out.println("提取的数字" + remove);
        System.out.println(list);
    }

    public static Future<String> useCompletableFuture() {
        Future<String> completableFuture = null;
        for (int i = 0; i < 10; i++) {
            completableFuture =
                    CompletableFuture.completedFuture(i + "");
        }

        return completableFuture;
    }

    public static void randomString() {
        String result = UUID.randomUUID().toString().replace("-", "");
//        System.out.println(result.substring(0, 8));
        System.out.println(result);
    }

    public static void testComputeIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
//        map.put("fankai",12);
        int length = map.computeIfAbsent("fankai", String::length);
        System.out.println(map.get("fankai"));
        System.out.println(length);

    }

    public static void testAnnotation() {
//        Method[] methods = UnlucklyDuck.class.getMethods();
//        for (Method method : methods) {
//            ParamName[] annotationsByType = method.getAnnotationsByType(ParamName.class);
//            System.out.println(annotationsByType.length);
//        }
        Field[] fields = UnlucklyDuck.class.getFields();
        for (Field field : fields) {
            ParamName[] annotationsByType = field.getAnnotationsByType(ParamName.class);
            System.out.println(annotationsByType[0].value());
        }
    }

    /**
     * java 8 Consumer
     */
    public static void testConsumer() {
        //设置好Consumer实现方法
        Consumer<Integer> square = x -> System.out.println("平方计算 : " + x * x);
        //传入值
        square.accept(1);
    }
}
