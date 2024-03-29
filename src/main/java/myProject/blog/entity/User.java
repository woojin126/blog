package myProject.blog.entity;

import lombok.*;
import myProject.blog.entity.enums.RoleInfo;
import myProject.blog.entity.timesupperclass.DatabaseEntity;

import javax.persistence.*;


@Getter
@Table(name = "UserInfo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends DatabaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_Id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleInfo role;



}
