package backend.pojo.reqrespojocontrollers.postcreatenewuser;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

public class PojoResCreateUser {
    String name;
    String job;
    String id;
    String createdAt;
}
