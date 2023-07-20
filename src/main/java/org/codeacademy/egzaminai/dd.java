package org.codeacademy.egzaminai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
public class dd {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        User user = new User();
        System.out.println("Type: Teacher 'press 1'\n \t Student 'press 0' ");
        user.setType(Integer.valueOf(sc.nextLine()));
        System.out.println(" type " + user.getType());

        System.out.println("yours nickname: ");
        user.setNick(sc.nextLine());
        System.out.println("Hello " + user.getNick()+" !  ");

        if (user.getType() == 0) {  //if we write '1'for teacher, program ends
            System.out.println(" Yuo got some questions : ");
            Klausimas klausimas = new Klausimas();
            klausimas.setKlausimasText("Kokia apytiksliai būna žaibo iškrovos įtampa?\n");
            Answer answer1 = new Answer();
            answer1.setText("100kV");
            answer1.setAnswerTrue(false);
            Answer answer2 = new Answer();
            answer2.setText("10GV ");
            answer2.setAnswerTrue(false);
            Answer answer3 = new Answer();
            answer3.setText("100MV");
            answer3.setAnswerTrue(true);
            System.out.println(klausimas.getKlausimasText() + "\n 1 " + answer1.getText() + "\n 2 " + answer2.getText() + "\n 3 " + answer3.getText());

            Answer select = new Answer();
            select.setAnswerSelect(sc.nextInt());
            answer1.setAnswerSelect(select.getAnswerSelect());
            answer2.setAnswerSelect(select.getAnswerSelect());
            answer3.setAnswerSelect(select.getAnswerSelect());

            klausimas.getAtsakymuSar().add(answer1);
            klausimas.getAtsakymuSar().add(answer2);
            klausimas.getAtsakymuSar().add(answer3);

            answer1.setKlausimas(klausimas);
            answer2.setKlausimas(klausimas);
            answer3.setKlausimas(klausimas);

            Klausimas klausimas2 = new Klausimas();
            klausimas2.setKlausimasText("kokia apytiksliai būna žaibo iškrovos srovė? ");
            Answer answer21 = new Answer();
            answer21.setText("60 ~ 170 A");
            answer21.setAnswerTrue(false);
            Answer answer22 = new Answer();
            answer22.setText("60 ~ 170 kA");
            answer22.setAnswerTrue(true);
            Answer answer23 = new Answer();
            answer23.setText("60 ~ 170MA");
            answer23.setAnswerTrue(false);

            System.out.println(klausimas2.getKlausimasText() + "\n 1 " + answer21.getText() + "\n 2 " + answer22.getText() + "\n 3 " + answer23.getText());
            Answer select2 = new Answer();
            select2.setAnswerSelect(sc.nextInt());
            answer21.setAnswerSelect(select2.getAnswerSelect());
            answer22.setAnswerSelect(select2.getAnswerSelect());
            answer23.setAnswerSelect(select2.getAnswerSelect());

            klausimas2.getAtsakymuSar().add(answer21);
            klausimas2.getAtsakymuSar().add(answer22);
            klausimas2.getAtsakymuSar().add(answer23);

            answer21.setKlausimas(klausimas2);
            answer22.setKlausimas(klausimas2);
            answer23.setKlausimas(klausimas2);

            Rezultatai rezultas = new Rezultatai();
            int x = 0;
            int atsakyta = 0;
            System.out.println(answer1.getAnswerTrue());
            System.out.println(answer2.getAnswerTrue());
            System.out.println(answer3.getAnswerTrue());
            for (int i = 0; i < 1; i++) {
                if (answer1.getAnswerTrue().equals(true)) {
                    x = 1;
                    System.out.println("daro 1 " + x + "atsakyta " + atsakyta);
                }
                if (answer2.getAnswerTrue().equals(true)) {
                    x = 2;
                    System.out.println("daro 2 " + x + "atsakyta " + atsakyta);
                }
                if (answer3.getAnswerTrue().equals(true)) {
                    x = 3;
                    System.out.println("daro 3 " + x + "atsakyta " + atsakyta);
                }
            }
            if (x == answer1.getAnswerSelect()) {
                atsakyta++;
                System.out.println("ieina i 1  " + x + "atsakyta " + atsakyta);
            }
            x = 0;
            System.out.println(answer21.getAnswerTrue());
            System.out.println(answer22.getAnswerTrue());
            System.out.println(answer23.getAnswerTrue());
            System.out.println("pries 2  " + x + "atsakyta " + atsakyta);

            for (int i = 0; i < 1; i++) {
                if (answer21.getAnswerTrue().equals(true)) {
                    x = 1;
                    System.out.println("daro 1 " + x + "atsakyta " + atsakyta);
                }
                if (answer22.getAnswerTrue().equals(true)) {
                    x = 2;
                    System.out.println("daro 2 " + x + "atsakyta " + atsakyta);
                }
                if (answer23.getAnswerTrue().equals(true)) {
                    x = 3;
                    System.out.println("daro 3 " + x + "atsakyta " + atsakyta);
                }
            }
            if (x == answer21.getAnswerSelect()) {
                atsakyta++;
                System.out.println("ieina i 2  " + x + "atsakyta " + atsakyta);
            }
            rezultas.setRezas(atsakyta);
            System.out.println("Rezultatas " + rezultas.getRezas());

            Transaction t = session.beginTransaction();
            session.persist(user);
            session.persist(klausimas);
            session.persist(klausimas2);
            session.persist(rezultas);
            t.commit();
            session.close();
        }
    }
}

