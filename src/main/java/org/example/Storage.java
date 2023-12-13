package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Storage {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();
    public static final String JSON_FILE_NAME = "jsonfile.json";
    public static final String XML_FILE_NAME = "xmlfile.xml";

    public static void save(Object student) throws IOException {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File(JSON_FILE_NAME), student);
        xmlMapper.writeValue(new File(XML_FILE_NAME), student);
    }

    public static Student2 loadJson() throws IOException {
        return objectMapper.readValue(new File(JSON_FILE_NAME), Student2.class);
    }

    public static Student2 loadXml() throws IOException {
        return xmlMapper.readValue(new File(XML_FILE_NAME), Student2.class);
    }
}
