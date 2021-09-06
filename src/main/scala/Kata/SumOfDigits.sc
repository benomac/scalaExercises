
  def digitalRoot(num: Int): Int = {
    val listify = num.toString.toList
    if (listify.length == 1) num
    else {
      val d = listify.map(x => x.toString.toInt).sum
      digitalRoot(d)
    }
  }

  digitalRoot(100)


