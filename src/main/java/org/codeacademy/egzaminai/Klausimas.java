package org.codeacademy.egzaminai;

import com.mysql.cj.Session;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "klausimas")
public class Klausimas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KLAUSIMO_NR")
    private Long klausimoNr;

    @Column(name = "KLAUSIMAS_text")
    private String klausimasText;

//    @OneTo//todo(fetch = FetchType.LAZY)
//    //maped by ...
//    cascade...
@OneToMany(
        mappedBy = "klausimas",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<Answer> atsakymuSar = new ArrayList<>();

}




