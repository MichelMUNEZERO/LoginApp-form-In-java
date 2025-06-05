import java.io.*;
import java.net.*;

public class SeverExam {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7655)) {
            System.out.println("Server started on port 7655...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                double num1 = Double.parseDouble(in.readLine());
                double num2 = Double.parseDouble(in.readLine());
                String operator = in.readLine();

                double result = 0;
                String response;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num2 != 0 ? num1 / num2 : 0;
                        break;
                    case "%":
                        result = num2 != 0 ? num1 % num2 : 0;
                        break;
                    default:
                        response = "Invalid operator";
                        out.println(response);
                        socket.close();
                        continue;
                }

                response = "Result: " + num1 + " " + operator + " " + num2 + " = " + result;
                out.println(response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
