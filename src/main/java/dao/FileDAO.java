package dao;

import java.io.File;
import java.io.RandomAccessFile;

public interface FileDAO {
    File[] listarFicheros(String path);

    File crearFichero(String path);

    RandomAccessFile leerFicheros(String path);


}
