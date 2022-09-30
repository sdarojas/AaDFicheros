package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public interface FileDAO {
    File[] listarFicheros(String path);

    File crearFichero(String path);

    RandomAccessFile leerFicheros(String path);


    void showIntegerFromFile(String path) throws IOException;

    void modIntegerFromFile(String path, int pos, int value) throws IOException;
}
