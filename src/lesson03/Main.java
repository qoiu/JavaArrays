package lesson03;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//   -----Задание1
//
//        System.out.println("Введите строку:");
//        Scanner in = new Scanner(System.in);
//        String str=in.nextLine();
//        System.out.println(reverseText(str));

//   -----Задание2
//
//        MyDeck<Integer> md=new MyDeck<>(15);
//        md.insertLeft(1);
//        md.insertLeft(2);
//        md.insertLeft(3);
//        md.insertLeft(4);
//        md.insertRight(-1);
//        md.insertRight(-2);
//
//        for (int i = 0; i <5 ; i++) {
//
//            System.out.println("left: "+md.peekLeft());
//            System.out.println(md.removeLeft());
//        }
//        System.out.println("right: "+md.peekRight());
//        System.out.println("left: "+md.peekLeft());
//        System.out.println(md.removeLeft());
//        System.out.println("right: "+md.peekRight());
//        System.out.println("left: "+md.peekLeft());
//        System.out.println(md.removeRight());
//        System.out.println("right: "+md.peekRight());
//        System.out.println("left: "+md.peekLeft());
//        System.out.println(md.removeLeft());
//        System.out.println("right: "+md.peekRight());
//        System.out.println("left: "+md.peekLeft());

        //   -----Задание3
        MyPriorityQueue<Integer> mpq=new MyPriorityQueue(10,Comparator.naturalOrder());
        mpq.insert(1);
        mpq.insert(7);
        mpq.insert(4);
        mpq.insert(5);

        System.out.println(mpq.toString());
        System.out.println(mpq.peek());

        //   -----Задание4
        MyStack<Integer> ms=new MyStack<>(2);
        for (int i = 0; i <20 ; i++) {
            ms.push(i);
        }
        System.out.println(ms.toString());

    }

    private static String reverseText(String text){
        MyStack<Character> myChar=new MyStack<>(text.length());
        int i=0;
        while (i<text.length()){
            myChar.push(text.charAt(i));
            i++;
        }
        StringBuilder sb=new StringBuilder();
        while (!myChar.isEmpty()){
            sb.append(myChar.pop());
        }
        return sb.toString();
    }
}
