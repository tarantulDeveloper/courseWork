package kg.sklad.services;

import kg.sklad.entities.Material;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MaterialService {
    List<Material> findAll();

    Boolean addMaterial(MultipartFile file, String productName, double price, int quantity) throws Exception;


}
