package com.example.todo.user.model.entity;

import com.example.todo.common.enums.Role;
import com.example.todo.security.jwt.entity.JwtEntity;
import com.example.todo.todo.model.entity.TodoEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "user_id")
    @Comment("아이디")
    private String userId;

    @Column(nullable = false, name = "password")
    @Comment("비밀번호")
    private String password;

    @Column(nullable = false, name = "email")
    @Comment("이메일")
    private String email;

    @Column(nullable = false, name = "name")
    @Comment("이름")
    private String name;

    @Column(name = "register_at")
    @Comment("가입 날짜")
    private LocalDate registerAt;

    @Column(name = "roles")
    @Comment("사용자 권한")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    @Comment("사용자가 작성한 할 일 목록")
    private List<TodoEntity> todo;

    @OneToMany(mappedBy = "user")
    @Comment("사용자 refresh token")
    private List<JwtEntity> jwt;
}
