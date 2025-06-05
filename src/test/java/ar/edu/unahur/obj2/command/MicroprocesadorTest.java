package ar.edu.unahur.obj2.command;

import ar.edu.unahur.obj2.command.comandos.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MicroprocesadorTest {
     Microprocesador micro = new Microprocesador();
     ProgramBuilder programa = new ProgramBuilder();


     @Test
    void incrementarTresVecesProgramCount(){
         programa.agregarInstruccion(new NOP(micro));
         programa.agregarInstruccion(new NOP(micro));
         programa.agregarInstruccion(new NOP(micro));
         programa.ejecutarPrograma(micro);
         assertEquals(3,micro.getProgramCounter());
     }

     @Test
    void testeandoAdd(){
         programa.setearAcumA(micro,20);
         programa.setearAcumB(micro,25);
         programa.agregarInstruccion(new ADD(micro));
         programa.ejecutarPrograma(micro);
         assertEquals(45,micro.getAcumuladorA());
         assertEquals(0,micro.getAcumuladorB());
     }

     @Test
    void testeandoSwap(){
         programa.setearAcumA(micro,20);
         programa.setearAcumB(micro,55);
         programa.agregarInstruccion(new SWAP(micro));
         programa.ejecutarPrograma(micro);
         assertEquals(55,micro.getAcumuladorA());
         assertEquals(20,micro.getAcumuladorB());
     }

     @Test
    void testeandoLod(){
         programa.setearAcumA(micro,20);
         programa.setearAddr(micro,5);
         programa.setearAcumA(micro,0);
         programa.agregarInstruccion(new LOD(5));
         programa.ejecutarPrograma(micro);

         assertEquals(20,micro.getAddr(5));
     }

     @Test
    void testeandoStr(){
         programa.setearAcumA(micro,28);
         programa.setearAddr(micro,1023);
         programa.agregarInstruccion(new STR(1023));
         programa.ejecutarPrograma(micro);

         assertEquals(28,micro.getAddr(1023));
     }

     @Test
    void testeandoVal(){
         programa.agregarInstruccion(new LODV(32));
         programa.ejecutarPrograma(micro);

         assertEquals(32,micro.getAcumuladorA());
     }
     /// /////////// TEST REQUERIDOS ////////////////////////////////////////////////////
     @Test
    void sumar20Mas17(){
         programa.agregarInstruccion(new LODV(20));
         programa.agregarInstruccion(new SWAP(micro));
         programa.agregarInstruccion(new LODV(17));
         programa.agregarInstruccion(new ADD(micro));
         programa.ejecutarPrograma(micro);

         assertEquals(37,micro.getAcumuladorA());
         assertEquals(0,micro.getAcumuladorB());
         assertEquals(4,micro.getProgramCounter());
     }

     @Test
    void sumar2Mas8Mas5(){
         programa.agregarInstruccion(new LODV(2));
         programa.agregarInstruccion(new STR(0));
         programa.agregarInstruccion(new LODV(8));
         programa.agregarInstruccion(new SWAP(micro));
         programa.agregarInstruccion(new LODV(5));
         programa.agregarInstruccion(new ADD(micro));
         programa.agregarInstruccion(new SWAP(micro));
         programa.agregarInstruccion(new LOD(0));
         programa.agregarInstruccion(new ADD(micro));
         programa.ejecutarPrograma(micro);

         assertEquals(15,micro.getAcumuladorA());
         assertEquals(0,micro.getAcumuladorB());

     }
}
