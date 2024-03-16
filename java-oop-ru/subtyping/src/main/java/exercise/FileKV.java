package exercise;

import java.util.HashMap;
import java.util.Map;

import static exercise.Utils.readFile;
import static exercise.Utils.writeFile;
import static exercise.Utils.serialize;
import static exercise.Utils.unserialize;
// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> dataBase;
    public FileKV(String filePath, Map<String, String> dataBase) {
        this.filePath = filePath;
        this.dataBase = new HashMap<>(dataBase);
        String serializeString = serialize(dataBase);
        writeFile(filePath, serializeString);
    }

    @Override
    public void set(String key, String value) {
        var content = readFile(getFilePath());
        var map = unserialize(content);
        map.put(key, value);
        content = serialize(map);
        writeFile(getFilePath(), content);


    }

    @Override
    public void unset(String key) {
        var content = readFile(getFilePath());
        var map = unserialize(content);
        map.remove(key);
        content = serialize(map);
        writeFile(getFilePath(), content);
    }

    @Override
    public String get(String key, String defaultValue) {
        var content = readFile(getFilePath());
        var map = unserialize(content);
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        var content = readFile(getFilePath());
        var map = unserialize(content);
        return new HashMap<>(map);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, String> getDataBase() {
        return dataBase;
    }

    public void setDataBase(Map<String, String> dataBase) {
        this.dataBase = dataBase;
    }
}
// END
