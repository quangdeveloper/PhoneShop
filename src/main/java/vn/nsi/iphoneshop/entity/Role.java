package vn.nsi.iphoneshop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends BaseModel {

    private String code;

    private String name;

    private String description;

    private Long parentId;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}

