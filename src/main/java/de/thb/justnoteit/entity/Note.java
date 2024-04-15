package de.thb.justnoteit.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private long notebookId;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: ").append(this.id);
        sb.append("\ntitle: ").append(this.title);
        sb.append("\ndescription: ").append(this.description);
        return sb.toString();
    }
}

