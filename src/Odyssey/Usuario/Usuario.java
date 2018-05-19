/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odyssey.Usuario;

import Odyssey.Estructuras.Listas.ListaSimple;


public class Usuario {
    private String nombreDeUsuario;
    private String nombre;
    private int edad;
    private String Contrasena;
    private ListaSimple <String> generosMusicales = new ListaSimple<String>();
    private ListaSimple <String> listaAmigos = new ListaSimple<String>();

    public Usuario(String nombreDeUsuario, String nombre, int edad, String Contrasena) {
        this.nombreDeUsuario = nombreDeUsuario;
        this.nombre = nombre;
        this.edad = edad;
        this.Contrasena = Contrasena;
        Usuarios.agregarUsuario(this);
    }
    

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

   
    
    
    
    
    
    
    
    
    
}
