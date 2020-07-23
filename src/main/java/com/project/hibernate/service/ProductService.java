package com.project.hibernate.service;


import com.project.hibernate.entity.Product;
import com.project.hibernate.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private JmsTemplate jmsTemplate;

    private static List<Product> products = new ArrayList<>();

    static {
//        products.add(new Product(499.99d, 1000, "Samsung Galaxy S8 Unlocked 64GB - US Version (Midnight Black) - US Warranty", "Samsung"));
//        products.add(new Product(184.29d, 500, "Huawei Honor 6X Dual Camera Unlocked Smartphone, 32GB Gray (US Warranty)", "Huawei"));
//        products.add(new Product(239.99d, 100, "Moto G Plus (5th Generation) - Lunar Gray - 64 GB - Unlocked - Prime Exclusive - with Lockscreen Offers & Ads", "Motorola"));
//        products.add(new Product(1000.0d, 400, "Leather bag imported from USA ", "Essential Products"));
//        products.add(new Product(49.99d, 800, "BLU Advance A5 -Unlocked Dual Sim Smartphone -Black", "BLU"));
//        products.add(new Product(264.99d, 800, "Apple iPhone 6 16GB Space Gray GSM Unlocked (Certified Refurbished)", "Apple"));
//        products.add(new Product(51.95d, 800, "Alcatel Ideal 4G LTE Unlocked 4060A Android 5mp 8GB Quad Core Desbloqueado", "Alcatel"));
//        products.add(new Product(57.99d, 800, "HUnlocked Cell Phones, DOOGEE X5 Dual Sim Smartphones - 5.0\" HD IPS Display - Android 6.0 - MT6580 Quad Core - 1GB RAM+8GB ROM - 5MP Camera - GSM Unlocked Phone International", "Doogee"));
//        products.add(new Product(129.50d, 800, "LeEco | Le S3 Unlocked Dual-SIM Smartphone; 5.5\" Display, 16MP Camera, 4K Video, 32GB Storage, 3GB RAM - Gray (U.S. Warranty)", "LeEco"));
//        products.add(new Product(319.99d, 800, "LG V20 H910a 64GB 5.7\" IPS LCD Display Android Smartphone w/ Dual Rear Cameras (16MP+8MP) - Carrier Unlocked for all GSM Carriers Worldwide (Titan Gray)", "LG"));
    }

    public void saveInitialBatch() {
        // save to the database
//        productRepository.save();
        // for each product -> after save ->
        products.forEach((products) -> {
            jmsTemplate.convertAndSend("saveprodtodb", products);
        });
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}