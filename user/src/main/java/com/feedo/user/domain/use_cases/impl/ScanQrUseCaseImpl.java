package com.feedo.user.domain.use_cases.impl;

import com.feedo.user.domain.model.Restaurant;
import com.feedo.user.domain.ports.BackServicePort;
import com.feedo.user.domain.use_cases.ScanQRUseCase;

public class ScanQrUseCaseImpl implements ScanQRUseCase {

    private final BackServicePort backService;
    public ScanQrUseCaseImpl(BackServicePort backService) {
        this.backService = backService;
    }

    @Override
    public void scanTable(String tableId) {
        // L'aplicacio crida al back demanant pel restaurant de la taula
        Restaurant restaurant = backService.getRestaurantByTable(tableId);

        // Mirar si restaurant esta open
        if(restaurant.isOpen()){
            // Es carrega la interfaz amb la llista de productes del restaurant
        }else{
            // Popup dient que restaurant està tancat
        }
        // Afegir item order UC
    }

}
