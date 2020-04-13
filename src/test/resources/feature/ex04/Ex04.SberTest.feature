#language: ru

@SberDepTest
Функционал: проверка страниц

  Сценарий: проверка страниц Сбера
    * пользователь заходит на сайт СберБанка
    * если сайт на английском, то меняет язык на русский
    * на верхней панеле наводит на "Вклады" и в выпадающем меню нажимает на кнопку "Вклады"
    * переходит на вкладку "Подобрать вклад"
    * ползователь выполняет проверку отображения 4-ёх чек боксов
      | Хочу снимать   |
      | Хочу пополнять |
      | Онлайн         |
      | Я - пенсионер  |
    * пользователь проверяет установку чек-бокса "Онлайн"
    * пользователь проверяет отображение 3-х вкладов:
      | Сохраняй |
      | Пополняй |
      | Управляй |
    * выбирает следущие чекбоксы:
      | Хочу снимать   |
      | Хочу пополнять |
    * пользователь проверяет наличие только вклада "Управляй"
    * нажимает на кнопку "Подробнее"
    * проверка нахождения на странице "«Сбербанк» - Вклад Управляй" и инфой по вкладу "Вклад Управляй"