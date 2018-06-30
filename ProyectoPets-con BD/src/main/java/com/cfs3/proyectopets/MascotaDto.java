package com.cfs3.proyectopets;

import java.util.ArrayList;
import java.util.List;


public class MascotaDto  implements java.io.Serializable {


     private int idMascota;
     private String nombre;
     private String tipo;
     private String color;
     private String sexo;
     private List<FichaDto> listaFichasm = new ArrayList<>();

    public MascotaDto() {
    }

	
    public MascotaDto(int idMascota, String nombre, String tipo, String color, String sexo) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.tipo = tipo;
        this.color = color;
        this.sexo = sexo;
    }
    public MascotaDto(int idMascota, String nombre, String tipo, String color, String sexo, FichaDto listFichasm) {
       this.idMascota = idMascota;
       this.nombre = nombre;
       this.tipo = tipo;
       this.color = color;
       this.sexo = sexo;
       this.listaFichasm.add(listFichasm);
    }
   
    public int getIdMascota() {
        return this.idMascota;
    }
    
    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public List<FichaDto> getListaFichasm() {
        return this.listaFichasm;
    }
    
    public void setListaFichasm(List<FichaDto> listaFichas) {
        this.listaFichasm = listaFichas;
    }




}


