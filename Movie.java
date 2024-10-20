import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "actors")
@ToString(exclude = "actors")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_release")
    private int yearOfRelease;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}