def count(string: String): Map[Char,Int] = {
  def loop(s: String, acc:  Map[Char,Int]):  Map[Char,Int] = {
    if (s == "") acc
    else
      if (!acc.contains(s.head)) loop(s.tail, acc + (s.head -> 1))
      else loop(s.tail, acc + (s.head -> (acc(s.head) + 1)))
  }
  loop(string, Map.empty)
}

count("abcbeba")