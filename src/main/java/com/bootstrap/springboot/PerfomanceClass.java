package com.bootstrap.springboot;
import java.util.LinkedHashMap;
public class PerfomanceClass {

public static void main(String[] args) {

    long time = System.nanoTime();
    Class class1 = "String".getClass();
    Class class11 = "Integer".getClass();
    Class class111 = "LinkedHashMap".getClass();

    System.out.println("time (getClass()) :" + (System.nanoTime() - time) + " ns" + class1.getName());

    long time2 = System.nanoTime();
    Class class2 = String.class;
    Class class22 = Integer.class;
    Class class222 = LinkedHashMap.class;

    System.out.println("time (.class):" + (System.nanoTime() - time2) + " ns" + class2);
} }