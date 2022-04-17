package HW25;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Students {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column(name = "id", nullable = false, columnDefinition = "int default 1")
    private int id;
    @Column(name = "first_name", nullable = true)
    private String firstName;
    @Column(name = "last_name", nullable = true)
    private String lastName;
    @Column(name = "group_id", nullable = true)
    private int groupId;
    @Column(name = "year", nullable = true)
    private int year;


    public Students(){

    }

    public Students(int id, String firstName, String lastName, int groupId, int year) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupId = groupId;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", firstName='" + firstName + ", lastName='" + lastName + ", groupId=" + groupId + ", year=" + year ;
    }

}