package com.lpnu.resourse;


import com.lpnu.dto.OrderDTO;
import com.lpnu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CartResource {

    @Autowired
    public CartService cartService;

    @GetMapping("/cart/{id}")
    public OrderDTO getCartByUserId(final @PathVariable Long userId){
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/cart/{id}/{gameId}")
    public OrderDTO addGameToCart(final @PathVariable Long id,
                                    final @PathVariable Long gameId){
        return cartService.addGameToCart(id, gameId);
    }


    @DeleteMapping("/cart/{id}/{gameId}")
    public OrderDTO removeGameFromCart(final @PathVariable Long userId,
                                  final @PathVariable Long gameId){
        return cartService.removeGameFromCart(userId, gameId);
    }

}