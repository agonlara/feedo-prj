package com.feedo.user.domain.use_cases.impl;

import com.feedo.user.domain.model.Order;
import com.feedo.user.domain.ports.BackServicePort;
import com.feedo.user.domain.use_cases.SendOrderUseCase;

public class SendOrderUseCaseImpl implements SendOrderUseCase {


    private final BackServicePort backService;
    public SendOrderUseCaseImpl(BackServicePort backService) {this.backService = backService; }


    @Override
    public Order sendOrder(Order order) {

        //L'aplicació envia Order cap al Back i el back retorna la order que ha rebut
        return backService.sendOrder(order);

        // Es carrega una pantalla amb el resum de la order rebuda des del back


    }
}
