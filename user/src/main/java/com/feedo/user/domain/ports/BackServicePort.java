package com.feedo.user.domain.ports;

import com.feedo.user.domain.model.Restaurant;

public interface BackServicePort {

    Restaurant getRestaurantByTable(String tableId);

}
