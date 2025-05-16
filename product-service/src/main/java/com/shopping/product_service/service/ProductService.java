package com.shopping.product_service.service;

import com.shopping.product_service.Dto.ProductRequest;
import com.shopping.product_service.Dto.ProductResponse;
import com.shopping.product_service.exception.CustomerNotFoundException;
import com.shopping.product_service.model.Product;
import com.shopping.product_service.repository.ProductRepository;
import com.shopping.product_service.utils.ProductMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public void updateProduct(@Valid ProductRequest productRequest) {
        var customer = this.productRepository.findById(productRequest.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", productRequest.id())
                ));
        mergeProduct(customer, productRequest);
        this.productRepository.save(customer);
    }

    private void mergeProduct(Product product, ProductRequest request) {
        if (StringUtils.isNotBlank(request.name())) {
            product.setName(request.name());
        }
        if (StringUtils.isNotBlank(request.description())) {
            product.setDescription(request.description());
        }
        if (request.price() != null) {
            product.setPrice(request.price());
        }
    }

    public String createNew(@Valid ProductRequest productRequest) {
        Product savedProduct = productRepository.save(mapper.toProduct(productRequest));
        return savedProduct.getId();
    }

    public void deleteProduct(@Valid String id) {
        this.productRepository.deleteById(id);
    }

    public List<ProductResponse> getAllProducts() { // to fix
        return  this.productRepository.findAll()
                .stream()
                .map(this.mapper::fromProduct)
                .collect(Collectors.toList());

    }

    public ProductResponse getProductById(String id) {
        return this.productRepository.findById(id)
                .map(mapper::fromProduct)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
    }

    public boolean existsById(@Valid String id) {
        return this.productRepository.findById(id)
                .isPresent();
    }

}

