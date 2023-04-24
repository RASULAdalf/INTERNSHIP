package lk.seekerscloud.InternshipTask.util;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
