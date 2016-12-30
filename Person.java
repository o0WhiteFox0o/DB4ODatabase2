package btn.k23.dhcantho.db4odatabase;

/**
 * Created by sonlonglxag on 11/21/16.
 */

public class Person {

    public String name;
    public int score;
    public String email;

    //empty constructor
    public Person(){}

    //constructor for a retrieve operation
    public Person(String name, int score, String email) {
        this.name = name;
        this.score = score;
        this.email = email;
    }

    public String toString(){
        return  (name+" "+ score +" "+email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
