package edu.miu.eregister.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;

    @Column(nullable=false, unique=true)
    @NotBlank
    private String name;

    @ManyToMany(mappedBy="roles")
    private List<User> users;

    public Role() {
    }

    public Role(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Role otherRole = (Role)obj;
        if(roleId == null) {
            if(otherRole.roleId != null) return false;
        }
        return (roleId.equals(otherRole.roleId)
                && name.equals(otherRole.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.roleId, this.name);
    }

}
