/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selfestimatimator.corelogic.logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import selfestimatimator.warehouse.FileLoader;
import java.lang.*;
import java.sql.SQLException;
import selfestimatimator.config.IConfigLoader;
import selfestimatimator.config.StorageType;
import selfestimatimator.warehouse.DataBaseLoader;
import selfestimatimator.warehouse.ILoadData;
import selfestimatimator.warehouse.MockupLoader;

/**
 *
 * @author Александр
 */
public class StockKeeper {

    IConfigLoader loaderConfig;
    ILoadData loader;

    public StockKeeper(IConfigLoader loaderConfig) throws Exception {
        this.loaderConfig = loaderConfig;
        loader = getLoader();
        loader.init(loaderConfig);
    }

    public void addTerm(String name) throws Exception {
        getLoader().addTerm(new Term(name));
    }

    public void addTag(String name) throws Exception {
        getLoader().addTag(new Tag(name));
    }

    public void addTagToTerm(String tagName, String termName) throws Exception {
        getLoader().addTagToTerm(new Term(termName), new Tag(tagName));
    }

    public void setSkill(String termName, Skill skill) throws Exception {
        getLoader().setUserSkill(loaderConfig.getUserName(), new Term(termName), skill.getValue());
    }

    public List<Term> getTerms() throws Exception {
        return new ArrayList(getLoader().getTerms().values());
    }

    public List<Tag> getTags() throws Exception {
        return new ArrayList(getLoader().getTags().values());
    }

    public UserSkills getUserSkills() throws Exception {
        return getLoader().getUserSkills(loaderConfig.getUserName());
    }

    private ILoadData getLoader() throws Exception {
        if (loader != null)
            return loader;
        switch (loaderConfig.getStorageType()) {
            case FileSystem:
                return new FileLoader(loaderConfig);
            case DataBase:
                return new DataBaseLoader(loaderConfig);
            case MockupLoader:
                return new MockupLoader();
            default:
                return null;
        }
    }
}
