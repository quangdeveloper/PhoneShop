package vn.nsi.iphoneshop.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleRP {

    private Long id;
    private String code;
    private String name;
    private Long parentId;
}
