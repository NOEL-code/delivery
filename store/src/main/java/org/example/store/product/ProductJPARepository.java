package org.example.store.product;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJPARepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    void deleteById(Long id);
}
