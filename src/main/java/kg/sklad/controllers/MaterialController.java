package kg.sklad.controllers;

import kg.sklad.entities.Material;
import kg.sklad.services.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/material")
@CrossOrigin(origins = "http://localhost:3000")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping()
    public List<Material> getAllMaterials() {
        return materialService.findAll();
    }

    @GetMapping("/{id}")
    public Material getMaterial(@PathVariable("id") int id) {
        return materialService.findById(id);
    }

    @PostMapping()
    public Boolean addMaterial(@RequestParam("file") MultipartFile file, @RequestParam("productName")String productName,
                               @RequestParam("price") double price, @RequestParam("quantity") int quantity) throws Exception {

        if(file.isEmpty()) {
            System.out.println("File is not present, body");
        }
        return materialService.addMaterial(file, productName,price,quantity);

    }

}
