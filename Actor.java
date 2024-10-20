
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "actors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "movies")
@ToString(exclude = "movies")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @ManyToMany
    @JoinTable(name = "actors_to_movies",
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private List<Movie> movies = new ArrayList<>();
}