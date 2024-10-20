import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "movies")
@ToString(exclude = "movies")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Movie> movies;
}