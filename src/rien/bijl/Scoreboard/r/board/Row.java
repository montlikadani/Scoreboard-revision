package rien.bijl.Scoreboard.r.board;

import org.bukkit.ChatColor;
import rien.bijl.Scoreboard.r.Main;
import rien.bijl.Scoreboard.r.util.Func;

import java.util.ArrayList;

/**
 * Created by Rien on 21-10-2018.
 */
public class Row {

    private int interval;
    private ArrayList<String> lines;
    private String line;
    private int current = 0;

    // Rules
    public boolean static_line = false;
    public boolean placeholders = false;
    public boolean active = false;

    public Row(ArrayList<String> lines, int interval)
    {
        this.lines = lines;
        this.interval = interval;

        if(lines.size() == 1)
            static_line = true;
        for(String line : lines)
            if(line.contains("%")) placeholders = true;

        if(static_line)
            if(lines.size() < 1)
                line = "";
            else
                line = Func.color(lines.get(0));

        update();
    }

    private int count = 0;

    public void update()
    {
        if(static_line) return;
        active = true;
        if(count >= interval)
        {
            count = 0;
            current++;
            if(current >= lines.size())
                current = 0;
            line = Func.color(lines.get(current));
        } else {
            count++;
        }
    }

    public String getLine() { return this.line; }

}
