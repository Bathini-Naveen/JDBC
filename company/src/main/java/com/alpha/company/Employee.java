package com.alpha.company;

	public class Employee { // A class that defines the Structure of an employee
		private int id;
		private String name;
		private int age;
		private int sal;
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
		public Employee(int id, String name, int age, int sal) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.sal = sal;
		}
	}
