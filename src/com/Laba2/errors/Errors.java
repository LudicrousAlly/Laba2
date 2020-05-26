package com.Laba2.errors;

import java.util.*;

import javassist.CannotCompileException;
import javassist.ClassPool;



public class Errors {

    public static void recursion() {

        recursion();

    }

    public static void indirectrecursion1() {

        indirectrecursion2();

    }

    public static void indirectrecursion2() {

        indirectrecursion1();

    }

    public static ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) {

        int choice;
        Scanner scan = new Scanner(System.in);
        Boolean exit = false;

        while(!exit) {
        System.out.println("\n1 -  java.lang.OutOfMemoryError: Java heap space\n2 -  java.lang.OutOfMemoryError: Java heap space v.2\n" +
                "3 - java.lang.OutOfMemoryError: Metaspace\n4 - java.lang.StackOverflowError\n5 - java.lang.StackOverflowError" +
                "\n6 - Exit\nYour choice: ");

        choice = scan.nextInt();


            switch (choice) {
                case (1):

                    try {
                        int error1[] = new int[1000 * 1000 * 1000];
                    } catch (Error e) {
                        System.out.println("Словили ошибочку '" + e + "'  :'(");
                    }
                    finally {
                        break;
                    }

                case (2):

                    try {
                        List<Integer> error2 = new ArrayList<>();
                        Random random = new Random();
                        while (true) {
                            error2.add(random.nextInt());
                        }
                    } catch (Error e) {
                        System.out.println("Словили ошибочку '" + e + "'  :'(");
                    }
                    finally {
                        break;
                    }

                case (3):

                    try {
                        for (int i = 0; ; i++) {
                            Class c = classPool.makeClass("com.saket.demo.Metaspace" + i).toClass();
                        }
                    }catch (Exception e)
                    {
                        System.out.println("Словили ошибочку '" + e + "'  :'(");
                    }
                    finally {
                        break;
                    }

                case (4):

                    try {
                        recursion();
                    } catch (Error e) {
                        System.out.println("Словили ошибочку '" + e + "'  :'(");
                    }
                    finally {
                        break;
                    }

                case (5):

                    try {
                        indirectrecursion1();
                    } catch (Error e) {
                        System.out.println("Словили ошибочку '" + e + "'  :'(");
                    }
                    break;

                case(6):

                    exit = true;

                default:
                    break;
            }
        }

    }
}
