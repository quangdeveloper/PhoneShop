package vn.nsi.iphoneshop.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginRQ {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
