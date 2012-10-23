package com.specimen.inventory.web.utils;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DateSerializer.
 */
public class DateSerializer extends JsonSerializer<Date> {

    /* (non-Javadoc)
   * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object, org.codehaus.jackson.JsonGenerator, org.codehaus.jackson.map.SerializerProvider)
    */
    @Override
    public void serialize(Date value_p, JsonGenerator gen, SerializerProvider prov_p)
            throws IOException, JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("m/d/yyyy");
        String formattedDate = formatter.format(value_p);
        gen.writeString(formattedDate);
    }
}