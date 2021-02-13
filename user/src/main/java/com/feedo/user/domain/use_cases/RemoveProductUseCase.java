package com.feedo.user.domain.use_cases;

import com.feedo.user.domain.model.Order;
import com.feedo.user.domain.model.Product;

public interface RemoveProductUseCase {

    void removeProduct (Product product, Order order);
}
