import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader{

    private final File file;

    public TsvTitleReader(File file) {
        this.file = file;
    }


    @Override
    public List<Title> read() {
       try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.readLine();
            return readwith(reader);
       }
       catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    private List<Title> readwith(BufferedReader reader) throws IOException {
        List<Title> resultingtitles = new ArrayList<>();
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        while(true){
            String line = reader.readLine();
            if(line == null)break;
            Title title = deserializer.deserialize(line);
            resultingtitles.add(title);
        }

        return resultingtitles;
    }
}
