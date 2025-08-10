import java.sql.Date;

public class Answer_vi {
    
}

final class Employee {
    private final String name;
    private final int id;
    private final Date joiningDate;

    public Employee(String name, int id, Date joiningDate) {
        this.name = name;
        this.id = id;
        this.joiningDate = new Date(joiningDate.getTime()); // defensive copy to prevent external mutation
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    //return a defensive copy to protect the internal state

    public Date getJoiningDate() {
        return new Date(joiningDate.getTime());
    }

    @Override
    public String toString() {
        return "Employee{name = '"+ name + ", id ="+ id+", joiningDate = " + joiningDate+"'}";
    }
}

/*
 * 
Class is final → prevents subclassing that could break immutability.

Fields are private and final → ensures values are set only once.

No setters → no way to change state after construction.

Defensive copies for mutable objects (Date) → ensures no external references can mutate the state.

State set only in constructor → no hidden mutations later.

Immutability & Thread-Safety
Thread-safety without synchronization:
Immutable objects cannot be changed after creation, so multiple threads can safely share them without locking or synchronization.

No race conditions:
Since the state never changes, there’s no risk of inconsistent views across threads.

Safe publishing:
Once a reference to an immutable object is shared, all threads see the same state.

Example:

Strings in Java are immutable — multiple threads can safely read the same String without worrying about modifications.
 */