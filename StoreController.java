/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sid.Wani
 */
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
public class StoreController {
     private Store store = new Store();
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    
    public final Store getStore() { return store; }
    private final int getAmount() { return Integer.parseInt(amountTf.getText()); }
    //private final int getPrice() { return Integer.parseInt(amountTf.getText()); }
    private final void setAmount(int amount) { amountTf.setText(""+amount); }
    //private final void setCash(int amount) { cashTxt.setText("0"); }
    
    
    @FXML private void handleSell(ActionEvent event) {
        Product product = getStore().getProduct();
        CashRegister cr = getStore().getCashRegister();
        int amount = getAmount();
        if (product.has(amount))
        {
            product.sell(amount);
            //cr.add(amount*product.getPrice());
        }
        setAmount(0);
    }
}
