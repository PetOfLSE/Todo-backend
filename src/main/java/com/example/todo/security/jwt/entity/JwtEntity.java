package com.example.todo.security.jwt.entity;

import com.example.todo.user.model.entity.UserEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Table(name = "refresh")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JwtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "created_at")
    @Comment("생성 시간")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "expired_at")
    @Comment("만료 시간")
    private LocalDateTime expiredAt;

    @Column(nullable = false, name = "token")
    @Comment("refresh token")
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Comment("사용자 고유 id")
    private UserEntity user;
}
