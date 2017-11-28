/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.pnl;

/**
 *
 * @author Guinness
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {

    private static final int PORT = 1000;

    private static final HashSet<String> names = new HashSet();

    private static final HashSet<PrintWriter> writers = new HashSet();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");

        try {
            ServerSocket listener = new ServerSocket(PORT);
            new Handler(listener.accept()).start();
        } catch (Exception e) {
        }

    }

    public static void set(int new_port) {
        System.out.println("The chat server is running.");
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(new_port);
            new Handler(listener.accept()).start();

        } catch (IOException e) {
            System.out.println("error: " + e);
        }

    }

    private static class Handler extends Thread {

        private String name;
        private final Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {

                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) {
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    }
                }

                out.println("NAMEACCEPTED");
                writers.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    String replaceAll = input.replaceAll("\n", "<n>");
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE%" + name + "%" + replaceAll);
                    }
                    System.out.println("replaceAll: "+replaceAll);
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {

                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
