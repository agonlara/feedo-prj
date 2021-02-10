package com.feedo.user.domain.use_cases.impl;

import com.feedo.user.domain.model.Product;
import com.feedo.user.domain.use_cases.AddProductUseCase;

public class AddProductUseCaseImpl implements AddProductUseCase {

    @Override
    public void addProduct(Product product) {

        if (product.isAvailable()) {

        }

        else {
            //Banner d'avís
        }
        //Boto afegir producte activat si availability is true

        //Afegir produte modifica la comdanda amb un nou producte

        //Pop up informatiu: Producte afegit

    }

}
