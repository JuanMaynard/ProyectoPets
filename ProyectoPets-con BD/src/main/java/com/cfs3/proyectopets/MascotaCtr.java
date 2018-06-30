/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfs3.proyectopets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AleC
 */
public class MascotaCtr {

    List<MascotaDto> listMasco;
    //constructora

    public MascotaCtr() {
        this.listMasco = new ArrayList<>();
    }
    //metodos

    void registrarMascota(int idMascota, String nombre, String tipo, String color, String sexo) {
        //agrega una mascota
        //int indice=listMasco.size();//valor de IdMascota
        MascotaDto mascota = new MascotaDto(idMascota,nombre,tipo,color,sexo);
        listMasco.add(mascota);
    }
    void registrarMascota(MascotaDto m){
        listMasco.add(m);
    }
    void agregarFicha(MascotaDto m,FichaDto f){
     List<FichaDto> l=m.getListaFichasm();
     l.add(f);
    }

    private boolean existeMascota(String nombreM) {
        //controla si existe una mascota con el mismo nombre
        Iterator<MascotaDto> listM = this.listMasco.iterator();
        boolean corte = false;
        MascotaDto masco;
        while (!corte) {
            if (listM.hasNext()) {
                masco = listM.next();
                if (masco.getNombre().equals(nombreM)) {
                   
                    corte = true;//un mascota con ese nombre ya existe
                }

            } else {
                return false;//no existe una mascota con ese nombre
            }
        }
        return true;
    }
    private boolean existeMascotaId(int idMascota) {
        //controla si existe una mascota con ese id
        Iterator<MascotaDto> listM = this.listMasco.iterator();
        boolean corte = false;
        MascotaDto masco;
        while (!corte) {
            if (listM.hasNext()) {
                masco = listM.next();
                if (masco.getIdMascota()== idMascota) {
                    corte = true;//un mascota con ese id existe
                }

            } else {
                return false;//no existe una mascota con ese id
               
            }
        }
        return true;
    }
    public void eliminarMascota(int i){
        //elimina la mascota i
      Iterator<MascotaDto> listM = this.listMasco.iterator();
        boolean corte = false;
        MascotaDto masco;
        while (!corte) {
            if (listM.hasNext()) {
                masco = listM.next();
                if (masco.getIdMascota()==i) {
                    listMasco.remove(masco);
                    System.out.println("Se ha eliminado la mascota: "+masco.getIdMascota()+" "+masco.getNombre());
                    corte = true;//un mascota con ese nombre existe y fue eliminada
                }

            } else {
                System.out.println("La mascota "+i+" "+"no existe");//no existe una mascota con ese id
                corte=true;
            }
        }
    }
    public void modificarNombreM(String nombreM){
        //cambia el nombre de una mascota por otro (solo cambia el de la primera)
      Iterator<MascotaDto> listM = this.listMasco.iterator();
        boolean corte = false;
        MascotaDto masco;
        while (!corte) {
            if (listM.hasNext()) {
                masco = listM.next();
                if (masco.getNombre().equals(nombreM)) {
                    masco.setNombre(nombreM);
                    corte = true;//un mascota con ese nombre existe
                }

            } else {
                System.out.println("La mascota "+nombreM+" "+"no existe");//no existe una mascota con ese nombre
                corte=true;
            }
        }
    }
    public void modificarColorM(String nombre, String colorM){
        //modifica el color de una mascota con nombre "nombre"
      Iterator<MascotaDto> listM = this.listMasco.iterator();
        boolean corte = false;
        MascotaDto masco;
        while (!corte) {
            if (listM.hasNext()) {
                masco = listM.next();
                if (masco.getNombre().equals(nombre)) {
                    masco.setColor(colorM);
                    corte = true;//un mascota con ese nombre existe
                }

            } else {
                System.out.println("La mascota "+nombre+" "+"no existe");//no existe una mascota con ese nombre
                corte=true;
            }
        }
    }
    public MascotaDto buscarMascota(int idMas){
        //busca una mascota en base a un ID
      Iterator<MascotaDto> listM = this.listMasco.iterator();
        boolean corte = false;
        MascotaDto masco=null;
        while (!corte) {
            if (listM.hasNext()) {
                masco = listM.next();
                if (masco.getIdMascota()==idMas) {
                    corte = true;//un mascota con ese ID existe
                }

            } else {
                System.out.println("La mascota con ID"+idMas+" "+"no existe");//no existe una mascota con ese ID
                corte=true;
            }
        }
        return masco;
    }
    @Override
    public String toString(){
        //lista todas las mascotas
     String mas="Fin listado Mascotas";   
     System.out.println("");
     System.out.println("Listado de mascotas");
     for(MascotaDto masco:listMasco){
       System.out.println("ID Mascota: "+masco.getIdMascota()+" Nombre: "+masco.getNombre()+" Tipo: "+masco.getTipo()+" Color: "+masco.getColor()+" Sexo: "+masco.getSexo());
     }   
    return mas; 
    }
}

