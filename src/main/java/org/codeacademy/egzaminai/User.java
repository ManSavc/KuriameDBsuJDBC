package org.codeacademy.egzaminai;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
    @NoArgsConstructor
    @Entity
    @Table(name = "User")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "User_id")
        private Long user_id;

        @Column(name = "Nick")
        private String nick;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "KLAUSIMO_NR")
        private Klausimas klausimas;
    }


