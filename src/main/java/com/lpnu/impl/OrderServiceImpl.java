package com.lpnu.impl;


import com.lpnu.dto.OrderDTO;
import com.lpnu.exception.ServiceException;
import com.lpnu.mapper.OrderToOrderDTOMapper;
import com.lpnu.repository.OrderRepository;
import com.lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderToOrderDTOMapper orderMapper;

    @Override
    public OrderDTO getOrderById(final Long id) {
        return orderMapper.toDTO(orderRepository.getOrderById(id));
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(e -> orderMapper.toDTO(e))
                .collect(Collectors.toList());    }

    @Override
    public OrderDTO createOrder(final OrderDTO orderDTO) {

        if(orderDTO.getId() != null){
            throw new ServiceException(400, "Order shouldn't have an id ", null);
        }

        return orderMapper.toDTO(orderRepository.createOrder(orderMapper.toEntity(orderDTO, null)));
    }

    @Override
    public OrderDTO updateOrder(final OrderDTO orderDTO) {
        if(orderDTO.getId() == null){
            throw new ServiceException(400, "Order have an id ", null);
        }

        return orderMapper.toDTO(orderRepository.updateOrder(orderMapper.toEntity(orderDTO, null)));
    }

    @Override
    public void deleteOrderById(final Long id) {
        orderRepository.deleteOrderById(id);
    }
}