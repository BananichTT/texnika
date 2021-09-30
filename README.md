# Список литературы 

- [Начало работы с Java Persistence API](https://www.tune-it.ru/web/vnik/home/-/blogs/начало-работы-с-java-persistence-api)
- [Вставка пользователей в таблицу](https://stackoverflow.com/questions/4967852/how-to-insert-values-into-database-using-queries-using-entity-manager-persisten)

 ```java
    em.getTransaction().begin();
    em.persist(user);
    em.getTransaction().commit();
 ```   
