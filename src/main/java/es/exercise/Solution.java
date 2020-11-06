package es.exercise;

import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    
    public List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {
        
        if(productsStockInformation.isEmpty()) throw new IllegalArgumentException("List of Product stock is empty");
        if(productsSalesInformation.isEmpty()) throw new IllegalArgumentException("List of Product sales is empty");
        
        List<Long> result;
        if(stockWeight > salesWeight){
            result = doOrderByStock(productsStockInformation);
        }else if (stockWeight < salesWeight){
            result = doOrderBySales(productsSalesInformation);
        }else{
            result = doOrderByStock(productsStockInformation);//default case
        }
        return result;
    }
    
    private static List<Long> doOrderBySales(List<ProductSales> productsSalesInformation) {
        Comparator<ProductSales> compareBySales = Comparator.comparing(ProductSales::getSalesAmount);
        List<ProductSales> sorted = productsSalesInformation.stream().sorted(compareBySales.reversed()).collect(Collectors.toList());
        return sorted.stream().map(ProductSales::getProductId).collect(Collectors.toList());
    }
    
    private static List<Long> doOrderByStock(List<ProductStock> productsStockInformation) {
        Comparator<ProductStock> compareByStock = Comparator.comparing(ProductStock::getAvailableStock);
        List<ProductStock> sorted = productsStockInformation.stream().sorted(compareByStock.reversed()).collect(Collectors.toList());
        return sorted.stream().map(ProductStock::getProductId).collect(Collectors.toList());
    }
    
}
