package com.training.shpakova.task1;

class CompositeFolderBuilder {
    private String name;

    public CompositeFolderBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CompositeFolder build() {
        return new CompositeFolder(name);
    }

}

