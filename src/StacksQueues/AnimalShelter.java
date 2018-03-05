package StacksQueues;

import java.util.LinkedList;

//Animal Shelter: 
//An animal shelter, which holds only dogs and cats, 
//operates on a strictly"first in, first out" basis. 
//People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, 
//or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type). 
//They cannot select which specific animal they would like. 
//Create the data structures to maintain this system and implement operations 
//such as enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure.

public class AnimalShelter {

	public static void main(String[] args){
		AnimalShelter as = new AnimalShelter();
		as.enqueue(new Dog("go1"));
		as.enqueue(new Dog("go2"));
		as.enqueue(new Dog("go3"));
		as.enqueue(new Cat("cat1"));
		as.enqueue(new Cat("cat2"));
		as.enqueue(new Dog("go4"));
		
		for(Animal a : as.list ){
			System.out.println(a.getName());
		}
		System.out.println();
		
		System.out.println(as.dequeueAny().getName());
		System.out.println(as.dequeueDog().getName());
		System.out.println(as.dequeueCat().getName());
		System.out.println(as.dequeueDog().getName());
		System.out.println(as.dequeueAny().getName());
		System.out.println(as.dequeueDog().getName());
		
	}
	
	LinkedList<Animal> list;
	
	public AnimalShelter(){
		list = new LinkedList<>();
	}
	
	public void enqueue(Animal a){
		list.add(a);
	}
	
	public Animal dequeueAny(){
		return list.removeFirst();
	} 
	
	public Cat dequeueCat(){
		
		Animal res = null;
		
		for(Animal n : list) {
			if(n instanceof Cat){
				list.remove(n);
				res = n;
				break;
			}
		}
		return (Cat) res;
	}
	
	public Dog dequeueDog(){
		
		Animal res = null;
		
		for(Animal n : list) {
			if(n instanceof Dog){
				list.remove(n);
				res = n;
				break;
			}
		}
		return (Dog) res;
	} 
	
	
}

interface Animal {
	String getName();
}

class Cat implements Animal {
	String name;
	
	Cat(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Dog implements Animal {
	String name;
	
	Dog(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
