package com.shopping.product_service.utils;

import com.shopping.product_service.Dto.ProductRequest;
import com.shopping.product_service.Dto.ProductResponse;
import com.shopping.product_service.model.Product;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

@Controller
public class ProductMapper {
    public  Product toProduct(ProductRequest request){
        if (request == null) {
            return null;
        }
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description((request.description()))
                .price(request.price())
                .build();
    }


    public  ProductResponse fromProduct(Product product){
        if (product == null) {
            return null;
        }

        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());

    }

    /*

    public Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }

     */
}
