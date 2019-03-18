val people =  List("Alfred","Boris","Ann","Jan","Anya","Monique", "Christophe", "Jan", "Joris", "Bert", "Olaf");

// Exercise 1

// I
people.map("Dear " + _)

// II
def addDear(str: String): String = "Dear " + str
people.map(addDear).foreach(println)

// III
people.flatMap(_.toCharArray)

// IV
people.flatMap(_.toCharArray).distinct

// V
people.foldLeft(0)(_+_.length)

// VI
people.fold("Dear ")(_ + ", " + _)

// VII
people.count(_.contains("an"))

// VIII
people.count(_.length == 3)

// IX
people.forall(_.charAt(0).isUpper)

// X
people.exists(_.contains('q') && _.contains('y'))


