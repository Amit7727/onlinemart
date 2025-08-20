package common.dto;

import lombok.Data;

@Data
public class OrderDto {

    Long id;
    Long userId;
    String productId;
    Integer quantity;
    Double total;
}
