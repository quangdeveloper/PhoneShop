package vn.nsi.iphoneshop.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import vn.nsi.iphoneshop.util.Constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class RsRP<T> {

    @JsonProperty(Constant.RESPONSE.RS)
    List<T> content = Collections.emptyList();

    public RsRP(T content) {
        if (content != null) {
            this.content = Arrays.asList(content);
        }

    }

    public RsRP(List<T> content) {
        if (content != null)
            this.content = content;
    }
}
