package com.codecool.snake;

import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private String ip = "localhost";
    private int port = 22222;
    private Scanner scanner = new Scanner(System.in);

    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ServerSocket serverSocket;

    public static Stage primaryStage;

    private boolean accepted = false;
    private boolean waitingForClient = true;
    private boolean connected;


    public Server(){

    }

    public void startServer(){
        System.out.println("Please input the IP: ");
        ip = scanner.nextLine();
        System.out.println("Please input the port: ");
        port = scanner.nextInt();
        while(port < 1 || port > 65535){
            System.out.println("The port you entered was invalid!");
            port = scanner.nextInt();
        }
        if (!connect()){
            initializeServer();
            start();
            connected = true;

        }
        if(accepted){
            start();
            connected = true;
        }

    }

    public void start() {
        if (accepted) {
            Game game = new Game();
            MenuBar.addMenu(game, primaryStage);

            primaryStage.setTitle("Snake Multiplayer");
            primaryStage.show();
            game.start();
        }else{
            listenForServerRequest();
        }
    }

    private boolean listenForServerRequest(){
        Socket socket = null;
        try{
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("Client has requested and joined the game");
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
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

    public boolean getConnected(){
        return this.connected;
    }

    public void sendData(SnakeHead snakeHead) {
        try {
            dos.writeInt(snakeHead.getHealth());
            System.out.println(snakeHead.getHealth());
            dos.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
