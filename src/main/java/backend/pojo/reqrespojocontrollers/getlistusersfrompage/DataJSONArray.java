package backend.pojo.reqrespojocontrollers.getlistusersfrompage;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

public class DataJSONArray {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
