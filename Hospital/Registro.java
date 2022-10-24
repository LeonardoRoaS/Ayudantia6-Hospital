package Hospital;

import Intranet.Alumno;

import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<Persona> personas;
    public Registro(){
        this.personas = new ArrayList<>();
    }

    //METODO 1 PARA AGREGAR (SIN OBJETO DEFINIDO)
    public boolean agregarPersona (String nombre, String apellido, int edad) {
        if (buscarPersona(nombre, apellido) == null) {
            Persona persona = new Persona(nombre, apellido, edad);
            this.personas.add(persona);
            return true;
        } else {
            return false;
        }
    }
    //METODO 2 PARA AGREGAR (CON OBJETO DEFINIDO)
    public boolean agregarPersona (Persona persona){
        if (buscarPersona(persona.getNombre(),persona.getApellido()) == null ){
            this.personas.add(persona);
            return true;
        }
        else{
            return false;
        }
    }
    //ELIMINAR PERSONA
    public boolean eliminarPersona (String nombre, String apellido){
        Persona persona = this.buscarPersona(nombre, apellido);
        if (persona != null){
            this.personas.remove(persona);
            return true;
        }
        else{
            return false;
        }

    }

    public Persona buscarPersona(String nombre, String apellido){
        for(Persona persona : this.personas){
            if(persona.getNombre().equals(nombre) && persona.getApellido().equals(apellido)){
                return persona;
            }
        }
        return null;
    }

    public List buscarPersonas(String nombre){
        ArrayList<Persona> personas = new ArrayList<>();
        for(Persona persona : this.personas){
            if(persona.getNombre().equals(nombre)){
                personas.add(persona);
            }
        }
        return personas;
    }

    public void mostrarPersonas(){
        for (Persona persona : this.personas){
            System.out.println(persona.toString());
        }
    }

    public void mostrarPersonas(List<Persona> personas){
        for (Persona persona : personas){
            System.out.println(persona.toString());
        }

    }


    public void Mayores60(){
        System.out.println("\nPersonas Mayores de 60 años:");
        for (Persona persona : this.personas){
            if (persona.getEdad()>60){
                System.out.println("Resultado: "+persona.getNombre()+" "+persona.getApellido());
            }
        }
    }

    public void buscarPersona0 (String nombre, String apellido){
        for (Persona persona : this.personas){
            if (persona.getNombre().equalsIgnoreCase(nombre) && persona.getApellido().equalsIgnoreCase(apellido)){
                System.out.println("Persona encontrada: "+persona.toString());
            }
        }

    }

}
