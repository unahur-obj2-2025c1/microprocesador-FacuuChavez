package ar.edu.unahur.obj2.command;

import ar.edu.unahur.obj2.command.comandos.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MicroprocesadorTest {
     Microprocesador micro = new Microprocesador();
     List<Operable> operables = new ArrayList<>();

     @Test
    void incrementarTresVecesProgramCount(){
         operables.add(new NOP(micro));
         operables.add(new NOP(micro));
         operables.add(new NOP(micro));
         micro.run(operables);
         assertEquals(3,micro.getProgramCounter());
     }

     @Test
    void testeandoAdd(){
         micro.setAcumuladorA(20);
         micro.setAcumuladorB(25);
         operables.add(new ADD(micro));
         micro.run(operables);
         assertEquals(45,micro.getAcumuladorA());
         assertEquals(0,micro.getAcumuladorB());
     }

     @Test
    void testeandoSwap(){
         micro.setAcumuladorA(20);
         micro.setAcumuladorB(55);
         operables.add(new SWAP(micro));
         micro.run(operables);
         assertEquals(55,micro.getAcumuladorA());
         assertEquals(20,micro.getAcumuladorB());
     }

     @Test
    void testeandoLod(){
         micro.setAcumuladorA(20);
         micro.setAddr(5);
         micro.setAcumuladorA(0);
         operables.add(new LOD(5));
         micro.run(operables);
         assertEquals(20,micro.getAddr(5));
     }

     @Test
    void testeandoStr(){
         micro.setAcumuladorA(28);
         micro.setAddr(1023);
         operables.add(new STR(1023));
         micro.run(operables);
         assertEquals(28,micro.getAddr(1023));
     }

     @Test
    void testeandoVal(){
         operables.add(new LODV(32));
         micro.run(operables);
         assertEquals(32,micro.getAcumuladorA());
     }
     /// /////////// TEST REQUERIDOS ////////////////////////////////////////////////////
     @Test
    void sumar20Mas17(){
         operables.add(new LODV(20));
         operables.add(new SWAP(micro));
         operables.add(new LODV(17));
         operables.add(new ADD(micro));
         micro.run(operables);
         assertEquals(37,micro.getAcumuladorA());
         assertEquals(0,micro.getAcumuladorB());
         assertEquals(4,micro.getProgramCounter());
     }

     @Test
    void sumar2Mas8Mas5(){
         operables.add(new LODV(2));
         operables.add(new STR(0));
         operables.add(new LODV(8));
         operables.add(new SWAP(micro));
         operables.add(new LODV(5));
         operables.add(new ADD(micro));
         operables.add(new SWAP(micro));
         operables.add(new LOD(0));
         operables.add(new ADD(micro));
         micro.run(operables);
         assertEquals(15,micro.getAcumuladorA());
         assertEquals(0,micro.getAcumuladorB());

     }
}
