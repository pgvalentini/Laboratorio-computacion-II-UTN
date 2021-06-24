/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julio.librerias.pruebas_junit_5;

/**
 *
 * @author julio
 */
public class Estadistica {
    
        public float sumavals(float v[]){
            float acu=0;
            
            for(int i=0;i<v.length;i++)
                acu += v[i];
            
            return acu;
        }
    
    
    	/**Calcula de los valores que contenga un vector de floats facilitado por el usuario
	 *@param v		vector de floats con los elemento introducidos por el usuario
	 *@return 		la media de los valores de v
	 *@see #media()
	 */
	public static float media(float[] v){
	   float res=0;
	   for(int i=0; i<v.length; i++){
	   	res+=v[i];
	   }
	   
	   return res/v.length;
	}
	/**Calcula la moda, el valor más repetido, del vector de floats v introducido por el usuario
	 *@param v		vector de floats con los elemento introducidos por el usuario
	 *@return 		valor más repetido del vector
	 *@see #moda()
	 */
	public static float moda(float[] v){
		int cont=0;
		float num=0;
		for(int i=0; i<v.length; i++){
		   int aux=0;	
		   for(int j=0; j<v.length; j++){
		      if(v[i]==v[j]) aux++;
		   }
		   if(aux>=cont){
		   	cont=aux;
		   	num=v[i];
		   } 
		 }
		return num;
	}
        
        /**Calcula la desviacion tipica del vector de floats v introducido por el usuario
	 *@param v		vector de floats con los elemento introducidos por el usuario
	 *@return 		desviacion tipica del vector
	 *@see #desviacion_tipica()
	 */
	public static float desviacion_tipica(float[] v){
		float res=(float) Math.sqrt(varianza(v));
		return res;
	}
	/**Calcula la varianza del vector de floats v introducido por el usuario
	 *@param v		vector de floats con los elemento introducidos por el usuario
	 *@return 		la varianza del vector
	 *@see #varianza()
	 */
	public static float varianza(float[] v){
	   float m=media(v);
	   float sum=0;
	   for(int i=0; i<v.length; i++){
	      sum+=Math.pow(v[i],2.0);
	   }
	   
	   return (float) (sum/v.length-Math.pow(m,2.0F));	
	}
}
