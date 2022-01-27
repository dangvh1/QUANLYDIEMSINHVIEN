package util;

import java.io.*;

public class FileUtil {
    public void writeDataToFile(Object[] data, String fileName) {
        if (StringUtil.isNullOrEmpty(fileName) || DataUtil.isNullOrEmpty(data)) {
            return;
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Object readDataFromFile(String fileName) {
        if (StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
