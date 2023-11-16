# Задание 1.

```
    Представьте, что вы работаете над разработкой простого приложения для записной книжки, которое 
    позволяет пользователям добавлять, редактировать и удалять контакты.
    Ваша задача - придумать как можно больше различных тестов (юнит-тесты, интеграционные тесты, 
    сквозные тесты) для этого приложения. Напишите название каждого теста, его тип и краткое описание 
    того, что этот тест проверяет.  
```


# Задание 2. 

``` 
    Ниже список тестовых сценариев. Ваша задача - определить тип каждого теста (юнит-тест, 
    интеграционный тест, сквозной тест) и объяснить, почему вы так решили. 
    1. Проверка того, что функция addContact корректно добавляет новый контакт в список 
    контактов.
    2. Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт 
    корректно отображается в списке контактов.
    3. Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее 
    удаление.
```

### Тест №1. Проверка того, что функция addContact корректно добавляет новый контакт в список контактов.

1.1 Данный тест может быть как простым unit-test-ом, так и интеграционным тестом. Зависеть все будет исключительно от реализации, в каждом конкретном случае. Если функция "addContact" реализована в классе, и данный класс, при вызове этой функции не взаимодействует с другими классами, то в данном случае - тест конкретно этой функциональности класса будет исключительно обычным unit-test-ом.

1.2 Возможен такой вариант реализации приложения, когда при вызове данной функции, класс, которому данная функция принадлежит, взаимодействует с другим классом, который будет передан в аргументах к вызову данной функции. 
Например, У нас есть два класса - UserService и UserRepository.
Список контактов, хранится в некотором хранилище (база данных, файл в папке и так далее).
Для работы со списком пользователей: - добавление пользователей, удаление пользователей, получение информации о пользователях и так далее, класс UserService использует класс UserRepository. 
Наш частный случай - добавление пользователей (вызов функции "addContact"). В этом случае тест будет интеграционным. При вызове теста будет проверено, что классы верно взаимодействуют между собой.


### Тест №2. Проверка того, что при добавлении контакта через пользовательский интерфейс, контакт корректно отображается в списке контактов.


Данный тест будет интеграционным. 
Исходя из формулировки вопроса - в данном конкретном случае - у нас как минимум имеется класс отвечающий за хранение списка контактов. И у нас есть пользовательский интерфейс, через который происходит добавление
контакта в список. То есть в нашем случае происходит взаимодействие между классами. И при проведении теста, хоть сам тест заключается в проверке корректности отображения контакта в списке, но попутно происходит и 
проверка взаимодействия между классами. Мы убеждаемся, что система работает правильно. Ну или не правильно, если вдруг происходит падение теста.


### Тест №3. Проверка полного цикла работы с контактом: создание контакта, его редактирование и последующее удаление.


Больше похоже, что данный тест, а я бы сказал данные тесты ( я бы разделил отдельно тесты на: создание контакта, на редактирование контакта, на удаление контакта), данный тесты будут е2е тестами, или так сказать сквозными тестами. Так как при проведении данных тестов у нас похоже будут задействованы все слои приложения. И слой отвечающий за хранение информации о пользователях, и слой отвечающий за логику, и слой отвечающий за отображение информации. 