# Classes

## Constructors
- A class in Kotlin can have a primary constructor and one or more secondary constructors.
  - If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted:

### Secondary constructors
- A class can also declare secondary constructors, which are prefixed with constructor:
```kotlin
class Person(val pets: MutableList<Pet> = mutableListOf())

class Pet {
    constructor(owner: Person) {
        owner.pets.add(this) // adds this pet to the list of its owner's pets
    }
}
```
### Companion objects
- If you need to write a function that can be called without having a class instance but that needs access to the internals of a class (such as a factory method), you can write it as a member of an object declaration inside that class.

# Functional (SAM) interfaces
- An interface with only one abstract method is called a functional interface, or a Single Abstract Method (SAM) interface. The functional 
interface can have several non-abstract members but only one abstract member.
To declare a functional interface in Kotlin, use the fun modifier.
```kotlin
fun interface KRunnable {
   fun invoke()
}
```
