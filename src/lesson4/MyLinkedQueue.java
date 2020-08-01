package lesson4;

public class MyLinkedQueue<T> {

    private MyLinkedList<T> stack = new MyLinkedList<T>();

    public void insert(T item){
        stack.insertFirst(item);
    }

    public T remove(){
        T temp=stack.getLast();
        stack.deleteLast();
        return temp;
    }

    public T peek(){
        return stack.getLast();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    @Deprecated
    public boolean isFull(){
        return false;
    }

    @Override
    public String toString() {
        if(stack.size()==0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (T i:stack){
            sb.append(i.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

}
