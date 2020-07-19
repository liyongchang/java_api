package com.container.hashTable;
/*
*1.不重写equals() hashCode()
 */
public class Student{

        String id;
        String name;

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }