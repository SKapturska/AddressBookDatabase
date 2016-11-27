package addressbookdatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PersonManagement {

    List<Person> people = new ArrayList<Person>();

    private void addToBook() {
        Scanner sc = new Scanner(System.in);
        String lastName;
        String firstName;
        String city;
        int phoneNumber;

        System.out.print("Podaj nazwisko ");
        lastName = sc.nextLine();

        System.out.print("Podaj imie ");
        firstName = sc.nextLine();

        System.out.print("Podaj Miasto ");
        city = sc.nextLine();

        System.out.print("Podaj numer telefonu ");
        phoneNumber = sc.nextInt();
        System.out.println();
        people.add(new Person(lastName, firstName, city, phoneNumber));
    }

    private void showPeople() {
        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.println("Nazwisko: " + p.getLastName() + " Imię: " + p.getFirstName() + " Miasto: " + p.getCity() + " Numer telefonu: " + p.getPhoneNumber() + "\n");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chosen = 0;
        do {
            do {
                System.out.print("1: Wpisz człowieka \n2: Wypisz człowieków \n3: Wyjście \n");
                chosen = sc.nextInt();
            } while (chosen != 1 && chosen != 2 && chosen != 3);

            if (chosen == 1) {
                addToBook();
            } else if (chosen == 2) {
                Collections.sort(people);
                showPeople();
            } else if (chosen == 3) {
                
            }

        } while (chosen != 3);

    }

}
