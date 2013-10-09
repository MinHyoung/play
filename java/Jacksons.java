import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dependencies:
 * - jackson-databind
 * - jackson-annotations
 * - jackson-core
 * See: http://wiki.fasterxml.com/JacksonDownload
 */
public class Jacksons {

    public static class User {
        public enum Gender {
            MALE,
            FEMALE,
        }

        public static class Name {
            public String first;
            public String last;
        }

        public Gender gender;
        public Name name;
        public boolean verified;
        public byte[] userImage;
    }


    public static class Field {
        public String type;
        public List<String> operators;
        public List<String> values;
        public String label;
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

        /**
         * 1. full data binding of pojo
         *
         * deserialize json to pojo
         */
        User user = mapper.readValue(new File("data/user.json"), User.class);
        //  serialize pojo to json
        mapper.writeValue(new File("data/user-pojo.json"), user);

        /**
         * 2. raw/untyped data binding
         *
         * binding type = Object.class or something more specific wrapper type like -
         * Map.class or List.class or String[].class
         *
         * For untyped data binding, Jackson uses the following concrete java types
         * for a given json type:
         *  object -> LinkedHashMap<String, Object>
         *  array -> ArrayList<Object>
         *  string -> String
         *  number - Integer, Long, BigInteger
         *  fraction - Double, BigDecimal
         *  true|false - Boolean
         *  null - null
         */
        Map<String, Object> userData = new HashMap<String, Object>();
        Map<String, String> nameStruct = new HashMap<String, String>();
        nameStruct.put("first", "Joe");
        nameStruct.put("last", "Sixpack");
        userData.put("name", nameStruct);
        userData.put("gender", "MALE");
        userData.put("verified", Boolean.FALSE);
        userData.put("userImage", "Rm9vYmFyIQ==");
        mapper.writeValue(new File("data/user-raw.json"), userData);

        /**
         * 3. data binding with generics
         *
         * Java's Type erasure prevents us from writing something like Map<String, User>.class
         * So, instead we use TypeReference to pass generic type definition via anonymous inner
         * class. If you don't do this and pass Map.class, then it is equivalent to binding to
         * Map<?, ?> which is an untyped map
         */
        Map<String, User> result = mapper.readValue(new File("data/user-map.json"),
                new TypeReference<Map<String, User>>() {
                });
        mapper.writeValue(new File("data/user-generics.json"), result);

//        Map<String, Map<String, Map<String, Object>>> config = mapper.readValue(new File("crunchbase.json"),
//                new TypeReference<Map<String, Map<String, Map<String, Object>>>>() {
//                });
//        mapper.writeValue(new File("output.json"), config);
//
//        for (Map.Entry<String, Map<String, Map<String, Object>>> configEntry : config.entrySet()) {
//            String table = configEntry.getKey();
//            Map<String, Map<String, Object>> tableParams = configEntry.getValue();
//            System.out.println(table + " -->");
//
//            for (Map.Entry<String, Object> fieldEntry : tableParams.get("fields").entrySet()) {
//                String fieldName = fieldEntry.getKey();
//                Map<String, String> fieldValues = (Map<String, String>) fieldEntry.getValue();
//                System.out.println(fieldName);
//                System.out.println(fieldValues.get("label"));
//            }
//        }

        JsonFactory jsonFactory = new JsonFactory();
        JsonParser jsonParser = jsonFactory.createParser(new File("data/search-result.json"));

        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
//            System.out.println(jsonParser.getCurrentToken());

            if ("docs".equals(jsonParser.getCurrentName())) {
                jsonParser.nextToken();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                        System.out.println("---");
                    }
                    if (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                        System.out.print(jsonParser.getCurrentName()+":");
                    } else if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING ||
                            jsonParser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT) {
                        System.out.println(jsonParser.getText());
                    }
                }
            }

            if ("numFound".equals(jsonParser.getCurrentName())) {
                System.out.println(jsonParser.getText());
                jsonParser.nextToken();
                System.out.println(jsonParser.getText());
            }

        }

        jsonParser.close();
    }
}
