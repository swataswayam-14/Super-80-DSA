# 📝 OOP Last-Minute Revision Cheat Sheet

A compact reference for quick scanning before interviews.

---

## **1. 4 Core Principles**
- **Encapsulation** → Bundle data & methods; hide details via access modifiers.
- **Abstraction** → Hide implementation; expose essentials (abstract classes/interfaces).
- **Inheritance** → “Is-A” relationship; reuse code.
- **Polymorphism** → One interface, many forms:
  - Compile-time → Overloading
  - Runtime → Overriding

---

## **2. Access Modifiers Table**
| Modifier   | Same Class | Same Package | Subclass | World |
|------------|------------|--------------|----------|-------|
| private    | ✅         | ❌           | ❌       | ❌    |
| default    | ✅         | ✅           | ❌       | ❌    |
| protected  | ✅         | ✅           | ✅       | ❌    |
| public     | ✅         | ✅           | ✅       | ✅    |

---

## **3. Overloading vs Overriding**
- **Overloading**:
  - Same method name, different params
  - Compile-time resolution
- **Overriding**:
  - Same signature, subclass
  - Runtime resolution
  - Rules: access ≥ parent, return type same/covariant, cannot override `final` or `static`

---

## **4. Static vs Instance**
- Static → Belongs to class, single copy
- Instance → Belongs to object
- Static methods can’t access instance variables directly

---

## **5. Constructor & Initialization Order**
1. Static blocks (Parent → Child)
2. Instance vars & blocks (Parent → Child)
3. Constructors (Parent → Child)

---

## **6. Abstract Class vs Interface**
| Feature              | Abstract Class        | Interface (Java 8+)       |
|----------------------|-----------------------|---------------------------|
| Methods              | Abstract + concrete   | Abstract, default, static |
| Variables            | Any type              | `public static final`     |
| Multiple inheritance | ❌                     | ✅                        |
| Constructor          | ✅                     | ❌                        |

---

## **7. Composition vs Inheritance**
- **Composition** → “Has-A”; flexible, low coupling
- **Inheritance** → “Is-A”; can lead to tight coupling

---

## **8. Immutable Class Checklist**
- Mark class `final`
- Make fields `private final`
- No setters
- Defensive copies for mutable fields

---

## **9. equals() & hashCode()**
- Override both for collections (`HashMap`, `HashSet`)
- Equal objects → same hash
- `hashCode()` inconsistency → lookup issues

---

## **10. Shallow vs Deep Copy**
- **Shallow**: Copies refs only
- **Deep**: Copies entire object graph

---

## **11. Inner Classes**
- **Member**: Access outer instance members
- **Static nested**: No outer instance ref
- **Local**: Inside method
- **Anonymous**: No name, quick override

---

## **12. final Keyword**
- Variable → Value fixed
- Method → No override
- Class → No inheritance

---

## **13. Covariant Return Types**
- Overridden method can return a more specific type than in parent

---

## **14. Key Design Patterns**
- **Singleton** → One instance
- **Factory** → Centralized object creation
- **Strategy** → Swap behavior at runtime
- **Observer** → Publisher-subscriber model

---

## **15. Common Tricky Points**
- Static methods are *hidden*, not overridden
- `private` methods not inherited
- Constructor chaining → `this()` / `super()`
- Interface diamond problem solved via explicit override

---
