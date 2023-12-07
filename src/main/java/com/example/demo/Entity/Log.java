package com.example.demo.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    long Id;

    @NotNull
    Date OperationExecutionDate;

    @NotNull
    @ManyToOne
    User OperatedUser;

    boolean Active;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Date getOperationExecutionDate() {
        return OperationExecutionDate;
    }

    public void setOperationExecutionDate(Date operationExecutionDate) {
        OperationExecutionDate = operationExecutionDate;
    }

    public User getOperatedUser() {
        return OperatedUser;
    }

    public void setOperatedUser(User operatedUser) {
        OperatedUser = operatedUser;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
