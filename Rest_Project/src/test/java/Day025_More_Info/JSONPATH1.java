package Day025_More_Info;

public class JSONPATH1 {

	public static void main(String[] args) {
		
		  String JSON = "{ \"store\": {\n" +
		            "    \"book\": [ \n" +
		            "      { \"category\": \"reference\",\n" +
		            "        \"author\": \"Nigel Rees\",\n" +
		            "        \"title\": \"Sayings of the Century\",\n" +
		            "        \"price\": 8.95\n" +
		            "      },\n" +
		            "      { \"category\": \"fiction\",\n" +
		            "        \"author\": \"Evelyn Waugh\",\n" +
		            "        \"title\": \"Sword of Honour\",\n" +
		            "        \"price\": 12\n" +
		            "      },\n" +
		            "      { \"category\": \"fiction\",\n" +
		            "        \"author\": \"Herman Melville\",\n" +
		            "        \"title\": \"Moby Dick\",\n" +
		            "        \"isbn\": \"0-553-21311-3\",\n" +
		            "        \"price\": 8.99\n" +
		            "      },\n" +
		            "      { \"category\": \"fiction\",\n" +
		            "        \"author\": \"J. R. R. Tolkien\",\n" +
		            "        \"title\": \"The Lord of the Rings\",\n" +
		            "        \"isbn\": \"0-395-19395-8\",\n" +
		            "        \"price\": 22.99\n" +
		            "      }\n" +
		            "    ],\n" +
		            "    \"bicycle\": {\n" +
		            "      \"color\": \"red\",\n" +
		            "      \"price\": 19.95,\n" +
		            "      \"atoms\": " + Long.MAX_VALUE + ",\n" +
		            "    }\n" +
		            "  }\n" +
		            "}";

		    String JSON2 = "[{\"email\":\"name1@mail.com\",\"alias\":\"name one\",\"phone\":\"3456789\"},\n" +
		            "{\"email\":\"name2@mail.com\",\"alias\":\"name two\",\"phone\":\"1234567\"},\n" +
		            "{\"email\":\"name3@mail.com\",\"alias\":\"name three\",\"phone\":\"2345678\"}]";

		 String JSON3 = "{\"id\":\"db24eeeb-7fe5-41d3-8f06-986b793ecc91\"}";


		    String JSON_MAP = "{ \"price1\" : 12.3,\n" +
		            "  \"price2\": 15.0 }";

		   String JSON_PATH_STARTING_WITH_NUMBER = "{ \"0\" : 12.3,\n" +
		            "  \"1\": 15.0 }";

		  String JSON_PATH_WITH_NUMBER = "{ \"map\" : { \"0\" : 12.3,\n" +
		            "  \"1\": 15.0 } }";

		    String JSON_PATH_WITH_SIZE = "{ \"map\" : { \"size\" : 12.3,\n" +
		            "  \"1\": 15.0 } }";

		     String JSON_PATH_WITH_BOOLEAN = "{ \"map\" : { \"true\" : 12.3,\n" +
		            "  \"false\": 15.0 } }";

		   String MALFORMED_JSON = "{\n" +
		            "    \"a\": 123456\n" +
		            "    \"b\":\"string\"\n" +
		            "}";

	
		   System.out.println(JSON);
	}
	
	
	

}
