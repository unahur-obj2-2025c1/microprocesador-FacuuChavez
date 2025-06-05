package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Microprocesador;
import ar.edu.unahur.obj2.command.Programable;

public class NOP implements Operable {

    public NOP(Microprocesador unMicro) { }

    @Override
    public void execute(Programable unMicro) {
        unMicro.incProgramCounter();
    }
}
