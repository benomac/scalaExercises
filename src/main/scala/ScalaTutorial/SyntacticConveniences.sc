val xs = List(1, 2, 3, 4, 5, 6)
val ys = List(7, 8, 9, 10, 11, 12)

for {
  x <- xs if x % 2 == 0
  y <- ys
} yield (x, y)