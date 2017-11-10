package com.jianmo.weather.demo.other;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * 文件上传，与WeatherDemo无关
 * @author jianmo
 */
public class UpFile {
    HttpServletRequest request;
    HttpSession session;

    ServletContext context;
    String upFileMessage="";
    File f1;
    public void setRequest(HttpServletRequest request){
        this.request=request;
    }

    public void setSession(HttpSession session){
        this.session=session;
    }

    public void setContext(ServletContext context){
        this.context=context;
    }

    public String getUpFileMessage(){
        String fileName=null;
        try {
            String tempFileName=(String)session.getId();
            String p=context.getRealPath(request.getContextPath());//获取路径
            System.out.println(p);
            p=p.substring(0,p.lastIndexOf("\\"));
            System.out.println(p);
            f1=new File(p,tempFileName);
            FileOutputStream outputStream=new FileOutputStream(f1);
            InputStream inputStream=request.getInputStream();
            byte b[]=new byte[10000];
            int n;
            while ((n=inputStream.read(b))!=-1){
                outputStream.write(b,0,n);
            }
            outputStream.close();
            inputStream.close();
            RandomAccessFile random=new RandomAccessFile(f1,"r");
            int second=1;
            String secondLine=null;
            while (second<=2){
                secondLine=random.readLine();
                second++;
            }
            int position=secondLine.lastIndexOf('=')+1;
            System.out.println("yyy"+position);
            fileName=secondLine.substring(position+1,secondLine.length()-1);
            fileName=new String(fileName.getBytes("ISO-8859-1"),"utf-8");
            session.setAttribute("Name",fileName);
            File file2=new File(p,fileName);
            RandomAccessFile accessFile=new RandomAccessFile(file2,"rw");
            random.seek(random.length());
            long mark=random.getFilePointer();
            long endPosition=0;
            int j=0;
            while (mark>=0&&j<6){
                mark--;
                random.seek(mark);
                n=random.readByte();
                System.out.println(n);
                if (n=='\n'){
                    endPosition=random.getFilePointer();
                    j++;
                }
            }
            System.out.println(j);
            random.seek(0);
            long startPoint=0;
            int forth=1;
            while ((n=random.readByte())!=-1&&forth<=4){
                if (n=='\n'){
                    startPoint=random.getFilePointer();
                    j++;
                }
            }
            random.seek(startPoint);
            while (startPoint<endPosition-1){
                n=random.readByte();
                accessFile.write(n);
                startPoint=random.getFilePointer();
            }
            accessFile.close();
            random.close();
            upFileMessage=fileName+"success upload";
        }catch (Exception e){
            if (fileName!=null){
                upFileMessage=fileName+"filed upload";
            }
            if (fileName==null){
                upFileMessage="fileName null";
            }
        }
        f1.delete();
        return upFileMessage;
    }
}
