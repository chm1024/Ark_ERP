package com.micolor.module.demo.trans.method;

import com.micolor.entity.demo.TransValue;

import java.io.FileWriter;
import java.util.List;

/**
 * Created by Evangoe on 26/06/16.
 */
public class FileWrite {
    public String writeFile(List<TransValue> list, String langflag,String realpath){
        FileWriter fw = null;
        String filepath=realpath+"/download/";
        String filename="";
        try {

            //message_br.properties
            if(langflag.equals("zn")) {
                filename = "message_zh.properties";
                filepath=filepath+filename;
            }else if(langflag.equals("br")){
                filename = "message_br.properties";
                filepath=filepath+filename;
            }

            fw = new FileWriter(filepath);
            for(TransValue transValue:list){
                if(langflag.equals("zn")){
                    fw.write(transValue.getTvkey()+"="+transValue.getDisc()+"\r\n");
                }else if(langflag.equals("br")){
                    fw.write(transValue.getTvkey()+"="+transValue.getTransdisc()+"\r\n");
                }else{
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filename;
    }
}
