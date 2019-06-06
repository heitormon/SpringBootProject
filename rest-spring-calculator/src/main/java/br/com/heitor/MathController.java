package br.com.heitor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.exception.UnsuportedMathOperationException;
import br.com.math.Operation;

@RestController
public class MathController {
	
Operation op = new Operation();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return op.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
		}
	@RequestMapping(value="/minus/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double minus(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return op.minus(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	@RequestMapping(value="/divide/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double divide(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return op.divide(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return op.mult(convertToDouble(numberOne), convertToDouble(numberTwo));
	}
	@RequestMapping(value="/square/{numberOne}", method=RequestMethod.GET)
	public Double square(@PathVariable(value="numberOne") String numberOne) throws Exception {
		if(!isNumeric(numberOne) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value!");
		}
		return op.square(convertToDouble(numberOne));
	}
	private Double convertToDouble(String strnumber) {
		if(strnumber==null) return 0D;
		String number = strnumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strnumber) {
		if(strnumber==null) return false;
		String number = strnumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
