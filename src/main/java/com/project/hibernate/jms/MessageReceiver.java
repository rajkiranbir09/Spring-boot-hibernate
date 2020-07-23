package com.project.hibernate.jms;



// MessageReceiver with Spring JMS


import java.util.Date;

import com.project.hibernate.entity.Product;
import com.project.hibernate.entity.Project;
import com.project.hibernate.entity.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    // Product
    // queue: saveprodtodb
    // container factory : myFactory
    @JmsListener(destination = "saveprodtodb", containerFactory = "myFactory")
    public void receiveProductSavedMessage(Product product) {
        System.out.println("Product Saved <" + product + ">");
    }

    // User
    @JmsListener(destination = "saveusertodb", containerFactory = "myFactory")
    public void receiveUserSavedMessage(User user) {
        System.out.println("User Saved <" + user + ">");
    }

//    @JmsListener(destination = "saveprodtocart", containerFactory = "myFactory")
//    public void receiveProductToCartMessage(ShoppingCart shoppingCart) {
//        System.out.println("Product Saved in the Cart <" + shoppingCart + ">");
//    }
//
//    @JmsListener(destination = "updateproductcart", containerFactory = "myFactory")
//    public void receiveUpdateProductMessage(ShoppingCart shoppingCart) {
//        System.out.println("Product to Cart Updated <" + shoppingCart + ">");
//    }

    @JmsListener(destination = "deleteproductcart", containerFactory = "myFactory")
    public void receiveDeleteProductMessage(Long id) {
        System.out.println("Product ID to Cart Deleted <" + id + ">");
    }

//    @JmsListener(destination = "purc", containerFactory = "myFactory")
//    public void receiveProductPurchaseMessage(Project project) {
//        System.out.println("Product from Cart Purchased <" + project + ">");
//    }

    @JmsListener(destination = "clearshoppingcart", containerFactory = "myFactory")
    public void receiveCartClearMessage(Date date) {
        System.out.println("All Products from Cart Erased on date <" + date + ">");
    }

    @JmsListener(destination = "findpurchasedproducts", containerFactory = "myFactory")
    public void receivePurchasedProductsMessage(Date date) {
        System.out.println("Retrieving all Products Purchased on day <" + date + ">");
    }

}