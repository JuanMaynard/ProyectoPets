/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfs3.proyectopets;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author AleC
 */
public class FichaCtr {
  List<FichaDto> listFicha;
    //constructora

    public FichaCtr() {
        this.listFicha = new ArrayList<>();
    }
    //metodos

    void agregarFicha(int idFicha,MascotaDto mascota, UsuarioDto usuario,String estado, String descripcion,Date fecha ) {
        //agrega una ficha
        FichaDto ficha = new FichaDto(idFicha,mascota,usuario,estado,descripcion,fecha);
        listFicha.add(ficha);
    }

    private boolean existeFicha(UsuarioDto usuario,MascotaDto mascota, String estado) {
        //controla si existe una ficha con una mascota y un estado determinado
        Iterator<FichaDto> listF = this.listFicha.iterator();
        boolean corte = false;
        FichaDto ficha;
        while (!corte) {
            if (listF.hasNext()) {
                ficha = listF.next();
                
                if (ficha.getUsuario().equals(usuario)&& ficha.getMascota().equals(mascota)&& ficha.getEstado().equals(estado)) {
                    corte = true;//un ficha para un idMascota con un IdSuario y un estado existe.
                }

            } else {
                return false;//no existe una ficha con ese IdUsuario IdMascota y ese estado.
            }
        }
        return true;
    }
    public void eliminarFicha(int i){
        //elimnina la ficha i
       Iterator<FichaDto> listF = this.listFicha.iterator();
        boolean corte = false;
        FichaDto ficha;
        while (!corte) {
            if (listF.hasNext()) {
                ficha = listF.next();
                if (ficha.getIdFicha()== i) {
                    this.listFicha.remove(ficha);
                    System.out.println("Se ha eliminado la ficha: "+ficha.getIdFicha()+" Mascota: "+ficha.getMascota().getIdMascota());
                    corte = true;//la ficha con idFicha existe y fue eliminada.
                }

            } else {
                System.out.println("La ficha "+i+" "+"no existe");//no existe una ficha con ese id
                corte=true;
            }
        }
    }
    public void eliminarFichasMasco(MascotaDto mascota){
        //elimina todas las fichas relacionadas con una mascota
     Iterator<FichaDto> listF = this.listFicha.iterator();
        boolean corte = false;
        FichaDto ficha;
        while (listF.hasNext()) {
            ficha = listF.next();
            if (ficha.getMascota().equals(mascota)) {
                    System.out.println("Se ha eliminado la ficha: "+ficha.getIdFicha()+"Mascota: "+ficha.getMascota().getIdMascota());
                    listF.remove();
            }

        } 
        
    }
    
    public void cambiarUsuario(UsuarioDto usuario, UsuarioDto nuevoU){
      Iterator<FichaDto> listF = this.listFicha.iterator();
        boolean corte = false;
        FichaDto ficha;
        while (!corte) {
            if (listF.hasNext()) {
                ficha = listF.next();
                if (ficha.getUsuario().equals(nuevoU)){
                    ficha.setUsuario(nuevoU);
                    corte = true;//un usuario con ese id existe y fue reemplazado
                }

            } else {
                System.out.println("El usuario "+nuevoU.getIdUsuario()+" "+"no existe en una ficha");//no existe un usuario con ese número de id
                corte=true;
            }
        }
    }
    public void modificarEstado(int idFicha, String estado){
      Iterator<FichaDto> listF = this.listFicha.iterator();
        boolean corte = false;
        FichaDto ficha;
        while (!corte) {
            if (listF.hasNext()) {
                ficha = listF.next();
                if (ficha.getIdFicha()== idFicha) {
                    ficha.setEstado(estado);
                    corte = true;//la ficha con idFicha existe y su estado fue reemplazado.
                }

            } else {
                System.out.println("La ficha "+idFicha+" "+"no existe");//no existe una ficha con ese id
                corte=true;
            }
        }
    }  
    public List<FichaDto> buscarMascotaenFicha(String estado,String descripcion){
        //devuelve una lista de fichas de un determinado estado y descripción
        List<FichaDto> resultado=new ArrayList<>();
        Iterator<FichaDto> listF = this.listFicha.iterator();
        FichaDto ficha;
        
        while (listF.hasNext()) {
            ficha = listF.next();
            
            if ((ficha.getDescripcion().contains(descripcion))&&(ficha.getEstado()==estado)) {
                resultado.add(ficha);
            }
        } 
        return resultado;  
        
    }
    public FichaDto buscarFicha(int idFicha){
        //busca una ficha con IdFicha en base de datos
      Iterator<FichaDto> listF = this.listFicha.iterator();
        boolean corte = false;
        FichaDto ficha=null;
        while (!corte) {
            if (listF.hasNext()) {
                ficha = listF.next();
                if (ficha.getIdFicha()==idFicha) {
                    corte = true;//ficha con ese Id encontrada!
                }

            } else {
                System.out.println("La ficha con ID"+idFicha+" "+"no existe");//no existe una ficha con ese ID
                corte=true;
            }
        }
        return ficha;
    }
    public void buscarMascotaEn(String estado1, String descripcion1) {
        List<FichaDto> lfi = new ArrayList<>();
        lfi = this.buscarMascotaenFicha(estado1, descripcion1); //busca en ficha mascotas en un estado que cumpla una descripcion dada
        System.out.println(" ");
        System.out.println("Listado de Mascotas en estado: " + estado1 + " descripción: " + descripcion1);
        for (FichaDto i : lfi) {
            //genera una lista de mascotas con las mascotas que cumplen los criterios

            System.out.println("idMascota " + i.getMascota().getIdMascota() + " " + " Nombre: " + i.getMascota().getNombre() + " " + " Encontrado en: " + i.getDescripcion());
        }
    }
    @Override
    public String toString(){
     String fi="Fin listado Fichas";  
     System.out.println("");
     System.out.println("Listado de fichas");
     for(FichaDto f:listFicha){
       System.out.println("ID ficha "+f.getIdFicha()+" ID Mascota "+f.getMascota().getIdMascota()+" ID usuario "+f.getUsuario().getIdUsuario()+" Estado "+f.getEstado()+" Descripción "+f.getDescripcion()+" Fecha "+f.getFecha());
     }   
    return fi; 
    }
            
}
