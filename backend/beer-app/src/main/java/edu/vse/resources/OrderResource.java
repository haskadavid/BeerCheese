package edu.vse.resources;

import edu.vse.context.CallContext;
import edu.vse.dtos.Order;
import edu.vse.exceptions.NotFoundException;
import edu.vse.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderResource {

    private final OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Order get(@PathVariable int id) {
        if (CallContext.isAdmin()) {
            return orderService.getOrder(id)
                    .orElseThrow(() -> new NotFoundException("Order not found"));
        } else {
            return CallContext.getContext().getUserId()
                    .flatMap(user -> orderService.getOrderForUser(id, user))
                    .orElseThrow(() -> new NotFoundException("Order not found"));
        }
    }
}
