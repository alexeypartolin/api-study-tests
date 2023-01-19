package backend.pojo.reqrespojocontrollers.getlistusersfrompage;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

public class PojoResUsers {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<DataJSONArray> data;
    private SupportJSONObject supportObject;
}
