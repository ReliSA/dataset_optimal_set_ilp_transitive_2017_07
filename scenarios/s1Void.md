# Scenario S1 Void

No requirements satisfied by components inside repository.

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
   <requirement id="1" namespace="crce.api.java.package">
        <attribute name="name" type="java.lang.String" value="nonexistentpackage"/>
    </requirement>
    <requirement id="666" namespace="result.optimize-by">
        <attribute name="function-ID" type="java.lang.String" value="cf-equal-cost"/>
        <attribute name="method-ID" type="java.lang.String" value="ro-ilp-transitive-dependencies"/>
    </requirement>    
</requirements>
```

## Expected Result

No components found.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<resources>
</resources>
```