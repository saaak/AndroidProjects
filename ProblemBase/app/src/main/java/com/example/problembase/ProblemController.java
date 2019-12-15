package com.example.problembase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ProblemController {

    private final String fileName = "saveProblems.txt";
    public Integer getLastProblemNum(BufferedReader bufferedReader) throws IOException {
        Integer count=0;
        while (bufferedReader.readLine()!=null){
            count++;

        }
        return count/6;
    }

    public BufferedReader readProblemBfe(File file) throws FileNotFoundException {
        try {
            BufferedReader proBfe = new BufferedReader(new FileReader(file));
            return proBfe;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public File getProFile(String dir){
        File problemFile = new File(dir, fileName);
        if (!problemFile.exists()) {
            boolean result; // 文件是否创建成功
            try {
                result = problemFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            if (!result) {
                return null;
            }
        }
        return problemFile;
    }

    public void saveProblem(File proFile,String problemText) throws FileNotFoundException {
        FileOutputStream outputStream = new FileOutputStream(proFile,true);
        try{
            outputStream.write(problemText.getBytes());
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
