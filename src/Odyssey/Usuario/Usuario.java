    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odyssey.Usuario;

import Odyssey.Estructuras.Listas.ListaSimple;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class Usuario {
    private String nombreDeUsuario;
    private String nombre;
    private int edad;
    private String Contrasena;
    private ListaSimple <String> generosMusicales = new ListaSimple<String>();
    private ListaSimple <String> listaAmigos = new ListaSimple<String>();
    
    private static ListaSimple <String> listaU = new ListaSimple<>();
    private static JSONObject archivoJ = new JSONObject();

    public Usuario(String nombreDeUsuario, String nombre, int edad, String Contrasena) {
            this.nombreDeUsuario = nombreDeUsuario;
            this.nombre = nombre;
            this.edad = edad;
            this.Contrasena = Contrasena;   
            System.out.println("Se ha creado el usuario"); 
            JSONArray u = new JSONArray();
            u.add(this.nombreDeUsuario);
            u.add(this.nombre);
            u.add(this.edad);
            u.add(this.Contrasena);
            System.out.println(u);
            archivoJ.put("Usuarios",u);
            System.out.println(archivoJ);
    }
    
}
