package io.jotech.productservice.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.jotech.productservice.dto.ProductRequest;
import io.jotech.productservice.dto.ProductResponse;
import io.jotech.productservice.model.Product;
import io.jotech.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        ModelMapper modelMapper = new ModelMapper();
        var product = modelMapper.map(productRequest, Product.class);
        productRepository.save(product);
        log.info("Product {} is saved successfully", product.getId());

    }

    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductResponse.class);

    }
}
