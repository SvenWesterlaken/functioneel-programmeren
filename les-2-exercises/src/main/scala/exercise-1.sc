def swap(tuple: (Int, String)): (String, Int) = {
  val (x, y) = tuple
  (y, x)
}

def doubleHead(list: List[Int]): List[Int] = {
  val head::tail = list
  head * 2::tail
}

def add(x: Int, y: Int): Int => Int = _ => x + y

def multiplyBy(x: Int, y: Int): Int => Int = _ => x * y

def applyFunc(x: Int, y: Int, f: (Int, Int) => Int): Int = f(x,y)

def sizeDescription(l: List[Int]): String = if (l.size < 10) "short" else if (l.size < 100) "long" else "very long"

def lucky(x: Int, y: Int): Int => String = _ => if (x == y) "Lucky Number!" else "Sorry, try again!"

def zip(l1: List[Int], l2: List[Int]): List[(Int, Int)] ={

  if (l1.nonEmpty && l2.nonEmpty) {
    val head1::tail1 = l1
    val head2::tail2 = l2

    (head1, head2) :: zip(tail1, tail2)

  } else {
    Nil
  }

}

def computeBillTotal(quantity: List[Int], prices: List[Double], discountStrategy: (Int, Double) => Double): Double ={

  if (quantity.nonEmpty && prices.nonEmpty) {
    val q::qs = quantity
    val p::ps = prices

    discountStrategy(q, p) + computeBillTotal(qs, ps, discountStrategy)

  } else {
    0.0
  }

}

// Strategies
def fullPrice(quantity: Int, price: Double): Double = quantity * price

def tenPercentDiscount(quantity: Int, price: Double): Double = quantity * price * 0.9

def happyHour(quantity: Int, price: Double): Double = if (quantity % 2 == 0) quantity / 2 * price else (quantity + 1) / 2 * price