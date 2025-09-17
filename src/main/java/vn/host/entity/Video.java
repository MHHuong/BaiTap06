package vn.host.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "videos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition="NVARCHAR(255)", nullable=false)
    private String title;

    @Column(columnDefinition="NVARCHAR(MAX)")
    private String description;

    private String url;

    private Boolean active = true;

    private LocalDateTime uploadedAt = LocalDateTime.now();
}