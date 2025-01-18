import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("title.basics (1).tsv");
        HashMap<TitleType,Integer> histogram = new HashMap<TitleType, Integer>();
        List<Title> titles = new TsvTitleReader(file).read();
        for (Title title: titles) {
            histogram.put(title.type(), histogram.getOrDefault(title.type(),0)+1);
        }
        for (TitleType type:histogram.keySet()) {
            System.out.println("El tipo de titulo "+ type+" tiene una frecuencia de : "+ histogram.get(type));
        }
    }
}
