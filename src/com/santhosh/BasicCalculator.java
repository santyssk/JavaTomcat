package com.santhosh;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicCalculator
 */
@WebServlet("/BasicCalculator")
public class BasicCalculator extends HttpServlet {
	
	int calculate(int previous, int current, boolean minus){
        if(minus)
            return previous-current;
        return previous+current;
    }
    
    int calculate(String s) {
        Stack<Integer> integerValues = new Stack<>();
        Stack<Boolean> booleanValues = new Stack<>();
        boolean minus = false;
        int result = 0;
        int current = 0;
        for(int i = 0; i < s.length(); i++){
        	char c = s.charAt(i);
            if(c>='0'&&c<='9')
                current=current*10-'0'+c;
            else
            if(c=='('){
            	integerValues.push(result);
            	booleanValues.push(minus);
                result=0;
                minus=false;
            }
            else
            if(c==')'){
                result = calculate(result,current,minus);
                current=0;
                int number = integerValues.pop();
                boolean sign = booleanValues.pop();
                result = calculate(number,result,sign);
                minus=false;
            }
            else
            if(c=='+'){
                result = calculate(result,current,minus);
                minus=false;
                current=0;
            }
            else
            if(c=='-'){
                result = calculate(result,current,minus);
                minus=true;
                current=0;
            }
        }
        result = calculate(result,current,minus);
        return result;
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String expression = request.getParameter("expression");
		if(expression != null && expression.length() > 0) {
			
			String result;
			try{
				int value = calculate(expression);
				result = "The value of the expression "
						+ expression + " is "+ String.valueOf(value);
			}
			catch(Exception e) {
				result = "The expression is not a valid one. Please check for errors";
			}
			request.setAttribute("result", result);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
	}

}
