import java.util.*;

public class Calc {
    String[] operations = {"*", "/", "+", "-"};

    public void launch(){
        while (true){
            System.out.println("Введите выражение:");
            Scanner input = new Scanner(System.in);
            System.out.println(calc(input.nextLine()));
        }
    }

    List<String> get_expression_items(String expression){
        expression = expression.replace(" ", "");
        for (String operation : operations) {
            expression = expression.replace(operation, String.format(" %s ", operation));
        }
        return new ArrayList<>(Arrays.asList(expression.split(" ")));
    }

    float calc_float(List<String> expression_items){
        float first_value = Float.parseFloat(expression_items.get(0));
        float second_value = Float.parseFloat(expression_items.get(2));
        switch (expression_items.get(1)){
            case "*":
                return first_value*second_value;
            case "/":
                return first_value/second_value;
            case "+":
                return first_value+second_value;
            case "-":
                return first_value-second_value;
        }
        return 0f;
    }

    public String calc(String expression){
        List<String> expression_items = get_expression_items(expression);
        float answer = calc_float(expression_items);
        if (answer%1 == 0){
            return String.valueOf((int) answer);
        }else{
            return String.valueOf(answer);
        }
    }

}
