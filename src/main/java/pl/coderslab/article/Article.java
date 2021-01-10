package pl.coderslab.article;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = Article.TABLE)
public class Article {
    public static final String TABLE = "article";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    @NotBlank
    @Size(max = 200)
    private String title;
    @ManyToOne
    private Author author;
    @ManyToMany
    @Size(min = 1)
    private List<Category> categories ;
    @NotBlank
    @Size(min = 500)
    @Column(length = 1000)
    private String content;
    private Timestamp created;
    private Timestamp updated;

    public Article(){
        categories= new ArrayList<>();
    }

public void addToCategories(Category category){
    categories.add(category);
}

    public void setCreated() {
        this.created =Timestamp.valueOf(LocalDateTime.now());
    }


    public void setUpdated() {
        this.updated =Timestamp.valueOf(LocalDateTime.now());
    }

}
