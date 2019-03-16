def swap(tuple: (Int, String)): (String, Int) = {
  val (x, y) = tuple
  (y, x)
}

def doubleHead(list: List[Int]): List[Int] = {
  val head::tail = list
  head * 2::tail
}

def add(x: Int, y: Int): Int => Int = {
  _ => x + y
}

def multiplyBy(x: Int, y: Int): Int => Int = {
  _ => x * y
}

def applyFunc(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x,y)

def sizeDescription(l: List[Int]): String ={
  if (l.size < 10) {
    "short"
  } else if (l.size < 100) {
    "long"
  } else {
    "very long"
  }
}

def lucky(x: Int, y: Int): Int => String = {
 _ => if (x == y) "Lucky Number!" else "Sorry, try again!"
}

def zip(l1: List[Int], l2: List[Int]): List[(Int, Int)] ={


  for(item1 <- l1; item2 <- l2) {
    (item1, item2)
  }
}
