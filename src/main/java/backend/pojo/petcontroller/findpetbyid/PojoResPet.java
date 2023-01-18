package backend.pojo.petcontroller.findpetbyid;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder

public class PojoResPet {
    private Integer id;
    private String name;
    private String status;
    private List<Object> photoUrls; // Массив строк
    private Category category; // JSON объект
    private List<Tags> tags; // массив JSON объектов
}
