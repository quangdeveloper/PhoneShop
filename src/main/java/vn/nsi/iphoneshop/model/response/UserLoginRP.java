package vn.nsi.iphoneshop.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserLoginRP {

    private String username;
    private String fullname;
    private String jwt;
    private List<RoleRP> roles;
}
