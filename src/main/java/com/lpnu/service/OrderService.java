package service;

import dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    OrderDTO createOrder(OrderDTO OrderDTO);
    OrderDTO updateOrder(OrderDTO OrderDTO);
    void deleteOrderById(Long id);
}
