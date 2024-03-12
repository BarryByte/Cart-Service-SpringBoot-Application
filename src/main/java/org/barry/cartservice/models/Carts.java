package org.barry.cartservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carts {
    private Long id;
    private Long userId;
    private String date;
    private Product[] products;


}
