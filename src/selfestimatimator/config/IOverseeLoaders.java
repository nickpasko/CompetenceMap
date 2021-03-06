/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selfestimatimator.config;

import java.util.List;
import java.util.Map;
import selfestimatimator.warehouse.ILoadData;

/**
 *
 * @author Александр
 */
public interface IOverseeLoaders {
    public void init(ILoadData loader);

    public void addTag(String name);
    public void deleteTagSoft(String name);
    public void deleteTagHard(String name);
    public List<String> getTagNames();
    
    public void addTerm(String name);
    public void deleteTermSoft(String name);
    public void deleteTermHard(String name);
    public List<String> getTermNames();
    
    public void addTagToTerm(String termName, String tagName);
    public List<String> getTermTagNames(String termName);
    
    public void setCurrentUser(String name);
    public void setUserSkill(String termName, int skillValue);
    public Map<String, Integer> getCurrentUserSkills();
}
