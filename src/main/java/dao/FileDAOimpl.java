package dao;

import service.FileService;

import java.io.File;

public class FileDAOimpl implements FileDAO{
    public File[] listarFicheros(String path){
        File directorio = new File(path);
        return directorio.listFiles();

    }

    @Override
    public File crearFichero(String path) {
        File fichero = new File(path);
        return fichero;
    }

}
