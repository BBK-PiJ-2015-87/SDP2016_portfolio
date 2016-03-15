val text = Vector("Hello ", "my ", "name ", "is ", "vlad")

val tuples = for (i <- 3 to 5; j <- 13 to 15) yield (i, j)
val reverse = for (i <- text ) yield (i.reverse)
Range(1,11,2).sum

def isPalindrome(word:String) : Boolean = {
  return word == word.reverse
}

isPalindrome("Vlad")
isPalindrome("anna")

val even = for (i <- 1 to 100 if i%2 == 0) yield (i)