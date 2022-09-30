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

    @Override
    public void showIntegerFromFile(String path) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(path,"r");
        randomAccessFile.seek(0);
        int position = 1;
        for (int i = 0;randomAccessFile.length() != randomAccessFile.getFilePointer();i++){
            int num = randomAccessFile.readInt();
            System.out.println(position +".- "+num);
            position++;
        }
        System.out.println("Fin del archivo");
    }

    @Override
    public void modIntegerFromFile(String path, int pos, int value) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(path,"rw");
        randomAccessFile.seek(pos*4);
        randomAccessFile.writeInt(value);
        randomAccessFile.seek(0);
        int position = 1;
        for (int i = 0;randomAccessFile.length() != randomAccessFile.getFilePointer();i++){
            int num = randomAccessFile.readInt();
            System.out.println(position +".- "+num);
            position++;
        }
        System.out.println("Fin del programa");
    }


}
