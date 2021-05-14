package com.example.bmi_calculator

class Questions {
    var mQuestions = arrayOf(
            "Która z tych żywności jest przetworzona?",
            "Co jest owocem?",
            "Ile należy dziennie wypić wody?",
            "Jakie oznaczenie ma koronawirus?",
            "Jaki kraj jest największym na świecie producentem kakao?",
            "Co jest najmniej zdrowe?",
            "Ile gram tłuszczu ma w sobie marchewka?",
            "Który owoc jest najzdrowszy?",
            "Jest zupą o konsystencji gulaszu, na bazie wołowiny lub jesiotra, z dodatkiem migdałów i orzechów. Charakterystyczna dla kuchni gruzińskiej. Mowa o:",
            "Skąd pochodzi SŁYNNA sałatka grecka?"
    )
    private val mChoices = arrayOf(arrayOf("jajko", "batonik", "gruszka", "woda"), arrayOf("pomidor", "por", "cebula", "kalafior"), arrayOf("200ml", "15l", "1l", "1.5l"), arrayOf("COVID-19", "CV", "SARS", "SARS-CoV-2"), arrayOf("Polska", "Senegal", "Wybrzeże Kości Słoniowej", "Meksyk"), arrayOf("Frytki", "Chipsy", "Banan", "Marchewka"), arrayOf("50g", "0g", "15g", "8g"), arrayOf("Jabłko", "Truskawka", "Pomarańcza", "Kiwi"), arrayOf("Charczo", "Tołmie", "Chinkali", "Puri"), arrayOf("Egipt", "Cypr", "Turcja", "Grecja"))
    private val mCorrectAnswers = arrayOf(
            "batonik",
            "pomidor",
            "1.5l",
            "SARS-CoV-2",
            "Wybrzeże Kości Słoniowej",
            "Chipsy",
            "0g",
            "Kiwi",
            "Charczo",
            "Grecja"
    )

    fun getQuestion(a: Int): String {
        return mQuestions[a]
    }

    fun getChoice1(a: Int): String {
        return mChoices[a][0]
    }

    fun getChoice2(a: Int): String {
        return mChoices[a][1]
    }

    fun getChoice3(a: Int): String {
        return mChoices[a][2]
    }

    fun getChoice4(a: Int): String {
        return mChoices[a][3]
    }

    fun getChoice5(a: Int): String {
        return mChoices[a][4]
    }

    fun getChoice6(a: Int): String {
        return mChoices[a][5]
    }

    fun getChoice7(a: Int): String {
        return mChoices[a][6]
    }

    fun getChoice8(a: Int): String {
        return mChoices[a][7]
    }

    fun getChoice9(a: Int): String {
        return mChoices[a][8]
    }

    fun getChoice10(a: Int): String {
        return mChoices[a][9]
    }

    fun getCorrectAnswer(a: Int): String {
        return mCorrectAnswers[a]
    }
}