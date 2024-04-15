package de.thb.justnoteit.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Notebook {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "notebookId" , fetch = FetchType.EAGER)
    private List<Note> notes = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nid: ").append(this.id);
        sb.append("\ntitle: ").append(this.title);
        sb.append("\ndescription: ").append(this.description);
        return sb.toString();
    }

    public int getNumberOfNotes() {
        return notes.size();
    }

    public Note getNote(int noteId) {
        return this.notes.stream()
                .filter(note -> note.getId() == noteId)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}