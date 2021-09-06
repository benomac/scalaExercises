def songDecoder(song: String): String = {
  song.replaceAll("(WUB)+", " ").trim
}

// for regex '+' means one or more
// '*' means 0 or more
// '?' means 0 or 1
// '.' means 1 any char

//"ABC" should return "ABC"
songDecoder("ABC")

//"WUB" should return ""
songDecoder("WUB")

//"WUBABC" should return "ABC
songDecoder("WUBABC ")

//"ABCWUBABC" should return "ABC ABC"
songDecoder("ABCWUBABC")

//"ABCWUBWUBABC" should return "ABC ABC"
songDecoder("ABCWUBWUBABC")