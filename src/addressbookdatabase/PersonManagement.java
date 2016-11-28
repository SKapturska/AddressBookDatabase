package addressbookdatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonManagement {

    List<Person> people = new ArrayList<Person>();
    SingletonConnection singletonConnection = SingletonConnection.getInstance();
    

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
                System.out.print("1: Wpisz człowieka \n2: Wypisz człowieków \n3: Zapis do bazy \n4: Odczyt z bazy \n5: Wyjście \n");
                chosen = sc.nextInt();
            } while (chosen != 1 && chosen != 2 && chosen != 3 && chosen != 4 && chosen != 5);

            if (chosen == 1) {
                addToBook();
            } else if (chosen == 2) {
                Collections.sort(people);
                showPeople();
            } else if (chosen == 3) {
                singletonConnection.addToDatabase();
            } else if(chosen == 4){
                ResultSet rs = singletonConnection.readFromDatabase();
                try {
                    while(rs.next()){
                        System.out.println("id: " + rs.getString(1));
                        System.out.println("nazwisko: " + rs.getString(2));
                        System.out.println("imie: " + rs.getString(3));
                        System.out.println("miasto: " + rs.getString(4));
                        System.out.println("nr telefonu: " + rs.getString(5));
                        System.out.println();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if(chosen == 5){
                System.exit(0);
            }

        } while (chosen != 5);

    }

}
