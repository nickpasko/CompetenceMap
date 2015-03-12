/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SelfEstimator.CoreLogic.Test;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import selfestimatimator.corelogic.logic.Tag;
import selfestimatimator.corelogic.logic.Term;

/**
 *
 * @author Александр
 */
public class TermTest {
    
    public TermTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void TermCreated_NameMatch() throws Exception
    {
        String name = "Booboo";
        Term term = new Term(name);
        if (!term.getName().equals(name))
            throw new Exception("Name do not match");
    }
    
    @Test
    public void TermAddSingleTag_GetTagNames_ReturnsSingleTagWithMatchingName() throws Exception
    {
        String tagName = "tag";
        String termName = "term";
        Tag tag = new Tag(tagName);
        Term term = new Term(termName);
        term.addTag(tag);
        List<String> tags = term.getAllTagNames();
        if (tags.size() != 1)
            throw new Exception("Exactly one tag expected in a list of term tags.");
        if (!tags.get(0).equals(tagName))
            throw new Exception("Tag name returned does not match the initial tag name.");
    }
    
    @Test
    public void TermAddTenTag_GetTagNames_ReturnsTenTagNames() throws Exception
    {
        String tagNamePattern = "tag";
        String termName = "term";
        Term term = new Term(termName);
        for (int i = 0; i < 10; i++)
        {
            Tag tag = new Tag(tagNamePattern+i);
            term.addTag(tag);
        }
        List<String> tags = term.getAllTagNames();
        if (tags.size() != 10)
            throw new Exception("Exactly ten tags expected in a list of term tags.");
    }
    
    
}