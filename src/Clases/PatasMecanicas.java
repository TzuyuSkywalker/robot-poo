package Clases;
import Interfaces.*;


public class PatasMecanicas implements iTraccion {

    @Override
    public String obtenerTipo() {
        return "Patas mecanicas";
    }
    @Override
    public int calcularPotenciaFinal(int potenciaBase) {
        return potenciaBase - 5;
    }
    @Override
    public int obtenerKmMaximos() {
        return 50;
    }
    @Override
    public String obtenerCaracteristicas() {
        return "Posee estabiizadores hidraulicos";
    }
    @Override
    public boolean necesitaReemplazo(int kmRecorridos) {
        return kmRecorridos >= obtenerKmMaximos();
    }
}



