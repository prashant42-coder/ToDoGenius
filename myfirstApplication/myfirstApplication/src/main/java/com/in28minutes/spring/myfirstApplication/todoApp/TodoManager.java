package com.in28minutes.spring.myfirstApplication.todoApp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
//@Controller
@SessionAttributes("name")
public class TodoManager {

	public  TodoManager (TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;
		
	// list of Todos List 
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedinUsername(model);
		List<TodoScript> todos = todoService.findByUsername(username);
		model.addAttribute("todos", todos);
		
		return "listTodos";
	}

	
	
	//GET, POST
		@RequestMapping(value="add-todo", method = RequestMethod.GET)
		public String showNewTodoPage(ModelMap model) {
			String username = getLoggedinUsername(model);
			TodoScript todo = new TodoScript(0, username, "Default Desc", LocalDate.now().plusYears(1), false);
			model.put("todo", todo);
			return "todo";
		}
		// todo adding list 

		@RequestMapping(value="add-todo", method = RequestMethod.POST)
		public String addNewTodo(ModelMap model, @Valid TodoScript todo, BindingResult result) {
			
			if(result.hasErrors()) {
				return "todo";
			}
			
			String username = getLoggedinUsername(model);
			todoService.addTodo(username, todo.getDescription(), 
			todo.getTargetDate(), false);
			return "redirect:list-todos";
		}
		
		// Todo  delete 
		@RequestMapping("delete-todo")
		public String deleteTodos(@RequestParam int id) {
			todoService.deleteById(id);
			return "redirect:list-todos";
		}
		
		// Todo Update 
		@RequestMapping(value ="update-todo", method= RequestMethod.GET)
		public String updateTodo(@RequestParam int id,ModelMap model) {
			TodoScript todo= todoService.findById(id);
			model.addAttribute("todo",todo);
			return "todo";
		}
		
		@RequestMapping(value="update-todo", method = RequestMethod.POST)
		public String UpdateTodo(ModelMap model, @Valid TodoScript todo, BindingResult result) {
			 
			if(result.hasErrors()) {
				return "todo";
			}
			
			String username = getLoggedinUsername(model);
			todo.setUsername(username);
			todoService.updateTodo(todo);
			return "redirect:list-todos";
		}
		
		private String getLoggedinUsername(ModelMap model) {
			return (String)model.get("name");
		}
		
	
}
