public class TsvTitleDeserializer implements TitleDeserializer{
    @Override
    public Title deserialize(String line) {
        return deserializeTitle(line.split("\t"));
    }

    public Title deserializeTitle(String[] split) {
        return new Title(split[0], StringToType(split[1]), split[2]);
    }

    private TitleType StringToType(String type) {
        return TitleType.valueOf(normalize(type));
    }

    private String normalize(String type) {
        return type.toUpperCase().charAt(0)+type.substring(1).replace("-"," ");
    }
}
