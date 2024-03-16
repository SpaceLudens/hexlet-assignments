package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> dataBase;

    public InMemoryKV(Map<String, String> dataBase) {
        this.dataBase = new HashMap<>(dataBase);
    }

    public Map<String, String> getDataBase() {
        return dataBase;
    }

    public void setDataBase(Map<String, String> dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void set(String key, String value) {
        getDataBase().put(key, value);
    }

    @Override
    public void unset(String key) {
        getDataBase().remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return getDataBase().getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(getDataBase());
    }

}
// END
