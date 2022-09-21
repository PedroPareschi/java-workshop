package br.com.pedropareschi;

import com.sun.jdi.Value;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            //check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            //if there are already stocks on the item, adjust the quantity
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && ((inStock.quantityInStock() - inStock.getReserved()) >= quantity)) {
            inStock.reserve(quantity);
            return quantity;
        }
        return 0;
    }

    public boolean sellStock(Basket basket){
        if(basket == null){
            return false;
        }
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()){
            if(item.getKey().quantityInStock() == item.getKey().getReserved()){
                list.remove(item.getKey().getName());
            } else {
                item.getKey().adjustStock(-item.getValue());
                item.getKey().reserve(-item.getValue());
            }
        }
        return true;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList(){
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String,StockItem> item : list.entrySet()){
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s += stockItem + ". There are " + stockItem.quantityInStock() + " in stock, with " + stockItem.getReserved() + " reserved. Value of items: ";
            s += String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;

        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
