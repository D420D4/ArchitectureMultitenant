package com.surf.surf.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "avis")
public class Avis {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "surfeur_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Surfeur surfeur;

    @Id
    @GeneratedValue(generator = "avis_generator")
    @SequenceGenerator(
            name = "avis_generator",
            sequenceName = "avis_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(columnDefinition = "text")
    private String text;

    @Column(columnDefinition = "text")
    private String note;

    public Surfeur getSurfeur() {
        return surfeur;
    }

    public void setSurfeur(Surfeur surfeur) {
        this.surfeur = surfeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
