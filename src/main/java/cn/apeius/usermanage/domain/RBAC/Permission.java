package cn.apeius.usermanage.domain.RBAC;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Asus on 2016/10/19.
 */
@Table(name = "tb_permission")
public class Permission {
    @Id
    private Long id;
    private String permissionName;

    //一个权限可以被多个角色拥有
    @Transient
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", roles=" + roles +
                '}';
    }
}
