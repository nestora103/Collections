package com.gubenkoDM.collections;

/**
 * Created by DmitriX on 20.03.2017.
 */
public class Cat {
    private int size;
    private int age;

    public Cat(int size, int age) {
        this.size = size;
        this.age = age;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void voice(){
        System.out.println("Mrrr");
    }
}
