package vn.nsi.iphoneshop.model.param;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonPropertyOrder({"pageNo", "pageSize"})
public class PageParam {

    @NotNull
    @ApiModelProperty(required = true)
    private Integer pageNo;

    @ApiModelProperty(required = true)
    @NotNull
    private Integer pageSize;

}

