package com.codegym.model;

import com.codegym.repositories.ProductRepository;
import com.codegym.service.product.ProductService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {

    List<ItemLine> itemLines = new ArrayList<>();
    public ItemLine getItemLineByItem(Product product){
        for (ItemLine itemLine: itemLines){
            if (itemLine.getProduct().getId().equals(product.getId())) return itemLine;
        }
        ItemLine itemLine = new ItemLine(product);
        itemLines.add(itemLine);
        return itemLine;
    }
    public void removeItemLineByProduct(Product product){
        for (ItemLine itemLine: itemLines){
            if (itemLine.getProduct().getId().equals(product.getId())){
                itemLines.remove(itemLine);
                return;
            }
        }
    }
}
