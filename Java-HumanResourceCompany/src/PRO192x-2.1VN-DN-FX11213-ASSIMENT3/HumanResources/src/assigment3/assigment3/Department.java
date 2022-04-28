package assigment3;

public class Department {
    String departmentId;
    String departmentName;
    int numberEmployee;

    public Department(String id, String name) {
        departmentId = id;
        departmentName = name;
        numberEmployee = 0;
    }

    public String getId() {
        return departmentId;
    }

    public String getName() {
        return departmentName;
    }

    public int getNumber() {
        return numberEmployee;
    }

    public void setId(String id) {
        this.departmentId = id;
    }

    public void setName(String name) {
        this.departmentName = name;
    }

    public void setNumber(int number) {
        this.numberEmployee = number;
    }

    public String toString() {
        return this.getId() + " - " + this.getName() + " - " + getNumber();
    }
}
