package ar.edu.unahur.obj2.command;

import ar.edu.unahur.obj2.command.comandos.Operable;

import java.util.List;

public class Microprocesador implements Programable {
    private Integer acumA;
    private Integer acumB;
    private Integer programCounter;
    private Integer lugarEnMemoria;
    private Integer[] memoria = new Integer[1024];

    public Microprocesador() {
        acumA = 0;
        acumB = 0;
        programCounter = 0;
        lugarEnMemoria = 0;
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        this.programCounter++;
    }

    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }

    @Override
    public void setAcumuladorA(Integer value) {
        this.acumA = value;
    }

    @Override
    public Integer getAcumuladorA() {
        return acumA;
    }

    @Override
    public void setAcumuladorB(Integer value) {
        this.acumB = value;
    }

    @Override
    public Integer getAcumuladorB() {
        return acumB;
    }

    @Override
    public void copyFrom(Programable programable) {

    }

    @Override
    public Programable copy() {
        return null;
    }

    @Override
    public void reset() {
        acumA = 0;
        acumB = 0;
        programCounter = 0;
        lugarEnMemoria = 0;
    }

    @Override
    public void setAddr(Integer addr) {
            memoria[addr] = acumA;
    }

    @Override
    public Integer getAddr(Integer addr) {
        return memoria[addr];
    }
}
