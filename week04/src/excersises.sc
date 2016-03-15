var value = 17;
println(value)
var text = "ABC1234"
text = "DEF1234"
println(text)
var number = 15.56
println(number)

val list = List(1,2,3)
val vector = Vector.fill(3,4)(Vector(1,2,3))
val vec = Vector.empty
val vec2 = vec :+1 :+2 :+3
val vec3 = 100 +: vec2
vec3.sum
vec3.min
vec3.max


