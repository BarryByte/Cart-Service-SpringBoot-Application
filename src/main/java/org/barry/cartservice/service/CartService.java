package org.barry.cartservice.service;

import org.barry.cartservice.FakeStoreDTO.CartServiceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";

    public CartServiceDTO[] getAllCarts(){
        CartServiceDTO[] response = restTemplate.getForObject(url + "/carts" , CartServiceDTO[].class);
        return response;
    }

    public CartServiceDTO getSingleCart(Long id){
        return restTemplate.getForObject(url + "/carts/" + id , CartServiceDTO.class);
    }

    public CartServiceDTO[] getUserCart(Long id){
        return restTemplate.getForObject(url +"/carts/user/" + id , CartServiceDTO[].class);
    }


    public CartServiceDTO updateCart(Long id) {
        CartServiceDTO cartServiceDTO = new CartServiceDTO();
        cartServiceDTO.setUserId(cartServiceDTO.getUserId());
        cartServiceDTO.setDate(cartServiceDTO.getDate());
        cartServiceDTO.setProducts(cartServiceDTO.getProducts());
        restTemplate.put(url, cartServiceDTO , CartServiceDTO.class );
        return cartServiceDTO;
    }

    public void deleteCart(Long id){
        restTemplate.delete(url+ "/carts/" + id  );
    }

    public CartServiceDTO[] getCartInRange(String startDate , String endDate){
        return restTemplate.getForObject(url + "/carts?startdate={startDate}&enddate={endDate}" , CartServiceDTO[].class);
    }

    public CartServiceDTO addCart(){
        CartServiceDTO cartServiceDTO = new CartServiceDTO();
        cartServiceDTO.setUserId(cartServiceDTO.getUserId());
        cartServiceDTO.setDate(cartServiceDTO.getDate());
        cartServiceDTO.setProducts(cartServiceDTO.getProducts());
        CartServiceDTO response = restTemplate.postForObject(url+  "/carts/" , cartServiceDTO, CartServiceDTO.class);
        assert response !=null;
        return response;
    }


}
