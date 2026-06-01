package Clases;
import Interfaces.*;


public class Oruga implements iTraccion{

    @Override
    public String obtenerTipo() {
        return "Oruga";
    }
    @Override
    public int calcularPotenciaFinal(int potenciaBase) {
        return potenciaBase - 3;
    }
    @Override
    public int obtenerKmMaximos() {
        return 400;
    }
    @Override
    public String obtenerCaracteristicas() {
        return "Posee sensor de temperatura Meke-M0";
    }
    @Override
    public boolean necesitaReemplazo(int kmRecorridos) {
        return kmRecorridos >= obtenerKmMaximos();
    }
}
