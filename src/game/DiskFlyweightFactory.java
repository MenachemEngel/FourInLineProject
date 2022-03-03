package game;

import java.util.HashMap;

public class DiskFlyweightFactory {

    private static final HashMap<Character,IDisk> diskMap = new HashMap<>();

    public static IDisk getDisk(char color){
        IDisk disk = diskMap.get(color);

        if(disk == null){
            disk = new Disk(color);
            diskMap.put(color, disk);
        }
        return disk;
    }
}
