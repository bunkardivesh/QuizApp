package com.divesh.quizapp

object Constants{

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
        1,
        "What country does this flag belongs to?",
         R.drawable.america,
        "America",
        "Australia",
        "Armenia",
        "Austria",
        1)

        val que2 = Question(
            2,
            "What country does this flag belongs to?",
            R.drawable.alzeria,
            "Argentina",
            "Algeria",
            "Armenia",
            "Austria",
            2)

        val que3 = Question(
            3,
            "What country does this flag belongs to?",
            R.drawable.brazil,
            "Brazil",
            "Bolivia",
            "Belarus",
            "Austria",
            1)

        val que4 = Question(
            4,
            "What country does this flag belongs to?",
            R.drawable.canada,
            "Argentina",
            "Chad",
            "Colombia",
            "Canada",
            4)

        val que5 = Question(
            5,
            "What country does this flag belongs to?",
            R.drawable.china,
            "Libya",
            "China",
            "Canada",
            "Sudan",
            2)

        val que6 = Question(
            6,
            "What country does this flag belongs to?",
            R.drawable.india,
            "Peru",
            "Iran",
            "India",
            "Indonesia",
            3)

        val que7 = Question(
            7,
            "What country does this flag belongs to?",
            R.drawable.itly,
            "India",
            "Italy",
            "Iran",
            "Syria",
            2)

        val que8 = Question(
            8,
            "What country does this flag belongs to?",
            R.drawable.russia,
            "Russia",
            "Romania",
            "Reunion",
            "Rwanda",
            1)

        val que9 = Question(
            9,
            "What country does this flag belongs to?",
            R.drawable.south_africa,
            "Sweden",
            "South Africa",
            "South Sudan",
            "South Korea",
            1)

        val que10 = Question(
            10,
            "What country does this flag belongs to?",
            R.drawable.uk,
            "United States Of America",
            "United Kingdom",
            "United Arab Emirates",
            "Mexico",
            2)

        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        return questionsList

    }
}