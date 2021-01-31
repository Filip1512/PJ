# Dlaczego GoogleTest C++?

GoogleTest C++ jest frameworkiem, który pozwala na pisanie jeszcze lepszych testów w języku C++, niezależnie od tego w jakim środowisku pracujesz: Linux, Windows, Mac.

## Co czyni test dobrym i jak Google C++ Testing Framework temu pomaga?

1. Testy powinny być niezależne oraz powtarzalne. Debugowanie testu, który kończy się powodzeniem lub niepowodzeniem w wyniku innych testów, jest trudne. Struktura testowa Google C ++ izoluje testy, uruchamiając każdy z nich na innym obiekcie. Gdy test się nie powiedzie, Google C ++ Testing Framework umożliwia uruchomienie go w izolacji w celu szybkiego debugowania. 

2. Testy powinny być dobrze zorganizowane i odzwierciedlać strukturę testowanego kodu. Google C ++ Testing Framework grupuje powiązane testy w przypadki testowe, które mogą współdzielić dane i podprogramy. Ten typowy wzorzec jest łatwy do rozpoznania i sprawia, że testy są łatwe do utrzymania. Taka spójność jest szczególnie pomocna, gdy ludzie zmieniają projekty i zaczynają pracować nad nowym kodem. 

3. Testy powinny być przenośne i wielokrotnego użytku. Społeczność opensource ma dużo kodu, który jest neutralny dla platformy, jej testy również powinny być neutralne dla platformy. GoogleTest C++ działa w różnych systemach operacyjnych, z różnymi kompilatorami (GCC, MSVC i inne), z wyjątkami lub bez, więc testy GoogleTest C++ mogą z łatwością działać z różnymi konfiguracjami. (Należy pamiętać, że bieżąca wersja zawiera tylko skrypty kompilacji dla systemu Linux).

4. Jeśli testy zakończą się niepowodzeniem, powinny dostarczyć jak najwięcej informacji o problemie. Struktura testowa Google C++ nie kończy się na pierwszym niepowodzeniu testu. Zamiast tego zatrzymuje tylko bieżący test i kontynuuje od następnego. Możesz także skonfigurować testy, które zgłaszają niepowodzenia niekrytyczne, po których bieżący test będzie kontynuowany. W ten sposób można wykryć i naprawić wiele błędów w jednym cyklu uruchom-edytuj-kompilacji. 

5. Struktura testowa powinna uwolnić autorów testów od obowiązków porządkowych i pozwolić im skupić się na treści testu. Google C++ Testing Framework automatycznie śledzi wszystkie zdefiniowane testy i nie wymaga od użytkownika wyliczania ich w celu ich uruchomienia. 

6. Testy powinny być szybkie. Dzięki platformie testowej Google C ++ możesz ponownie wykorzystywać współdzielone zasoby w testach i płacić za konfigurację / wyłączenie tylko raz, bez uzależniania testów od siebie nawzajem. 

Platforma testowa Google C++ jest oparta na popularnej architekturze xUnit, więc osoby wcześniej korzystające z JUnit lub PyUnit poczują się jak u siebie.


## Informacja dotycząca instalacji

Upewnij się, że w ścieżce wyszukiwania nagłówka znajduje się GTEST_ROOT/include, aby kompilator mógł znaleźć „gtest / gtest.h” podczas kompilowania testu.


## Główny zamysł GoogleTest C++ oraz samego testowania

Korzystając z Google Test, zaczynasz od napisania asercji, czyli instrukcji sprawdzających, czy warunek jest prawdziwy. Rezultatem asercji może być sukces, niepowodzenie niekrytyczne lub niepowodzenie krytyczne. Jeśli wystąpi krytyczna awaria, przerywa bieżącą funkcję; w przeciwnym razie program będzie kontynuowany normalnie.

Testy używają asercji, aby zweryfikować zachowanie testowanego kodu. Jeśli test ulegnie awarii lub ma nieudane potwierdzenie, to kończy się niepowodzeniem; inaczej to się powiedzie.

Przypadek testowy zawiera jeden lub wiele testów. Powinieneś pogrupować testy w przypadki testowe, które odzwierciedlają strukturę testowanego kodu. Gdy wiele testów w przypadku testowym wymaga współużytkowania wspólnych obiektów i podprogramów, można umieścić je w klasie osprzętu testowego.

Program testowy może zawierać wiele przypadków testowych.

## Testowanie

### Asercje

- Wersje ASSERT_* generują krytyczne błędy w przypadku niepowodzenia i przerywają bieżącą funkcję.
- Wersje EXPECT_* generują niepowodzenia niekrytyczne, które nie przerywają bieżącej funkcji. Zwykle preferowane są EXPECT_*, ponieważ pozwalają na zgłoszenie więcej niż jednego błędu w teście. Należy jednak użyć ASSERT_*, jeśli nie ma sensu kontynuować, gdy dane stwierdzenie zawodzi.


Aby dostarczyć niestandardowy komunikat o błędzie, wystarczy przesłać go strumieniowo do makra przy użyciu operatora << lub sekwencji takich operatorów. Przykład:

```cpp
ASSERT_EQ(x.size(), y.size()) << "Vectors x and y are of unequal length";

for (int i = 0; i < x.size(); ++i) {
  EXPECT_EQ(x[i], y[i]) << "Vectors x and y differ at index " << i;
}
```


#### Podstawowe asercje

Asercje operujące na podstawowych warunkach true/false:

| Asercje krytyczne | Asercje niekrytyczne | Podsumowanie |
| ----------------- |----------------------| -------------|
| ASSERT_TRUE(warunek); | EXPECT_TRUE(warunek); | Warunek spełniony (true) |
| ASSERT_FALSE(warunek); | EXPECT_FALSE(warunek); | Warunek niespełniony (false) |

Pamiętaj, że w przypadku niepowodzenia ASSERT_* zwraca błąd krytyczny i wraca z bieżącej funkcji, podczas gdy EXPECT_* zwraca niepowodzenie niekrytyczne, pozwalając funkcji na dalsze działanie. W obu przypadkach niepowodzenie potwierdzenia oznacza niepowodzenie testu zawierającego.

#### Porównania binarne

Czyli porównywanie dwóch wartości:

| Asercje krytyczne | Asercje niekrytyczne | Podsumowanie |
| ----------------- |----------------------| -------------|
| ASSERT_EQ(val1,val2); | EXPECT_EQ(val1,val2); | val1 == val2 |
| ASSERT_NE(val1,val2); | EXPECT_NE(val1,val2); | val1 != val2 |
| ASSERT_LT(val1,val2); | EXPECT_LT(val1,val2); | val1 < val2 |
| ASSERT_LE(val1,val2); | EXPECT_LE(val1,val2); | val1 <= val2 |
| ASSERT_GT(val1,val2); | EXPECT_GT(val1,val2); | val1 > val2 |
| ASSERT_GE(val1,val2); | EXPECT_GE(val1,val2); | val1 >= val2 |

W przypadku błędu, GoogleTest wypisze zarówno val1 jak i val2. 

#### Porównywanie stringów

| Asercje krytyczne | Asercje niekrytyczne | Podsumowanie |
| ----------------- |----------------------| -------------|
| ASSERT_STREQ(str1,str2); | EXPECT_STREQ(str1,_str_2); | oba ciągi mają tę samą zawartość |
| ASSERT_STRNE(str1,str2); | EXPECT_STRNE(str1,str2); | ciągi mają różną zawartość |
| ASSERT_STRCASEEQ(str1,str2); | EXPECT_STRCASEEQ(str1,str2); | oba ciągi mają tę samą zawartość, ignoruje wielkość znaków |
| ASSERT_STRCASENE(str1,str2); | EXPECT_STRCASENE(str1,str2); | ciągi mają różną zawartość, ignoruje wielkość znaków |

## Pisanie testów

Podstawa do budowy testów:

```cpp
TEST(test_case_name, test_name) {
 ... test body ...
}
```


Przykładowa funkcja int

```cpp
int Factorial(int n); // Zwraca silnie z parametru n
```

Oraz jej test

```cpp
// Test silnia(0)
TEST(FactorialTest, HandlesZeroInput) {
  EXPECT_EQ(1, Factorial(0));
}

// Testowanie silni liczb dodatnich
TEST(FactorialTest, HandlesPositiveInput) {
  EXPECT_EQ(1, Factorial(1));
  EXPECT_EQ(2, Factorial(2));
  EXPECT_EQ(6, Factorial(3));
  EXPECT_EQ(40320, Factorial(8));
}
```


Inny przykłady testów można znaleźć [tutaj](https://github.com/Filip1512/PJ/tree/master/TAU-Java/Presentation/C++/examples).

