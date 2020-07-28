package lesson02;

import lesson02.MyArrayList;

import java.util.Comparator;

public class MySortedArrayList<Item extends Comparable<Item> & Comparator> extends MyArrayList<Item> {

    @Override
    public void add(Item item) {
        int i=0;
        while (i<this.getSize() && item.compareTo(get(i))>=0){
            i++;
        }
        super.add(i,item);
    }

    @Override
    public void add(int index, Item item) {
        add(item);
    }

    @Deprecated
    @Override
    public void set(int index, Item item) {
        throw new UnsupportedOperationException("Unavailable method");
    }

    public int binarySearch(Item item){
        int hi=0;
        int lo=getSize()-1;

        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(item.compareTo(get(mid))<0){
                hi=mid;
            }else if(item.compareTo(get(mid))>0){
                lo=mid;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
