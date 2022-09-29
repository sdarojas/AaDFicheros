package service;

import dao.FileDAO;
import dao.FileDAOimpl;
import entity.Fichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
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


    }
    public String crearString(){
        String texto;
        try(Scanner sc = new Scanner(System.in)) {
            texto = sc.nextLine();
        }
        return texto;
    }

    public int pideInt(){
        int entero;
        try (Scanner sc = new Scanner(System.in)) {
            entero = sc.nextInt();
        }
        return entero;
    }


    public void modificarEnteros(){
        String path = "C:\\Users\\Sergio\\Downloads\\enteros.dat";
        RandomAccessFile fileLectura = fileDAO.leerFicheros(path);
        leerFichero(fileLectura);

        System.out.println("Introduce un número");
        int entero = pideInt();

        try {
            fileLectura.seek(fileLectura.length());
            fileLectura.writeInt(entero);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        leerFichero(fileLectura);

    }
    public void leerFichero(RandomAccessFile fileLectura) {
        int num;
        try {
            fileLectura.seek(0);
            for (int i = 0; i < fileLectura.length(); i++) {
                num = fileLectura.readInt();
                System.out.println(num);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
