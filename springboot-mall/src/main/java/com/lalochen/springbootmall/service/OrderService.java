package com.lalochen.springbootmall.service;

import com.lalochen.springbootmall.dto.CreateOrderRequest;
import com.lalochen.springbootmall.dto.OrderQueryParams;
import com.lalochen.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);


    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
