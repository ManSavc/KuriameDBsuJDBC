package org.codeacademy.egzaminai;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class dd {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();


        System.out.println("yours nickname");
        User user = new User();
        user.setNick(sc.nextLine());


        Klausimas klausimas = new Klausimas();
        klausimas.setKlausimasText("ar lyja");
        Answer answer = new Answer();
        answer.setText("taip");
        answer.setAnswerTrue(true);
        Answer answer2 = new Answer();
        answer2.setText("neg");
        answer2.setAnswerTrue(false);
        Answer answer3 = new Answer();
        answer3.setText("neznn");
        answer3.setAnswerTrue(false);

        klausimas.getAtsakymuSar().add(answer);
        klausimas.getAtsakymuSar().add(answer2);
        klausimas.getAtsakymuSar().add(answer3);

        answer.setKlausimas(klausimas);
        answer2.setKlausimas(klausimas);
        answer3.setKlausimas(klausimas);

//        session.persist(klausimas);
//
        Klausimas klausimas2 = new Klausimas();
        klausimas2.setKlausimasText("ar silta");
        Answer answer20 = new Answer();
        answer20.setText("manau");
        answer20.setAnswerTrue(true);
        Answer answer22 = new Answer();
        answer22.setText("jokiu_budu nezinau");
        answer22.setAnswerTrue(false);
        Answer answer23 = new Answer();
        answer23.setText("neisivaizduoju");
        answer23.setAnswerTrue(false);

        klausimas2.getAtsakymuSar().add(answer20);
        klausimas2.getAtsakymuSar().add(answer22);
        klausimas2.getAtsakymuSar().add(answer23);

        answer20.setKlausimas(klausimas2);
        answer22.setKlausimas(klausimas2);
        answer23.setKlausimas(klausimas2);
//
//        Rezultatai rezultatai = new Rezultatai();
//       // int j = 2;
//        rezultatai.setPateikta_klausimu(2);
////        rezultatai.setProcentas( 0);
//        //todo nes jei atsakytu nulis, negalima dalybagg
//        session.persist(rezultatai);
        session.persist(user);
        session.persist(klausimas);
        session.persist(klausimas2);
        t.commit();
        session.close();

//        Klausimas klausimas = new Klausimas();
//        klausimas.setKlausimas("Ar lyja");
////        klausimas.setAtsakymuSar("Ar lyja");
////        session.persist(klausimas);
//        List<Klausimas> klausimaiIsDb = session.createQuery("from Klausimas", Klausimas.class)
//                .getResultList();
////        klausimaiIsDb.stream().forEach(System.o);
//        klausimaiIsDb.stream().map(q -> gautiAtsakyma(q)).collect(Collectors.toList());
//
//        session.getTransaction().commit();
    }

//    private static Boolean gautiAtsakyma(Klausimas q) {
//        System.out.println(q.getKlausimas());
//        System.out.println(q.getAtsakymuSar());
//        String ats = sc.nextLine();
//        //q.setAtsakymas();  boolenas
////if equals..
//return null;
//    }
////private static int palygintiAtsakyma(){
//        //gauta atsakyma palyginti su nurodytu ats
//}

    private static Session createSession() {
        Configuration cfg = new Configuration();
        SessionFactory factory = cfg.configure().buildSessionFactory();
        Session session = factory.openSession();
        session.setHibernateFlushMode(FlushMode.ALWAYS);
        return session;
    }
}

