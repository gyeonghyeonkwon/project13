package com.ll.project_13_backend.orders.service;

import com.ll.project_13_backend.member.entity.Member;
import com.ll.project_13_backend.orders.entity.Orders;

public interface OrdersService {
    Orders createFromCart(Member buyer);

    void payByCashOnly(Orders orders);
}
