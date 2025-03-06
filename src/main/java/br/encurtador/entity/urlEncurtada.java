package br.encurtador.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class urlEncurtada {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String urlOriginal;

    @Column
    private String codigoCurto;

    public urlEncurtada(String urlOriginal, String codigoCurto) {
        this.urlOriginal = urlOriginal;
        this.codigoCurto = codigoCurto;
    }
}
