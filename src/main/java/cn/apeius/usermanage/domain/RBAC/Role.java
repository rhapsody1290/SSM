package cn.apeius.usermanage.domain.RBAC;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by Asus on 2016/10/19.
 */
@Table(name = "tb_role")
public class Role {
    @Id
    private Long id;
    private String roleName;
    //一个角色对应多个用户
    @Transient
    private List<User> users;
    //一个角色有多个权限
    @Transient
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                ", permissions=" + permissions +
                '}';
    }
}
