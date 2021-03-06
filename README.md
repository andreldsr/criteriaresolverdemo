# Criteria Resolver Demo
A demo project to show the use cases of the library Criteria Resolver

## Criteria Search Object
The API expects a Search Object and build the criteria query using only the filled fields

## Example
The ProductSearchObject extends SearchObject and was created to representate all the possibilities in a hipotetical search screen and translates the optional fields in its properties using the Criteria Resolver annotation @CriteriaField to define the specific comparation in each field and the path to the propertie even if it is inside an inner object.
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
Produces the following query without any other configuration
```sql
SELECT
        product0_.id as id1_1_,
        product0_.category_id as category5_1_,
        product0_.description as descript2_1_,
        product0_.name as name3_1_,
        product0_.price as price4_1_ 
FROM
        product product0_ 
CROSS JOIN
        category category1_
WHERE
        product0_.category_id = category1_.id
        and (product0_.description like ?)
        and product0_.price = 10;
```

## ProjectionField
With Criteria Resolver you can easily define the return that you want from the query creating an object with its fields representing the projections. The ProductDTO was created defining the projections for the query using the Criteria Resolver annotation @ProjectionField that receives the path to the original data, even if it is inside an inner object. The @ProjectionField is optional when the object propertie has the same name of the entity propertie.
```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @ProjectionField(projectionPath = "name")
    private String productName;
    private Double price;
    @ProjectionField(projectionPath = "category.name")
    private String categoryName;
}
```
Passing the ProductDTO as a parameter to the repository produces the following query without any other configuration
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

## Repository
To use the SearchObject you must create a repository that extends CriteriaBaseRepository passing the base entity for the criteria and it will automatically have all the necessary methods
```java
@Repository
public class ProductCriteriaRepository extends CriteriaBaseRepository<Product> {
    public ProductCriteriaRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
```

## Service
In your service class you define the return type of the method. When the return type its the same of the base entity of the criteria the repository offers the methods getResultList() and getSingleResult()
```java
public List<Product> getProductByCriteria(ProductSearchObject productSearchObject){
    return productCriteriaRepository.getResultList(productSearchObject);
}
```
When the return type its another class created with @ProjectionField annotation the repository offers you the getGenericQuery() method that receives the searchObject and the desired return class
```java
public List<ProductDTO> getProductByCriteria(ProductSearchObject productSearchObject){
    return productCriteriaRepository.getGenericQuery(productSearchObject, ProductDTO.class).getResultList();
}
```

## Installation
Add the dependency on you pom.xml
```xml
<dependency>
    <groupId>com.github.andreldsr</groupId>
    <artifactId>criteriaresolver</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[APACHE](https://choosealicense.com/licenses/apache/)
