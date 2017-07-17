# Scenario S1 Void

All requirements satisfied by a set of components without transitive dependencies.

## Prerequisities

1. CRCE running at **crceurl**

## Steps

1. Upload all components listed in the section **Repository Contains** below to CRCE.
1. Wait until indexing finishes.
1. Send the query from section **Query** to the **crceurl**/rest/api/v2/metadata/catalogue as POST request body.  
   Request must have the following HTTP header: **Content-Type: application/xml** 

## Repository Contains

* all 5 simple components from /data folder

## Query

```
<requirements>
   <requirement uuid="1" namespace="crce.api.java.package">
        <attribute name="name" type="java.lang.String" value="cz.zcu.kiv.relisa.data.simple1"/>
        <requirement uuid="10" namespace="crce.api.java.class">
          <attribute name="name" type="java.lang.String" value="TestClass"/>
          <requirement uuid="100" namespace="crce.api.java.method">
              <attribute name="name" type="java.lang.String" value="testMethod"/>
              <attribute name="paramTypes" type="java.util.List" value="[java.lang.String]"/>
              <attribute name="returnType" type="java.lang.String" value="java.lang.Integer"/>
          </requirement>          
        </requirement>     
    </requirement>
    <requirement uuid="2" namespace="crce.api.java.package">
            <requirement uuid="20" namespace="crce.api.java.class">
              <attribute name="name" type="java.lang.String" value="AnotherTestClass"/>
              <requirement uuid="200" namespace="crce.api.java.method">
                  <attribute name="name" type="java.lang.String" value="getMeaningOfLife"/>
              </requirement>
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

Two components returned - the larger of the two *simple-1* components, as it is the only one to provide method
**Integer testMethod(String parameter)** and the smallest of the three *simple-2* components, as they all
provide method **getMeaningOfLife**.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<resources>
    <resource uuid="05c9d891-b529-4164-ab2d-0d3b53762ad5">
        <capability uuid="f42074dc-284b-4bdc-ac93-b9153ab5644f" namespace="crce.identity">
          <attribute name="categories" type="java.lang.String" value="zip,java-api,java-api-required"/>
          <attribute name="external-id" type="java.lang.String" value="-"/>
          <attribute name="name" type="java.lang.String" value="simple-1-1.1.0.jar"/>
          <attribute name="size" type="java.lang.String" value="2673"/>
          <attribute name="version" type="java.lang.String" value="-"/>
        </capability>
    </resource>
    <resource uuid="547d3805-be93-4b23-90ad-81e39f8c3cc3">
        <capability uuid="06241c8e-1770-4651-bdba-8535548ede7a" namespace="crce.identity">
          <attribute name="categories" type="java.lang.String" value="zip,java-api,java-api-required"/>
          <attribute name="external-id" type="java.lang.String" value="-"/>
          <attribute name="name" type="java.lang.String" value="simple-2-1.0.0.jar"/>
          <attribute name="size" type="java.lang.String" value="2771"/>
          <attribute name="version" type="java.lang.String" value="-"/>
        </capability>
    </resource>
</resources>
```