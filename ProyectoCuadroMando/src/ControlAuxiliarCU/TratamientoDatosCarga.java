/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAuxiliarCU;

/**
 *
 * @author ivan
 */
public class TratamientoDatosCarga {
    int totalErrores;
    int totalLecturas;
    double porcentaje;
    
  public TratamientoDatosCarga( int errores, int lecturas){
      // convertimos errores y totalLecturas a double para obener
      // decimales en la división, al obtener porcentaje
      totalErrores = errores;
      totalLecturas = lecturas;
      double erroresDouble = errores;
      double totalLecturasDouble = lecturas;
      porcentaje = (erroresDouble / totalLecturasDouble);
      redondear();
      
}
  
  private void redondear(){
      // redondeamos a 3 decimales el valor de porcentaje (según ejemplo del proyecto)
      porcentaje = Math.rint(porcentaje*1000)/1000;
  }
 
  
     public int getErrores(){   
            return totalErrores;
}
     public int getTotalLecturas(){   
            return totalLecturas;
}
     public double getPorcentaje (){   
            return porcentaje;
}
    
}
