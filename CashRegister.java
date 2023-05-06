
import java.text.DecimalFormat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sid.Wani
 */
public class CashRegister implements ProductObserver {
    private double cash;
     private DoubleProperty cash1 = new SimpleDoubleProperty();

    public CashRegister() {
        this.cash=0;
    }

    public void add(double money) {
        cash1.set(cash1.get()+money);
    }
    

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
    //public DoubleProperty incomeProperty() { return income; }
    public final String getCash() { return formatted(cash1.get()); }
    public ReadOnlyDoubleProperty cashProperty() { return cash1; }
    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}