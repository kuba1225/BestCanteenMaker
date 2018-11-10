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

### 4.1 Menu główne

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/main_menu.png" width="50%"/>

W menu głównym użytkownik ma do wyboru 3 przyciski:
<ul>
<li>"Nowa stołówka" - rozpoczęcie procedury generowania stołówki </li>
<li>"Instrukcja" - wyświetlenie instrukcji obsługi programu </li>
<li>"Wyjście" - opuszczenie programu </li>
</ul>

### 4.2 Instrukcja

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/instructions_panel.png" width="50%"/>

Panel ten zawiera instrukcję obsługi programu.

### 4.3 Panel wprowadzania wymiarów stołówki

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/dimensions_input_panel_error.png" width="50%"/>

Panel ten zawiera 6 pól tekstowych, do których należy wprowadzić wymiar odpowiedniej ściany stołówki. Każde pole opisane jest odopwiednią 
etykietą, a rysunek znajdujący się ponad polami tekstowymi przedstawia które ściany w generowanej stołówce odpowiadają poniższym etykietom.
Podczas wprowadzania danych przeprowadzana ich jest ich walidacja. W razie podania niepoprawnych danych wyświetlany jest odpowiedni 
komunikat i uniemozliwione jest przejście do następnej części etapu generowania stołówki.

### 4.4 Panel wprowadzania parametrów stołówki

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/parameters_input_panel_error.png" width="50%"/>

W panelu tym wprowadzamy parametry określające generowaną przez nas stołówkę. Panel ten również zawiera walidację wprowadzanych danych.

*Przy wprowadzeniu wartosci 0 w polu Iterations speed program bedzie działał w trybie manualnego
przewijania.*

### 4.5 Wizualizacja z automatycznym przewijaniem

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/generator_auto.png" width="50%"/>

Wizualizacja rozpoczyna się po kliknięciu przycisku start i automatycznie przewija się z ustalonym w poprzenim oknie tempem.

### 4.6 Wizualizacja z manualnym przewijaniem

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/generator_manual.png" width="50%"/>

Wizualizacja rozpoczyna się po kliknięciu przycisku start, ale żwby zobaczyć następny projekt należy kliknąć przycisk next. Aby
przewijanie odbywało się w sposób manualny, należy wprowadzić wartość 0 w polu Iterations w poprzednim etapie pracy programu.

## 5. Korzystanie z programu

Program możemy uruchomić poprzez podwójne kliknięcie w plik <b>BCM.jar</b>, albo za pośrednictwem
wiersza poleceń po wpisaniu komendy <b>javac -jar BCM.jar</b>. Po uruchomieniu programu w oknie
wyświetla sie menu główne. Aby utworzyć projekt szkolnej stołówki, należy wybrać w menu opcję
*Nowa stołówka*. Następnie w oknie wyświetli sie panel w którym należy podać wymiary stołówki.
Po wprowadzeniu wymiarów klikamy przycisk *Next* i jeżeli wszystkie wprowadzone dane były poprawne,
wyświetli się kolejny panel w którym musimy wprowadzić parametry. Jeżeli w polu *Iterations speed*
wprowadziliśmy wartość *0*, program bedzie działał w trybie manualnego przewijania, w przeciwnym razie
wyniki będą automatycznie przewijane w ustalonym przez nas odstepie czasu. Po wprowadzeniu
danych należy kliknąć przycisk *Submit*, po czym zostanie wyżwietlony panel wyświetlajacy wyniki
ukazujący wygenerowane projekty stołówek.

## 6. Opis danych wejściowych
Użytkownik przed rozpoczęciem działania programu musi zdefiniować parametry potrzebne do stworzenia
modeli stołówek. Wymagane parametry to:
<ul>
<li>Wymiary stołówki;</li>
<li>Ilość miejsc na stołówce;</li>
<li>Budżet;</li>
<li>Liczba iteracji;</li>
<li>Szybkość wyświetlania poszczególnych iteracji lub wybór manualnego przełączania (*);</li>
<li>Liczba osobników w pokoleniu (*);</li>
<li>Współczynnik krzyżowania (*);</li>
<li>Współczynnik mutacji (*).</li>
</ul>
  
(*) – parametry opcjonalne.


## 7. Użyte technologie

### 7.1 Biblioteka graficzna Swing

Graficzna cześć projektu została zrealizowana przy pomocy biblioteki Swing. Jest ona najpopularniejszą
biblioteką graficzną Javy i umozliwia bardzo szybkie tworzenie graficznego interfejsu użytkownika.

## 8 Opis struktur i algorytmów
### 8.1 Algorytmy
#### Algorytmy genetyczne

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/GeneticAlgorithmDiagram.png" width="50%"/>
##### Diagram algorytmu genetycznego


##### Przebieg pracy algorytmu:
<ol>
<li> <b>Inicjacja</b> – w tym miejscu algorytm tworzy pewna populacje poczatkowa. W programie BCM
w tym miejscu generowane sa współrzedne rozstawienia poszczególnych elementów stołówki.
Liczba osobników danej populacji ustawiana jest przez uzytkownika poprzez interfejs graficzny.</li> 
<li> <b>Ocena przystosowania</b> – tutaj algorytm sprawdza czy osiagniety rezultat jest zgodny z
naszymi oczekiwaniami – w przypadku programu BCM sprawdzane jest, czy została osiagnieta
odpowiednia liczba miejsc, czy cena wykonania stołówki jest zgodna z zamierzeniami oraz jak
wysoki jest komfort rozstawienia miejsc z punktu widzenia uzytkownika. W punkcie tym
wyliczamy w jakim stopniu (w ilu procentach) otrzymany wynik – osobniki danego pokolenia
- jest zgodny z oczekiwanymi rezultatami.</li> 
<li> <b>Sprawdzenie warunku zatrzymania</b> – w tym punkcie sprawdzane jest, czy algorytm moze
juz zakonczyc prace. Zakonczenie pracy algorytmu moze nastapic wówczas, gdy ocena przystosowania
osobników danej populacji wynosi okreslona na poczatku wartosc (np. 90%), albo
– tak jak w przypadku programu BCM – po okreslonej liczbie iteracji, która jest podawana
poprzez interfejs graficzny.</li> 
<li> <b>Selekcja</b> – tutaj algorytm wybiera najlepsze osobniki danej populacji, aby nastepnie poddac je
operacji krzyzowania. Osobniki te stana sie rodzicami nastepnej populacji, której to przekaza
swoje geny – własnie dlatego jest to bardzo wazny element algorytmu. Najbardziej popularne
metody selekcji populacji rodzicielskiej to:
<ol>
<li> <b>metoda ruletki</b> – budujemy wirtualne koło w którym kazdemu z osobników przyporzadkowany
jest wycinek proporcjonalny do stopnia dostosowania wyliczonego za pomoca funkcji
oceny, poniewaz lepiej dostosowane osobniki posiadaja wiekszy wycinek koła, wieksze jest
prawdopodobienstwo, ze to one zostana wylosowane,</li> 
<li> <b>selekcja turniejowa</b> – wybieramy w sposób losowy kilka osobników, sposród których wybieramy
jednego najlepiej dostosowanego; czynnosc powtarzamy, az do zbudowania całej
populacji,</li> 
<li> <b>selekcja rankingowa</b> – szeregujemy wszystkich osobników według ich stopnia przystosowania
wyliczonego na podstawie funkcji oceny,</li> 
</ol>
</li>
<li> <b>Operacje genetyczne</b> – w punkcie tym tworzone jest kolejne pokolenie. Na wybranych w
poprzednim podpunkcie rodzicach wykonujemy nastepujace operacje: 
<ol>
<li> <b>krzyzowania</b> – operacja ta polega na utworzeniu nowego kodu genetycznego na podstawie
kodu genetycznego dwóch rodziców. Mozna na przykład wybrac punkt przeciecia (zwykle
srodek) genów obydwu rodziców, a nastepnie połaczyc dwie powstałe połówki w dwa nowe
osobniki,</li> 
<li> <b>mutacja</b> – operacja ta polega na zmianie jednego z losowo wybranych chromosomów na
przeciwny. W programi BCM mutacja polega na zamianie losowo wybranego chromosomu
z chromosomem innego losowo wybranego osobnika danej populacji. Jej celem jest
wprowadzenie róznorodnosci w populacji. Czestotliwosc wystepowania mutacji nie powinna
byc jednak zbyt duza (ok. 0,05) , gdyz zbyt duzy współczynnik moze doprowadzic
do powstawania wielu negatywnych rozwiazan.</li> 
</ol>
</li>
<li> <b>Utworzenie nowej populacji</b> – w punkcie tym algorytm tworzy obiekty powstałe na podstawie
operacji genetycznych wykonanych w poprzednim punkcie.</li> 
<li> <b>Wybór najlepszych osobników</b> – ta czesc algorytmu wykonywana jest gdy warunek zatrzymania
został spełniony. Wówczas sposród otrzymanych osobników wybierany jest ten o
najlepszym stopniu przystosowania. W programie BCM prezentowane sa wszystkie osobniki z
koncowej populacji.</li> 
</ol>

### 8.2 Struktury
<b>Matrix</b> – dynamiczna struktura danych zrealizowana jako jednowymiarowa tablica imitujaca za
pomoca odpowiednich metod dwuwymiarowa macierz. Macierz zrealizowana jest za pomoca tablicy typu double.

<b>Coordinates</b> – obiekty tej klasy przechowują współrzędne punktów w przestrzeni dwuwymiarowej.

## 9. Moduły

### 9.1 Diagram modułów

<img src="https://github.com/kubabar1/readme_images_repository/blob/master/best_canteen_maker/modules_diagram.png" width="75%"/>

### 9.2 Opis modułów
W tej sekcji zostana opisane poszczególne pakiety oraz zawarte w nich klasy i ich metody.


#### 9.2.1 GUI
W tym pakiecie znajduja sie klasy odpowiedzialne za implementacje podstawowych elementów graficznego
interfejsu uzytkownika.
<ul>
<li><b>BCMFrame</b> – klasa ta implementuje główne okno programu.</li>
<li><b>Menu</b> – klasa ta odpowiedzialna jest za implementacje panelu wyswietlajacego menu główne programu.</li>
<li><b>DimensionsInputPanel</b> – klasa zawierajaca implementacje panelu w którym uzytkownik ma
wprowadzac wymiary stołówki.</li>
<li><b>ParametersInputPanel</b> – klasa implementujaca panel w którym uzytkownik wprowadza parametry
dotyczace generowanych projektów stołówek.</li>
<li><b>Visualizer</b> – w klasie tej znajduje sie implementacja panelu wyswietlajacego kolejne
projekty stołówek wraz z opisem.</li>
</ul>

#### 9.2.2 Logic
W tym pakiecie znajduja sie klasy które maja za zadanie implementowac logike aplikacji – algorytm
genetyczny. Przez wydzielenie tego pakietu jako odrebnej całosci, oddzielamy czesc graficzna programu
od jego logiki. Dzieki takiemu podejsciu, w pózniejszym czasie bedzie bardzo łatwo mozna
utworzyc nowy interfejs graficzny i bez zmian w kodzie programu odpowiadajacym za algorytmy
podłaczyc go do logiki.

<ul>
<li><b>BCM</b> – w klasie tej znajduja sie wywołania metod pozostałych klas danego pakietu, których
połaczenie umozliwia realizacje podstawowych załozen algorytmów genetycznych.</li>

<li><b>Individual</b> – klasa ta reprezentuje pojedynczego osobnika danej populacji. Wykorzystuje ona macierz
(klasa „Matrix”) aby przechowywac współrzedne konkretnych obiektów na tworzonej „mapie”
stołówki, oraz współrzedne konkretnych obiektów przechowywane w listach których typy sa z kolei
tworzone na podstawie klas zawartych w pakiecie „canteencomponents”.</li>

<li><b>Population</b> – klasa ta ma za zadanie utworzyc okreslona liczbe osobników – obiektów klasy Individual.
Liczba osobników danej populacji do utworzenia podana jest przez uzytkownika poprzez
graficzny interfejs.</li>

<li><b>FitnessCounter</b> – klasa ta przechowuje metody odpowiedzialne za liczenie współczynnika dostosowania
osobników danej populacji do poczatkowych załozen.</li>

<li><b>GeneticAlgorithm</b> – klasa ta przechowuje metody potrzebne do realizacji algorytmu genetycznego,
miedzy metody innymi odpowiedzialne za wybór odpowiednich rodziców nowej populacji.</li>
</ul>

#### 9.2.3  Dynamicstructures
W pakiecie tym znajduja sie klasy odpowiedzialne za implementacje dynamicznych struktur danych,
uzywanych przez program do przeprowadzania obliczen oraz przechowywania danych.

<ul>
  <li><b>Matrix</b> - klasa ta przechowuje implementacje macierzy jako dynamicznej struktury danych.</li>
  <li><b>Coordinates</b> - obiekty tej klasy przechowują współrzędne punktów w przestrzeni dwuwymiarowej.</li>
</ul> 
 
#### 9.2.4  Canteencomponents
Pakiet ten zawiera klasy które reprezentuja poszczególne obiekty stołówki.

<ul>
<li><b>CanteenComponents</b> – klasa po której dziedzicza pozostałe klasy z danego pakietu, reprezentujace
poszczególne obiekty stołówki.</li>
<li><b>Chair</b> – klasa reprezentujaca krzesło, zawiera współrzedne, typ, koszt, jego wymiary oraz odpowiednie
metody dostepowe,</li>
<li><b>Table</b> – klasa reprezentujaca stół, zawiera współrzedne, typ, koszt, jego wymiary oraz odpowiednie
metody dostepowe,</li>
<li><b>Lamp</b> - klasa reprezentujaca pojedynczy element oswietlenia, zawiera współrzedne, koszt oraz
odpowiednie metody dostepowe,</li>
<li><b>Door</b> – klasa reprezentujaca drzwi, zawierajaca współrzedne, wymiary, koszt oraz odpowiednie
metody dostepowe,</li>
<li><b>Shop</b> - klasa reprezentujaca sklep, zawierajaca współrzedne, wymiary, koszt oraz odpowiednie
metody dostepowe,</li>
<li><b>Window</b> - klasa reprezentujaca pojedyncze okno, zawierajaca współrzedne, typ, koszt oraz odpowiednie
metody dostepowe,</li>
</ul>



## 10. Fragmenty kodu programu oraz ciekawe rozwiązania

### 10.1 Oddzielenie czesci odpowiadajacej za logike od czesci odpowiadajacej za grafike
Dzieki takiemu podejsciu bardzo łatwo mozna podłaczyc graficzny interfejs uzytkownika lub zastapic
go innym. Do wygenerowania projektu potrzebne sa jedynie metody zawarte w głównej
klasie logiki - „BCM”. Za pomoca metody „generateProjects()” generujemy obiekty na podstawie
danych podanych przez interfejs graficzny i umieszczonych w niej za pomoca statycznych
metod dostepowych, a nastepnie rezultat - wygenerowane współrzedne obiektów stołówek, bedacych
najlepszymi osobnikami poszczególnych populacji - pobieramy za pomoca odpowiedniej
metody dostepowej z listy „bestIndividualInEachIterationPopulation” zawartej w klasie BCM.

### 10.2 Metoda odpowiedzialna za selekcje ruletkowa osobników podczas ich ewolucji
Metoda ta słuzy do wyboru osobników populacji rodzicielskiej, która bedzie brała dalszy udział
w ewolucji. Czesc ta jest bardzo wazna, gdyz to od niej w głównej mierze bedzie zalezec czy
ewolucja osobników bedzie przebiegała prawidłowo. Ciekawym rozwiazaniem jest wykorzystanie
w tej metodzie petli w której generujemy losowa liczbe i szukamy takiego osobnika który
miesci sie w danym przedziale, przechowywanym w tablicy rankingTab - im wiecej punktów
komfortu posiada osobnik, tym wiekszy przedział zajmuje i tym wieksze jest prawdopodobienstwo,
ze zostanie on wylosowany.

```
for(int j=0 ; j<populationSize ; j++){
  randomNumber = r . next Int ( 1 0 0 ) ;
  for(int i=0 ; i<rankingTab.length ; i++){
    if(randomNumber <= rankingTab[i]){
      numberIndividual = i;
      break;
    }
  }
  parentPopulationIndividualsNumber [j] = numberIndividual;
}
```



## 11. Podsumowanie
Program w poprawny sposób spełnia poczatkowe załozenia. Współrzedne obiektów wygenerowane
z wykorzystaniem algorytmów genetycznych sa liczone bez błedów, a ich pózniejsza wizualizacja
odbywa sie prawidłowo. W trakcie pracy skupilismy sie na maksymalnym zrozumieniu potrzeb
uzytkownika, a takze na tym, aby program, mimo swojej scisłej dziedziny, mógł byc uzywany przez
wszystkich. Prostota, łatwosc nauki korzystania oraz szybkosc działania to główne zalety naszego
programu.
