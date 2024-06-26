package com.Main;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Marketplace {

    public static void main(String[] args) {
        ItemComparator itemComparator = new ItemComparator();

        PriorityQueue<Item> itemQueue = new PriorityQueue<>(itemComparator);

        itemQueue.add(new Item("Refrigerator", 1200.0, "Home Appliances"));
        itemQueue.add(new Item("Microwave", 300.0, "Home Appliances"));
        itemQueue.add(new Item("Dishwasher", 900.0, "Home Appliances"));
        itemQueue.add(new Item("Washing Machine", 800.0, "Home Appliances"));
        itemQueue.add(new Item("Air Conditioner", 1500.0, "Home Appliances"));

        System.out.println("Items sorted by name and price:");
        while (!itemQueue.isEmpty()) {
            System.out.println(itemQueue.poll());
        }
    }
}

class Item {
    private String itemName;
    private double itemPrice;
    private String itemCategory;

    public Item(String itemName, double itemPrice, String itemCategory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    @Override
    public String toString() {
        return "Item{name='" + itemName + "', price=" + itemPrice + ", category='" + itemCategory + "'}";
    }
}


class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        int nameComparison = item1.getItemName().compareTo(item2.getItemName());
        if (nameComparison == 0) {
            return Double.compare(item1.getItemPrice(), item2.getItemPrice());
        }
        return nameComparison;
    }
}
