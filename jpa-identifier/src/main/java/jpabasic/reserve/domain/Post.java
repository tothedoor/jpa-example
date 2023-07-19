package jpabasic.reserve.domain;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity
@Table(name = "post", schema = "dev")
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_seq_gen",
            sequenceName = "post_seq",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_seq_gen"
    )
    private long id;
    private String title;
    private String content;
    @Column(name = "reg_dtm")
    private LocalDate regDtm;

    protected Post() {}

    public long getId() {
        return id;
    }

    public Post(String title, String content, LocalDate regDtm) {
        this.title = title;
        this.content = content;
        this.regDtm = regDtm;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getRegDtm() {
        return regDtm;
    }
}
