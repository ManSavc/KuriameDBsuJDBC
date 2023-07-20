package org.codeacademy.egzaminai;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Answer")
public class Answer {

    @Id //this is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answer_id") //@Collumn rodo su kokiu stulpeliu bus suristi duomenys
                                //pvz jeigu stulpelio pavadinimas atitinka duomenu pavadinima, tada ok,
                        //bet sujungiant reikia nurodyti'su mapinti' pvz lentele'atlikejas' , o duomenys 'daininikas'
    private Long answer_id;

    @Column(name = "AnswerSelect")
    private Integer answerSelect;

    @Column(name = "Text")
    private String text;

    @Column(name = "AnswerTrue")
    private Boolean answerTrue;

    @ManyToOne(fetch = FetchType.LAZY)  // fettch type lazy ---> (hibernato parinkimas)netraukia nepazymetu lauku kuriu neprasom
    @JoinColumn(name = "KLAUSIMO_NR")   //sudarom rysi, daug atsakymu
    private Klausimas klausimas;        // vienam klausimui
}
