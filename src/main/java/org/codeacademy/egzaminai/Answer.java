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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answer_id")
    private Long answer_id;

    @Column(name = "Text")
    private String text;

    @Column(name = "AnswerTrue")
    private Boolean answerTrue;

    @ManyToOne(fetch = FetchType.LAZY)  // fettch type lazy ---> (hibernato parinkimas)netraukia nepazymetu lauku kuriu neprasom
    @JoinColumn(name = "KLAUSIMO_NR")   //sudarom rysi, daug atsakymu
    private Klausimas klausimas;        // vienam klausimui
}
