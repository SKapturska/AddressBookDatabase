package addressbookdatabase;

public class Person implements Comparable{
    private String lastName;
    private String firstName;
    private String city;
    private int phoneNumber;
    
    Person(String lastName, String firstName, String city, int phoneNumber){
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Object t) {
        String lastName = ((Person)t).getLastName();
        return (this.lastName.compareTo(lastName));
    }
    
    
}
