package com.example.bmi_calculator;

public class Questions {

    public String mQuestions[] = {
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
    };

    private String mChoices[][] = {
            {"jajko", "batonik", "gruszka", "woda"},
            {"pomidor", "por", "cebula", "kalafior"},
            {"200ml", "15l", "1l", "1.5l"},
            {"COVID-19", "CV", "SARS", "SARS-CoV-2"},
            {"Polska", "Senegal", "Wybrzeże Kości Słoniowej", "Meksyk"},
            {"Frytki", "Chipsy", "Banan", "Marchewka"},
            {"50g", "0g", "15g", "8g"},
            {"Jabłko", "Truskawka", "Pomarańcza", "Kiwi"},
            {"Charczo", "Tołmie", "Chinkali", "Puri"},
            {"Egipt", "Cypr", "Turcja", "Grecja"}
    };

    private String mCorrectAnswers[] = {
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
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    };

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    };

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    };

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    };

    public String getChoice5(int a){
        String choice = mChoices[a][4];
        return choice;
    };

    public String getChoice6(int a){
        String choice = mChoices[a][5];
        return choice;
    };

    public String getChoice7(int a){
        String choice = mChoices[a][6];
        return choice;
    };

    public String getChoice8(int a){
        String choice = mChoices[a][7];
        return choice;
    };

    public String getChoice9(int a){
        String choice = mChoices[a][8];
        return choice;
    };

    public String getChoice10(int a){
        String choice = mChoices[a][9];
        return choice;
    };

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
