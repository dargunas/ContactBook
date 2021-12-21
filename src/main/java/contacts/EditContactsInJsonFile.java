package contacts;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EditContactsInJsonFile {




    public EditContactsInJsonFile() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/contactList.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Contacts contacts = new Contacts();
        JsonNode parser = objectMapper.readTree(reader);
        Map<String, Object> listOfContacts = new HashMap<>();
        Map<Integer, Object> listOfContactsFinal = new HashMap<>();
        listOfContacts.put("Name", parser.path("Name"));
        listOfContacts.put("Last name", parser.path("Last name"));
        listOfContacts.put("email", parser.path("email"));
        listOfContacts.put("Phone number", parser.path("Phone number"));

        for (int i = 0; i < listOfContacts.size(); i++){
            listOfContactsFinal.put(i, listOfContacts);
        }
    }
}
