package com.shopping.product_service.controller;

import com.shopping.product_service.Dto.ProductRequest;
import com.shopping.product_service.Dto.ProductResponse;
import com.shopping.product_service.model.Product;
import com.shopping.product_service.service.ProductService;
import com.shopping.product_service.utils.ProductMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService service ;

    // Insert
    @PostMapping
    public ResponseEntity<String> CreateProduct(@Valid @ RequestBody ProductRequest productRequest)
    {
        return ResponseEntity.ok(service.createNew(productRequest));
    }
    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductRequest productRequest,@PathVariable Long id){
        service.updateProduct(productRequest);
        return ResponseEntity.accepted().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@Valid @PathVariable String id){
        service.deleteProduct(id);
        return ResponseEntity.accepted().build();
    }

    // Get All Product
    @GetMapping
    public ResponseEntity<List<ProductResponse>> GetAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable String id){
    return ResponseEntity.ok(service.getProductById(id));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@Valid @PathVariable String id){
        return ResponseEntity.ok(service.existsById(id));
    }

}
