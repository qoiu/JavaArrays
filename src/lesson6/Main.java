package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        MyTreeMap<Integer, String> map = new MyTreeMap<>();
//
//        map.put(5,"five");
//        map.put(1,"one");
//        map.put(3,"three");
//        map.put(2,"two");
//
//        System.out.println(map);
//        System.out.println(map.get(2));
//        map.put(2,"ttt");
//        System.out.println(map);
//
//        map.deleteMin();
//        System.out.println(map);

//        map.put(23,23);
//        map.put(13,13);
//        map.put(16,16);
//        map.put(3,3);
//        //map.put(2,2);
//        //map.put(1,1);
//        System.out.println(map.toString());
//        System.out.println(map.isBalance());
        Random random=new Random();
        int balancedTree=0;
        final int MAP_AMOUNT=20000;
        for (int i=0;i<MAP_AMOUNT;i++){
            NewTreeMap<Integer,Integer> map=new NewTreeMap();
            int k;
            while (map.height()<6){
                k=random.nextInt(200)-100;
                map.put(k,k);
            }
            if(map.isBalance()){
                balancedTree+=1;
            }
        }
        System.out.println(balancedTree);
        System.out.println((double)balancedTree/MAP_AMOUNT*100 + "%");

    }
}
