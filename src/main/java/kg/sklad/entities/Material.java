package kg.sklad.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;
}
