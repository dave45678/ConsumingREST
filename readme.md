## Consuming a REST Endpoint

A simple application that consumes a RESTful service.

A RESTful service can be found at ```https://gturnquist-quoters.cfapps.io/api/random```. It randomly fetches quotes about Spring Boot and returns them as a JSON document.

If you request that URL through your web browser or curl, you’ll receive a JSON document that looks something like this:

```json
{
   type: "success",
   value: {
      id: 10,
      quote: "Really loving Spring Boot. Making apps is easy."
   }
}
```

Spring provides a template class called RestTemplate. RestTemplate makes interacting with most RESTful services a one-line incantation. And it can even bind that data to custom domain types.

You will also need to include libraries for general data-binding functionality. Jackson is available on Maven and works on core streaming API. 

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
</dependency>
```

 is a simple Java class with a handful of properties and matching getter methods. It’s annotated with @JsonIgnoreProperties from the Jackson JSON processing library to indicate that any properties not bound in this type should be ignored.

In order for you to directly bind your data to your custom types, you need to specify the variable name exact same as the key in the JSON Document returned from the API. In case your variable name and key in JSON doc are not matching, you need to use @JsonProperty annotation to specify the exact key of JSON document.


```json
{
   type: "success",
   value: {
      id: 10,
      quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
   }
}
```
### Quote Class
A class to contain the data that you retrieve. It is a simple Java class with a handful of properties and matching getter methods. It’s annotated with ```@JsonIgnoreProperties``` from the Jackson JSON processing library to indicate that any properties not bound in this type should be ignored.

In order for you to directly bind your data to your custom types, you need to specify the variable name exact same as the key in the JSON Document returned from the API. 
In case your variable name and key in JSON doc are not matching, you need to use ```@JsonProperty``` annotation to specify the exact key of JSON document.

### Value Class
An additional class is needed to embed the inner quotation itself. 
This uses the same annotations but maps onto other data fields.

### Resources
https://www.baeldung.com/rest-template
