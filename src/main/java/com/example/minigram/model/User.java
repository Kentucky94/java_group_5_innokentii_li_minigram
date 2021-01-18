package com.example.minigram.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int postsCount;

    @Column
    private int subscriptionsCount;

    @Column
    private int subscribersCount;

    @OneToMany(mappedBy = "userPublisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "userCommenter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "userLiked", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;

    @OneToMany(mappedBy = "userSubscriber", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscribers;

    @OneToMany(mappedBy = "userSubscribedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subscription> subscribedTo;
}
