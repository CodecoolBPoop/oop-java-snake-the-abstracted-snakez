package com.codecool.snake;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static final int WIDTH = 1366;
    private static final int HEIGHT = 768;

    private String ip = "localhost";
    private int port = 222222;
    private Scanner scanner = new Scanner(System.in);
    private Thread thread;

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ServerSocket serverSocket;

    private boolean unableToCommunicateWithOpponent = false;
    private boolean accepted = false;


    public Server(){
        System.out.println("Please input the IP: ");
        ip = scanner.nextLine();
        System.out.println("Please input the port: ");
        port = scanner.nextInt();
        while(port < 1 || port > 65535){
            System.out.println("The port you entered was invalid!");
            port = scanner.nextInt();
        }
        if (!connect()) initializeServer();

        start();

    }

    public void start() {
        while(true) {
            if (accepted) {
                Game game = new Game();
                game.start();
            } else {
                listenForServerRequest();
            }
        }
    }

    private void listenForServerRequest(){
        Socket socket = null;
        try{
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("Client has requested and joined the game");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private boolean connect(){
        try {
            socket = new Socket(ip, port);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
        } catch (IOException e) {
            System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
            return false;
        }
        System.out.println("Successfully connected to the server.");
        return true;
    }

    private void initializeServer() {
        try {
            serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
