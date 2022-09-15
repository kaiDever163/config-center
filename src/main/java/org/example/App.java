package org.example;

import org.example.interfaceTest.FunctionInter;
import org.example.pojo.ParamName;
import org.example.pojo.UnlucklyDuck;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        testConsumerIsActive();
    }

    public static void filedMethod() {
        FunctionInter functional = null;
        functional.say();
        functional.dance();
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

    public static void testAndThen() {
        //当前值
        Consumer<Integer> consumer1 = x -> System.out.println("当前值 : " + x);
        //相加
        Consumer<Integer> consumer2 = x -> {
            System.out.println("相加 : " + (x + x));
        };
        //相乘
        Consumer<Integer> consumer3 = x -> System.out.println("相乘 : " + x * x);
        //andThen拼接
        consumer1.andThen(consumer2).andThen(consumer3).accept(1);
    }

    public static void testStringClass() {
        String s1 = "Hello";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;
        System.out.println(s1 == s9);
    }

//    public static void testBucket(){
//        //Create the Bandwidth to set the rule - one token per minute
//        Bandwidth oneCosumePerMinuteLimit = Bandwidth.simple(1, Duration.ofMinutes(1));
//
//        //Create the Bucket and set the Bandwidth which we created above
//        Bucket bucket = Bucket.builder()
//                .addLimit(oneCosumePerMinuteLimit)
//                .build();
//
//        //Call method tryConsume to set count of Tokens to take from the Bucket,
//        //returns boolean, if true - consume successful and the Bucket had enough Tokens inside Bucket to execute method tryConsume
//        System.out.println(bucket.tryConsume(1)); //return true
//
//        //Call method tryConsumeAndReturnRemaining and set count of Tokens to take from the Bucket
//        //Returns ConsumptionProbe, which include much more information than tryConsume, such as the
//        //isConsumed - is method consume successful performed or not, if true - is successful
//        //getRemainingTokens - count of remaining Tokens
//        //getNanosToWaitForRefill - Time in nanoseconds to refill Tokens in our Bucket
//        ConsumptionProbe consumptionProbe = bucket.tryConsumeAndReturnRemaining(1);
//        System.out.println(consumptionProbe.isConsumed()); //return false since we have already called method tryConsume, but Bandwidth has a limit with rule - one token per one minute
//        System.out.println(consumptionProbe.getRemainingTokens()); //return 0, since we have already consumed all of the Tokens
//        System.out.println(consumptionProbe.getNanosToWaitForRefill()); //
//    }

    public static void testStringAndStringBuilder() {
        String abc0 = "abc";
        StringBuilder abc1 = new StringBuilder("abc");
        System.out.println(System.identityHashCode(abc0));
        System.out.println(System.identityHashCode(abc1));
    }

    public static void testUnmodifiableSet() {
        Set<String> set = new HashSet<>();
        set.add("fankai");
        // create and initialize the set instance
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);
        set.add("Costa Rica");
        System.out.println(unmodifiableSet);

    }

    public static void testConsumerIsActive(){
        Consumer consumer = s->{
            consumerMethod((String) s);
        };
    }

    public static void consumerMethod(String s){
        System.out.println(s);
        System.out.println("hahaha");
    }

}
