package ua.com.alevel.fileread;

import java.io.File;

public class DirectoryTree {
    public static void main(String[] args) {
        File file = new File("C:/testFolder");
        DirectoryTree directoryTree = new DirectoryTree();
        directoryTree.showNestedTree(file);
    }

    public void showNestedTree(File source) {
        if (source.isDirectory()) {
            System.out.println(source.getName() + " is directory");
            for (File file:
                 source.listFiles()) {
                showNestedTree(file);
            }
        } else if (source.isFile()) {
            System.out.println(source.getName() + " is file");
        }
    }

}
