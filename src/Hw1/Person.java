package Hw1;

public class Person {
    public String name;
    public String birthDate;
    public String birthPlace;

    public Person(String name, int birthDate, String birthPlace) {
        this.name=name;
        this.birthDate=String.valueOf(birthDate);  //Converts birthDate of type integer to String.
        this.birthPlace=birthPlace;
    }

    public Person(String name, int birthDate) {
        this.name=name;
        this.birthDate=String.valueOf(birthDate);
    }

    public Person(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "Name: " + name  + ", Birth Date: " + (getBirthDate()==null ? "-": getBirthDate())
                + ", Birth Place: " + (getBirthPlace()==null ? "-": getBirthPlace());
    }


    //getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if(name.length()>3) { //if string value called name contains more than 3 symbols
                this.name=name; //then, there is no error
            } else {        //if string value called name contains less than 3 symbols
                throw new IllegalArgumentException();  //throws an exception
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");

        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        try {
            if(birthDate.length()>3) { //if string value called birthDate contains more than 3 symbols
                this.birthDate=birthDate; //then, there is no error
            } else {        //if string value called birthDate contains less than 3 symbols
                throw new IllegalArgumentException();  //throws an exception
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");

        }
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        try {
            if(birthPlace.length()>3) { //if string value named birthPlace contains more than 3 symbols
                this.birthPlace=birthPlace; //then, there is no error
            } else {        //if string value named birthPlace contains less than 3 symbols
                throw new IllegalArgumentException();  //throws an exception
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, input cannot contain less than 3 symbols.");

        }
    }

}
