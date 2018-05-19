
package Odyssey.Usuario;

import Odyssey.Estructuras.Listas.ListaSimple;


public class Usuarios {
    private static ListaSimple <Usuario> usuarios = new ListaSimple<>();
    
    public static void agregarUsuario(Usuario u){
        if(existeUsuario(u))
            System.out.println("El nombre de Usuario ya existe");
        else
            usuarios.add(u);
    }
    
    public static boolean existeUsuario(Usuario usuario){
        for(int i = 0; i < usuarios.size();i++){
            if(usuarios.get(i).getNombreDeUsuario().equals(usuario.getNombreDeUsuario()))
                return true;
        }
        return false;
    }
}
