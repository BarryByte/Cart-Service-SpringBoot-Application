package org.barry.cartservice.controller;

import org.barry.cartservice.FakeStoreDTO.CartServiceDTO;
import org.barry.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    CartService cs;
    @GetMapping("/carts")
    public CartServiceDTO[] getAllProducts(){
        return cs.getAllCarts();
    }
    @GetMapping("/carts/{id}")
    public CartServiceDTO getSingleCart(@PathVariable Long id){
        return cs.getSingleCart(id);
    }

    @GetMapping("/carts/user/{id}")
    public CartServiceDTO[] getUserCart(@PathVariable Long id){
        return cs.getUserCart(id);
    }

    @PutMapping("/carts/{id}")
    public CartServiceDTO updateCart(@PathVariable Long id){
        return cs.updateCart(id);
    }
    @DeleteMapping("/carts/{id}")
    public String deleteCart(@PathVariable Long id){
        cs.deleteCart(id);
        return "Cart deleted Successfullly";
    }
    @GetMapping("/carts?startdate={startDate}&endate={endDate}")
    public CartServiceDTO[] getInDateRange(String startDate , String endDate){
        return cs.getCartInRange(startDate,endDate);
    }

    @PostMapping("/carts")
    public CartServiceDTO addCart(){
        return cs.addCart();
    }
}
