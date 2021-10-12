def sumOfOddNumber(n: Long): Long = {
  def getFirstOrLastNumberOfNthRow(numberOfRows: Long, ad: Long, firstNumberOfNthRow: Long): Long = {
    if (numberOfRows == 1) firstNumberOfNthRow
    else getFirstOrLastNumberOfNthRow(numberOfRows - 1, ad + 2, firstNumberOfNthRow + ad)
  }
  val getFirstNumber = getFirstOrLastNumberOfNthRow(n, 2, 1)
  val getLastNumber = getFirstOrLastNumberOfNthRow(n, 4, 1)
  val foo = getFirstNumber to getLastNumber by 2
  foo.sum
}

sumOfOddNumber(5)