package Interfaces;


public interface iTraccion{

    String obtenerTipo();
    int calcularPotenciaFinal(int potenciaBase);
    int obtenerKmMaximos();
    String obtenerCaracteristicas();
    boolean necesitaReemplazo(int kmRecorridos);
}
