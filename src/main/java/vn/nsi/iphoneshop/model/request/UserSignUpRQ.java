package vn.nsi.iphoneshop.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonPropertyOrder({"username","password","fullname","phone","email"})
public class UserSignUpRQ {

    @NotNull
    @JsonProperty("username")
    private String username;

    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("fullname")
    private String fullname;

    @NotNull
    @JsonProperty("phone")
    private String phone;

    @NotNull
    @JsonProperty("email")
    private String email;

}
