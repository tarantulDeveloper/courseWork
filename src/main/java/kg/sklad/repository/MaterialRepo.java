package kg.sklad.repository;

import kg.sklad.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Integer> {
    Optional<Material> findByProductName(String productName);
}
