package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LOD implements Operable{

    Integer addr;
    public LOD(Integer unAddr) {
        this.addr = unAddr;
    }

    @Override
    public void execute(Programable micro) {
        micro.setAcumuladorA(micro.getAddr(addr));
        micro.incProgramCounter();
    }
}
