package resourse;

import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CartService;

@RestController
public class CartResource {
/*
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
    */

}