/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selfestimatimator.warehouse;

import java.util.List;
import java.util.Map;
import selfestimatimator.config.IConfigLoader;
import selfestimatimator.corelogic.logic.Tag;
import selfestimatimator.corelogic.logic.Term;
import selfestimatimator.corelogic.logic.UserSkills;

/**
 *
 * @author Александр
 */
public interface ILoadData {
    public void init(IConfigLoader loaderConfig);

    public void addTag(Tag tag)throws Exception;
    public boolean deleteTagSoft(Tag tag)throws Exception;
    public void deleteTagHard(Tag tag)throws Exception;
    public Map<String, Tag> getTags()throws Exception;
    
    public void addTerm(Term term)throws Exception;
    public boolean deleteTermSoft(Term term)throws Exception;
    public void deleteTermHard(Term term)throws Exception;
    public void deleteTermFromAllTermTags(Term term)throws Exception;
    public Map<String, Term> getTerms()throws Exception;
    
    public void addTagToTerm(Term term, Tag tag)throws Exception;
    public void deleteTagFromTerm(Term term, Tag tag)throws Exception;
    public void deleteTagFromAllTerms(Tag tag)throws Exception;
    
    public void setUserSkill(String userName, Term term, int skill)throws Exception;
    public UserSkills getUserSkills(String userName)throws Exception;
     
}
