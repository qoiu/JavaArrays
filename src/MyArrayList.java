import java.util.Comparator;

public class MyArrayList<Item extends Comparable>{
    private int size;
    private Item[] list;
    private final int DEFAULT_CAPACITY=10;
    private final double DEFAULT_CAPACITY_UPDATE=0.75;
    private int capacity;

    public MyArrayList(int capacity){
        if(capacity<0){
            throw new IllegalArgumentException("Incorrect capacity: "+ capacity);
        }
        this.capacity=capacity;
        this.list=(Item[])new Comparable[capacity];
    }

    public MyArrayList(){
        this.capacity=DEFAULT_CAPACITY;
        list=(Item[])new Comparable[DEFAULT_CAPACITY];
    }


    private void checkIndex(int index) {
        if(index<0 || index>size){
            throw new IllegalArgumentException("Incorrect index: "+ index);
        }
    }

    public void add(Item item){
        add(size,item);
    }

    public void add(Item...items){
        for(Item item:items){
            add(item);
        }
    }

    public void add(int index, Item item){
        checkIndex(index);
        expanseCheck(size+1);
        for (int i = size; i > index ; i--) {
            list[i]=list[i-1];
        }
        list[index]=item;
        size++;
    }

    public void remove(int index){
        checkIndex(index);
        for (int i = index; i <size-1 ; i++) {
            list[i]=list[i+1];
        }
        list[size]=null;
        size--;
    }

    public Item get(int index){
        return list[index];
    }

    public void set(int index, Item item){
        list[index]=item;
    }

    private void expanseCheck(int index){
        if(index>=capacity){
            capacity= (int) (capacity*2);
            //list = Arrays.copyOf(list,capacity);
            Item[] list2 = (Item[])new Comparable[capacity];
            for (int i = 0; i < size; i++) {
                list2[i]=list[i];
            }
            list=list2;
            list2=null;
        }
    }

    public boolean find(Item item){
        return indexOf(item) > -1;
    }

    public boolean remove(Item item){
        int i=0;
        while (i<size && !list[i].equals(item)){
            i++;
        }
        if(i==size)return false;
        remove(i);
        return true;
    }

    public final int indexOf(Item item){
        for (int i = 0; i < size ; i++) {
            if(list[i].equals(item))return i;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    private boolean less(Item item1, Item item2){
        return item1.compareTo(item2)<0;
    }

    private void swap(int index1,int index2){
        Item temp=list[index1];
        list[index1]=list[index2];
        list[index2]=temp;
    }

    public void selectionSort(){
        for (int i = 0; i < size -1 ; i++) {
            int iMin=i;
            for (int j = i+1; j < size; j++) {
                if(less(list[j],list[iMin]))
                iMin=j;
            }
            swap(i,iMin);
        }
    }

    public void selectionSort(Comparator<Item> comparator){
        for (int i = 0; i < size -1 ; i++) {
            int iMin=i;
            for (int j = i+1; j < size; j++) {
                if(comparator.compare(list[j], list[iMin]) < 0)
                iMin=j;
            }
            swap(i,iMin);
        }
    }

    public void insertionSort(){
        Item key;
        for (int i = 1; i < size; i++) {
            int j=i;
            key=list[j];
            while (j>0 && less(key,list[j-1])){
                list[j]=list[j-1];
                j--;
            }
            list[j]=key;
        }
    }

    public void insertionSort(Comparator<Item> comparator){
        Item key;
        for (int i = 1; i < size; i++) {
            int j=i;
            key=list[j];
            while (j>0 && comparator.compare(key,list[j - 1]) < 0){
                list[j]=list[j-1];
                j--;
            }
            list[j]=key;
        }
    }

    public void bubbleSort() {
        boolean isSwapped;
        for (int i = size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }


    public void bubbleSort(Comparator<Item> comparator) {
        boolean isSwapped;
        for (int i = size - 1; i > 0; i--) {
            isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    swap(j + 1, j);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("("+size+"/"+capacity+") [");
        for (int i = Math.max(0,size-10); i < size ; i++) {
            sb.append(list[i].toString()+", ");
        }
        sb.setLength(sb.length()-2);
        sb.append("]");
        return sb.toString();
    }

}
