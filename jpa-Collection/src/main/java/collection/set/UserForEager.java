package collection.set;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "dev")
public class UserForEager {

    @Id
    private long id;
    private String name;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_tel",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "tel_no")
    private Set<String> telNoSet = new HashSet<>();

    protected UserForEager() {}

    public UserForEager(String name, Set<String> telNoSet) {
        this.name = name;
        this.telNoSet = telNoSet;
    }

    public Set<String> getTelNoSet() {
        return telNoSet;
    }
}
