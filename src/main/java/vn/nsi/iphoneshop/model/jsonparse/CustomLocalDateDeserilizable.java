package vn.nsi.iphoneshop.model.jsonparse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomLocalDateDeserilizable extends StdDeserializer<LocalDate> {

    public CustomLocalDateDeserilizable() {
        super(LocalDate.class);
    }

    public CustomLocalDateDeserilizable(Class<LocalDate> t) {
        super(t);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        if (StringUtils.hasText(jsonParser.getValueAsString())) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(jsonParser.getValueAsString(),df);
        }
        return null;
    }
}
