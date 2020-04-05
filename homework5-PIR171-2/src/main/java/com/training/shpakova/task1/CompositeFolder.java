package com.training.shpakova.task1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CompositeFolder implements Folder {
    private final ArrayList<Folder> innerFolders = new ArrayList<Folder>();
    private final String name;
    private int position;

    public CompositeFolder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Folder getInstance() {
        Folder result;
        if (position < innerFolders.size()) {
            result = innerFolders.get(position);
        } else {
            result = this;
        }
        return result;
    }

    @Override
    public void add(Folder folder) {
        innerFolders.add(folder);
    }

    @Override
    public int getSize() {
        return innerFolders.size();
    }

    @Override
    public void print(int count) {
        count++;
        System.out.println(name + "/");
        for (Folder folder : innerFolders) {
            printSpaces(count + 1);
            folder.print(count);
        }
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public void perform(String[] array) {
        boolean correctInput = new Check().getResult(array);
        if (correctInput) {
            int index = 0;
            Folder current = this;
            Folder nextFolder;
            boolean elementsToAddExist = (index < array.length);
            while (elementsToAddExist) {
                nextFolder = findNextPlace(current, array[index]);
                if (nextFolder == current) {
                    for (int i = index; i < array.length; i++) {
                        current = createNewElement(array[i], current);
                    }
                    break;
                }
                current = current.getInstance();
                index++;
                elementsToAddExist = (index < array.length);
            }
        }
    }

    private Folder findNextPlace(Folder folder, String searchedElement) {
        Folder foundFolder = folder;
        Folder current;
        for (position = 0; position < folder.getSize(); position++) {
            folder.setPosition(position);
            current = folder.getInstance();
            if (current.getName().equals(searchedElement)) {
                foundFolder = current;
                break;
            }
        }
        return foundFolder;
    }

    private Folder createNewElement(String name, Folder element) {
        Folder folder = element;
        if (isFile(name)) {
            File file = new FileBuilder().setName(name).build();
            element.add(file);
        } else {
            folder = new CompositeFolderBuilder().setName(name).build();
            element.add(folder);
        }
        return folder;
    }

    private boolean isFile(String element) {
        final String PATTERN = ".*\\.[\\w|\\d]*";
        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(element);
        return m.matches();
    }

}

