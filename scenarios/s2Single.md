# Scenario S2 Single

All requirements satisfied by single component without transitive dependencies

## Prerequisities

1. CRCE running at **crceurl**

## Steps

1. Upload all components listed in the section **Repository Contains** below to CRCE.
1. Wait until indexing finishes.
1. Send the query from section **Query** to the **crceurl**/rest/api/v2/metadata/catalogue as POST request body.  
   Request must have the following HTTP header: **Content-Type: application/xml** 

## Repository Contains

* all components from **/data/simple/out** folder

## Query

```
<requirements>
   <requirement uuid="1" namespace="crce.api.java.package">
        <attribute name="name" type="java.lang.String" value="cz.zcu.kiv.relisa.data.simple1"/>
        <requirement uuid="2" namespace="crce.api.java.class">
          <attribute name="name" type="java.lang.String" value="TestClass"/>
        </requirement>
    </requirement>
    <requirement uuid="666" namespace="result.optimize-by">
        <attribute name="function-ID" type="java.lang.String" value="cf-file-size"/>
        <attribute name="method-ID" type="java.lang.String" value="ro-ilp-transitive-dependencies"/>
    </requirement>    
</requirements>
```

## Expected Result

Single component found - there are two feasible candidates, but the 1.0.0 version is smaller than 1.1.0.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<resources>
  <resource uuid="0c3a99ae-6839-4ac2-8d2f-4f75fb636782">
    <capability uuid="2b48639c-d821-4a3e-81e1-d23814b76987" namespace="crce.identity">
      <attribute name="categories" type="java.lang.String" value="zip,java-api,java-api-required"/>
      <attribute name="external-id" type="java.lang.String" value="-"/>
      <attribute name="name" type="java.lang.String" value="simple-1-1.0.0.jar"/>
      <attribute name="size" type="java.lang.String" value="2632"/>
      <attribute name="version" type="java.lang.String" value="-"/>
    </capability>
  </resource>
</resources>
```