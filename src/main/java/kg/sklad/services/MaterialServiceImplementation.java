package kg.sklad.services;

import kg.sklad.entities.Material;
import kg.sklad.repository.MaterialRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImplementation implements MaterialService{
    private final MaterialRepo materialRepo;

    public MaterialServiceImplementation(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }
    @Override
    public List<Material> findAll() {
        return materialRepo.findAll();
    }

    @Override
    public Boolean addMaterial(MultipartFile file, String productName, double price, int quantity) throws Exception{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence " + fileName);
            }
            Optional<Material> material = materialRepo.findByProductName(productName);
            if(material.isPresent()) {
                return false;
            }
            Material myMaterial = Material.builder()
                    .productName(productName)
                    .price(price)
                    .quantity(quantity)
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .data(file.getBytes())
                    .build();

            materialRepo.save(myMaterial);
            return true;

        } catch (Exception e) {
            throw new Exception("Could not save file: " + fileName);
        }
    }
}
