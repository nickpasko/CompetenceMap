/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selfestimatimator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import selfestimatimator.config.Config;
import selfestimatimator.config.IConfig;
import selfestimatimator.config.IConfigLoader;
import selfestimatimator.config.StorageType;
import selfestimatimator.corelogic.logic.Skill;
import selfestimatimator.corelogic.logic.StockKeeper;
import selfestimatimator.corelogic.logic.Tag;
import selfestimatimator.corelogic.logic.Term;
import selfestimatimator.corelogic.logic.UserSkills;
import selfestimatimator.userinterface.ConsoleUI;
import selfestimatimator.userinterface.IRunApplication;
import selfestimatimator.warehouse.FileLoader;

/**
 *
 * @author Александр
 */
public class SelfEstimatimator {

    public static void main(String[] args) throws Exception {

        IConfig config = new Config();

        config.setStorageType(StorageType.FileSystem);
        config.setTagFileName("C://java/tags.txt");
        config.setTermFileName("C://java/terms.txt");
        config.setTermTagsFileName("C://java/termTags.txt");
        config.setUserSkillsFileName("C://java/termSkills.txt");
        //add new comment

       
//        config.setStorageType(StorageType.DataBase);
//        config.setDBConnectionString("jdbc:postgresql://localhost:5432/SelfEstimator?user=postgres&password=user");

        IRunApplication ui = new ConsoleUI();
        ui.run(config);


    }
}
