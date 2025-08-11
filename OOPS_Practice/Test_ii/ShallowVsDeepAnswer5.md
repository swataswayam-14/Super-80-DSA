| **Type**         | **What it does**                                                                                           | **When problem occurs**                                            |
| ---------------- | ---------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------ |
| **Shallow Copy** | Creates a new object, but copies references of mutable fields — both objects share the same inner objects. | If one object changes a mutable field, the other sees the change.  |
| **Deep Copy**    | Creates a new object and recursively copies all mutable fields — new independent copies are made.          | No shared state, so changes in one object do not affect the other. |


### how Cloneable works in java

- Cloneable is a marker interface (no method)
- if a class implements Cloneable, calling super.clone() won't throw CloneNotSupportedException
- Object.clone() makes a shallow copy by default
- to implement deep copy , we have to manually clone mutable fields inside clone().