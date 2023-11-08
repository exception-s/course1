# Лабораторная работа №2
----

## Классы
**Класс** - программное описание типа данных, который описывает некоторую сущность поставленной задачи.

**Свойство класса** - поле данных класса(переменная, массив и т.д.), которое содержит значение некоторого параметра сущности.

**Метод класса** - функция, которая описывает то, как сущность выполняет некоторые действия.

**Объект** - конкретный пример класса, который имеет свои собственные конкретные значения свойств. (ссылка на класс)

Оператор new:
* Выделяет память под объект
* Создаёт объект(вызывает конструктор)
* Возвращает ссылку на созданный объект

**Конструктор** - специальный метод для инициализации объекта во время его создания с помощью оператора new.
Каждый класс в java имеет конструктор по умолчанию без параметров, который доступен, если не описано никаких других конструкторов.


**package** - папка/метод группировки классов
Через import можно сделать классы из какой-либо package доступными в своей программе.

## Инкапсуляция
----
Это скрытие свойств и внутренних методов в классе и предоставление доступа к ним через публичные (доступные другим классам) методы.

*Модификаторы доступа:*
* public - доступно всем
* private - доступно только внутри класса
* protected - доступно только внутри пакета класса и наследникам
* default - доступно только в пакете класса
* _getter и setter_  - методы, которые, соответственно, возвращают и меняют значение какого-либо поля в классе.

## Наследование
----
_Наследование_ нужно, когда у некоторого множества классов есть много общих атрибутов, общего поведения.
Мы ищем одинаковые атрибуты, методы и образуем класс-предок, от которого будет наследоваться множество наследников, использующих что-либо от предка.

Используя ключевое слово super, можно вызвать конструктор родительского класса. Уникальные характеристики наследующего класса указываем в самом наследнике (инициализация доп. полей, которых уже нет в предке).


## Полиморфизм
----
Это возможность использовать объекты с одинаковым протоколом взаимодействия без информации о типе и внутренней структуре объекта.

* Переопределение методов
* Перегрузка методов
* Коварианты возвращаемых типов
* Абстрактные классы

Использование методов дочерних классов объектами родительского класса.
Переопределение методов: **(@Override)**
* Все методы в Java могут быть перегружены (кроме методов final).
* Перегруженный в дочернем классе метод будет вызван для объекта данного класса вместо метода родительского класса.
* Если метод не был перегружен, вызовется реализация метода в родительском классе.

Одинаковые по названию, но разные по параметрам методы в одном и том же классе - перегрузка **(@Overload)** .

## Вопрос от Письмака с лекции

_Зачем в java конструкторы с модификатором доступа private?_
1) Не нужна работа с объектами класса, используются только его static методы.
2) Классы вне метода создавать нельзя: гарантия, например, существования ровно одного объекта соответствующего класса.

## Области видимости переменных
----
Переменные доступны в том блоке кода, в котором они объявлены. Например, если переменная объявлена в начале какого-либо метода, она будет доступна внутри всего тела метода. Если переменная объявлена внутри if, к примеру, она будет доступна лишь внутри блока if. То же работает с циклами, яркий пример - переменная i, которая обычно используется внутри цикла for.
* Область видимости аргументов метода — тело метода.

### Внутри класса область видимости зависит от типа переменной:

* Статические переменные принадлежат самому классу. Они доступны без создания объекта, область их видимости содержит все методы класса — как статические, так и нет.
* Нестатические переменные класса принадлежат экземпляру класса (объекта). В их область видимости попадают нестатические методы класса.

## Ключевое слово this

Чтобы использовать переменную класса, необходимо на неё явно указать с помощью ключевого слова this.

## Модификаторы final и static
---
**final** — это модификатор, позволяющий объявлять константные поля в классе. Если у вас есть некоторое свойство проектируемого вами объекта, значение которого не будет меняться, то вы можете воспользоваться этим модификатором. Любая попытка переопределить значение поля с модификатором final приводит к выбросу исключения.

**static** - поле(единое для всех объектов): существует на уровне класса, а не объекта; Для каждого класса создается только один экземпляр статической переменной (переменой класса).




 **EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT EXPLICIT**
-----
_Подключение внешнего jar-файла к себе в программу сразу на гелиосе._
1) Напишите работающую программу у себя в IDE/иным любым способом.
2) Скиньте любым способом файлы программы на гелиос (покемоны .java, атаки .java, файл main (основной код)) (конечно же, лучше создать репозиторий на гитхабе
и склонировать его на гелиос - максимально просто)
3) Скиньте на гелиос сам внешний jar-файл, разберитесь и сформируйте файл MANIFEST.MF (приложу явный пример к README, первая строчка мастхев, 
вторая - про Class-Path, позже об этом, третья - класс, в котором содержится метод main - запуск всего кода, а так же обязательно перенос строки в конце)
4) Всё скинули? Прекрасно, можно работать дальше. Когда мы сформировали на гелиосе директорию с нашими файлами (не умаляя общности, назовём её lab2, это неважно)
мы должны скомпилировать наши файлы: с атаками покемонов легче, назовём директорию с атаками attacks, тогда команда

```java

javac -cp Pokemon.jar: attacks/*

```

скомпилирует все .java файлы в папке attacks.
-cp - флаг classpath, после которого идут файлы/директории, _откуда_ компилятор берёт информацию для файлов из attacks.

Pokemon.jar лежит внутри директории lab2(наравне с main и папками attacks, pokemons)
Далее папка с покемонами: 

```java

javac -cp Pokemon.jar: pokemons/name.java

```

Где name.java заменяется на имена нужных вам покемонов(поочерёдно!) сначала условно name_1, потом name_2, и так далее до name_k (до k-ого покемона).
Скомпилировали папки атак и покемонов.
Далее компилируем основной файл с main:

```java

javac -cp Pokemon.jar: main.java

```

Здесь, очевидно, main.java - файл с основным кодом(у вас он может называться по-другому, это неважно, просто смените в команде имя).

Прекрасно! Осталось всего ничего.
Нужно сформировать jar со всем нужным:

```java

jar -cfm <название>.jar MANIFEST.MF *

```

Вместо <название> вставляете всё, что душе угодно. * означает, что мы берём в jar все файлы в текущей директории(просто папки с атаками и покемонами, основной код и файл Pokemon.jar)
Всё! Осталось запустить наш файл:

```java

java -jar <название>.jar

```

Готово, можно наслаждаться результатом.








# Лабораторная работа №3
----

## Принципы SOLID и STUPID

### Принципы SOLID:

* **Принцип единственной обязанности**: это значит, что Ваши классы должны быть логически разделены и не содержать разнородной логики.
* **Принцип открытости/закрытости**: принцип закрытости данных классов для модификации и открытости для расширения. 
* **Принцип подстановки Барбары Лисков**: гласит, что при наследовании мы не должны менять поведение переопределяемых методов, чтобы использовать однотипно объекты всех дочерних классов, где ожидается родительский тип. Сложно написано, сори :(
* **Принцип разделения интерфейса**: не стоит придумывать интерфейсы, в которых сразу определены методы для всего. Разделяйте интерфейсы по логике их использования.
* **Принцип инверсии зависимостей**: заключается в том, чтобы абстракции не зависели от реализаций, но чтобы зависимостями реализаций были абстракции. Коротко говоря: даешь больше интерфейсов!

### Принципы STUPID:

* **Синглтон**: шаблон "одиночка" - использование одного и того же шаблона везде.
* **Сильная связанность**: сильная связь между "подпрограммами" и "модулями" Вашей программы, если изменение одной влечёт изменение другой, то, вероятно, связанность есть.
* **Невозможность тестирования**: очевидно, тяжело тестировать программу :)
* **Преждевременная оптимизация**: фактически, оптимизированные системы гораздо сложнее, чем просто написание цикла или использование преинкремента вместо постинкремента. В конечном итоге, вы останетесь с нечитабельным кодом.
* **Не дискриптивное присвоение имени**: название переменных, классов, методов, проч. неудобно/не соответствует смыслу/сильно сокращено/неразумно/т.д.
* **Дублирование кода**: дублированный код неэффективен, таким образом, не повторяйтесь, и также делайте его короче и проще. Пишите код только один раз!


## Класс Object и его методы по умолчанию
---
Object – базовый класс для всех классов. У него практически нет никаких данных, но есть несколько методов. Хотя мы можем создать обычный класс, который не является наследником, но фактически все классы наследуются от класса Object. Все остальные классы, даже те, которые мы добавляем в свой проект, являются неявно производными от класса Object. Поэтому все типы и классы могут реализовать те методы, которые определены в классе Object.

### toString()

Этот метод позволяет получить текстовое описание любого объекта. Реализация его в классе Object очень простая:

```java

return getClass().getName() + "@" + Integer.toHexString(hashCode());

```

Из такого описания можно узнать класс объекта, у которого вызвали данный метод. А также можно различать объекты – разным объектам соответствуют разные цифры, идущие после символа @.

Но ценность данного метода в другом. Данный метод можно переопределить в любом классе и возвращать более нужное или более детальное описание объекта.

### equals()

Метод equals принимает в качестве параметра объект любого типа, который мы затем приводим к текущему, если они являются объектами одного класса.

```java

return (this == obj);

```

Оператор **instanceof** позволяет выяснить, является ли переданный в качестве параметра объект объектом определенного класса.


### hashCode()

Метод hashCode позволяет задать некоторое числовое значение, которое будет соответствовать данному объекту или его хэш-код. По данному числу, например, можно сравнивать объекты.

Реализация по умолчанию hashCode() возвращает значение, которое называется идентификационный хеш (identity hash code). Здравый смысл подсказывает, что идентификационный хеш использует целочисленное представление адреса памяти.

```java

public native int hashCode();

```

### clone()

Цель этого метода – клонировать объект – т.е. создать его клон/копию/дубликат.

Если его вызвать, то Java-машина создаст и вернет дубликат объекта, у которого вызвали этот метод.

Клонирование объекта в классе Object реализовано очень примитивно – при клонировании создается всего один новый объект: просто создается еще один объект и его полям присваиваются значения полей объекта-образца.

Если копируемый объект содержит ссылки на другие объекты, то ссылки будут скопированы, дубликаты тех объектов не создаются.

### finalize

Этот метод вызывается Java-машиной(сборщиком мусора) у объекта перед тем, как объект будет уничтожен(если обнаруживает то, что на объект больше нет никаких ссылок(references)). Фактически этот метод – противоположность конструктору. В нем можно освобождать ресурсы, используемые объектом.

```java

protected void finalize() throws Throwable { }

```

Метод finalize, объявленный в классе Object, не выполняет никаких действий. Тот факт, что в классе Object объявляется метод finalize, означает, что метод finalize для любого класса всегда может вызвать метод finalize для своего суперкласса. Это нужно делать всегда, если только программист не намерен аннулировать действия финализатора в суперклассе.

**by Джошуа Блох**:
1. finalize() можно использовать только в двух случаях:
1.1 Проверка/подчистка ресурсов с логированием
1.2 При работе с нативным кодом, который не критичен к утечке ресурсов
2. finalize() замедляет работу GC по очистке объекта в 430 раз
3. finalize() может быть не вызван


### wait(), notify(), notifyAll()

Иногда при взаимодействии потоков встает вопрос о извещении одних потоков о действиях других. Например, действия одного потока зависят от результата действий другого потока, и надо как-то известить один поток, что второй поток произвел некую работу. И для подобных ситуаций у класса Object определено ряд методов:

* **wait()**: освобождает монитор и переводит вызывающий поток в состояние ожидания до тех пор, пока другой поток не вызовет метод notify().
* **notify()**: продолжает работу потока, у которого ранее был вызван метод wait().
* **notifyAll()**: возобновляет работу всех потоков, у которых ранее был вызван метод wait()


(((многопоточка)))


## Особенности реализации наследования в Java.
---
* Наследуем только 1 класс, java не поддерживает наследование нескольких классов(см. "Проблема Алмаза"), также и "себя" нельзя наследовать. 
* НО поддерживается возможность наследования(хотя на самом деле это не совсем наследование) множественных интерфейсов.
* Наследуется все кроме приватных переменных и методов.
* Методы родителя(как и конструктор) можно вызвать с помощью super.
* Можно запретить наследование класса, поставив перед ним модификатор final:

```java

public final class <name> {}

```

## Понятие абстрактного класса. Модификатор abstract.
---
Абстрактные классы служат шаблонами для создания других классов. Экземпляр такого класса нельзя создать сам по себе – он служит основой для других классов. При объявлении такого класса в его определении ставится ключевое слово abstract.

```java

public abstract class <name> {}

```

Абстрактные классы могут иметь свои абстрактные методы, обычные методы, поля, конструкторы и прочее, но для абстрактных классов (в отличие от конкретных) нельзя напрямую создавать экземпляры. Напротив, абстрактные классы непосредственно предназначены для того, чтобы их расширяли другие классы, которые затем могут реализовывать абстрактные методы и наследовать неабстрактные члены и поведение абстрактного класса.

### Абстрактные методы 

_Абстрактным_ называется такой метод, который объявляется, но не предоставляет реализации. Он объявляется при помощи ключевого слова abstract:

```java

public abstract <type> <name> {}

```

В абстрактных методах нет тела, но они могут содержать возвращаемый тип, параметры и модификаторы. Ответственность за реализацию абстрактного метода ложится на конкретные субклассы, расширяющие абстрактный класс.

Особенности:

* Абстрактный метод не может быть объявлен как final или private.
* Абстрактный метод обязательно должен объявляться внутри абстрактного класса.
* Конкретный субкласс, расширяющий абстрактный класс, обязательно должен предоставлять реализацию для всех его унаследованных абстрактных методов.


## Понятие интерфейса, реализация, методы, отличия от абстрактных классов
---
Интерфейс - это совокупность некоторых методов, не имеющих реализации, которые реализуются в классе, использующем данный интерфейс.
Для его объявления пишут ключевое interface вместо class:

```java

public interface <name> {}

```

Все методы в интерфейсе имеют модификатор public по умолчанию(даже если его не написать). Вместе с методами интерфейс в java может содержать константы, которые всегда должны иметь модификаторы public static.
Если класс, использующий интерфейс, не абстрактный, то в нём обязаны быть реализованы методы интерфейса.	
### Отличия от класса

* Вы не можете создать экземпляр интерфейса.
* В интерфейсе не содержатся конструкторы.
* Все методы в интерфейсе абстрактные.
* Интерфейс не может содержать поля экземпляров. Поля, которые могут появиться в интерфейсе, обязаны быть объявлены и статическими, и final.
* Интерфейс не расширяется классом, он реализуется классом.
* Интерфейс может расширить множество интерфейсов.


## Перечисляемый тип данных (enum) в Java. Особенности реализации и использования.

Объявление типа enum определяет класс (enum type), который может содержать методы и другие поля. Компилятор автоматически добавляет некоторые методы, когда создает тип enum. Например, он имеет статический метод values, который возвращает массив, содержащий значения объекта в порядке их объявления.

```java

public enum <name> {}

```

Перечисления позволяют реализовать заданное количество экземпляров некоторого класса, ограничив при этом программиста в создании этих экземпляров вручную.


## Методы и поля с модификаторами static и final
---
**final** — это модификатор, позволяющий объявлять константные поля и методы в классе. Если у вас есть некоторое свойство проектируемого вами объекта, значение которого не будет меняться, то вы можете воспользоваться этим модификатором. Любая попытка переопределить значение поля/метода с модификатором final приводит к выбросу исключения. Методы и поля с модификатором final не наследуются. Также можно создавать final классы.

**static** - поле(единое для всех объектов): существует на уровне класса, а не объекта; Для каждого класса создается только один экземпляр статической переменной (переменой класса). В случае методов static означает, что метод принадлежит всему классу, вызывать static метод можно напрямую через имя класса, не создавая объект.

### static-блоки

Статические блоки применяют для инициализации статических переменных. Статический блок выполняется только один раз, когда класс загружается в память. Это происходит, если в коде запрашивается либо объект класса, либо статические члены этого класса.
Класс может содержать несколько статических блоков, а каждый из них выполняется в той же последовательности, в которой они написаны в коде.



## Перегрузка и переопределение методов. Коварианты возвращаемых типов данных.
---
Переопределение методов: **(@Override)** 
* Все методы в Java могут быть перегружены (кроме методов final).
* Перегруженный в дочернем классе метод будет вызван для объекта данного класса вместо метода родительского класса.
* Если метод не был перегружен, вызовется реализация метода в родительском классе.

Одинаковые по названию, но разные по параметрам методы в одном и том же классе - перегрузка **(@Overload)** .

### Ковариантность возвращаемых типов

Переопределённый метод класса-наследника может возвращать значение, чей тип является наследником того, что возвращает переопределяемый метод класса-родителя. В этом и состоит концепция ковариантности возвращаемых типов.


## Элементы функционального программирования в синтаксисе Java. Функциональные интерфейсы, лямбда-выражения. Ссылки на методы.
---
**Функциональный интерфейс (functional interface)** – это интерфейс у которого только один абстрактный метод. Функциональный интерфейс может содержать любое количество методов по умолчанию (default) или статических методов.

**Лямбда-выражение** образует реализацию метода, определенного в функциональном интерфейсе.
Общая форма записи: 

```java

(параметры) -> {тело}

```

Лямбда-выражение может содержать 0 и более входных параметров и аналогично 0 и более выражений в теле.
* Если параметров нет или их больше одного, скобки необходимы
* Нет необходимости объявлять один параметр в скобках, но в этом случае нельзя явно указать тип параметра
* Нет необходимости использовать фигурные скобки и ключевое слово return, если тело состоит из одного выражения
* Если тело содержит более одного выражения, фигурные скобки и ключевое слово return необходимы

*Пример:*

```java

public class LambdaApp {
 
    public static void main(String[] args) {
         
        Operationable operation;
        operation = (x,y)->x+y;
         
        int result = operation.calculate(10, 20);
        System.out.println(result); //30
    }   
}
interface Operationable{
    int calculate(int x, int y);
}

```

В роли функционального интерфейса выступает интерфейс Operationable, в котором определен один метод без реализации - метод calculate. Данный метод принимает два параметра - целых числа, и возвращает некоторое целое число.


Если лямбда выражения вызывают только один существующий метод, лучше ссылаться на этот метод по его имени. Ссылки на методы (Method References) – это компактные лямбда выражения для методов у которых уже есть имя. Например:

```java

Consumer<String> consumer = str -> System.out.println(str);

```

можно переписать с помощью method references:

```java

Consumer<String> consumer = System.out::println;

```

### Ссылка на статический метод

```java

ContainingClass::staticMethodName

```

### Ссылка на нестатический метод конкретного объекта

```java

containingObject::instanceMethodName

```

### Ссылка на нестатический метод любого объекта конкретного типа

```java

ContainingType::methodName

```

### Ссылка на конструктор

```java

Classname::new

```




# Лабораторная работа №4
----

## Обработка исключительных ситуаций, три типа исключений

Исключения в правилах языка не обошли и Java стороной. Исключения — это
ситуации, которые можно характеризовать так: «Что то пошло не так». Например произошло деление на нуль и т. п.
Исключения в Java — это объекты определенного типа. Для работы с этими объектами в Java есть набор инструментов и языковых конструкций. К тому же сама Java-машина особым образом работает с объектами-исключениями. 

**Классификация**:
* Error: это такие исключения, которые возникли по причине ошибок самой Java-машины, и Ваш код не может ничего с этим сделать. В качестве примера можно вспомнить ситуацию, когда в память, выделенная Java-машине закончилась. В такой ситуации нет смысла обрабатывать эту ошибку, разве что выводом записи на экран «Капут». 
* Unchecked(*"непроверяемые"* ошибки): это ошибки времени выполнения(runtime exception), т. е. на момент компиляции еще не известно «вылетит» там ошибка или нет.
* Checked(*"проверяемые"* ошибки): 

### Обработка исключений

*Пример:*

```java

public void method() throws IOException, IllegalArgumentException {
	throw new IOException();
}

public void app() {
	try {
		method();
	} 
	catch (IOException ex) {
		// код
	}
	finally {
		// код
	}
}

```

В этом примере у нас есть некоторый метод method(), который отмечен, как метод,способный сгенерировать исключения типов IOException или IllegalArgumentException. Такаяконструкция обязывает программиста, который использует этот метод, обрамлять его конструкцией try-catch. Таким образом, в момент компиляции может быть проверено, обрабатывается ли ошибка указанная в определении используемого метода. Для «отлавливания» и обработки исключений, используется конструкция try-catch. В блоке try находится код, который, возможно, генерирует исключения. В блоках catch указывается тип ошибки, которую обрабатывает этот блок catch и код-обработчик. В приведенном на слайде примере обработка исключений опущена. На ее месте находятся комментарии. В конструкции try-catch есть еще один необязательный блок — finally. В теле этого блока прописывается код, который необходимо выполнить в любом случае, независимо от того, было ли сгенерировано исключение или нет.

Однако это не все, что касается исключений. Вы самостоятельно можете генерировать исключения, в надежде, что кто-либо «поймает» их. Это делается с помощью оператора throw. Пример генерации своего исключения представлен на слайде в методе method().

*Note*: чтобы "ловить" несколько исключений(один и тот же код для разных исключений) и не писать лишний код, можно сделать так:

```java

catch(IOException | IllegalArgumentException) {
	// код
}

```


## Вложенные, локальные и анонимные классы

* **Вложенные классы**
Как понятно из термина, это класс внутри класса. Используется, когда сам он внешний и самостоятельный не нужен, когда он нужен именно для какого-то самостоятельного класса. Из объекта вложенного класса нельзя обращаться к нестатическим членам внешнего класса.

Правила его объявления внутри класса ровно такие же, как и для обычных элементов класса:

```java

public class Outer {

	// fields and methods of class Outer

	public static class Inner {
		// fields and methods of class Inner
	}

}

```

*Note: вложенный класс с модификатором static будем называть внутренним классом.* 

Создание экземпляров внешнего и вложеннего/внутреннего класса:

```java

Outer externalObject = new Outer(); // внешний

Outer.Inner interiorObject1 = externalObject.new Inner(); // вложенный (без static)

Outer.Inner interiorObject2 = new Outer.Inner(); // внутренний (вложенный + static, объект не обязателен)

```

*Note: если вложенний класс не static, то создавать объекты вложенного класса можно только тогда, когда существует объект внешнего класса. (в примере выше создание идёт как раз с помощью externalObject)*

Обращение к элементам внешнего класса из вложенного:

```java

Outer.this.someMethod();

```

* **Локальные классы**
Самый странный в Java класс, который только может быть — это локальный класс.
Такой класс можно объявить где угодно. И говоря где угодно имеется в виду любой блок кода:

* в методе
* в блоке кода
* в блоке инициализации
* в блоке цикла
* в блоке условного оператора
* т.д.

выше представлено лишь несколько примеров, где может быть объявлен такой класс.

Странность его в том, что объекты этого класса можно создать только в области
видимости того блока, где он был объявлен. По этой причине не совсем понятно как он может быть использован на практике. Но такое тоже есть и об этом будет полезно знать.

*Несколько "правил" для локальных классов:*
* модификатор доступа не указывается
* невозможно объявление статических методов(и любых иных статических членов)
* но возможно использование статических констант
* использование внешних локальных переменных возможно, если они определены, как "effectively final"(это НЕ ключевое слово, это такие переменные, которые после объявления никак не используются и не меняются вне локального класса)
* не могут быть статичными

* **Анонимные классы**
Анонимный класс - своеобразный аналог локального класса. Разница в том, что у локального класса есть имя и тип, а у анонимного нет, поэтому он и называется анонимным.
Мы как бы создаём "на лету" какой-то объект, которым пользуемся, но не присваиваем ему типа и имени.

```java

public void start() { ... }

public void test() {
	start(new SomeClass() {
		public void doSomething() {}
	}
}

```

Здесь синтаксис внутри некоего "start" и является анонимным классом.


## Механизм рефлексии (reflection) в Java. Класс Class

Мы привыкли, что, например, класс - это структура, описывающая поведение некоторых объектов. При создании нами объектов мы понимаем, что у них есть какие-то состояния и поведения, которые мы описываем с помощью классов. Но Java кроме самих объектов воспринимает состояния и поведения тоже как объекты. Рефлексия в Java - тот факт, что Java вообще всё воспринимает как объекты.
Класс состоит из полей и методов - его свойств - и поведения: например, способность породить объект класса. Продолжим цепочку с точки зрения Java. Поле класса состоит из его свойств - типа и имени - и поведения: например, способность задать полю какое-то значение.
**Рефлексия позволяет:**
* Узнать/определить класс объекта
* Получить информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах
* Выяснить, какие методы принадлежат реализуемому интерфейсу/интерфейсам
* Создать экземпляр класса, причем имя класса неизвестно до момента выполнения программы
* Получить и установить значение поля объекта по имени
* Вызвать метод объекта по имени

*Рассмотрим некоторый пример кода:*

```java

Class<Object> objectClass = Object.class;
Field[] fields = objectClass.getDeclaredFields();

for(Field field : fields) {
	System.out.println(...)
}

```

В данном примере создаётся экземпляр класса Class, который "представляет" класс Object.(не тот самый Object, а просто случайный класс, имени другого не придумал) В fields записываются все поля, имеющиеся в классе Object. Далее мы просто пробегаемся по ним for'ом и выводим что-то.

Здесь фигурирует так называемый класс **Class**. Это всего лишь класс, объектами которого, как ни странно, являются классы :) 
Экземпляры класса Class представляют классы и интерфейсы. 
Class не имеет public конструктора. Вместо этого объекты классов создаются автоматически виртуальной машиной Java при загрузке классов и посредством вызовов метода defineClass в загрузчике классов. Обобщая, можно сказать, что с помощью Class мы и получаем доступ ко всему, что нужно, в рефлексии, работая с классами как с объектами.