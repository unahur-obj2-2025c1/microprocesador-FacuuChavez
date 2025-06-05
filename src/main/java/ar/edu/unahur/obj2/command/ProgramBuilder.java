package ar.edu.unahur.obj2.command;

import ar.edu.unahur.obj2.command.comandos.Operable;

import java.util.ArrayList;
import java.util.List;

public class ProgramBuilder {
    private List<Operable> programa;
    public ProgramBuilder() {
        this.programa = new ArrayList<>();
    }
    public ProgramBuilder agregarInstruccion(Operable instruccion){
        this.programa.add(instruccion);
        return this;
    }
    public List<Operable> build(){
        return this.programa;
    }
    public ProgramBuilder ejecutarPrograma(Programable unMicro){
        unMicro.run(this.programa);
        return this;
    }
    public void setearAcumA(Microprocesador unMicro, Integer value){
        unMicro.setAcumuladorA(value);
    }
    public void setearAcumB(Microprocesador unMicro, Integer value){
        unMicro.setAcumuladorB(value);
    }
    public void setearAddr(Microprocesador unMicro, Integer value){
        unMicro.setAddr(value);
    }
}
