> [코틀린 공식문서](https://kotlinlang.org/docs/home.html) 중 일부 기록하고 싶은 것들만 기록합니다.
# Basic syntax

## Creating classes and instances

- Properties of a class can be listed in its declaration or body.

```kotlin
class Rectangle(var height: Double, var length: Double) {
    var perimeter = (height + length) * 2
}
```

- The default constructor with parameters listed in the class declaration is available automatically.

```kotlin
val rectangle = Rectangle(5.0, 2.0)
println("The perimeter is ${rectangle.perimeter}")
```

## Nullable values and null checks
- A reference must be explicitly marked as nullable when null value is possible. Nullable type names have ? at the end.
```kotlin
if (x == null) {
    println("Wrong number format in arg1: '$arg1'")
    return
}
if (y == null) {
    println("Wrong number format in arg2: '$arg2'")
    return
}

// x and y are automatically cast to non-nullable after null check
println(x * y)
```

## Type checks and automatic casts
- The `is` operator checks if an expression is an instance of a type.
- If an immutable local variable or property is checked for a specific type, there's no need to cast it explicitly.
```kotlin
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}
```

