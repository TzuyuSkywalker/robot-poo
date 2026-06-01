package Clases;
import Interfaces.*;

public class RuedaDeCaucho implements iTraccion {

        @Override
        public String obtenerTipo(){
            return "Rueda de caucho";
        }

        @Override
        public int calcularPotenciaFinal(int potenciaBase){
            return potenciaBase - 1;
        }

        @Override
        public int obtenerKmMaximos(){
            return 100;
        }

        @Override
        public String obtenerCaracteristicas(){
            return "No posee caracteristicas especiales";
        }

        @Override
        public boolean necesitaReemplazo(int kmRecorridos){
            return kmRecorridos >= obtenerKmMaximos();
        }
}
