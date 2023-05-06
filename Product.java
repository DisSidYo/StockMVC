
import java.util.LinkedList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sid.Wani
 */
public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private String name;
    private int stock;
    private double price;
    private IntegerProperty sold = new SimpleIntegerProperty();
    private DoubleProperty income = new SimpleDoubleProperty();
    private IntegerProperty left = new SimpleIntegerProperty();

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
       sold.set(0);
        income.bind(sold.multiply(price));
        left.bind(sold.subtract(stock).multiply(-1));
    }
    public final String getName() { return name; }
    public final int getStock() { return stock; }
    public final double getPrice() { return price; }
    public final int getSold() { return sold.get(); }
    public ReadOnlyIntegerProperty soldProperty() { return sold; };
    public final double getIncome() { return income.get(); }
    public ReadOnlyDoubleProperty incomeProperty() { return income; }
    public final int getLeft() { return left.get(); }
    public ReadOnlyIntegerProperty leftProperty() { return left; }

    

    public void sell(int n) {
        stock = left.get() - n;
        double money = n * price;
        sold.set(sold.get()+ n);
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock = stock + n;
    }

    public boolean has(int n) {
        return stock >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
