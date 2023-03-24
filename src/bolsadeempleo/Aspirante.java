package bolsadeempleo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "aspirantes")
public class Aspirante {

    @DatabaseField(id = true)
    private String cedula;

    @DatabaseField
    private String nombre;

    @DatabaseField
    private int edad;

    @DatabaseField
    private int experiencia;

    @DatabaseField
    private String profesion;

    @DatabaseField
    private String telefono;

    public Aspirante() {
    }

    public Aspirante(String cedula, String nombre, int edad, int experiencia, String profesion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.experiencia = experiencia;
        this.profesion = profesion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Aspirante{" + "cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad + ", experiencia=" + experiencia + ", profesion=" + profesion + ", telefono=" + telefono + '}';
    }

}
