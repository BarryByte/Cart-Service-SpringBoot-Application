package org.barry.cartservice.FakeStoreDTO;

import lombok.Getter;
import lombok.Setter;
import org.barry.cartservice.models.Product;

@Getter
@Setter
public class CartServiceDTO {
    Long id;
    Long userId;
    String date;
    Product[] products;

}
