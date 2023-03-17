## Обучение OTUS QA.Java.Professional
### Домашнее задание №4 - Разворачивание и подключение Selenoid
#### Задание
Необходимо подключить Selenoid, перенести существующие тесты на использование Selenoid.
Добавить возможность запускать тесты на mobile chrome.

#### Описание реализации
В проекте иcпользуется Java 8

#### Запуск Selenoid
--создать сети
docker network create selenoid_1
docker network create selenoid_2

--создать контейнеры
docker run -d --name selenoid_1 -p 4445:4444 --net=selenoid_1 -v //var/run/docker.sock:/var/run/docker.sock -v D:\selenoid\conf:/etc/selenoid:ro aerokube/selenoid -limit=12 -capture-driver-logs -max-timeout=0h30m0s -container-network=selenoid_1
docker run -d --name selenoid_2 -p 4446:4444 --net=selenoid_2 -v //var/run/docker.sock:/var/run/docker.sock -v D:\selenoid\conf:/etc/selenoid:ro aerokube/selenoid -limit=12 -capture-driver-logs -max-timeout=0h30m0s -container-network=selenoid_2

--генерация пароля
docker run —rm -ti xmartlabs/htpasswd <username> <password> > htpasswd

D:\selenoid\ggr\ggr_windows_386 -guests-allowed -guests-quota test -quotaDir D:\selenoid\ggr\quota
D:\selenoid\ggr\ggr-ui_windows_386 -quota-dir D:\selenoid\ggr\quota
D:\selenoid\selenoid-ui_windows_386 -status-uri http://127.0.0.1:8888 -selenoid-uri http://127.0.0.1:8888 -webdriver-uri http://127.0.0.1:4444

#### Запуск тестов
clean test -Dcucumber.filter.tags=@test