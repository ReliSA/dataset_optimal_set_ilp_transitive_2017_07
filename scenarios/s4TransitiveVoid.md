# Scenario S3 Multiple

All requirements are satisfied by a component with transitive dependency, but the dependency is missing.

## Prerequisities

1. CRCE running at **crceurl**

## Steps

1. Upload all components listed in the section **Repository Contains** below to CRCE.
1. Wait until indexing finishes.
1. Send the query from section **Query** to the **crceurl**/rest/api/v2/metadata/catalogue as POST request body.  
   Request must have the following HTTP header: **Content-Type: application/xml** 

## Experiment Part A

Tests that no results are returned if a first-level transitive dependency is missing (i.e. component that is 
a direct dependency of the component which satisfies our query).

### Repository Contains

* all components in **data/complex-1a** folder (and no other components).

### Query

```
<requirements>
   <requirement uuid="1" namespace="crce.api.java.package">
        <attribute name="name" type="java.lang.String" value="cz.zcu.kiv.relisa.data.parking.carpark.status"/>
        <requirement uuid="10" namespace="crce.api.java.class">
          <attribute name="name" type="java.lang.String" value="IParkingStatusUpdate"/>         
        </requirement>     
    </requirement>
    <requirement uuid="666" namespace="result.optimize-by">
        <attribute name="function-ID" type="java.lang.String" value="cf-file-size"/>
        <attribute name="method-ID" type="java.lang.String" value="ro-ilp-transitive-dependencies"/>
    </requirement>
    <directive name="operator" value="or"/>
</requirements>
```

### Expected Result

No components returned, because carpark and statsbase are missing one transitive dependency - OSGi core.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<resources>
</resources>
```

## Experiment Part B

Tests that no results are returned if a nested-level transitive dependency is missing (i.e. component that is 
a transitive dependency, but not a direct dependency, of the component which satisfies our query).

### Repository Contains

* all components in **data/complex-1a** and **data/complex-1b** folders (and no other components).

### Query

```
<requirements>
   <requirement uuid="1" namespace="crce.api.java.package">
        <attribute name="name" type="java.lang.String" value="cz.zcu.kiv.relisa.data.parking.carpark.status"/>
        <requirement uuid="10" namespace="crce.api.java.class">
          <attribute name="name" type="java.lang.String" value="IParkingStatusUpdate"/>         
        </requirement>     
    </requirement>
    <requirement uuid="666" namespace="result.optimize-by">
        <attribute name="function-ID" type="java.lang.String" value="cf-file-size"/>
        <attribute name="method-ID" type="java.lang.String" value="ro-ilp-transitive-dependencies"/>
    </requirement>
    <directive name="operator" value="or"/>
</requirements>
```

### Expected Result

No components returned, because carpark and statsbase are missing one transitive dependency - OSGi core.

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<resources>
</resources>
```