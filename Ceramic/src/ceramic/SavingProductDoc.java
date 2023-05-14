/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ceramic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nafis
 */
public class SavingProductDoc {
  
    public static void WriteProductToBinaryFile(String fileName, String productName, String productDesc, Float productPrice , int productQuantity) throws IOException {
    String filePath = System.getProperty("user.dir") + "/" + fileName + ".bin";
    
    ArrayList<ProductInfo> productList = new ArrayList<>();

    // Check if file exists
    File file = new File(filePath);
    if (file.exists()) {
        // If file exists, add the product to the binary file
        AddProductToBinary(filePath, productName, productDesc, productPrice, productQuantity );
    } else {
        // If file does not exist, create a new binary file and add the product
        productList.add(new ProductInfo(productName, productDesc, productPrice, productQuantity));
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        outputStream.writeObject(productList);
        outputStream.close();
    }
}

public static void AddProductToBinary(String filePath, String productName, String productDesc, Float productPrice, int productQuantity) throws IOException {
    ArrayList<ProductInfo> productList;

    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
    try {
        productList = (ArrayList<ProductInfo>) inputStream.readObject();
        productList.add(new ProductInfo(productName, productDesc, productPrice , productQuantity));
    } catch (ClassNotFoundException e) {
        System.out.println("Error reading binary file: " + e.getMessage());
        throw new IOException("Error reading binary file: " + e.getMessage());
    }
    inputStream.close();

    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
    outputStream.writeObject(productList);
    outputStream.close();
}
public static void removeProductFromBinary( String productName) throws IOException {
    ArrayList<ProductInfo> productList;
    String filePath = "ProductInfo.bin";
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
    try {
        productList = (ArrayList<ProductInfo>) inputStream.readObject();
        // Search for the product to remove
        for (ProductInfo product : productList) {
            if (product.getName().equals(productName)) {
                productList.remove(product);
                break;
            }
        }
    } catch (ClassNotFoundException e) {
        System.out.println("Error reading binary file: " + e.getMessage());
        throw new IOException("Error reading binary file: " + e.getMessage());
    }
    inputStream.close();

    ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
    outputStream.writeObject(productList);
    outputStream.close();
}
}

class ProductInfo implements Serializable {
    private final String productNameString;
    private final String productDescString;
    private final float productPrice;
    private final int productQuantity;
    //private final String productType;

    
    public ProductInfo(String productName, String productDesc, float productPrice, int productQuantity) {
        this.productNameString = productName;
        this.productDescString = productDesc;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

     
     
    public String getName() {
        return productNameString;
    }

    public String getDesc() {
        return productDescString;
    }
    public Float getPrice(){
        return productPrice;
    }
    public Float getQuantity(){
        return productPrice;
    }
    

    
}

