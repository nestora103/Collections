package com.gubenkoDM.collections;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by DmitriX on 23.03.2017.
 */
public class LinkedListClass {
    private void printCollection(Collection<Cat> collection){
        //получаем имя класса через рефлексию
        System.out.println(collection.getClass().getSimpleName());
        for (Cat cat:collection) {
            System.out.println(cat.getSize()+" "+cat.getAge());
        }
    }
    public void test(){
        LinkedList<Cat> ll=new LinkedList<>();
        ll.add(new Cat(1,1));
        printCollection(ll);

        ll.add(0,new Cat(2,2));
        printCollection(ll);


        LinkedList<Cat> ll2= (LinkedList<Cat>) ll.clone();
        printCollection(ll2);

        Cat cat=ll.element();
        System.out.println(cat.getSize()+" "+cat.getAge());

        ll.offer(new Cat(3,3));
        printCollection(ll);

    }
}
