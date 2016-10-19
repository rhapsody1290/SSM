package cn.apeius.usermanage.domain;

import cn.apeius.usermanage.domain.RBAC.User;

/**
 * Created by Asus on 2016/10/8.
 */
public class UserForm {
    private User[] users;

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
