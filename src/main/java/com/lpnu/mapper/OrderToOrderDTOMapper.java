package mapper;

import dto.OrderDTO;
import entity.Order;
import entity.User;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDTOMapper {

    public Order toEntity(final OrderDTO orderDTO, final User user){
        if(user == null){

            //todo add custom exception throwing

        }

        final Order order = new Order();

        order.setId(orderDTO.getId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderDetails(order.getOrderDetails());
        order.setUser(user);

        return order;
    }

    public OrderDTO toDTO(final Order order){
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());
//        orderDTO.setOrderDetails(order.getOrderDetails());
        if(order.getUser() != null){
//            orderDTO.setUserFirstname(order.getUser().getFirstname());
//            orderDTO.setUserLastname(order.getUser().getLastname());
        }

        return orderDTO;
    }
}