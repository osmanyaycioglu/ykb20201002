package com.training.ykb.order.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RestaurantOrder {

    @NotEmpty
    @Size(max = 10, min = 5)
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }
}
