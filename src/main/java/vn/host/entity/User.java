package vn.host.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable=false)
    private String password;

    @Column(columnDefinition="NVARCHAR(255)")
    private String fullName;

    @Column(unique=true)
    private String email;

    private Boolean active = true;

    private LocalDateTime createdAt = LocalDateTime.now();
}