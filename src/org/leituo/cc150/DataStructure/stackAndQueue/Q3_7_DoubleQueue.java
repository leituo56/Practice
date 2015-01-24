//  3.7 An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
// People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
// or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
// They cannot select which specific animal they would like.
// Create the data structures to maintain this system and implement opera- tions such as enqueue,
// dequeueAny, dequeueDog and dequeueCat. You may use the built-in L inkedL ist data structure.

package org.leituo.cc150.DataStructure.stackAndQueue;

import java.util.LinkedList;

/**
 * Created by leituo56 on 10/30/14.
 */
public class Q3_7_DoubleQueue {
    public Q3_7_DoubleQueue() {
        AnimalQueue aq = new AnimalQueue();
        aq.enQueue(new Animal(true));//cat
        aq.enQueue(new Animal(false));//dog
        aq.enQueue(new Animal(true));//cat
        aq.enQueue(new Animal(true));//cat
        aq.enQueue(new Animal(false));//dog
        aq.enQueue(new Animal(true));//cat
        System.out.println(aq.deQueueAny());
        System.out.println(aq.deQueueCat());
        System.out.println(aq.deQueueAny());
        System.out.println(aq.deQueueAny());
    }

    public static void main(String[] args) {
        Q3_7_DoubleQueue test = new Q3_7_DoubleQueue();
    }
}
class AnimalQueue{
    LinkedList<Animal> catQueue;
    LinkedList<Animal> dogQueue;
    int index = 0;
    AnimalQueue() {
        catQueue = new LinkedList<Animal>();
        dogQueue = new LinkedList<Animal>();
    }
    public void enQueue(Animal pet){
        pet.index = index++;
        if (pet.isCat)
            catQueue.add(pet);
        else
            dogQueue.add(pet);
    }
    public Animal deQueueAny(){
        if (isEmpty())
            return null;
        if (dogQueue.isEmpty() || catQueue.get(0).index < dogQueue.get(0).index)
            return catQueue.remove(0);
        else
            return dogQueue.remove(0);
    }
    public Animal deQueueCat(){
        return catQueue.remove(0);
    }
    public boolean isEmpty(){
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }
}
class Animal{
    public int index;
    public boolean isCat;

    Animal(boolean isCat) {
        this.isCat = isCat;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "index=" + index +
                ", isCat=" + isCat +
                '}';
    }
}
