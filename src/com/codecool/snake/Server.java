package com.codecool.snake;

import com.codecool.snake.entities.snakes.SnakeHead;
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
    private DataOutputStream dos2;
    private DataInputStream dis2;

    private ServerSocket serverSocket;

    public static Stage primaryStage;

    private boolean accepted = false;
    private boolean waitingForClient = true;
    private boolean connected;
    private int enemyHealth;
    private int enemyScore;


    public Server() {

    }

    public void startServer() {
        System.out.println("Please input the IP: ");
        ip = scanner.nextLine();
        System.out.println("Please input the port: ");
        port = scanner.nextInt();
        while (port < 1 || port > 65535) {
            System.out.println("The port you entered was invalid!");
            port = scanner.nextInt();
        }
        if (!connect()) {
            initializeServer();
            start();
            connected = true;

        }
        if (accepted) {
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
        } else {
            listenForServerRequest();
        }
    }

    private boolean listenForServerRequest() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dos2 = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            dis2 = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("Client has requested and joined the game");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean connect() {
        try {
            socket = new Socket(ip, port);
            dos = new DataOutputStream(socket.getOutputStream());
            dos2 = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            dis2 = new DataInputStream(socket.getInputStream());
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

    public boolean getConnected() {
        return this.connected;
    }

    public void sendHealth(SnakeHead snakeHead) {
        try {
            dos.writeInt(snakeHead.getHealth());
            System.out.println(snakeHead.getHealth());
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send100(int num){
        try {
            dos.writeInt(num);
            dos2.write(0);
            System.out.println(num);
            dos.flush();
            dos2.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendScore(SnakeHead snakeHead) {
        try {
            dos2.writeInt(Globals.getScore());
            System.out.println(snakeHead.getHealth());
            dos2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getEnemyHealth() {
        try{if (dis.available() != 0) {
            try {
                enemyHealth = dis.readInt();
                return enemyHealth;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }}catch (IOException e){
            e.printStackTrace();
        }
        return enemyHealth;
    }
    public int getEnemyScore() {
        try{if (dis2.available() != 0) {
            try {
                enemyScore = dis2.readInt();
                return enemyScore;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }}catch (IOException e){
            e.printStackTrace();
        }
        return enemyScore;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

}
