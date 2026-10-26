package Lab3.Ex3_Hotel;

public abstract class Person {
    private String fullname;
    private int age;

    public Person(String name, int age){
        setFullname(name);
        setAge(age);
    }

    public String getFullname(){
        return fullname;
    }

    public void setFullname(String name){
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid name!");
        }
        this.fullname = name.trim();
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if (age < 1){
            throw new IllegalArgumentException("Invalid age!");
        }
        this.age = age;
    }

    @Override 
    public String toString(){
        return String.format("Name: %s | age: %d", 
                            fullname, age);
    }
}
