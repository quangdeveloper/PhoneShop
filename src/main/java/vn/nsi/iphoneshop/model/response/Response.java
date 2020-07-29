package vn.nsi.iphoneshop.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.StringUtils;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"map", "code", "message"})
public class Response {

    @JsonIgnore
    private Object map;

    private String code;

    private String message;

    @JsonProperty("map")
    public Object getBody() {

        if (map != null && map instanceof ActionRP) {//xu update, insert, delete
            return ((ActionRP) map).getValue();
        }
        if (!StringUtils.hasText(message)) {//xu truong TH ko co message

            String mess = ResponseConfig.getInstance().getMess(this.code);
            if (mess != null) {
                this.message = mess;
            }
        }
        //mac dinh la se return lai gia tri dc gan
        return map;
    }

}
