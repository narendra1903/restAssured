/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ABC_032_JSON_PATH;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import io.restassured.path.json.support.Book;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JsonPathTest2 {

    public   String JSON = "";

  
    
    @BeforeTest
    public void Test1()
    {
    	RestAssured.baseURI = "http://localhost:8080";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/store.json");

		// First get the JsonPath object instance from the Response interface
		JsonPath j1 = response.jsonPath();
		
		JSON=response.body().asString();
    }

    @Test
    public void getList() {
        final List<String> categories = new JsonPath(JSON).get("store.book.category");
        assertThat(categories.size(), equalTo(4));
        assertThat(categories, hasItems("reference", "fiction"));
    }

    @Test
    public void firstBookCategory() {
        final String category = JsonPath.with(JSON).get("store.book[0].category");
        assertThat(category, equalTo("reference"));
    }

    @Test
    public void lastBookTitle() {
        final String title = JsonPath.with(JSON).get("store.book[-1].title");
        assertThat(title, equalTo("The Lord of the Rings"));
    }

    @Test
    public void booksWithArgAuthor() {
        String author = "Herman Melville";
        final List<Map<String, ?>> books = JsonPath.with(JSON)
                .param("author", author)
                .get("store.book.findAll { book -> book.author == author }");
        assertThat(books.size(), equalTo(1));

        final String authorActual = (String) books.get(0).get("author");
        assertThat(authorActual, equalTo(author));
    }

    @Test
    public void booksBetween5And15() {
        final List<Map<String, ?>> books = JsonPath.with(JSON).get("store.book.findAll { book -> book.price >= 5 && book.price <= 15 }");
        assertThat(books.size(), equalTo(3));

        final String author = (String) books.get(0).get("author");
        assertThat(author, equalTo("Nigel Rees"));

        final int price = (Integer) books.get(1).get("price");
        assertThat(price, equalTo(12));
    }

    @Test
    public void sizeInPath() {
        final Integer size = JsonPath.with(JSON).get("store.book.size()");
        assertThat(size, equalTo(4));
    }

    @Test
    public void getRootObjectAsMap() {
        final Map<String, Map> store = JsonPath.given(JSON).get("store");
        assertThat(store.size(), equalTo(2));

        final Map<String, Object> bicycle = store.get("bicycle");
        final String color = (String) bicycle.get("color");
        final float price = (Float) bicycle.get("price");
        assertThat(color, equalTo("red"));
        assertThat(price, equalTo(19.95f));
    }

    @Test
    public void getFloatAndDoublesAsBigDecimal() {
        final JsonPath using = JsonPath.with(JSON).using(new JsonPathConfig(JsonPathConfig.NumberReturnType.BIG_DECIMAL));
        assertThat(using.<Map<String, Map>>get("store").size(), equalTo(2));

        final Map<String, Object> bicycle = using.<Map<String, Map>>get("store").get("bicycle");
        final String color = (String) bicycle.get("color");
        final BigDecimal price = (BigDecimal) bicycle.get("price");
        assertThat(color, equalTo("red"));
        assertThat(price, equalTo(new BigDecimal("19.95")));
    }

    @Test
    public void getFloatAndDoublesAsBigDecimalUsingStaticConfiguration() {
        JsonPath.config = new JsonPathConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL);
        try {
            final Map<String, Map> store = JsonPath.with(JSON).get("store");
            assertThat(store.size(), equalTo(2));

            final Map<String, Object> bicycle = store.get("bicycle");
            final String color = (String) bicycle.get("color");
            final BigDecimal price = (BigDecimal) bicycle.get("price");
            assertThat(color, equalTo("red"));
            assertThat(price, equalTo(new BigDecimal("19.95")));
        } finally {
            JsonPath.config = null;
        }
    }

    @Test
    public void nonStaticJsonPathConfigHasPrecedenceOverStaticConfiguration() {
        JsonPath.config = new JsonPathConfig().numberReturnType(JsonPathConfig.NumberReturnType.FLOAT_AND_DOUBLE);
        try {
            final Map<String, Map> store = JsonPath.with(JSON).using(new JsonPathConfig(JsonPathConfig.NumberReturnType.BIG_DECIMAL)).get("store");
            assertThat(store.size(), equalTo(2));

            final Map<String, Object> bicycle = store.get("bicycle");
            final String color = (String) bicycle.get("color");
            final BigDecimal price = (BigDecimal) bicycle.get("price");
            assertThat(color, equalTo("red"));
            assertThat(price, equalTo(new BigDecimal("19.95")));
        } finally {
            JsonPath.config = null;
        }
    }

    @Test
    public void getRootObjectAsMap2() {
        final Map<String, Object> store = JsonPath.from(JSON).get("store.book[0]");
        for (Map.Entry<String, Object> stringObjectEntry : store.entrySet()) {
            System.out.println(stringObjectEntry.getKey() + " = " + stringObjectEntry.getValue());
        }
    }

    /*@Test
    public void rootPath() {
        final JsonPath jsonPath = new JsonPath(JSON).setRootPath("store.book");
        assertThat(jsonPath.getInt("size()"), equalTo(4));
        assertThat(jsonPath.getList("author", String.class), hasItem("J. R. R. Tolkien"));
    }

    @Test
    public void rootPathFollowedByArrayIndexing() {
        final JsonPath jsonPath = new JsonPath(JSON).setRootPath("store.book");
        assertThat(jsonPath.getString("[0].author"), equalTo("Nigel Rees"));
    }*/

   
    

    @Test
    public void getNumericalValues() {
        assertThat(JsonPath.with(JSON).getDouble("store.book[0].price"), equalTo(8.95D));
        assertThat(JsonPath.with(JSON).getFloat("store.book[0].price"), equalTo(8.95F));

        // The price is stored as an integer
        assertThat(JsonPath.with(JSON).getByte("store.book[1].price"), equalTo((byte) 12));
        assertThat(JsonPath.with(JSON).getShort("store.book[1].price"), equalTo((short) 12));
        assertThat(JsonPath.with(JSON).getInt("store.book[1].price"), equalTo(12));
        assertThat(JsonPath.with(JSON).getLong("store.book[1].price"), equalTo(12L));

        // The atoms is stored as a long
        assertThat(JsonPath.with(JSON).getByte("store.bicycle.atoms"), equalTo((byte) Long.MAX_VALUE));
        assertThat(JsonPath.with(JSON).getShort("store.bicycle.atoms"), equalTo((short) Long.MAX_VALUE));
        assertThat(JsonPath.with(JSON).getInt("store.bicycle.atoms"), equalTo((int) Long.MAX_VALUE));
        assertThat(JsonPath.with(JSON).getLong("store.bicycle.atoms"), equalTo(Long.MAX_VALUE));
    }

  
    

  

   

 

  
   
    @Test
    public void getStringConvertsTheResultToAString() {
        final String priceAsString = JsonPath.with(JSON).getString("store.book.price[0]");

        assertThat(priceAsString, is("8.95"));
    }


    /*
    @Test
    public void getObjectWorksWhenPathPointsToAJsonObject() {
        final Book book = JsonPath.from(JSON).getObject("store.book[2]", Book.class);

        assertThat(book, equalTo(new Book("fiction", "Herman Melville", "Moby Dick", "0-553-21311-3", 8.99f)));
    }*/

   /* @Test
    public void getObjectWorksWhenPathPointsToATypeRefMap() {
        final Map<String, Object> book = JsonPath.from(JSON).getObject("store.book[2]", new TypeRef<Map<String, Object>>() {});

        assertThat(book.get("category"), Matchers.<Object>equalTo("fiction"));
        assertThat(book.get("author"), Matchers.<Object>equalTo("Herman Melville"));
        assertThat(book.get("price"), Matchers.<Object>equalTo(8.99));
    }*/

/*    @Test
    public void getObjectWorksWhenPathPointsToATypeRefList() {
        final List<Float> prices = JsonPath.from(JSON).getObject("store.book.price", new TypeRef<List<Float>>() {});

        assertThat(prices, containsInAnyOrder(8.95, 12, 8.99, 22.99));
    }*/

    /*@Test
    public void getObjectWorksWhenPathPointsToAJsonObject2() {
        final List<Book> books = JsonPath.from(JSON).getList("store.book", Book.class);

        assertThat(books, hasSize(4));
        assertThat(books.get(0).getAuthor(), equalTo("Nigel Rees"));
    }*/

    @Test
    public void getObjectAsMapWorksWhenPathPointsToAJsonObject() {
        final Map<String, String> book = JsonPath.from(JSON).getObject("store.book[2]", Map.class);

        assertThat(book, hasEntry("category", "fiction"));
        assertThat(book, hasEntry("author", "Herman Melville"));
    }

    @Test
    public void getObjectWorksWhenPathPointsToAList() {
        final List<String> categories = JsonPath.from(JSON).getObject("store.book.category", List.class);

        assertThat(categories, hasItems("reference", "fiction"));
    }

    @Test
    public void getObjectAsFloatWorksWhenPathPointsToAFloat() {
        final Float price = JsonPath.from(JSON).getObject("store.book.price[0]", Float.class);

        assertThat(price, equalTo(8.95f));
    }

    @Test
    public void getObjectAsStringWorksWhenPathPointsToAString() {
        final String category = JsonPath.from(JSON).getObject("store.book.category[0]", String.class);

        assertThat(category, equalTo("reference"));
    }

    
    @Test
    public void canParseJsonDocumentWhenPathIncludesMinusInsideEscaped() {
        JsonPath path = new JsonPath("{ \"a-b\"  : \"minus\" , \"a.b\" : \"dot\"  , \"a.b-c\" : \"both\"  }");

        assertThat(path.getString("'a.b-c'"), equalTo("both"));
    }

    /**
     * Verifies that issue 195 is resolved.
     */
    @Test
    public void canParseJsonDocumentWithMultipleConsecutiveIntegersInsidePath() {
        String json = "{\n" +
                "    \"foo.bar.baz\": {\n" +
                "        \"0.2.0\": \"test\"\n" +
                "    }\n" +
                "}";

        final String string = JsonPath.from(json).getString("'foo.bar.baz'.'0.2.0'");

        assertThat(string, equalTo("test"));
    }

    @Test
    public void
    can_parse_multiple_values() {
        // Given
        final JsonPath jsonPath = new JsonPath(JSON);

        // When
        final String category1 = jsonPath.getString("store.book.category[0]");
        final String category2 = jsonPath.getString("store.book.category[1]");

        // Then
        assertThat(category1, equalTo("reference"));
        assertThat(category2, equalTo("fiction"));
    }

   
}

   
    