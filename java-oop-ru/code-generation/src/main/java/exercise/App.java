package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static exercise.Car.serialize;
import static exercise.Car.unserialize;

// BEGIN
public class App {
 public static void save(Path path, Car car) throws JsonProcessingException, IOException {
     String str = serialize(car);
     byte[] strToBytes = str.getBytes();
     Files.write(path, strToBytes, StandardOpenOption.CREATE);
 }

 public static Car extract(Path path) throws IOException {
     BufferedReader bufferedReader = Files.newBufferedReader(path);
     String line = bufferedReader.readLine();
     return unserialize(line);
 }
}
// END
