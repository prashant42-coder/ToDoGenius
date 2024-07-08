package com.in28minutes.spring.myfirstApplication.todoApp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
private static List<TodoScript> todos = new ArrayList<>();
	private static int todoCount=0;
	static {
		todos.add(new TodoScript(++todoCount, "in28minutes","Learn AWS", 
							LocalDate.now().plusYears(1), false ));
		todos.add(new TodoScript(++todoCount, "in28minutes","Learn DevOps", 
				LocalDate.now().plusYears(2), false ));
		todos.add(new TodoScript(++todoCount, "in28minutes","Learn Full Stack Development", 
				LocalDate.now().plusYears(3), false ));
	}
	
	public List<TodoScript> findByUsername(String username){
		Predicate<? super TodoScript> predicate= 
		todo->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
public void addTodo(String username ,String description,LocalDate targetDate,boolean done ) {
		TodoScript todo = new TodoScript(++todoCount,username,description,targetDate,done);
		
		todos.add(todo);
		
	}	
public void deleteById(int id) {
	Predicate<? super TodoScript> predicate= todo->todo.getId()==id;
	todos.removeIf(predicate);
}
public void updateById(int id) {
	Predicate<? super TodoScript> predicate= todo->todo.getId()==id;
	todos.removeIf(predicate);
}

public TodoScript findById(int id) {
	Predicate<? super TodoScript> predicate= todo->todo.getId()==id;
TodoScript todo=todos.stream().filter(predicate).findFirst().get();
	
	
	return todo;
}

public void updateTodo(@Valid TodoScript todo) {
deleteById(todo.getId());
todos.add(todo);
}


}
