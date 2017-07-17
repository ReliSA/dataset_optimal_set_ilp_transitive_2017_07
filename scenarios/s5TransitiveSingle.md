# Scenario S3 Multiple

All requirements are satisfied by a component with transitive dependency, but the dependency is missing.

## Prerequisities

1. CRCE running at **crceurl**

## Steps

1. Upload all components listed in the section **Repository Contains** below to CRCE.
1. Wait until indexing finishes.
1. Send the query from section **Query** to the **crceurl**/rest/api/v2/metadata/catalogue as POST request body.  
   Request must have the following HTTP header: **Content-Type: application/xml** 

## Repository Contains

* all components in **data/complex-1a**, **data/complex-1b** and **data/complex-2** folders (and no other components).

## Query

```
<requirements>
   <requirement uuid="1" namespace="crce.api.java.package">
        <attribute name="name" type="java.lang.String" value="cz.zcu.kiv.relisa.data.parking.carpark.status"/>
        <requirement uuid="10" namespace="crce.api.java.class">
          <attribute name="name" type="java.lang.String" value="IParkingStatus"/>         
        </requirement>     
    </requirement>
    <requirement uuid="666" namespace="result.optimize-by">
        <attribute name="function-ID" type="java.lang.String" value="cf-file-size"/>
        <attribute name="method-ID" type="java.lang.String" value="ro-ilp-transitive-dependencies"/>
    </requirement>
    <directive name="operator" value="or"/>
</requirements>
```

## Expected Result

Carpark-1.0.0 and slf4j-api-1.7.22 are returned because they have smaller size than their higher-version peers.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<resources>
  <resource uuid="68a825d6-a141-46db-a81a-5a895bf3d67a">
    <capability uuid="832adc83-6d04-4327-b1a5-e23be81558c5" namespace="crce.identity">
      <attribute name="categories" type="java.lang.String" value="zip,java-api,java-api-required"/>
      <attribute name="external-id" type="java.lang.String" value="-"/>
      <attribute name="name" type="java.lang.String" value="carpark-1.0.0.jar"/>
      <attribute name="size" type="java.lang.String" value="7701"/>
      <attribute name="version" type="java.lang.String" value="-"/>
    </capability>
  </resource>
  <resource uuid="37c9bfa6-9c36-4066-a947-0ab00cbe9dc3">
    <capability uuid="a05e5e40-e9b1-4825-b290-d0a98e1393e5" namespace="crce.identity">
      <attribute name="categories" type="java.lang.String" value="zip,osgi,java-api,java-api-required"/>
      <attribute name="external-id" type="java.lang.String" value="slf4j.api"/>
      <attribute name="name" type="java.lang.String" value="slf4j-api"/>
      <attribute name="size" type="java.lang.String" value="41077"/>
      <attribute name="version" type="java.lang.String" value="1.7.22"/>
    </capability>
  </resource>
  <resource uuid="c470ca10-c82c-428c-aa7b-c55f3bbbdd96">
    <capability uuid="921bacb9-6c4d-41af-9dda-0a1e0ee3a255" namespace="crce.identity">
      <attribute name="categories" type="java.lang.String" value="zip,osgi,compared,java-api,java-api-required"/>
      <attribute name="external-id" type="java.lang.String" value="osgi.core"/>
      <attribute name="name" type="java.lang.String" value="osgi.core"/>
      <attribute name="size" type="java.lang.String" value="246924"/>
      <attribute name="version" type="java.lang.String" value="4.2.0.200908310645"/>
    </capability>
  </resource>
  <resource uuid="37547a2e-5f9b-4a20-85cb-1573418a7773">
    <capability uuid="0b1ea7d8-3d9a-4dfe-ac17-01657a1345f1" namespace="crce.identity">
      <attribute name="categories" type="java.lang.String" value="zip,osgi,compared,java-api,java-api-required"/>
      <attribute name="external-id" type="java.lang.String" value="slf4j.simple"/>
      <attribute name="name" type="java.lang.String" value="slf4j-simple"/>
      <attribute name="size" type="java.lang.String" value="15257"/>
      <attribute name="version" type="java.lang.String" value="1.7.25"/>
    </capability>
  </resource>
</resources>
```