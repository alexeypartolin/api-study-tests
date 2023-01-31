package backend.pojo.reqrespojocontrollers.getlistusersfrompage;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

@JsonIgnoreProperties(ignoreUnknown = true)
public class PojoResUsers {
    private Integer page;
    private Integer per_page;
    @JsonProperty("total")
    private Integer Vsego;
    private Integer total_pages;
    private List<DataJSONArray> data;
    private SupportJSONObject support;
}
