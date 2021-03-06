package com.lpnu.service;


import com.lpnu.dto.OrderDTO;

public interface CartService {
    OrderDTO getCartByUserId(Long userId);
    OrderDTO addGameToCart(Long userId, Long gameId);
    OrderDTO removeGameFromCart(Long userId, Long gameId);
}
