package com.cfs3.proyectopets;
// Generated 21/06/2018 21:57:44 by Hibernate Tools 4.3.1


import java.util.Date;


public class FichaDto  implements java.io.Serializable {


     private int idFicha;
     private MascotaDto mascota;
     private UsuarioDto usuario;
     private String estado;
     private String descripcion;
     private Date fecha;

    public FichaDto() {
    }

    public FichaDto(int idFicha, MascotaDto Mascota, UsuarioDto Usuario, String estado, String descripcion, Date fecha) {
       this.idFicha = idFicha;
       this.mascota = Mascota;
       this.usuario = Usuario;
       this.estado = estado;
       this.descripcion = descripcion;
       this.fecha = fecha;
    }
   
    public int getIdFicha() {
        return this.idFicha;
    }
    
    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }
    public MascotaDto getMascota() {
        return this.mascota;
    }
    
    public void setMascota(MascotaDto Mascota) {
        this.mascota = Mascota;
    }
    public UsuarioDto getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(UsuarioDto Usuario) {
        this.usuario = Usuario;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}


