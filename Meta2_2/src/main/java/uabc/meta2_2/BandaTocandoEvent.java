/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.meta2_2;

/**
 *
 * @author Dell
 */
public class BandaTocandoEvent extends Message{
    private final String nombreBanda;
    private final String nombreCancion;
    private final int duracion;

    public BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracion) {
        super("BandaTocandoEvent");
        this.nombreBanda = nombreBanda;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public Object getPayload() {
        return this;
    }

    @Override
    public String toString() {
        return "BandaTocandoEvent{" + "nombreBanda=" + nombreBanda + ", nombreCancion=" + nombreCancion + ", duracion=" + duracion + "s}";
    }
    
    
}
