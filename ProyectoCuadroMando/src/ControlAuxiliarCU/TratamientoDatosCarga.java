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
    double erroresDouble;
    double totalLecturasDouble;
    double porcentaje;
    
  public TratamientoDatosCarga( int errores, int totalLecturas){
      // convertimos errores y totalLecturas a double para obener
      // decimales en la división, al obtener porcentaje
      erroresDouble = errores;
      totalLecturasDouble = totalLecturas;
      porcentaje = (erroresDouble / totalLecturasDouble);
      
}
  
  private void redondear(){
      // redondeamos a 3 decimales el valor de porcentaje (según ejemplo del proyecto)
      porcentaje = Math.rint(porcentaje*1000)/1000;
  }
 
  
     public double getErrores(){   
            return erroresDouble;
}
     public double getTotalLecturas(){   
            return totalLecturasDouble;
}
     public double getPorcentaje (){   
            return porcentaje;
}
    
}
