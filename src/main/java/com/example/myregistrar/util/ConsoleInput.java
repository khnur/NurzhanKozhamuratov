package com.example.myregistrar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine() throws IOException {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }

    public static int readInt() throws NumberFormatException, IOException {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                throw new NumberFormatException(e.getMessage());
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public static void close() throws IOException {
        reader.close();
    }

    private ConsoleInput() {}
}
