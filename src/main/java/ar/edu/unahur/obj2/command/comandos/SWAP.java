package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class SWAP implements Operable{

    public SWAP(Microprocesador unMicro) {

    }

    @Override
    public void execute(Programable micro) {
        Integer aux;
        aux = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(aux);
        micro.incProgramCounter();
    }
}
