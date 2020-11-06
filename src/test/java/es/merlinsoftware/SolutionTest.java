/*Copyright (C) Nuevo Banco del Chaco S.A.
Unauthorized copying of this file, via any medium is strictly prohibited.
Proprietary and confidential.*/
/* Created by gonza on 5/11/2020 */
package es.merlinsoftware;

import es.exercise.Solution;
import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SolutionTest {
    
    @InjectMocks
    Solution solution;
    
    
    @BeforeEach
    public void setUpData() {
        ProductStock productStock = new ProductStock(1L,400000L);
        ProductStock productStock2 = new ProductStock(2L,200000L);
        ProductStock productStock3 = new ProductStock(3L,700000L);

        List<ProductStock> productsStockInformation = new ArrayList<>();
        productsStockInformation.add(productStock2);
        productsStockInformation.add(productStock);
        productsStockInformation.add(productStock3);

        List<ProductSales> productsSalesInformation = new ArrayList<>();
        ProductSales productSales = new ProductSales(1L, 20d);
        ProductSales productSales1 = new ProductSales(2L, 30d);
        ProductSales productSales2 = new ProductSales(3L, 10d);

        productsSalesInformation.add(productSales);
        productsSalesInformation.add(productSales1);
        productsSalesInformation.add(productSales2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void sortProductsByScores_throwExceptionWhen_productStockListIsEmpty(){
        List<ProductSales> sales = new ArrayList<>();
        List<ProductStock> stocks = new ArrayList<>();
        when(solution.sortProductsByScores(1,1,stocks,sales)).thenThrow(new IllegalArgumentException("List of Product stock is empty"));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void sortProductsByScores_throwExceptionWhen_salesStockListIsEmpty(){
        List<ProductSales> sales = new ArrayList<>();
        List<ProductStock> stocks = new ArrayList<>();
        stocks.add(new ProductStock(1l,1l));
        when(solution.sortProductsByScores(1,1,stocks,sales)).thenThrow(new IllegalArgumentException("List of Product stock is empty"));
    }
    
    @Test
    public void sortProductsByScores_sortByStock(){
        ProductStock productStock = new ProductStock(1L,400000L);
        ProductStock productStock2 = new ProductStock(2L,200000L);
        ProductStock productStock3 = new ProductStock(3L,700000L);

        List<ProductStock> productsStockInformation = new ArrayList<>();
        productsStockInformation.add(productStock2);
        productsStockInformation.add(productStock);
        productsStockInformation.add(productStock3);

        List<ProductSales> productsSalesInformation = new ArrayList<>();
        ProductSales productSales = new ProductSales(1L, 20d);
        ProductSales productSales1 = new ProductSales(2L, 30d);
        ProductSales productSales2 = new ProductSales(3L, 10d);

        productsSalesInformation.add(productSales);
        productsSalesInformation.add(productSales1);
        productsSalesInformation.add(productSales2);
        List<Long> result = new ArrayList<>();
        result.add(3L);
        result.add(1L);
        result.add(2L);
        
        assertThat(solution.sortProductsByScores(2,1,productsStockInformation,productsSalesInformation)).isEqualTo(result);
    }
    
    @Test
    public void sortProductsByScores_sortByDefault(){
        ProductStock productStock = new ProductStock(1L,400000L);
        ProductStock productStock2 = new ProductStock(2L,200000L);
        ProductStock productStock3 = new ProductStock(3L,700000L);
        
        List<ProductStock> productsStockInformation = new ArrayList<>();
        productsStockInformation.add(productStock2);
        productsStockInformation.add(productStock);
        productsStockInformation.add(productStock3);
        
        List<ProductSales> productsSalesInformation = new ArrayList<>();
        ProductSales productSales = new ProductSales(1L, 20d);
        ProductSales productSales1 = new ProductSales(2L, 30d);
        ProductSales productSales2 = new ProductSales(3L, 10d);
        
        productsSalesInformation.add(productSales);
        productsSalesInformation.add(productSales1);
        productsSalesInformation.add(productSales2);
        List<Long> result = new ArrayList<>();
        result.add(3L);
        result.add(1L);
        result.add(2L);
        
        assertThat(solution.sortProductsByScores(2,1,productsStockInformation,productsSalesInformation)).isEqualTo(result);
    }
    
    @Test
    public void sortProductsByScores_sortBySales(){
        ProductStock productStock = new ProductStock(1L,400000L);
        ProductStock productStock2 = new ProductStock(2L,200000L);
        ProductStock productStock3 = new ProductStock(3L,700000L);
    
        List<ProductStock> productsStockInformation = new ArrayList<>();
        productsStockInformation.add(productStock2);
        productsStockInformation.add(productStock);
        productsStockInformation.add(productStock3);
    
        List<ProductSales> productsSalesInformation = new ArrayList<>();
        ProductSales productSales = new ProductSales(1L, 20d);
        ProductSales productSales1 = new ProductSales(2L, 30d);
        ProductSales productSales2 = new ProductSales(3L, 10d);
    
        productsSalesInformation.add(productSales);
        productsSalesInformation.add(productSales1);
        productsSalesInformation.add(productSales2);
        List<Long> result = new ArrayList<>();
        result.add(2L);
        result.add(1L);
        result.add(3L);
    
        assertThat(solution.sortProductsByScores(1,2,productsStockInformation,productsSalesInformation)).isEqualTo(result);
    }
    
    
    
    
    
}
