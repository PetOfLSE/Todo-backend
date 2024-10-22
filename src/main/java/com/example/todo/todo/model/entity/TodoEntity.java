package com.example.todo.todo.model.entity;

import com.example.todo.user.model.entity.UserEntity;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "title")
    @Comment("제목")
    private String title;

    @Column(nullable = false, name = "content")
    @Comment("내용")
    private String content;

    @Column(nullable = false, name = "created_at")
    @Comment("등록일")
    private LocalDate createdAt;

    @Column(nullable = false, name = "completed")
    @Comment("할일 완료")
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Comment("사용자 고유 id")
    private UserEntity user;
}
