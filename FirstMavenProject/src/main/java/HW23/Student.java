package HW23;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int groupId;
    private int year;

    @Override
    public String toString() {
        return
                "id=" + id +
                ", firstName='" + firstName + ", lastName='" + lastName + ", groupId=" + groupId + ", year=" + year ;
    }

}
