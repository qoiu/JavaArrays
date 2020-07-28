
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList mal=new MyArrayList();
        Random random=new Random();
        for (int i = 0; i < 100_000 ; i++) {
            mal.add(random.nextInt(100000));
        }
        mal.add(5,3,7,0);
        mal.add(0,404);
        System.out.println(mal.toString());
        Date timer=new Date();
        //mal.selectionSort();//100_000=8973
        //mal.selectionSort(Comparator.naturalOrder());
        //mal.insertionSort();//100_000=2846;
        mal.insertionSort(Comparator.naturalOrder());
       // mal.bubbleSort();//100_000=26477
        //mal.bubbleSort(Comparator.reverseOrder());
        System.out.println(mal.toString());
        System.out.println("time elapse: " + (new Date().getTime()-timer.getTime()));

    }
}
