#!/usr/bin/env scala

//> using scala "3.4.2"

case class Language(originalRank: Int, name: String, category: String)

val languageData =
  """1, JavaScript, Web
    |2, Python, General
    |3, Java, General
    |4, PHP, Web
    |5, C#, General
    |6, TypeScript, Web
    |7, CSS, Web
    |7, C++, General
    |9, Ruby, General
    |10, C, General
    |11, Swift, General
    |12, Go, General
    |12, R, General
    |14, Shell, Shell Scripting
    |14, Kotlin, General
    |14, Scala, General
    |17, Objective-C, General
    |18, PowerShell, Shell Scripting
    |19, Rust, General
    |19, Dart, Mobile""".stripMargin

val allLanguages: Iterator[Language] = languageData.linesIterator
  .map { line =>
    val parts = line.split(",").map(text => text.trim)
    val rank = parts(0).toInt
    val name = parts(1)
    val category = parts(2)
    Language(rank, name, category)
  }

val generalPurposeLanguages: Iterator[(Language, Int)] = allLanguages
  .filter { language =>
    language.category.equalsIgnoreCase("general")
  }
  .zipWithIndex

println("🧠 General-purpose languages:")
println(f"${"GeneralRank"}%-12s ${"OriginalRank"}%-13s ${"Language"}")
println("-" * 40)

for ((language, generalIndex) <- generalPurposeLanguages) {
  val generalRank = generalIndex + 1
  val originalRank = language.originalRank
  val name = language.name
  println(f"#$generalRank%-11d #$originalRank%-12d $name")
}

