package rambookapp.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rambookapp.model.Order;
import rambookapp.model.Student;
import rambookapp.service.OrderService;
import rambookapp.service.UserService;

@Controller
@RequestMapping("orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@GetMapping
	public String list(ModelMap modelMap, HttpSession session) {

		List<Order> list = orderService.findAllOrders();
		System.out.println("orders:"+ list.size());
		for (Order order : list) {
			System.out.println(order);
		}
		modelMap.addAttribute("ORDERS_LIST", list);
		return "order/LIST";

}

	@GetMapping("/myorders")
	public String myOrders(ModelMap modelMap, HttpSession session) {
		Student user=userService.findByEmail((String) session.getAttribute("log_id"));
        Long id=user.getId();
        List<Order> list = orderService.findByUserId(id);
        System.out.println("orders:"+ list.size());
        for (Order order : list) {
            System.out.println(order);
        }
        modelMap.addAttribute("ORDERS_LIST", list);
        return "order/listmyorder";

    }

	
	
	

	@PostMapping("/save")
	public String save(@RequestParam("total_amount") Integer totalAmount,@RequestParam("paymentmode") String paymentmode, HttpSession session) {

		Order orderInCart = (Order) session.getAttribute("MY_CART_ITEMS");
		
		if ( orderInCart != null && orderInCart.getOrderItems().size() > 0) {
			orderInCart.setUser(userService.findByEmail((String)session.getAttribute("log_id")));
			orderInCart.setTotalPrice(totalAmount);
			orderInCart.setPaymentmode(paymentmode);
			
			orderService.save(orderInCart);
			session.removeAttribute("MY_CART_ITEMS");			
		}
				
		return "redirect:../orders/myorders";
	}
	
	@GetMapping("/updateStatus")
	public String updateStatus(@RequestParam("id") Long orderId , @RequestParam("status")String status ) {
		Order order = orderService.findOne(orderId);
		if ("CANCELLED".equals(status) ) {
			order.setCancelledDate(LocalDate.now());
		}
		else if ("DELIVERED".equals(status)) {
			order.setDeliveredDate(LocalDate.now());
		}
		
		order.setStatus(status);
		orderService.save(order);	
		return "redirect:../orders/myorders";
	}
	
	@GetMapping("/cart")
	public String cart(){
		return "order/cart";
	}
}