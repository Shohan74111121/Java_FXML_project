/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceramic;

import java.io.Serializable;

/**
 *
 * @author Nufis
 */
public class ProductOnSale {
    private final String productNameString;
    private final float productPrice;
    private final int productQuantity;
    private final String productType;
    
    public ProductOnSale(String productName, float productPrice, int productQuantity, String productType) {
        this.productNameString = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productType = productType;
    }
    public String getName() {
        return productNameString;
    }

    public Float getPrice(){
        return productPrice;
    }
    public int getQuantity(){
        return productQuantity;
    }
    public String getType(){
        return productType;
    }
}
