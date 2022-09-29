package service;

import dao.FileDAO;
import dao.FileDAOimpl;
import entity.Fichero;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileService {
    private final FileDAO fileDAO= new FileDAOimpl();
    public void listarFicheros(){
       File[] ficheros = fileDAO.listarFicheros("/home/sergio");
        for (File file:ficheros) {
            Fichero fichero = new Fichero(file.getName());
            if (file.isDirectory()){
                fichero.setTipo("directorio");
            }else{
                fichero.setTipo("fichero");
            }
            System.out.println("El fichero "+fichero.getNombre()+" es un "+fichero.getTipo());
        }
    }
    public void crearFicheros(){
        String path = "/home/sergio/Descargas/prueba/";
        System.out.println("Introduzca el nombre del fichero");
        String nombre = crearString();
        path = path + nombre + ".txt";
        File fichero = fileDAO.crearFichero(path);
        System.out.println("Introduzca el contenido del fichero");
        String contenido = crearString();
        FileWriter writer = new FileWriter(fichero);



    }
    public String crearString(){
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();
        return texto;
    }


}
