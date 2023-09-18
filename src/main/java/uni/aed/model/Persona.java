package uni.aed.model;
public class Persona {
    public static final int NAME=0;
    public static final int AGE=1;
    
    public static final int LESS=-1;
    public static final int EQUAL=0;
    public static final int MORE=1;
    
    public static int compareAttribute;    
    
    private String name;
    private int age;
    private char gender;
    
    static{
        compareAttribute=NAME;
    }

    public Persona(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGener() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGener(char gender) {
        this.gender = gender;
    }

    
    @Override
    public String toString( )  {
        return this.name    + "||" +
               this.age     + "||" +
               this.gender;
    }
    
    public void setCompareAttribute(int attribute){
        compareAttribute=attribute;
    }
    public int compareTo(Persona persona){
        return compareTo(persona, compareAttribute);
    }
    public int compareTo(Persona persona, int attribute){
        int comparisonResult;
        if(attribute==AGE){
            int p2age=persona.getAge();
            if(this.age<p2age)
                comparisonResult=LESS;
            else if(this.age==p2age)
                comparisonResult=EQUAL;
            else
                comparisonResult=MORE;
        }else{
            String p2name=persona.getName();
            comparisonResult=this.name.compareTo(p2name);
        }
        return comparisonResult;
    }

    
}
