package vn.nsi.iphoneshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {

    private String username;

    private String password;

    private String fullname;

    private String email;

    private String phone;

    @Builder.Default
    private Boolean isActive = Boolean.TRUE;

    @ManyToMany
    @ToString.Exclude
    List<Role> roles;

    private String otp;

    private LocalDateTime expiredOTP;

}
