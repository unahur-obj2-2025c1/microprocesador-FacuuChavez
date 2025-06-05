package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class ADD implements Operable {

    public ADD(Microprocesador unMicro) { }

    @Override
    public void execute(Programable unMicro) {
        Integer sum;
        sum = unMicro.getAcumuladorA() + unMicro.getAcumuladorB();
        unMicro.setAcumuladorA(sum);
        unMicro.setAcumuladorB(0);
        unMicro.incProgramCounter();
    }
}
