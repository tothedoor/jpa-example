package jpabasic.reserve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "user", schema = "dev")
public class User {

    @Id
    private String email;

    private String name;

    @Column(name = "create_date")
    private LocalDate createDate;

    protected User() {}

    public User(String email, String name, LocalDate createDate) {
        this.email = email;
        this.name = name;
        this.createDate = createDate;
    }
}
