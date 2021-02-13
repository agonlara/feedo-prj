package com.feedo.user.domain.use_cases.impl;

import com.feedo.user.domain.model.Order;
import com.feedo.user.domain.model.Product;
import com.feedo.user.domain.use_cases.RemoveProductUseCase;

public class RemoveProductUseCaseImpl implements RemoveProductUseCase {


    @Override
    public void removeProduct(Product product, Order order) {

        //Botó restar producte només està activat si el producte es troba a la Order

        if (order.getProducts().contains(product)) {
            order.getProducts().remove(product);
        }

        //missatge informatiu producte eliminat

    }
}
