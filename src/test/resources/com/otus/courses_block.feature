#language: ru

  @test
  Функционал: Курсы платформы Otus

    @find_course_by_name
    Структура сценария: Поиск курса по его имени
      Пусть Открыт браузер '<браузер>'
      И Открыта главная страница "https://otus.ru"
      Если Кликнуть на курс "Специализация Python"
      Тогда Откроется страница курса с названием "Python Developer"
      Примеры:
        | браузер |
        | chrome  |
        | opera   |

    @find_course_by_date
    Структура сценария: Поиск курса по дате старта
      Пусть Открыт браузер '<браузер>'
      И Открыта главная страница "https://otus.ru"
      Если Кликнуть на курс с датой больше "2023-мар-20"
      Тогда Откроется страница курса
      Примеры:
        | браузер |
        | chrome  |
        | opera   |

    @find_cheap_course
    Структура сценария: Поиск самого дешевого курса
      Пусть Открыт браузер '<браузер>'
      И Открыта главная страница "https://otus.ru"
      Если Кликнуть на самый дешевый курс
      Тогда Откроется страница курса
      Примеры:
        | браузер |
        | chrome  |
        | opera   |

    @find_expensive_course
    Структура сценария: Поиск самого дорогого курса
      Пусть Открыт браузер '<браузер>'
      И Открыта главная страница "https://otus.ru"
      Если Кликнуть на самый дорогой курс
      Тогда Откроется страница курса
      Примеры:
        | браузер |
        | chrome  |
        | opera   |