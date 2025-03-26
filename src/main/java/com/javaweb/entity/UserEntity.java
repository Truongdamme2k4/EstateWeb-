package com.javaweb.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4988455421375043688L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", nullable = false, unique = true)
    String userName;

    @Column(name = "fullname", nullable = false)
    String fullName;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "status", nullable = false)
    Integer status;

    @Column(name = "email", unique = true)
    String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    List<RoleEntity> roles = new ArrayList<>();


    @ManyToMany(mappedBy = "userEntities")
    List<BuildingEntity> buildingEntities = new ArrayList<>();

    @ManyToMany(mappedBy = "userEntities")
    List<CustomerEntity> customerEntities = new ArrayList<>();
//
//    @OneToMany(mappedBy="users", fetch = FetchType.LAZY)
//    private List<UserRoleEntity> userRoleEntities = new ArrayList<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


}