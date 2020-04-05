package com.training.shpakova.task1;

class File implements Folder {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Folder getInstance() {
        return this;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void add(Folder folder) {
    }

    @Override
    public void print(int count) {
        System.out.println(name);
    }

    @Override
    public void setPosition(int position) {
    }

}
