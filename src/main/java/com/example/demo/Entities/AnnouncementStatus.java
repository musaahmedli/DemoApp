package com.example.demo.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Entity
@Data
@NoArgsConstructor
public class AnnouncementStatus
{
    @Id
    private long id;
    private String name;
    private boolean isActive;
}
