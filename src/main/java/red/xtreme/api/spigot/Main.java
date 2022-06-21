package red.xtreme.api.spigot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.hocon.HoconConfigurationLoader;
import org.spongepowered.configurate.loader.ConfigurationLoader;
import red.xtreme.api.spigot.bStats.Metrics;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Main extends JavaPlugin {

    //config files
    //settings.conf
    public File settingsFile;
    public CommentedConfigurationNode settings;
    public ConfigurationLoader<CommentedConfigurationNode> settingsLoader;

    public void onEnable() {
        try {
            registerConfigFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(settings.node("metrics").getBoolean()) {
            int pluginId = 15535;
            Metrics metrics = new Metrics(this, pluginId);
        }

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "__  ___                              _    ____ ___");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "\\ \\/ | |_ _ __ ___ _ __ ___   ___   / \\  |  _ |_ _|");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + " \\  /| __| '__/ _ | '_ ` _ \\ / _ \\ / _ \\ | |_) | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + " /  \\| |_| | |  __| | | | | |  __// ___ \\|  __/| |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "/_/\\_\\\\__|_|  \\___|_| |_| |_|\\___/_/   \\_|_|  |___|");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "V. "+getDescription().getVersion()+" | Plugin enabled successfully | xtreme.red");

    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "__  ___                              _    ____ ___");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "\\ \\/ | |_ _ __ ___ _ __ ___   ___   / \\  |  _ |_ _|");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + " \\  /| __| '__/ _ | '_ ` _ \\ / _ \\ / _ \\ | |_) | |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + " /  \\| |_| | |  __| | | | | |  __// ___ \\|  __/| |");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "/_/\\_\\\\__|_|  \\___|_| |_| |_|\\___/_/   \\_|_|  |___|");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "V. "+getDescription().getVersion()+" | Plugin disabled successfully | xtreme.red");
    }

    private void registerConfigFiles() throws IOException {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        //settings.conf
        settingsFile = new File(getDataFolder(), "/settings.conf");
        settingsLoader = HoconConfigurationLoader.builder().file(settingsFile).build();

        if(!settingsFile.exists()) {
            InputStream in = getClass().getResourceAsStream("/settings.conf");
            if(in != null) {
                Files.copy(in, settingsFile.toPath());
            }
        }
        settings = settingsLoader.load();
    }

}
