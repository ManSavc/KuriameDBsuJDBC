package org.codeacademy.egzaminai;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Rezultatai")
public class  Rezultatai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Res_id")
    private Long res_id;



    //    Integer result = 2*2;
@Column(name = "Rezas")
private Integer Rezas;

//    public Integer getRezas() {
//        return Rezas;
//    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KLAUSIMO_NR")
    private Klausimas klausimas;
}
