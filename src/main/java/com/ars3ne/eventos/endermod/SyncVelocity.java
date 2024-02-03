package com.ars3ne.eventos.endermod;

import com.ars3ne.eventos.aEventos;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SyncVelocity {

    public static void sendMessageVelocity(List<String> messages) {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);

        try {
            out.writeUTF("reinosmessage");

            StringBuilder sb = new StringBuilder();

            for (String msg : messages) {
                sb.append(msg).append("\n");
            }
            sb.deleteCharAt(sb.lastIndexOf("\n"));

            out.writeUTF(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        aEventos.getInstance().getLogger().info("Enviando comunicação ao bungee/velocity.");
        int random = new Random().nextInt(Bukkit.getOnlinePlayers().size());
        Player player = (Player) Bukkit.getOnlinePlayers().toArray()[random];
        player.sendPluginMessage(aEventos.getInstance(), "aeventos:channel", stream.toByteArray());
    }

    public static void sendStartSignal() {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);

        try {
            out.writeUTF("iniciar");
        } catch (IOException e) {
            e.printStackTrace();
        }

        aEventos.getInstance().getLogger().info("Enviando sinal de start ao bungee/velocity.");
        int random = new Random().nextInt(Bukkit.getOnlinePlayers().size());
        Player player = (Player) Bukkit.getOnlinePlayers().toArray()[random];
        player.sendPluginMessage(aEventos.getInstance(), "aeventos:channel", stream.toByteArray());
    }

    public static void sendStopSignal() {

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(stream);

        try {
            out.writeUTF("parar");
        } catch (IOException e) {
            e.printStackTrace();
        }

        aEventos.getInstance().getLogger().info("Enviando sinal de stop ao bungee/velocity.");
        int random = new Random().nextInt(Bukkit.getOnlinePlayers().size());
        Player player = (Player) Bukkit.getOnlinePlayers().toArray()[random];
        player.sendPluginMessage(aEventos.getInstance(), "aeventos:channel", stream.toByteArray());
    }

}
