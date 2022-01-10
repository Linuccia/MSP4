# Методы и средства программной инженерии
## Лабораторная работа №4
1. Для своей программы из лабораторной работы #4 по дисциплине "Программирование интернет-приложений" реализовать:

     +	MBean, считающий общее число установленных пользователем точек, а также число точек, не попадающих в область. В случае, если количество установленных пользователем точек стало кратно 10, разработанный MBean должен отправлять оповещение об этом событии.
     +	MBean, определяющий процентное отношение "попаданий" к общему числу кликов пользователя по координатной плоскости.
***
2. С помощью утилиты *JConsole* провести мониторинг программы:

     +	Снять показания MBean-классов, разработанных в ходе выполнения задания 1.
     +	Определить версию Java Language Specification, реализуемую данной средой исполнения.
***
3. С помощью утилиты *VisualVM* провести мониторинг и профилирование программы:

     +	Снять график изменения показаний MBean-классов, разработанных в ходе выполнения задания 1, с течением времени.
     +	Определить имя класса, объекты которого занимают наибольший объём памяти JVM; определить пользовательский класс, в экземплярах которого находятся эти объекты.
