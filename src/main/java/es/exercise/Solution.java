package es.exercise;

import es.exercise.pojo.Product;
import es.exercise.pojo.ProductSales;
import es.exercise.pojo.ProductStock;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    
    public List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {
        
        if(productsStockInformation.isEmpty()) throw new IllegalArgumentException("List of Product stock is empty");
        if(productsSalesInformation.isEmpty()) throw new IllegalArgumentException("List of Product sales is empty");
        
        /*flat stock list on product list*/
        List<Product> products = productsStockInformation.stream()
                .map(p -> new Product(p.getProductId(),0d,p.getAvailableStock()))
                .collect(Collectors.toList());
        
        /*update flatten list with sales amount, and get both list flattened*/
        products.forEach(product ->
                product.setSalesAmount(
                        productsSalesInformation.stream()
                        .filter(sales -> sales.getProductId().equals(product.getProductId()))
                        .map(ProductSales::getSalesAmount)
                        .findAny().orElse(0D)
                )
        );
        
        Comparator<Product> compareBySales = Comparator.comparing(Product::getSalesAmount).reversed();
        Comparator<Product> compareByStock = Comparator.comparing(Product::getAvailableStock).reversed();
        
        List<Long> result;
        if(stockWeight > salesWeight){
            result = doOrderByStock(products,compareBySales,compareByStock);
        }else if (stockWeight < salesWeight){
            result = doOrderBySales(products,compareBySales,compareByStock);
        }else{
            result = doOrderByStock(products,compareBySales,compareByStock);//default case
        }
//        System.out.println(result);
        return result;
    }
    
    private static List<Long> doOrderBySales(List<Product> products, Comparator<Product> compareBySales, Comparator<Product> compareByStock) {
        List<Product> sorted = products.stream()
                .sorted(compareBySales.thenComparing(compareByStock))
                .collect(Collectors.toList());
        return getSortedIds(sorted);
    }
    
    private static List<Long> doOrderByStock(List<Product> products, Comparator<Product> compareBySales, Comparator<Product> compareByStock) {
        List<Product> sorted = products.stream()
                .sorted(compareByStock.thenComparing(compareBySales))
                .collect(Collectors.toList());
        return getSortedIds(sorted);
    }
    
    private static List<Long> getSortedIds(List<Product> sorted) {
        return sorted.stream().map(Product::getProductId).collect(Collectors.toList());
    }
    
}
