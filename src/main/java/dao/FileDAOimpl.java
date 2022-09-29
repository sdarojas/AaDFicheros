package dao;

import service.FileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDAOimpl implements FileDAO{
    public File[] listarFicheros(String path){
        File directorio = new File(path);
        return directorio.listFiles();

    }

    @Override
    public File crearFichero(String path) {
        File fichero = new File(path);
        try {
            fichero.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fichero;
    }

    @Override
    public RandomAccessFile leerFicheros(String path) {
        try {
            RandomAccessFile file = new RandomAccessFile(path,"rw");
            return file;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



}
