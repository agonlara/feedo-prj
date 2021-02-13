package com.feedo.user.domain.use_cases;

import com.feedo.user.domain.model.Order;

public interface SendOrderUseCase {

    Order sendOrder(Order order);
}
