package lesson4;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();

        mll.insertFirst("Katia");
        mll.insertFirst("Petia");
        mll.insertFirst("Maria");

        System.out.println(mll);

        mll.insertLast("Bob");
        System.out.println(mll);



//        System.out.println(mll.deleteFirst());
//        System.out.println(mll);
//
//        System.out.println(mll.getFirst());

//        mll.insert(1, "Sasha");
//        System.out.println(mll);
//
        System.out.println(mll.delete("Bob"));
        System.out.println(mll);


        for (String s : mll) {
            System.out.println(s);
        }


    }
}
