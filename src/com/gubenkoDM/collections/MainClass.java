package com.gubenkoDM.collections;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Created by DmitriX on 20.03.2017.
 */
public class MainClass {

    public static void printCollection(Collection<Cat> collection){
        //получаем имя класса через рефлексию
        System.out.println(collection.getClass().getSimpleName());
        for (Cat cat:collection) {
            System.out.println(cat.getSize()+" "+cat.getAge());
        }
    }

    public static void main(String[] args) {
        List<Cat> list=new ArrayList<>();
        //добавление элемента в конец
        boolean state=list.add(new Cat(1,1));
        System.out.println(state);

        Cat trueCat=new Cat(2,2);

        //добавление элемента по индексу
        //list.add(0,new Cat(2,2));
        list.add(0,trueCat);

        System.out.println(list.get(0).getSize()+" "+ list.get(1).getSize());

        //получим отобжажение списка в виде строки(объекты будут отбражаться как полное_имя_объектаАдрес_в_куче)
        System.out.println(list.toString());

        Collection<Cat> collection=new ArrayList<>();
        collection.add(new Cat(3,3));
        collection.add(new Cat(4,4));

        printCollection(collection);

        //добавление одного списка в конец другого
        list.addAll(collection);

        printCollection(list);

        Collection<Cat> collection2=new ArrayList<>();
        collection2.add(new Cat(5,5));
        collection2.add(new Cat(6,6));

        //вставка одной коллекции в другую начиная с указанного номера элемента, если элементы внутри есть то они сдвигаются на колличество вставляемых элементов вправа
        list.addAll(0,collection2);

        printCollection(list);

        //очищение списка
        //list.clear();
        //printCollection(list);

        System.out.println(list.get(2).equals(trueCat));

        //сравниваем объект в коллекции с самим собой . Если ссылки совпадают то тру а так фолс
        boolean bool=list.contains(trueCat); //один и тот же объект.
        boolean bool2=list.contains(new Cat(2,2));
        boolean bool3=list.contains(new Cat(10,10));

        System.out.println(bool+" "+bool2+" "+bool3);

        //у двух объектов с одинаковым содержимим но разных объктов в паняти кучи(адрес в куче) будет разный хэш код
        System.out.println(list.get(2).hashCode()==new Cat(2,2).hashCode());

        //поиск объекта в списке. поиск производится по адресу объекта в куче.
        System.out.println(list.indexOf(new Cat(2,2))); //-1
        System.out.println(list.indexOf(trueCat)); //2

        //проверка что в основной список входят элементы из подсписков
        System.out.println(list.containsAll(collection2)); //true
        System.out.println(list.containsAll(collection)); //true

        //true -пустой список, false в остальных случаях
        System.out.println(list.isEmpty());

        //получаем объект Итератор с помощью которого можно пробегать по коллекции

        //Объект Итератора определяет по каким правилам производить прохождение по элементам списка!!!

        // hasNext()-пока не конец ; next() след элемент коллекции ; remove()-удалить элемент коллекции
        //
        Iterator<Cat> iterator=list.iterator();
        //
        while(iterator.hasNext()){
            System.out.println(iterator.next().getSize());
        }
        System.out.println(" ");

        ListIterator<Cat> listIterator=list.listIterator();
        //
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().getSize());
        }

        //удаление указанного объекта из списка
//        list.remove(trueCat);
//        printCollection(list);
        //удаление из списка всех элементов которые присутствуют в списке удаления
//        list.removeAll(collection);
//        printCollection(list);

        //реазилация внутреннего(локального) класса оператора для реализации условий замещения элементов списка

        //Объект оператора определяет по каким правилам производить замену элементов списка!!!

//        class Operator<T> implements UnaryOperator<T>{
//            @Override
//            public T apply(T t) {
//                return (T) new Cat(500,500); //собственно заменяем все объекты списка другими котами
//            }
//        }
        //создание объекта оператора для замены элементов в коллекции по нужным правилам
        //Operator<Cat> operator=new Operator<>();

        //замена
        //list.replaceAll(operator);

        //через анонимный класс
        //list.replaceAll(new UnaryOperator<Cat>() {
//            @Override
//            public Cat apply(Cat cat) {
//                return new Cat(500,500); //собственно заменяем все объекты списка другими котами
//            }
//        });
//        printCollection(list);


        //оставляем в списке только те элементы которые содержатся в переданной методу коллекции
        //list.retainAll(collection);
        //printCollection(list);

        //изменение содержимого элемента списка по индексу
        list.set(0,new Cat(111,111));
        printCollection(list);

        System.out.println("Сколько элементов заполнено "+list.size());

//      a negative integer, zero, or a positive integer as the first argument is less than,
//      equal to, or greater than the second.
//      если o1<02 -> -1 ; если o1==02-> 0; если o1>o2-> 1

        //реализация компаратора через анонимный класс.
        // Объект компаратора определяет как будем сортировать список!!!

        //сортировка от большего к меньшему
        list.sort(new Comparator<Cat>(){
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1.getSize()<o2.getSize()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        printCollection(list);

        //сортировка от меньшего к большему
        list.sort(new Comparator<Cat>(){
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1.getSize()>o2.getSize()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        printCollection(list);

        //list.spliterator()!!

        //получение подсписка из списка
        List<Cat> subList=list.subList(1,3);
        printCollection(subList);

        Object objArr[]=list.toArray();
        for (Object obj:objArr) {
            System.out.println(obj.toString());
        }

        System.out.println(" ");
        Cat catArr[]=new Cat[list.size()];
        list.toArray(catArr);
        for (Cat cat:catArr) {
            System.out.println(cat.toString());
        }

        //list.parallelStream();!!
        //list.stream();
//        list.forEach(new Consumer<Cat>() {
//            @Override
//            public void accept(Cat cat) {
//
//            }
//        });


    }
}
