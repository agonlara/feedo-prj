package com.feedo.user.domain.use_cases.impl;

import com.feedo.user.domain.model.Order;
import com.feedo.user.domain.model.Product;
import com.feedo.user.domain.use_cases.AddProductUseCase;

public class AddProductUseCaseImpl implements AddProductUseCase {

    @Override
    public void addProduct(Product product) {

        if (product.isAvailable()) {

            //Boto afegir producte activat si està available

            Order.getInstance().getProducts().add(product);

            //Pop up informatiu: Producte afegit

        }

    }

}
