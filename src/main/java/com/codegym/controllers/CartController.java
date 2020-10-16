package com.codegym.controllers;

import com.codegym.model.Cart;
import com.codegym.model.ItemLine;
import com.codegym.model.Product;
import com.codegym.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/cart")
@Controller
@SessionAttributes("cart")
public class CartController {

    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart getCart(){
        return new Cart();
    }

    @GetMapping
    public String showCart(@ModelAttribute("cart") Cart cart){
        return "/shoppingCart/cart";
    }

    @GetMapping("/{id}")
    public String orderProduct(@PathVariable Long id, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        ItemLine itemLine = cart.getItemLineByItem(product);
        itemLine.setQuantity(itemLine.getQuantity()+1);
        return "redirect:/cart";
   }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, @ModelAttribute("cart") Cart cart){
        Product product = productService.findById(id);
        cart.removeItemLineByProduct(product);
        return "redirect:/cart";
    }

}
