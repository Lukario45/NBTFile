package com.Lukario45.NBTFile;

import org.spacehq.opennbt.NBTIO;
import org.spacehq.opennbt.tag.builtin.CompoundTag;
import org.spacehq.opennbt.tag.builtin.Tag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kevin on 11/12/2014.
 */
public class NBTFile {
    private File nbtFile;
    private boolean compressed;
    private String mainCompoundTagName;
    private Map<String,Tag> tagMap;

    /**
     * @unused
     */
    private NBTFile(String mainCompoundTagName){}

    public NBTFile(String mainCompoundTagName,String path){
        setMainCompoundTagName(mainCompoundTagName);
        setNbtFile(new File(path));
        setCompressed(false);
        tagMap = new HashMap<String, Tag>();
    }
    public NBTFile(String mainCompoundTagName,String path, Boolean compressed){
        setMainCompoundTagName(mainCompoundTagName);
        setNbtFile(new File(path));
        setCompressed(compressed);
        tagMap = new HashMap<String, Tag>();
    }
    public NBTFile(String mainCompoundTagName,File file){
        setMainCompoundTagName(mainCompoundTagName);
        setNbtFile(file);
        setCompressed(false);
        tagMap = new HashMap<String, Tag>();
    }
    public NBTFile(String mainCompoundTagName,File file, Boolean Compressed){
        setMainCompoundTagName(mainCompoundTagName);
        setNbtFile(file);
        setCompressed(compressed);
        tagMap = new HashMap<String, Tag>();
    }
    public void createFile() throws IOException {
        if(!nbtFile.exists()){
            nbtFile.createNewFile();
            CompoundTag compoundTag = new CompoundTag(getMainCompoundTagName(),getTagMap());
            NBTIO.writeFile(compoundTag,getNbtFile(),isCompressed());
        } else {
            CompoundTag c = NBTIO.readFile(getNbtFile(),isCompressed());
            if (!c.getName().equals(getMainCompoundTagName())){
                CompoundTag compoundTag = new CompoundTag(getMainCompoundTagName(),getTagMap());
                NBTIO.writeFile(compoundTag,getNbtFile(),isCompressed());
            }
        }
    }
    public void write(Tag t) throws IOException {
        CompoundTag main = NBTIO.readFile(getNbtFile(),isCompressed());
        setTagMap(main.getValue());
        getTagMap().put(t.getName(),t);
        main.setValue(getTagMap());
        NBTIO.writeFile(main,getNbtFile(),isCompressed());


    }
   // public void write(String name)
    public Tag read(String tagName) throws IOException {
        CompoundTag c = NBTIO.readFile(getNbtFile(),isCompressed());
        Tag t = c.get(tagName);
        return t;
    }



    public File getNbtFile(){
        return this.nbtFile;
    }
    public void setNbtFile(File nbtFile){
        this.nbtFile = nbtFile;
    }
    public boolean isCompressed(){
        return this.compressed;
    }
    public void setCompressed(boolean compressed){
        this.compressed = compressed;
    }
    public String getMainCompoundTagName(){
        return this.mainCompoundTagName;
    }
    public void setMainCompoundTagName(String name){
        this.mainCompoundTagName = name;
    }
    public Map getTagMap(){
        return this.tagMap;
    }
    public void setTagMap(Map map){
        this.tagMap = map;
    }
    public void addTagToTagMap(Tag t){
        tagMap.put(t.getName(),t);
    }



}
