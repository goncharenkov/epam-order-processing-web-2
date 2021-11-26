package epam.api.rest;

import epam.domain.Order;
import epam.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/epam/v1/orders")
@Api(tags = {"order"})
public class OrderController extends AbstractRestHandler {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create an order.")
    public void createOrder(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response) {
        Order createdOrder = this.orderService.createOrder(order);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdOrder.getOrderId()).toString());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single order.")
    public
    @ResponseBody
    Order getOrder(@ApiParam(value = "The ID of the order.", required = true)
                   @PathVariable("id") int id,
                   HttpServletRequest request, HttpServletResponse response) throws Exception {
        Order order = this.orderService.getOrder(id);
        return order;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete an order.")
    public void deleteOrder(@ApiParam(value = "The ID of the existing order.", required = true)
                            @PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.orderService.getOrder(id));
        this.orderService.deleteOrder(id);
    }
}
