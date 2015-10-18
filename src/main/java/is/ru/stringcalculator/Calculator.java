package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		/*if(text.contains("-")){
				throw new ExceptionNegative();
		}*/
		if(text.startsWith("//")){
			return sum(splitByGiven(text));
		}
		if(text.contains(",")){
			return sum(splitNumbers(text));
		}

		else 
			return (toInt(text));
	}

	private static int toInt(String number){
			return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[,:\n]");
	}

	private static String[] splitByGiven(String numbers){
	    String[] part = numbers.split("\n");
		String delimiter = part[0].substring(2);
		numbers = part[1];
	    return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    if (toInt(number) <= 1000){
			    total += toInt(number);
			}
		}
		return total;
    }
    /*private class NumberExceptions extends Exception
	{
		public void ExceptionNegative()
        {
                String[] message; 
                message[0] ="Negatives not Allowed";
                return message;
        }
	}*/
}
