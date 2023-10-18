package uni.aed.model;

public class Empleado extends Persona {
    private String  rol;

    public Empleado(String name, int age, char gender,String rol ) {
        super(name, age, gender);
        this.rol = rol;
    }
            
    public String getRol() {
        return rol;
    }        

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Empleado{ " + super.toString() + "\t\t" + rol + '}';
    }
}
