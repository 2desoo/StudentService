# Student Service

## Описание

Student Service - это приложение для управления студентами, разработанное на Spring Boot. Оно предоставляет API для выполнения операций CRUD (Создание, Чтение, Обновление, Удаление) над студентами. Для обеспечения безопасности API используется протокол OAuth 2.0 для аутентификации и авторизации пользователей.

## Функциональные возможности

- Получение списка всех студентов
- Добавление нового студента
- Обновление информации о студенте
- Удаление студента по идентификатору

## Используемые технологии

- **Spring Boot** - фреймворк для создания приложений на Java
- **Spring Security** - для управления безопасностью приложения с использованием OAuth 2.0
- **Hibernate** - для работы с базой данных через JPA
- **OAuth 2.0** - для аутентификации и авторизации пользователей через сторонние сервисы, такие как Google и GitHub

## Установка

Клонируйте репозиторий:

   ```bash
   git clone https://github.com/2desoo/StudentService.git
```
## Перейдите в директорию проекта:

```bash
cd StudentService
```
## Соберите проект:

```bash
mvn clean install
```

## Запустите приложение:

```bash
mvn spring-boot:run
```
## Использование
После запуска приложения вы можете взаимодействовать с API через HTTP-запросы. Приложение по умолчанию будет доступно по адресу http://localhost:8080/api/students.

Аутентификация с использованием OAuth 2.0
Перед выполнением запросов к API вам необходимо получить токен доступа через OAuth 2.0. Доступна авторизация через Google и GitHub. Вам потребуется клиент, поддерживающий OAuth 2.0, чтобы получить токен. После получения токена, добавьте его в заголовок авторизации вашего запроса.
## Примеры запросов
- Получить всех студентов:
```bash
curl -X GET http://localhost:8080/api/students \
-H "Authorization: Bearer {your_access_token}"
```
- Добавить нового студента:

```bash
curl -X POST http://localhost:8080/api/students \
-H "Content-Type: application/json" \
-H "Authorization: Bearer {your_access_token}" \
-d '{
    "lastName": "Иванов",
    "firstName": "Иван",
    "patronymic": "Иванович",
    "studentGroup": "Группа A",
    "averageGrade": 4.5
}'
```
- Обновить студента:

```bash
curl -X PUT http://localhost:8080/api/students/{id} \
-H "Content-Type: application/json" \
-H "Authorization: Bearer {your_access_token}" \
-d '{
    "lastName": "Петров",
    "firstName": "Петр",
    "patronymic": "Петрович",
    "studentGroup": "Группа B",
    "averageGrade": 4.8
}'
```
- Удалить студента:

```bash
curl -X DELETE http://localhost:8080/api/students/{id} \
-H "Authorization: Bearer {your_access_token}"
```
## Тестирование
Для запуска тестов используйте следующую команду:

```bash
mvn test
```
