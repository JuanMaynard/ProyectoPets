
package com.cfs3.proyectopets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UsuarioCtr {

    List<UsuarioDto> listUsu;
    //constructora

    public UsuarioCtr() {
        this.listUsu = new ArrayList<>();
    }
    //metodos

    void registrarUsuario(int idUsuario, String apellidoYnombre, String correo, String contrasenia, String direccion, int telefono) {
        //agrega un usuario
        //int indice=listUsu.size();
        UsuarioDto usuario = new UsuarioDto(idUsuario, apellidoYnombre, correo, contrasenia, direccion, telefono);
        listUsu.add(usuario);
    }
    void agregarFicha(UsuarioDto usu,FichaDto f){
     List<FichaDto> l=usu.getListaFichas();
     l.add(f);
    }
    private boolean existeUsuario(String nombUsu, String contrasenia) {
        Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto user;
        while (!corte) {
            if (listU.hasNext()) {
                user = listU.next();
                if ((user.getApellidoynombre().equals(nombUsu)) && (user.getContrasenia().equals(contrasenia))) {
                    corte = true;//el usuario ya existe
                }

            } else {
                return false;//no existe el usuario
            }
        }
        return true;
    }

    private boolean existeUsuarioId(int idUsuario) {
        Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto user;
        while (!corte) {
            if (listU.hasNext()) {
                user = listU.next();
                if (user.getIdUsuario() == idUsuario) {
                    corte = true;//el usuario existe
                }

            } else {
                return false;//no existe el usuario
            }
        }
        return true;
    }

    public void eliminarUsuario(int i) {
        //elimina el usuario i
        Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto user;
        while (!corte) {
            if (listU.hasNext()) {
                user = listU.next();
                if (user.getIdUsuario() == i) {
                    this.listUsu.remove(user);
                    System.out.println("Se ha eliminado el usuario: "+user.getIdUsuario()+" "+user.getApellidoynombre());
                    corte = true;//el usuario existe y fue eliminado
                }

            } else {
                System.out.println("El usuario " + i + " " + "no existe");//no existe el usuario
                corte = true;

            }
        }
    }

    public void modificarContraseñia(String nombUsu, String c) {
        Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto user;
        while (!corte) {
            if (listU.hasNext()) {
                user = listU.next();
                if (user.getApellidoynombre().equals(nombUsu)) {
                    user.setContrasenia(c);
                    corte = true;//el usuario existe
                }

            } else {
                System.out.println("El usuario " + nombUsu + " " + "no existe");//no existe el usuario
                corte=true;
            }
        }
    }

    public void modificarDireccion(String nombUsu, String d) {
        Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto user;
        while (!corte) {
            if (listU.hasNext()) {
                user = listU.next();
                if (user.getApellidoynombre().equals(nombUsu)) {
                    user.setDireccion(d);
                    corte = true;//el usuario existe
                }

            } else {
                System.out.println("El usuario " + nombUsu + " " + "no existe");//no existe el usuario
                corte=true;
            }
        }
    }

    public void modificarTelefono(String nombUsu, int t) {
        Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto user;
        while (!corte) {
            if (listU.hasNext()) {
                user = listU.next();
                if (user.getApellidoynombre().equals(nombUsu)) {
                    user.setTelefono(t);
                    corte = true;//el usuario existe
                }

            } else {
                System.out.println("El usuario " + nombUsu + " " + "no existe");//no existe el usuario
                corte=true;
            }
        }
    }
    public UsuarioDto buscarUsuario(int idUs){
        //busca una mascota en base a un ID
      Iterator<UsuarioDto> listU = this.listUsu.iterator();
        boolean corte = false;
        UsuarioDto usu=null;
        while (!corte) {
            if (listU.hasNext()) {
                usu = listU.next();
                if (usu.getIdUsuario()==idUs) {
                    corte = true;//un mascota con ese ID existe
                }

            } else {
                System.out.println("El usuario con ID"+idUs+" "+"no existe");//no existe un usuario con ese ID
                corte=true;
            }
        }
        return usu;
    }

    @Override
    public String toString() {
        String us = "Fin listado Usuarios";
        System.out.println("");
     System.out.println("Listado de usuarios");
        for (UsuarioDto listU : listUsu) {
            System.out.println("ID Usuario: " + listU.getIdUsuario() + " Apellido y nombre: " + listU.getApellidoynombre() + " Correo: " + listU.getCorreo() + " Dirección: " + listU.getDireccion() + " Teléfono: " + listU.getTelefono());
        }
        return us;
    }
}
