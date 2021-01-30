# Criteria Resolver Demo
A demo project to show the use cases of the library Criteria Resolver

# Criteria Search Object
The API expects a Search Object and build the criteria query using only the filled fields

# Example
The ProductSearchObject was created to representate all the possibilities in a hipotetical search screen and translates the optional fields in its properties using the Criteria Resolver annotation @CriteriaField to define the specific comparation in each field and the path to the propertie even if it is inside an inner object.
```java
@Getter
@Setter
public class ProductSearchObject extends SearchObject {
    @CriteriaField(comparationType = CriteriaField.ComparationType.LIKE)
    private String name;
    @CriteriaField(comparationType = CriteriaField.ComparationType.LIKE)
    private String description;
    @CriteriaField(fieldName = "price", comparationType = CriteriaField.ComparationType.GREATER_EQUALS)
    private Double minPrice;
    @CriteriaField(fieldName = "price", comparationType = CriteriaField.ComparationType.LESS_EQUALS)
    private Double maxPrice;
    @CriteriaField(fieldName = "price")
    private Double exactPrice;
    @CriteriaField(fieldName = "category.name", comparationType = CriteriaField.ComparationType.LIKE)
    private String category;
}
```
Using it as the @RequestBody of an API Post endpoint will make it expect the following body
```json
{
  "name": "string",
  "description": "string",
  "minPrice": 0,
  "maxPrice": 0,
  "exactPrice": 0,
  "category": "string"
}
```

And a ProductSearchObject with this fields filled
```json
{
  "exactPrice": 10,
  "description": "description test"
}
```
produces the following query without any other configuration
```sql
SELECT 
  product0_.name as col_0_0_,
  product0_.price as col_1_0_,
  category1_.name as col_2_0_
FROM
  product product0_ 
CROSS JOIN
  category category1_
WHERE
  product0_.category_id = category1_.id
  and (product0_.description like ?)
  and product0_.price = 10;
```
