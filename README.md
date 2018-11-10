# BestCanteenMaker

## 1. Nazwa programu
*BestCanteenMaker* - nazwa programu oddaje główną funkcję jaką program ma wykonywać (tworzenie projektów stołówek).

## 2. Cel programu
Celem programu jest stworzenie i wyświetlenie użytkownikowi różnych konfiguracji stołówek bazując
na podanych wymaganiach. Program, po dostarczeniu odpowiednich danych w formie graficznej,
rozpocznie spersonalizowane pod użytkownika wyświetlanie kolejnych modeli stołówek – dążac do
znalezienia najlepszego możliwego rozmieszczenia obiektów na sali.

Cel programu jest zawsze ten sam (co zostało opisane w powyższym akapicie), natomiast sam wynik
może róznic sie znaczaco zależnie od ustalonego budżetu, standardu komfortu, wielkości sali czy też
innych, podanych przez osobę obsługujacą program, parametrów.

## 3. Opis funkcji
<ul>
<li>Umożliwienie użytkownikowi wprowadzenia do programu bardzo szczegółowych wymagań dotyczacych
parametrów stołówki i samego działania programu</li>
<li>Sprawdzanie poprawności wprowadzanych danych</li>
<li>Wyświetlanie użytkownikowi modeli z poszczególnych faz pracy programu. Szybkość oraz
automatyzacja wyświetlania będą zależne od użytkownika</li>
<li>Wyznaczenie najlepszego rozwiązania zgodnego z podanymi wymaganiami</li>
<li>Obsługa programu za pomocą przystepnego interfejsu graficznego</li>
<li>Możliwosc wywołania instrukcji obsługi programu opisujacej w sposób dokładny parametry
wejściowe oraz działanie programu</li>
</ul>

## 4. Obsługa programu
Program obsługiwany jest poprzez graficzny interfejs użytkownika (który został stworzony w bibliotece *Swing*).

### Menu główne

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/main_menu.png" width="50%"/>

W menu głównym użytkownik ma do wyboru 3 przyciski:
<ul>
<li>"Nowa stołówka" - rozpoczęcie procedury generowania stołówki </li>
<li>"Instrukcja" - wyświetlenie instrukcji obsługi programu </li>
<li>"Wyjście" - opuszczenie programu </li>
</ul>

### Instrukcja

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/instructions_panel.png" width="50%"/>

Panel ten zawiera instrukcję obsługi programu.

### Panel wprowadzania wymiarów stołówki

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/dimensions_input_panel_error.png" width="50%"/>

Panel ten zawiera 6 pól tekstowych, do których należy wprowadzić wymiar odpowiedniej ściany stołówki. Każde pole opisane jest odopwiednią 
etykietą, a rysunek znajdujący się ponad polami tekstowymi przedstawia które ściany w generowanej stołówce odpowiadają poniższym etykietom.
Podczas wprowadzania danych przeprowadzana ich jest ich walidacja. W razie podania niepoprawnych danych wyświetlany jest odpowiedni 
komunikat i uniemozliwione jest przejście do następnej części etapu generowania stołówki.

### Panel wprowadzania parametrów stołówki

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/parameters_input_panel_error.png" width="50%"/>

W panelu tym wprowadzamy parametry określające generowaną przez nas stołówkę. Panel ten również zawiera walidację wprowadzanych danych.

*Przy wprowadzeniu wartosci 0 w polu Iterations speed program bedzie działał w trybie manualnego
przewijania.*

### Wizualizacja z automatycznym przewijaniem

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/generator_auto.png" width="50%"/>

Wizualizacja rozpoczyna się po kliknięciu przycisku start i automatycznie przewija się z ustalonym w poprzenim oknie tempem.

### Wizualizacja z manualnym przewijaniem

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/generator_manual.png" width="50%"/>

Wizualizacja rozpoczyna się po kliknięciu przycisku start, ale żwby zobaczyć następny projekt należy kliknąć przycisk next. Aby
przewijanie odbywało się w sposób manualny, należy wprowadzić wartość 0 w polu Iterations w poprzednim etapie pracy programu.



//////////////////////////////////////////////////////////////////////////////////////////////////
Korzystanie z programu
Program mozemy uruchomic poprzez podwójne klikniecie w plik „BCM.jar”, albo za posrednictwem
wiersza polecen po wpisaniu komendy „javac -jar BCM.jar”. Po uruchomieniu programu w oknie
wyswietla sie menu główne. Aby utworzyc projekt szkolnej stołówki, nalezy wybrac w menu opcje
„New Canteen”. Nastepnie w oknie wyswietli sie panel w którym nalezy podac wymiary stołówki.
Po wprowadzeniu wymiarów klikamy przycisk „Next” i jezeli wszystkie wprowadzone dane były poprawne,
wyswietli sie kolejny panel w którym musimy wprowadzic parametry („Liczba osobników
w pokoleniu”, „Współczynnik krzyzowania”, „Współczynnik mutacji” sa parametrami opcjonalnymi,
przeznaczone sa dla uzytkowników zaawansowanych). Jezeli w polu „Iterations speed” wprowadzilimy
wartosc „0”, program bedzie działał w trybie manualnego przewijania, w przeciwnym razie
wyniki beda automatycznie przewijane w ustalonym przez nas odstepie czasu. Po wprowadzeniu
danych nalezy kliknac przycisk „Submit”, po czym zostanie wywietlony panel wywietlajacy wyniki
ukazujacy wygenerowane projekty stołówek.

Opis danych wejsciowych
Uzytkownik przed rozpoczeciem działania programu musi zdefiniowac parametry potrzebne do stworzenia
modeli stołówek. Wymagane parametry to:
• Wymiary stołówki;
• Ilosc miejsc na stołówce;
• Budzet;
• Liczba iteracji;
• Szybkosc wyswietlania poszczególnych iteracji lub wybór manualnego przełaczania (*);
• Liczba osobników w pokoleniu (*);
• Współczynnik krzyzowania (*);
• Współczynnik mutacji (*).
(*) – parametry opcjonalne.


## Użyte technologie

### Biblioteka graficzna Swing

Graficzna cześć projektu została zrealizowana przy pomocy biblioteki Swing. Jest ona najpopularniejszą
biblioteką graficzną Javy i umozliwia bardzo szybkie tworzenie graficznego interfejsu użytkownika.

Opis struktur i algorytmów
5.1 Algorytmy
Algorytmy genetyczne
Diagram algorytmu genetycznego
Przebieg pracy algorytmu:
1. Inicjacja – w tym miejscu algorytm tworzy pewna populacje poczatkowa. W programie BCM
w tym miejscu generowane sa współrzedne rozstawienia poszczególnych elementów stołówki.
Liczba osobników danej populacji ustawiana jest przez uzytkownika poprzez interfejs graficzny.
2. Ocena przystosowania – tutaj algorytm sprawdza czy osiagniety rezultat jest zgodny z
naszymi oczekiwaniami – w przypadku programu BCM sprawdzane jest, czy została osiagnieta
odpowiednia liczba miejsc, czy cena wykonania stołówki jest zgodna z zamierzeniami oraz jak
wysoki jest komfort rozstawienia miejsc z punktu widzenia uzytkownika. W punkcie tym
wyliczamy w jakim stopniu (w ilu procentach) otrzymany wynik – osobniki danego pokolenia
- jest zgodny z oczekiwanymi rezultatami.
3. Sprawdzenie warunku zatrzymania – w tym punkcie sprawdzane jest, czy algorytm moze
5
juz zakonczyc prace. Zakonczenie pracy algorytmu moze nastapic wówczas, gdy ocena przystosowania
osobników danej populacji wynosi okreslona na poczatku wartosc (np. 90%), albo
– tak jak w przypadku programu BCM – po okreslonej liczbie iteracji, która jest podawana
poprzez interfejs graficzny.
4. Selekcja – tutaj algorytm wybiera najlepsze osobniki danej populacji, aby nastepnie poddac je
operacji krzyzowania. Osobniki te stana sie rodzicami nastepnej populacji, której to przekaza
swoje geny – własnie dlatego jest to bardzo wazny element algorytmu. Najbardziej popularne
metody selekcji populacji rodzicielskiej to:
(a) metoda ruletki – budujemy wirtualne koło w którym kazdemu z osobników przyporzadkowany
jest wycinek proporcjonalny do stopnia dostosowania wyliczonego za pomoca funkcji
oceny, poniewaz lepiej dostosowane osobniki posiadaja wiekszy wycinek koła, wieksze jest
prawdopodobienstwo, ze to one zostana wylosowane,
(b) selekcja turniejowa – wybieramy w sposób losowy kilka osobników, sposród których wybieramy
jednego najlepiej dostosowanego; czynnosc powtarzamy, az do zbudowania całej
populacji,
(c) selekcja rankingowa – szeregujemy wszystkich osobników według ich stopnia przystosowania
wyliczonego na podstawie funkcji oceny,
5. Operacje genetyczne – w punkcie tym tworzone jest kolejne pokolenie. Na wybranych w
poprzednim podpunkcie rodzicach wykonujemy nastepujace operacje:
(a) krzyzowania – operacja ta polega na utworzeniu nowego kodu genetycznego na podstawie
kodu genetycznego dwóch rodziców. Mozna na przykład wybrac punkt przeciecia (zwykle
srodek) genów obydwu rodziców, a nastepnie połaczyc dwie powstałe połówki w dwa nowe
osobniki,
(b) mutacja – operacja ta polega na zmianie jednego z losowo wybranych chromosomów na
przeciwny. W programi BCM mutacja polega na zamianie losowo wybranego chromosomu
z chromosomem innego losowo wybranego osobnika danej populacji. Jej celem jest
wprowadzenie róznorodnosci w populacji. Czestotliwosc wystepowania mutacji nie powinna
byc jednak zbyt duza (ok. 0,05) , gdyz zbyt duzy współczynnik moze doprowadzic
do powstawania wielu negatywnych rozwiazan.
6. Utworzenie nowej populacji – w punkcie tym algorytm tworzy obiekty powstałe na podstawie
operacji genetycznych wykonanych w poprzednim punkcie.
7. Wybór najlepszych osobników – ta czesc algorytmu wykonywana jest gdy warunek zatrzymania
został spełniony. Wówczas sposród otrzymanych osobników wybierany jest ten o
najlepszym stopniu przystosowania. W programie BCM prezentowane sa wszystkie osobniki z
koncowej populacji.
5.2 Struktury
Matrix – dynamiczna struktura danych zrealizowana jako jednowymiarowa tablica imitujaca za
pomoca odpowiednich metod dwuwymiarowa macierz.
p r i v a t e i n t cn ;
p r i v a t e i n t rn ;
p r i v a t e double [ ] matrix = new double [ rn  cn ] ;
Macierz zrealizowana jest za pomoca tablicy typu double.


## Diagram modułów

4 Opis modułów
W tej sekcji zostana opisane poszczególne pakiety oraz zawarte w nich klasy i ich metody.
4.1 GUI
W tym pakiecie znajduja sie klasy odpowiedzialne za implementacje podstawowych elementów graficznego
interfejsu uzytkownika.
BCMFrame – klasa ta implementuje główne okno programu.
Menu – klasa ta odpowiedzialna jest za implementacje panelu wyswietlajacego menu główne programu.
DimensionsInputPanel – klasa zawierajaca implementacje panelu w którym uzytkownik ma
wprowadzac wymiary stołówki.
ParametersInputPanel – klasa implementujaca panel w którym uzytkownik wprowadza parametry
dotyczace generowanych projektów stołówek.
ManualScrollingPanel – w klasie tej znajduje sie implementacja panelu wyswietlajacego kolejne
projekty stołówek wraz z opisem. Wtym panelu kolejne projekty sa wyswietlane w sposób manualny.
AutomaticScrollingPanel - w klasie tej znajduje sie implementacja panelu wyswietlajacego kolejne
projekty stołówek wraz z opisem. W tym panelu kolejne projekty sa wyswietlane w sposób
automatyczny – to program ma za zadanie pokazywac kolejne projekty co ustalony odstep czasu.
4.2 Logic
W tym pakiecie znajduja sie klasy które maja za zadanie implementowac logike aplikacji – algorytm
genetyczny. Przez wydzielenie tego pakietu jako odrebnej całosci, oddzielamy czesc graficzna programu
od jego logiki. Dzieki takiemu podejsciu, w pózniejszym czasie bedzie bardzo łatwo mozna
utworzyc nowy interfejs graficzny i bez zmian w kodzie programu odpowiadajacym za algorytmy
podłaczyc go do logiki.
BCM – w klasie tej znajduja sie wywołania metod pozostałych klas danego pakietu, których
połaczenie umozliwia realizacje podstawowych załozen algorytmów genetycznych.
• void generateProjects() – metoda ta generuje współrzedne rozstawienia poszczególnych obiektów
w stołówce,
Individual – klasa ta reprezentuje pojedynczego osobnika danej populacji. Wykorzystuje ona macierz
(klasa „Matrix”) aby przechowywac współrzedne konkretnych obiektów na tworzonej „mapie”
stołówki, oraz współrzedne konkretnych obiektów przechowywane w listach których typy sa z kolei
tworzone na podstawie klas zawartych w pakiecie „canteencomponents”.
• void setTables() – metoda ta odpowiedzialna jest za ustawienie stołów w odpowiednich miejscach
na macierzy współrzednych stołówki,
• void setChairs() – metoda ta odpowiedzialna jest za ustawienie krzeseł w odpowiednich miejscach
na macierzy współrzednych stołówki,
2
• void setLighting(int x,int y) - metoda ta odpowiedzialna jest za ustawienie oswietlenia w odpowiednich
stołówki, tak aby poszczególne elementy oswietlenia były umieszczone w odległosci
„x” wzgledem tych lezacych w tym samym rzedzie oraz „y” wzgledem tych lezacych w tej samej
kolumnie, a natepnie dodaniu wyliczonych współrzednych do odpowiedniej listy współrzednych
elementów oswietlenia,
• void setWindows(int l) - metoda ta odpowiedzialna jest za ustawienie okien w odpowiednich
miejscach stołówki, tak aby poszczególne okna były od siebie oddalone minimum o długosc „l”,
a natepnie dodaniu wyliczonych współrzednych do odpowiedniej listy współrzednych okien,
• void setDoor() - metoda ta odpowiedzialna jest za ustawienie drzwi w odpowiednich miejscach
stołówki i zapisaniu ich w utworzonym obiekcie klasy „Door”,
• void setEscapeRoute() – metoda ta słuzy do wyznaczenia współrzednych drogi ewakuacyjnej
na macierzy współrzednych stołówki,
Population – klasa ta ma za zadanie utworzyc okreslona liczbe osobników – obiektów klasy Individual.
Liczba osobników danej populacji do utworzenia podana jest przez uzytkownika poprzez
graficzny interfejs.
• void createPopulation(int n) – metoda ta ma za zadanie utworzenie populacji liczacej „n”
osobników, a nastepnie zapisaniu jej w odpowiedniej liscie osobników,
FitnessCounter – klasa ta przechowuje metody odpowiedzialne za liczenie współczynnika dostosowania
osobników danej populacji do poczatkowych załozen.
• int getFitness(Individual individual) – metoda ta zwraca wartosc współczynnika dostosowania
danego osobnika; wartosc ta liczona jest na podstawie współczynnika komfortu, ceny oraz
liczby miejsc,
• int calculateComfort(Individual individual) – metoda liczy dla danego osobnika wartosc całkowitego
współczynnika komfortu danej stołówki
• int calculateSeatingComfort() – liczy komfort pojedynczego miejsca siedzacego,
• int calculateTotalCost(Individual individual) – metoda ta liczy całkowity koszt wykorzystanych
komponentów w projekcie danej stołówki,
• int calculateNumberOfSeats(Individual individual) – zwraca liczbe miejsc siedzacych w projekcie
danej stołówki
GeneticAlgorithm – klasa ta przechowuje metody potrzebne do realizacji algorytmu genetycznego,
miedzy metody innymi odpowiedzialne za wybór odpowiednich rodziców nowej populacji.
• Individual crossover(Individual i1, Individual i2) – metoda ta implementuje krzyzowanie dwóch
wybranych osobników danej populacji,
• void mutate(Individual i) – metoda ta realizuje operacje mutacji losowo wybranego genu danej
populacji
• Individual rouletteSelection() – metoda ta realizuje selekcje populacji rodzicielskiej metoda
ruletkowa
• Individual tournamentSelection()– metoda ta realizuje selekcje populacji rodzicielskiej metoda
turniejowa
• Individual rankingSelection()– metoda ta realizuje selekcje populacji rodzicielskiej metoda rankingowa
3
4.3 Dynamicstructures
W pakiecie tym znajduja sie klasy odpowiedzialne za implementacje dynamicznych struktur danych,
uzywanych przez program do przeprowadzania obliczen oraz przechowywania danych.
Matrix - klasa ta przechowuje implementacje macierzy jako dynamicznej struktury danych.
• public void put(double obj, int column, int row) - metoda ta słuzy do umieszczania obiektu
obj w macierzy do komórki o współrzednych column, row (usuwa stare dane i wpisuje nowe),
• public void add(double obj, int column, int row) – metoda ta słuzy do dodawania obiektu obj
do komórki macierzy o współrzednych column, row (dodaje nowe dane do starych),
• public double get(int column, int row) – metoda ta słuzy do pobierania obiektu z macierzy z
komórki o współrzednych column, row,
• public int getColumnNumber() - metoda ta zwraca liczbe kolumn w macierzy,
• public int getRowNumber() - metoda ta zwraca liczbe rzedów w macierzy
4.4 IOcommunication
Wtym pakiecie znajduja sie klasy majace za zadanie komunikacje programu z plikami zewnetrznymi.
Writer - klasa ta posiada metody pozwalajace na zapis otrzymanych rezultatów do pliku.
• public void writeToFile(String filename) – metoda ta wypisuje otrzymane dane do pliku wyjsciowego
4.5 Canteencomponents
Pakiet ten zawiera klasy które reprezentuja poszczególne obiekty stołówki.
CanteenComponents – klasa po której dziedzicza pozostałe klasy z danego pakietu, reprezentujace
poszczególne obiekty stołówki.
Chair – klasa reprezentujaca krzesło, zawiera współrzedne, typ, koszt, jego wymiary oraz odpowiednie
metody dostepowe,
Table – klasa reprezentujaca stół, zawiera współrzedne, typ, koszt, jego wymiary oraz odpowiednie
metody dostepowe,
Lamp - klasa reprezentujaca pojedynczy element oswietlenia, zawiera współrzedne, koszt oraz
odpowiednie metody dostepowe,
Door – klasa reprezentujaca drzwi, zawierajaca współrzedne, wymiary, koszt oraz odpowiednie
metody dostepowe,
Shop - klasa reprezentujaca sklep, zawierajaca współrzedne, wymiary, koszt oraz odpowiednie
metody dostepowe,
Window - klasa reprezentujaca pojedyncze okno, zawierajaca współrzedne, typ, koszt oraz odpowiednie
metody dostepowe,




## Fragmenty kodu programu oraz ciekawe rozwiązania

### 1. Oddzielenie czesci odpowiadajacej za logike od czesci odpowiadajacej za grafike

Dzieki takiemu podejsciu bardzo łatwo mozna podłaczyc graficzny interfejs uzytkownika lub zastapic
go innym. Do wygenerowania projektu potrzebne sa jedynie metody zawarte w głównej
klasie logiki - „BCM”. Za pomoca metody „generateProjects()” generujemy obiekty na podstawie
danych podanych przez interfejs graficzny i umieszczonych w niej za pomoca statycznych
metod dostepowych, a nastepnie rezultat - wygenerowane współrzedne obiektów stołówek, bedacych
najlepszymi osobnikami poszczególnych populacji - pobieramy za pomoca odpowiedniej
metody dostepowej z listy „bestIndividualInEachIterationPopulation” zawartej w klasie BCM.

### 2. Metoda odpowiedzialna za selekcje ruletkowa osobników podczas ich ewolucji
Metoda ta słuzy do wyboru osobników populacji rodzicielskiej, która bedzie brała dalszy udział
w ewolucji. Czesc ta jest bardzo wazna, gdyz to od niej w głównej mierze bedzie zalezec czy
ewolucja osobników bedzie przebiegała prawidłowo. Ciekawym rozwiazaniem jest wykorzystanie
w tej metodzie petli w której generujemy losowa liczbe i szukamy takiego osobnika który
miesci sie w danym przedziale, przechowywanym w tablicy rankingTab - im wiecej punktów
komfortu posiada osobnik, tym wiekszy przedział zajmuje i tym wieksze jest prawdopodobienstwo,
ze zostanie on wylosowany.

f o r ( i n t j = 0 ; j < popul a t i onSi z e ; j++) {
randomNumber = r . next Int ( 1 0 0 ) ;
f o r ( i n t i = 0 ; i < rankingTab . l eng th ; i++) {
i f ( randomNumber <= rankingTab [ i ] ) {
numberIndividual = i ;
break ;
}
}
parentPopulationIndividualsNumber [ j ] = numberIndividual ;
}


## GUI

Interfejs uzytkownika został zaprojektowany z mysla o przejrzystosci oraz łatwosci obsługi. Graficzna
oprawa programu jest mozliwie maksymalnie dostosowana do uzytkownika oraz zapewnia komfort
oraz prostote uzytkowania przy równoczesnym rozwiazywaniu skomplikowanego problemu w sposób
zadowalajacy.

Zastosowane rozwiazania:
• stworzenie przewijanej, podzielonej na działy instrukcji opisujacej w sposób dokładny program
oraz podpowiadajacej jak z niego korzystac;
• zastosowanie panelu podswietlajacego dana sciane przy wprowadzaniu jej długosci;
• nieinwazyjny system komunikowania o błedach. Uzytkownik zawsze dostaje jasna podpowiedz
o istniejacym problemie bez spowolnienia pracy czy utraty postepów;
• pasek ładowania jako najlepsze oraz najprostsze przyblizenie uzytkownikowi skomplikowanie
ocenianych parametrów utworzonej stołówki;
• dwa tryby pracy panelu wizualizujacego: manualny i automatyczny;
• zastosowanie minimalistycznej i prostej w odczytaniu konwencji pokazywania konkretnych elementów
stołówki.

Komunikaty błedów
7.1 Nieprawidłowe wymiary stołówki
NIEPOPRAWNE DANE WEJSCIOWE : Nie podano wszystkich wymiarów
W razie wystapienia takiego komunikatu nalezy upewnic sie, czy podalismy wszystkie wymagane
wymiary. Jezeli którys z wymiarów został przez nas pominiety, nalezy go uzupełnic.
NIEPOPRAWNE DANE WEJSCIOWE : Nieprawidłowy format wprowadzonych wymiarów
W razie wystapienia takiego komunikatu nalezy upewnic sie, czy podane przez nas wymiary sa w
odpowiednim formacie - czy sa cyframi. Jezeli przez przypadek wpisalismy inna wartosc, nalezy ja
usunac i podac prawidłowa.
NIEPOPRAWNE DANE WEJSCIOWE : Jeden z podanych wymiarów jest ujemny
W razie wystapienia takiego komunikatu nalezy upewnic sie, czy wszystkie podane przez nas wymiary
sa wieksze od zera. Jezeli podalismy wartoc ujemna, nalezy na jej miejsce podac wartosc
dodatnia.
7.2 Nieprawidłowe parametry
NIEPOPRAWNE DANE WEJSCIOWE : Nie podano wszystkich parametrów
W razie wystapienia takiego komunikatu nalezy upewnic sie, czy podalismy wszystkie wymagane
parametry - nie wliczajac parametrów opcjonalnych. Jezeli pominelismy niektóre parametry, nalezy
je uzupełnic.
NIEPOPRAWNE DANE WEJSCIOWE : Nieprawidłowy format wprowadzonych parametrów
W razie pojawienia sie takiego komunikatu nalezy sprawdzic, czy wszystkie podane przez nas
parametry sa liczbami. Jezeli przez przypadek wpisalismy inna wartosc, nalezy ja usunac i podac
prawidłowa.
NIEPOPRAWNE DANE WEJSCIOWE : Jeden z podanych parametrów jest ujemny
W razie wystapienia takiego komunikatu nalezy upewnic sie, czy wszystkie podane przez nas parametry
sa wieksze od zera. Jezeli jeden z podanych przez nas parametrów ma wartosc ujemna
7
nalezy go zastapic wartoscia dodatnia.
7.3 Błedy zwiazane z obsługa pliku wyjsciowego
PRÓBA UTWORZENIA PLIKU ZAKONCZONA NIEPOWODZENIEM
Pojawienie sie takiego komunikatu oznacza, ze próba zapisu danych do pliku wyjsciowego jest
niemozliwa. Wpływ na to moze miec wiele czynników, np. brak miejsca na dysku, albo brak
odpowiednich praw dostepu.
*jezeli program nie moze sie uruchomic nalezy upewnic sie czy mamy zainstalowany na naszym
urzadzeniu JRE - srodowisko uruchomieniowe dla programów napisanych w jezyku Java, zawierajace
wirtualna maszyne Javy
Rysunek

## Podsumowanie

Program w poprawny sposób spełnia poczatkowe załozenia. Współrzedne obiektów wygenerowane
z wykorzystaniem algorytmów genetycznych sa liczone bez błedów, a ich pózniejsza wizualizacja
odbywa sie prawidłowo. W trakcie pracy skupilismy sie na maksymalnym zrozumieniu potrzeb
uzytkownika, a takze na tym, aby program, mimo swojej scisłej dziedziny, mógł byc uzywany przez
wszystkich. Prostota, łatwosc nauki korzystania oraz szybkosc działania to główne zalety naszego
programu.
