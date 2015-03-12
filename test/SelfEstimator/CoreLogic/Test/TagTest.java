/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelfEstimator.CoreLogic.Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import selfestimatimator.corelogic.logic.Tag;

/**
 *
 * @author Александр
 */
public class TagTest {

    public TagTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CreateTag_GetName_NameMatches() throws Exception{
        String tagName = "checkName";
        Tag tag = new Tag(tagName);
        if(!tag.getName().equals(tagName))
            throw new Exception("Names don't match!");
    }
}