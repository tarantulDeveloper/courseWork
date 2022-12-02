package kg.sklad.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    private String fileName;
    private String downloadURL;
    private String fileType;
    private String fileSize;

}
