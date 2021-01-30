package com.feedo.back.infraestructure.rest;

import com.feedo.back.domain.model.Table;
import com.feedo.back.domain.use_cases.table.FindTableUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestaurantResource.RESTAURANTS)
@AllArgsConstructor
public class RestaurantResource {

    public static final String RESTAURANTS = "/restaurants";

    private final FindTableUseCase findTableUseCase;

    @GetMapping("/table/{id}")
    public Table findTable(@PathVariable String id) {
        return findTableUseCase.findTableById(id);
    }

}
