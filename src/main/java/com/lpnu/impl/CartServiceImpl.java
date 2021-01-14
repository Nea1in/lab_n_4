package com.lpnu.impl;


import com.lpnu.dto.OrderDTO;
import com.lpnu.entity.Game;
import com.lpnu.entity.Order;
import com.lpnu.mapper.OrderToOrderDTOMapper;
import com.lpnu.repository.GameRepository;
import com.lpnu.repository.OrderRepository;
import com.lpnu.repository.UserRepository;
import com.lpnu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private OrderToOrderDTOMapper orderMapper;

    @Override
    public OrderDTO getCartByUserId(final Long userId) {
        return null;
    }

    @Override
    public OrderDTO addGameToCart(final Long userId, final Long gameId) {
        final List<Order> orders = orderRepository.getOrdersByUserId(userId);

        Order order = orders.stream()
                .filter(e -> !e.wasPaid())
                .findFirst()
                .orElse(null);

        if(order == null){
            //тут ми створюємо нове замовлення
            order = new Order();

            order.setOrderDate(LocalDate.now());
            order.setUser(userRepository.getUserById(userId));

        }

        final Game game = gameRepository.getGameById(gameId);

        if(order.getOrderDetails().containsKey(game)){
            int value = order.getOrderDetails().get(game);
            order.getOrderDetails().put(game, ++value);
        } else {
            order.getOrderDetails().put(game, 1); //we use 1 because it is first game
        }

        orderRepository.createOrder(order);


        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO removeGameFromCart(final Long userId, final Long bookId) {
        return null;
    }
}