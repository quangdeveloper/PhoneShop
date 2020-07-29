package vn.nsi.iphoneshop.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;

@Builder
@Data
public class PageRP {

    @JsonProperty("rs")
    @Builder.Default
    private Object content = Collections.emptyList();

    @JsonProperty("total_item")
    private long total = 0;

}
