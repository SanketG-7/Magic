package net.homey.models;


import jakarta.persistence.*;
        import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feedback")

public class feedback {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String message;

    private int rating;

    private LocalDateTime createdAt = LocalDateTime.now();
}
