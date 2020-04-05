package com.training.shpakova.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeFolderTest {
    public static final String NAME_OF_MAIN = "C";
    public static final int SIZE_OF_FOLDER = 1;
    public static final int SIZE_OF_ELEMENT = 0;
    public static final String[] ARRAY = {"1", "1.exe"};
    public static final String NAME_OF_ELEMENT = "1";
    public static final String NAME_OF_DEEPER_LEVEL_ELEMENT = "1.exe";
    CompositeFolder compositeFolder;
    Folder compositeFolderElement;

    @Before
    public void init() {
        compositeFolder = new CompositeFolderBuilder().setName(NAME_OF_MAIN).build();
        compositeFolderElement = new CompositeFolderBuilder().setName(NAME_OF_ELEMENT).build();
        compositeFolder.add(compositeFolderElement);
    }

    @Test
    public void testGetInstanceAndAddReturnElement() {
        assertEquals(compositeFolder.getInstance(), compositeFolderElement);
    }

    @Test
    public void testGetInstanceReturnItself() {
        assertEquals(compositeFolder.getInstance().getInstance(), compositeFolderElement);
    }

    @Test
    public void testGetSize() {
        assertEquals(SIZE_OF_FOLDER, compositeFolder.getSize());
        assertEquals(SIZE_OF_ELEMENT, compositeFolder.getInstance().getSize());
    }

    @Test
    public void testPerform() {
        compositeFolder.perform(ARRAY);
        assertEquals(compositeFolder.getInstance().getName(), NAME_OF_ELEMENT);
        assertEquals(SIZE_OF_FOLDER, compositeFolder.getInstance().getSize());
        assertEquals(compositeFolder.getInstance().getInstance().getName(), NAME_OF_DEEPER_LEVEL_ELEMENT);
        assertEquals(SIZE_OF_ELEMENT, compositeFolder.getInstance().getInstance().getSize());
    }

}