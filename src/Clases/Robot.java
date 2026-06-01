package Clases;
import Interfaces.*;


public class Robot{

    private String numeroDeSerie;
    private int potenciaBase;
    private iTraccion traccion;
    private int kmRecorridos;

    public Robot(String numeroDeSerie, int potenciaBase){
        this.numeroDeSerie = numeroDeSerie;
        this.potenciaBase = potenciaBase;
        this.kmRecorridos = 0;
    }

    public void setTraccion(iTraccion traccion){
        this.traccion = traccion;
        this.kmRecorridos = 0;
    }

    public boolean tieneTraccion(){
        if (traccion == null){
            return false;
        }
        return true;
    }

    public boolean puedeAvanzar(int km){
        if (traccion == null){
            return false;
        }
        return kmRecorridos + km <= traccion.obtenerKmMaximos();
    }

    public void avanzar(int km){
        if (puedeAvanzar(km)) {
            kmRecorridos += km;
            System.out.println("El robot avanzo " + km + " kilometros.");
        }else{
            System.out.println("No se puede avanzar esa cantidad de kilometros.");
        }
    }

    public boolean necesitaReemplazo(){
        if (traccion == null)
        {
            return false;
        }
        return traccion.necesitaReemplazo(kmRecorridos);
    }

    public int obtenerPotenciaFinal(){
        if (traccion == null){
            return potenciaBase;
        }
        return traccion.calcularPotenciaFinal(potenciaBase);
    }

    public void mostrarDatos(){
        System.out.println("Numero de serie: " + numeroDeSerie);
        System.out.println("Potencia base: " + potenciaBase);
        if (traccion == null){
            System.out.println("No posee traccion.");
        }else{
            System.out.println("Potencia final: " + obtenerPotenciaFinal());
            System.out.println("Traccion: " + traccion.obtenerTipo());
            System.out.println("Km recorridos: " + kmRecorridos);
            System.out.println("Km maximos: " + traccion.obtenerKmMaximos());
            System.out.println("Caracteristicas: " + traccion.obtenerCaracteristicas());
        }
    }

    public void reiniciarKilometros(){
        kmRecorridos = 0;
    }
}