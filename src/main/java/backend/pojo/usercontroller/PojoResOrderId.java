package backend.pojo.usercontroller;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

public class PojoResOrderId {
    Integer id;
    Integer petId;
    Integer quantity;
    String shipDate;
    String status;
    Boolean complete;
}
