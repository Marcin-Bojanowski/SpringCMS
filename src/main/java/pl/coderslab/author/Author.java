package pl.coderslab.author;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.article.Article;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = Author.TABLE)
public class Author {
    public static final String TABLE = "author";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;


    public String getFullName() {
        return firstName + " " + lastName;
    }
}
