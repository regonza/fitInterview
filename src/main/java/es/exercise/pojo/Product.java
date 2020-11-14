/*Copyright (C) Nuevo Banco del Chaco S.A.
Unauthorized copying of this file, via any medium is strictly prohibited.
Proprietary and confidential.*/
/* Created by gonza on 8/11/2020 */
package es.exercise.pojo;

import lombok.Data;

@Data
public class Product {
    Long productId;
    Double salesAmount;
    Long availableStock;
    
    public Product(Long productId, Double salesAmount, Long availableStock) {
        this.productId = productId;
        this.salesAmount = salesAmount;
        this.availableStock = availableStock;
    }
    
}
