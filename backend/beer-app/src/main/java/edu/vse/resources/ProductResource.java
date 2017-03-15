package edu.vse.resources;

import edu.vse.dtos.Product;
import edu.vse.dtos.Products;
import edu.vse.exceptions.NotFoundException;
import edu.vse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Product get(@PathVariable int id) {
        return productService.get(id).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @RequestMapping(method = GET)
    public Products list(@RequestParam(required = false) Optional<Integer> supplier,
                         @RequestParam(required = false) Optional<Integer> category) {
        if (category.isPresent()) {
            return productService.listByCategory(category.get());
        } else if (supplier.isPresent()) {
            return productService.listBySupplier(supplier.get());
        } else {
            return productService.list();
        }
    }

    @RequestMapping(method = POST)
    public Product post(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.saveWithId(product, id);
    }
}
