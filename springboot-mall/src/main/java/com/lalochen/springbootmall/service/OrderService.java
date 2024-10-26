package com.lalochen.springbootmall.service;

import com.lalochen.springbootmall.dto.CreateOrderRequest;
import com.lalochen.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);


    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
