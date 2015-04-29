package it.tostao.sswa.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for Index.
 * @author sleski
 *
 */
public class IndexTest {

    /**
     * tests if the correct view information is coming back.
     */
    @Test
    public void testGet() {
        Index index = new Index();
        assertEquals("index", index.get().getViewName());
    }

}
