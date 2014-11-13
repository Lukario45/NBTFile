package com.Lukario45.NBTFile;

import org.spacehq.opennbt.tag.builtin.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Kevin on 11/12/2014.
 */
public class Utilitys {
    public static Tag getFromCompound(CompoundTag c, String tagName){
        Tag t = c.get(tagName);
        return t;
    }
    public static CompoundTag constructMultiCompoundTag(CompoundTag lastCompound, Map<String,Tag> tags, String newCompoundName){
        tags.put(lastCompound.getName(),lastCompound);
        CompoundTag newCompound = new CompoundTag(newCompoundName,tags);
        return newCompound;
    }
    public static ByteArrayTag makeByteArrayTag(String name,byte[] data){
        return new ByteArrayTag(name,data);
    }
    public static ByteTag makeByteTag(String name,byte data){
        return new ByteTag(name,data);
    }
    public static DoubleTag makeDoubleTag(String name,double data){
        return new DoubleTag(name,data);
    }
    public static FloatTag makeFloatTag(String name,float data){
        return new FloatTag(name,data);
    }
    public static IntArrayTag makeIntArrayTag(String name,int[] data){
        return new IntArrayTag(name,data);
    }
    public static IntTag makeIntTag(String name,int data){
        return new IntTag(name,data);
    }
    public static ListTag makeListTag(String name,List data){
        return new ListTag(name,data);
    }
    public static LongTag makeLongTag(String name,long data){
        return new LongTag(name,data);
    }
    public static ShortTag makeShortArrayTag(String name,short data){
        return new ShortTag(name,data);
    }
    public static StringTag makeStringTag(String name,String data){
        return new StringTag(name,data);
    }
}
