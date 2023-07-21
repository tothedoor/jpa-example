package converter;

import jakarta.persistence.AttributeConverter;

public class BooleanYNconverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return aBoolean ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return "Y".equals(s) ? true : false;
    }
}
