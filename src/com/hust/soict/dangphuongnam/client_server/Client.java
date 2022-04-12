package com.hust.soict.dangphuongnam.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 9898);
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
      Scanner scanner = new Scanner(System.in);
      while (true) {
        String message = scanner.nextLine();
        if (message == null || message.isEmpty()) {
          break;
        } else {
          out.println(message);
          String received = in.readLine();
          System.out.println(received);
        }
      }
      socket.close();
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}