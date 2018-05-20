/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odyssey.Biblioiteca.SoundTrack;

/**
 *Clase que va a alojar los soundtracks de la aplicacion
 *
 */
public class SoundTrack {
    /**
     * Atributos de la clase soundtrack, que almacenan informacion como el nombre, el artista
     * el album al que pertenecen, la ruta de aceso en memoria y la calificacion
     */
    private String nombre;
    private String artista;
    private String album;
    private String path;
    private int calificacion;
    
    /**
     * constructor de la clase
     * @param nombre 
     * @param artista
     * @param album
     * @param path localizacion en memoria
     */

    public SoundTrack(String nombre, String artista, String album, String path) {
        this.nombre = nombre;
        this.artista = artista;
        this.album = album;
        this.path = path;
    }
    
    
    
    
}
