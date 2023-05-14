/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ceramic;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafis
 */
public class ManagingDocument {
    public static void PrintProductFromBinary(String filePath) throws IOException {
    ArrayList<ProductInfo> productList = new ArrayList<>();

    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
    try {
        productList = (ArrayList<ProductInfo>) inputStream.readObject();
    } catch (ClassNotFoundException e) {
        System.out.println("Error reading binary file: " + e.getMessage());
        throw new IOException("Error reading binary file: " + e.getMessage());
    }
    inputStream.close();

    for (ProductInfo product : productList) {
        System.out.println("Product Name: " + product.getName());
        System.out.println("Product Quantity: " + product.getDesc());
        System.out.println("Product Price: " + product.getPrice());
        System.out.println();
    }
}
    public static ArrayList<String> getProductNamesFromBinary(String filePath) throws IOException {
    ArrayList<ProductInfo> productList;

    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
    try {
        productList = (ArrayList<ProductInfo>) inputStream.readObject();
    } catch (ClassNotFoundException e) {
        System.out.println("HERE LIES THE PROBLEM: " + e.getMessage());
        throw new IOException("Error reading binary file: " + e.getMessage());
    }
    inputStream.close();

    ArrayList<String> productNames = new ArrayList<>();
    for (ProductInfo product : productList) {
        productNames.add(product.getName());
    }
    return productNames;
}
    public static String[] getProductInfoFromBinary(String filePath, String productName) throws FileNotFoundException{
        ArrayList<ProductInfo> productList = new ArrayList<>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(ManagingDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            productList = (ArrayList<ProductInfo>) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("HERE LIES THE PROBLEM1 " + e.getMessage());
            try {
                throw new IOException("HERE LIES THE PROBLEM2 fucker " + e.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(ManagingDocument.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ManagingDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(ManagingDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println( productName);
        String[] oneProduct = new String [3];
        
    for (ProductInfo product : productList) {
        if (product.getName().equals(productName)){
           oneProduct[0] = product.getDesc();
           oneProduct[1] = String.valueOf(product.getPrice());
           oneProduct[2] = String.valueOf(product.getQuantity());
           
        }
    }
    return  oneProduct;
}
}