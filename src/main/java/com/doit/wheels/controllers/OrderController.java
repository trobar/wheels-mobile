package com.doit.wheels.controllers;

import com.doit.wheels.dao.entities.Order;
import com.doit.wheels.dao.entities.PicturesDto;
import com.doit.wheels.services.OrderService;
import com.doit.wheels.utils.exceptions.NoPermissionsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/order")
public class OrderController extends AbstractController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Order> getAllOrders(@PathVariable Long id) throws NoSuchElementException {
        Order order = orderService.findById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(value = "/page/{pageNumber}")
    @ResponseBody
    public ResponseEntity<List<Order>> getOrderFromPage(@PathVariable Integer pageNumber) throws NoSuchElementException {
        List<Order> orderList = orderService.fetchOrdersFromPage(pageNumber);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderNo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Order> getOrderByOrderNo(@PathVariable String id){
        return new ResponseEntity<>(orderService.findOrderByOrderNo(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Order> postOrder(@RequestBody Order order) {
        Order newOrder = orderService.save(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Order> putOrder(@RequestBody Order newOrder) {
        Order order = orderService.update(newOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Order> removeOrderWithAccesses(@PathVariable Long orderId) throws NoPermissionsException {
        Order order = orderService.findById(orderId);
        orderService.delete(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping(value = "/update-status/{id}", params = {"status"})
    @ResponseBody
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam("status") String status) {
        Order order = orderService.updateStatus(id, status);
        if(order == null) {
            throw new NoSuchElementException();
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping(value = "/assign-driver/{id}", params = {"driverId"})
    @ResponseBody
    public ResponseEntity<Order> assignDriver(@PathVariable Long id, @RequestParam("driverId") Long driverId) {
        Order order = orderService.assignDriver(id, driverId);
        if(order == null) {
            throw new NoSuchElementException();
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value = "/pictures/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PicturesDto> getOrderPicturesById(@PathVariable String id){
        return new ResponseEntity<>(orderService.getWheelsPicturesByOrderNo(id), HttpStatus.OK);
    }
}
