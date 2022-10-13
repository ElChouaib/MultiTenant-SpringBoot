package com.example.demo.order;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDto {
    private String name;

    @NotNull
    private int userId;

}
