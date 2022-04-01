package xymb.multipaperrealplayercountontablist;

import org.bukkit.OfflinePlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import com.github.puregero.multilib.MultiLib;

public class Placeholders extends PlaceholderExpansion {
    public Placeholders() {
    }

    @Override
    public String getAuthor() {
        return "Xymb";
    }

    @Override
    public String getIdentifier() {
        return "multipaper";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return false;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("player_count")) {
            return String.valueOf(MultiLib.getAllOnlinePlayers().size());
        }
        return null;
    }
}