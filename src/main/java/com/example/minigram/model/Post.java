package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String image = "images/user.png";

    @Column(nullable = false)
    private String description;

    @Column
    private LocalDateTime datetime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User userPublisher;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", datetime=" + datetime +
                ", userPublisher=" + userPublisher.getId() +
                '}';
    }
}
