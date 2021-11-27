package epam.service;

import epam.dao.jpa.ProductRepository;
import epam.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
    }

    public Product addProduct(Product product) {
        log.info("adding product - " + product.getName());
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        log.info("getting product by id - " + id);
        productRepository.delete(id);
    }

    @Cacheable("products")
    public Product getProduct(int id) {
        log.info("getting product by id - " + id);
        return productRepository.findOne(id);
    }
}
