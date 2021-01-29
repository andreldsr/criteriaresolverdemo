# Criteria Resolver Demo
A demo project to show the use cases of the library Criteria Resolver

# Criteria Search Object
The API expects a Search Object and build the criteria query using only the filled fields

# Example
The ProductSearchObject with this fields filled
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
