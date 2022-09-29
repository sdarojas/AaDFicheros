package dao;

import java.io.File;

public interface FileDAO {
    File[] listarFicheros(String path);

    File crearFichero(String path);
}
