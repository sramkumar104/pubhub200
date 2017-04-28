package rambookapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import rambookapp.model.Book;
import rambookapp.service.BookService;

@Controller
@RequestMapping("books")
public class BookController {
	private static final Logger LOGGER = Logger.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@GetMapping
	public String list(HttpSession session) {
		LOGGER.info("Entering list");
		List<Book> books = bookService.findAll();
		System.out.println(books);
		session.setAttribute("books", books);
		return "list";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, ModelMap modelMap, HttpSession session) {
		System.out.println("ShowBook:" + id);
		Book book = bookService.findOne(id);
		modelMap.addAttribute("SELECTED_BOOK", book);
		return "book/show";
	}


}
