package org.base.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRoles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private Role role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", user=" + user +
                ", role=" + role +
                '}'+"\n";
    }
}
