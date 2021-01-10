package pl.coderslab.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@ToString
@Table(name = Category.TABLE)
public class Category {
    public final static String TABLE = "category";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //    @Column(length = 100)
    @NotBlank
    @Size(min = 5)
    private String name;
    private String description;
}
