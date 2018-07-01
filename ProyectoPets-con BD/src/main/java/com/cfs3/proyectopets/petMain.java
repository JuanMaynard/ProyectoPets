/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cfs3.proyectopets;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 *
 * @author AleC
 */
public class petMain {

    
    public static void main(String[] args) {
        // TODO code application logic here
    UsuarioCtr usCtr = new UsuarioCtr();
        usCtr.registrarUsuario(1, "Almada Ernesto", "almadaernesto@gmail.com", "almadae123", "Laprida 352", 4434477);
        usCtr.registrarUsuario(2, "Bernal Patricia", "bernalpatricia@gmail.com", "bernalp123", "arana 567", 4428943);
        usCtr.registrarUsuario(3, "Santin Mariano", "santinmariano@gmail.com", "santinm123", "brasil 155", 4442390);
        usCtr.registrarUsuario(4, "Rodriguez Lucia", "rodriguezlucia@gmail.com", "rodriguezl123", "estrada 67", 4456799);

        //creacion mascotas
        MascotaCtr mascoCtr = new MascotaCtr();
        mascoCtr.registrarMascota("pepo", "gato", "negro y blanco", "macho");
        mascoCtr.registrarMascota("laica", "perro", "marron", "hembra");
        mascoCtr.registrarMascota("nn", "gato", "gris", "hembra");
        mascoCtr.registrarMascota("nn", "perro", "negro", "macho");
        mascoCtr.registrarMascota("nn", "perro", "gris", "hembra");

        //creacion fichas
        FichaCtr fiCtr = new FichaCtr();
        Date fecha1 = new Date(2018, 6, 15);
        Date fecha2 = new Date(2018, 5, 20);
        Date fecha3 = new Date(2018, 5, 10);
        Date fecha4 = new Date(2018, 6, 9);
        fiCtr.agregarFicha(1, mascoCtr.buscarMascota(2), usCtr.buscarUsuario(1), "perdido", "arana al 500", fecha1);
        fiCtr.agregarFicha(2, mascoCtr.buscarMascota(3), usCtr.buscarUsuario(3), "encontrado", "callao al 200", fecha2);
        fiCtr.agregarFicha(3, mascoCtr.buscarMascota(1), usCtr.buscarUsuario(4), "perdido", "laprida al 300", fecha3);
        fiCtr.agregarFicha(4, mascoCtr.buscarMascota(5), usCtr.buscarUsuario(2), "encontrado", "zona parque", fecha4);
        fiCtr.agregarFicha(5, mascoCtr.buscarMascota(4), usCtr.buscarUsuario(4), "encontrado", "dique parque", fecha3);
        
        //agregar fichas a usuarios y a mascotas
        mascoCtr.agregarFicha(mascoCtr.buscarMascota(2), fiCtr.buscarFicha(1));
        usCtr.agregarFicha(usCtr.buscarUsuario(1), fiCtr.buscarFicha(1));
        mascoCtr.agregarFicha(mascoCtr.buscarMascota(3), fiCtr.buscarFicha(2));
        usCtr.agregarFicha(usCtr.buscarUsuario(3), fiCtr.buscarFicha(2));
        mascoCtr.agregarFicha(mascoCtr.buscarMascota(1), fiCtr.buscarFicha(3));
        usCtr.agregarFicha(usCtr.buscarUsuario(4), fiCtr.buscarFicha(3));
        mascoCtr.agregarFicha(mascoCtr.buscarMascota(5), fiCtr.buscarFicha(4));
        usCtr.agregarFicha(usCtr.buscarUsuario(2), fiCtr.buscarFicha(4));
        mascoCtr.agregarFicha(mascoCtr.buscarMascota(4), fiCtr.buscarFicha(4));
        usCtr.agregarFicha(usCtr.buscarUsuario(4), fiCtr.buscarFicha(4));
        
        //impresion de las fichas
        fiCtr.toString();

        // eliminacion de usuario y listado
        usCtr.eliminarUsuario(1);
        usCtr.toString();

        //eliminación de mascota y listado
        mascoCtr.eliminarMascota(2);
        mascoCtr.toString();

        //eliminacion de ficha y listado
        fiCtr.eliminarFicha(1);
        fiCtr.toString();

        //buscar mascotas, por ejemplo, encontradas en el parque
        fiCtr.buscarMascotaEn("encontrado", "parque");
        
        mascoCtr.registrarMascota();
                
    try {

             StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                     .configure()
                     .build();
            try {
                 
                 SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                 Session session = sessionFactory.openSession();
                 session.beginTransaction();
                 ejemplo1(session);
                 //ejemplo3(session);
                 session.getTransaction().commit();
                 session.close();
                 sessionFactory.close();
                } catch (Exception e) {
                  e.printStackTrace();
                 }
          } catch (Exception e) {
              e.printStackTrace();
        }
        
   }

    public static void ejemplo1(Session session) {
        // Traigo el cliente con ID 1
        UsuarioDto m = session.load(UsuarioDto.class, 4);
        System.out.println(m.getApellidoynombre()+" "+m.getContrasenia()+" "+m.getCorreo()+" "+m.getDireccion());
//
//        // Imprimo sus teléfonos
//        System.out.println("---Telefonos");
//        for (Telefono telefono : c.getTelefonos()) {
//            System.out.println(telefono.getNumero());
//        }
//
//        // Imprimo sus facturas
//        for (Factura factura : c.getFacturas()) {
//            System.out.println("---Factura");
//            System.out.println(factura);
//            for (DetalleFactura detalleFactura : factura.getDetalleFactura()) {
//                System.out.println(detalleFactura);
//            }
//        }
    }
//
//    public static void ejemplo2(Session session) {
//
//        CriteriaQuery<Cliente> q = session.getCriteriaBuilder().createQuery(Cliente.class);
//        q.select(q.from(Cliente.class));
//        List<Cliente> l = session.createQuery(q).list();
//        System.out.println("Lista de clientes");
//        for (Cliente cl : l) {
//
//            System.out.println(cl);
//        }
//    }
//

    public static void ejemplo3(Session session) {

        //Query q = session.createQuery("from UsuarioDto where direccion = arana", UsuarioDto.class);
        
        Query q = session.createQuery("from MascotaDto where color = :color");
        q.setParameter("color", "gris");
        List<MascotaDto> l = q.list();
        System.out.println("Lista de mascotas");
        for (MascotaDto mas : l) {
            System.out.println(mas.getNombre()+" "+mas.getColor()+" "+mas.getSexo()+" "+mas.getTipo());
        }
    }

}
    
