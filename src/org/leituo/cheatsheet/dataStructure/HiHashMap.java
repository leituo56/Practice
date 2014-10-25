//  Implementation: Linked List, move after mod, BST(log n)
//  O(1) lookup
//  map.put(key, value)
//  map.get(key)
package org.leituo.cheatsheet.dataStructure;

import java.util.HashMap;

/**
 * Created by leituo56 on 10/24/14.
 */
public class HiHashMap {
    public HashMap<Integer, Student> buildHashMap(Student[] students){
        HashMap<Integer, Student> map = new HashMap<Integer, Student>();
        for (Student s:students){
            map.put(s.getId(), s);
        }
        return map;
    }

    // Test Case
    public static void main(String[] args) {
        // Basic
        HashMap<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(1, "Hello");
        aMap.put(2, "World");
        System.out.println(aMap.containsKey(3));
        System.out.println(aMap.containsValue("Hello"));
        aMap.remove(1);
        System.out.println(aMap.size());
        aMap.clear();

        // Build
        Student[] students = {new Student(1, "Steve"), new Student(2, "Jason")};
        HiHashMap test = new HiHashMap();
        HashMap<Integer, Student> map = test.buildHashMap(students);

        System.out.println(map);
        System.out.println(map.get(1).getName());
    }

}
// Other Class
class Student{
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
