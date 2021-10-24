package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SECRET")
public class Secret {
    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "PAYLOAD")
    private String payload;

    public Secret(String payload) {
        this.payload = payload;
    }
}
