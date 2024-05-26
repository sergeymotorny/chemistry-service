package com.motorny.ss.chemistryservice;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.mapper.ProductMapper;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ChemistryServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ChemistryServiceApplication.class, args);
    }

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void run(String... args) throws Exception {

//        List<Product> list = productRepository.findProductsByBrandId(5);
//
//        list.stream()
//                .map(productMapper::toProductDto)
//                .collect(Collectors.toSet());
//
//        list = productRepository.findProductsByBrandId(5);
//        list.forEach(System.out::println);

    }
}
