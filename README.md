# Title TBD, Transitive Closure
Jakub Danek and Premek Brada

NTIS -- New Technologies for the Information Society,   
Faculty of Applied Sciences,   
University of West Bohemia,   
Univerzitni 8, 306 14 Pilsen  
Czech Republic

---

This experiment verifies validity of ILP model for finding transitive closure
of software components.
 
## Simulation Scenarios

Scenarios S1 - S3 cover the same functionality as had been provided by the original ILP model.

Scenarios S4 - S6 cover transitive closure functionality.

**Main Provider** - component satisfying the requested requirement set (or its part).  
**Transitive Dependency** - component satisfying requirements of a **main provider**.

1. **S1 Void** - no requirements satisfied by repository components
    * empty result
    * no cost-based selection
1. **S2 Single** - all requirements satisfied by single component without transitive dependencies
    * single component returned
    * cost-based selection
    * repository contains multiple viable candidates
1. **S3 Multiple** - all requirements satisfied by a set of components without transitive dependencies
    * multiple components returned
    * cost-based selection
    * repository contains multiple viable candidates
1. **S4 Void Transitive** - all requirements are satisfied by a component with transitive dependency,
but the dependency is missing.
    * empty result
    * repository contains single viable candidate, but no transitive providers
1.  **S5 Single Transitive** - all requirements are satisfied by a single component with single transitive
 dependency.
    * two components returned - main provider with is dependency
    * cost-based selection
    * repository contains multiple viable candidates for both main provider and its transitive dependency
1. **S6 Multiple Transitive** - all requirements satisfied by a set of components with own transitive dependencies
    * multiple components returned
    * cost-based selection
    * repository contains multiple viable candidates for both main providers and their dependencies

 
### Source Data

This experiment is realized using simple component-based
[parking lot simulation](https://github.com/ReliSA/obcc-parking-example).


## Results



## Source Code

## Licensing
<a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Title TBD, Transitive Closure</span> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://relisa.kiv.zcu.cz/" property="cc:attributionName" rel="cc:attributionURL">Jakub Danek, Premek Brada</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License</a>.