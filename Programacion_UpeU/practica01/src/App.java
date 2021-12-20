
import java.util.Scanner;

import Entidades.Persona;
import implementacion.PersonaDatos;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int op=0;
        PersonaDatos pd = new PersonaDatos();
        

        System.out.println("Eliga una opcion");
        System.out.println("opcion 1. crear Lista");
        System.out.println("opcion 2. Listar Lista");
        System.out.println("Opcion 3. Eliminar Lista");
        System.out.println("Opcion 4. Actualizar lista");
        op=teclado.nextInt();

        switch (op) {
            case 1:
                Persona p1 = new Persona();
                p1.setId(1);
                p1.setNombres("JeanFranco");
                p1.setAp_paterno("Laura");
                p1.setAp_materno("Quispe");
                p1.setDireccion("Jr. Manuel Pardo");
                p1.setSexo("M");
                break;
            case 2:
            for(Persona ps: pd.ListaPersona()){
                System.out.println(ps.getId()+" "+ps.getNombres()+" "+ps.getAp_paterno()+" "+ps.getDireccion());
            }
            break;
            default:
                break;
        }

        
    
        
    }

    
}