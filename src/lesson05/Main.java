package lesson05;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //System.out.println(rootCalc(14,14));

        bagTask();

    }

    private static long rootCalc(int number, int root) {
        if (root == 1) return number;
        return rootCalc(number, root - 1) * number;
    }

    private static void bagTask() {
        Bag bag = new Bag(15);
        Random random = new Random();
        List<Item> itemsList = new ArrayList<>();
        int totalVal = 0;
        for (int i = 0; i < 1000; i++) {
            itemsList.add(new Item(random.nextInt(bag.getCapacity() / 2) + 1, random.nextInt(1000)));
            System.out.println(itemsList.get(i).toString());
            totalVal += itemsList.get(i).getValue();
        }
        System.out.println("BestBag: " + getBestBag(itemsList, bag.getCapacity()).toString());
    }

    private static Bag getBestBag(List<Item> items, int bagCapacity) {
        Bag bestBag = new Bag(bagCapacity);
        int maxValue;
        int id = 0;
        while (id < items.size()) {
            Bag testBag = new Bag(bagCapacity);
            testBag = tryPutItem(new Bag(bagCapacity), testBag, items, id);
            bestBag = (testBag.calcValue() > bestBag.calcValue()) ? testBag : bestBag;
            id++;
        }
        return bestBag;
    }


    private static Bag tryPutItem(Bag bestBag, Bag bag, List<Item> items, int index) {
        bag.put(items.get(index));
        if (bag.calcWeight() <= bag.getCapacity()) {
            if (bag.calcValue() > bestBag.calcValue()) {
                bestBag = bag;
            }
            if (index < items.size() - 1) {
                tryPutItem(bestBag, bag, items, index + 1);
            }
        } else {
            bag.remove(items.get(index));
            if (index < items.size() - 1) {
                tryPutItem(bestBag, bag, items, index + 1);
            }
        }
        return bestBag;
    }
}

class Bag {
    public Bag(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public Bag(List<Item> items) {
        this.items = items;
    }

    private int capacity;
    private List<Item> items;

    public int calcWeight() {
        int weight = 0;
        for (Item item : items) {
            weight += item.getWeight();
        }
        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public void put(Item item) {
        items.add(item);
    }

    public int calcValue() {
        int value = 0;
        for (Item item : items) {
            value += item.getValue();
        }
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bag: (").append(calcValue()).append(") ") ;
        for (Item item : items) {
            sb.append(item.toString());
        }
        return sb.toString();
    }
}

class Item {
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    private int weight;
    private int value;

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[ вес:" + weight + ", стоимость: " + value + "]";
    }
}