# relex-internship-test-task
Relex company autumn internship 2023 test task Java

## Стек:
Java 17\
Gradle - build tool\
PostgreSQL - database\
Spring Boot 3.1.4\
Spring-Boot-Web\
Spring-Boot-Data-JPA\
Spring-Boot-Security 6\
Project Lombok\
SpringDoc OpenAPI 2.2.0

## Задание:
Необходимо разработать приложение в виде RESTful API на языке Java с использованием фреймворка Spring Boot.\
Данные, получаемые и отправляемые приложением, должны быть в формате JSON.\
Приложение должно реализовывать упрощенный функционал мессенджера.
## Реализованные требования:

_Примеры привожу в Postman_

### Регистрация и авторизация:
* есть API для регистрации, сохраняющий пользователя в хранилище (обязательно);\
_В качестве хранилища использовал PostgreSQL_
* есть хэширование паролей.\
_Через BCryptPasswordEncoder_

![Post Registration ReqResp.png](src%2Fmain%2Fresources%2Fimages%2FPost%20Registration%20ReqResp.png)

![Post Registration DB.png](src%2Fmain%2Fresources%2Fimages%2FPost%20Registration%20DB.png)

* есть API, позволяющий залогиниться в системе и сохраняющее информацию о сессии любым способом (обязательно);
* есть поддержка Spring Security;
* есть API, позволяющий завершить текущую сессию и разлогиниться (обязательно).

_Использовалась стандартная Login страница Spring Security_\
Login address: http://localhost:8080/login 

![Login Page.png](src%2Fmain%2Fresources%2Fimages%2FLogin%20Page.png)

Logout address: http://localhost:8080/logout

![Logout Page.png](src%2Fmain%2Fresources%2Fimages%2FLogout%20Page.png)

***

### Профиль пользователя:
* есть API, позволяющий изменять базовую информацию профиля (обязательно);

![Put Update Data ReqResp.png](src%2Fmain%2Fresources%2Fimages%2FPut%20Update%20Data%20ReqResp.png)

![Put Update Data DB.png](src%2Fmain%2Fresources%2Fimages%2FPut%20Update%20Data%20DB.png)

* есть API, позволяющий обновить пароль (обязательно);

![Put Update Password ReqResp.png](src%2Fmain%2Fresources%2Fimages%2FPut%20Update%20Password%20ReqResp.png)

* есть API, позволяющий удалить аккаунт пользователя (обязательно).

![Delete ReqResp.png](src%2Fmain%2Fresources%2Fimages%2FDelete%20ReqResp.png)

![Delete DB.png](src%2Fmain%2Fresources%2Fimages%2FDelete%20DB.png)

***

### Социальная часть:
* есть API, позволяющий отправить другому пользователю сообщение, 
реализована проверка на существование пользователя (обязательно);

![Post Message Send ReqResp.png](src%2Fmain%2Fresources%2Fimages%2FPost%20Message%20Send%20ReqResp.png)

* есть API, позволяющий просматривать историю сообщений с конкретным пользователем (обязательно).

![Get Message ReqResp.png](src%2Fmain%2Fresources%2Fimages%2FGet%20Message%20ReqResp.png)

***

### Дополнительно:
* документирование запросов через Swagger.

swagger-ui/index.html:

![Swagger-ui html.png](src%2Fmain%2Fresources%2Fimages%2FSwagger-ui%20html.png)