package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.launchcode.javawebdevtechjobsmvc.models.Search;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    private static ArrayList<Job> jobs = new ArrayList<>();
//    private static Search searchObject = new Search();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);
//        model.addAttribute("search", new Search());
        return "search";
    }

    // TODO - Figure out the radio button settings
//    @RequestMapping(value = "results{searchTerm}")
    @PostMapping("results{searchTerm}")
    public String displaySearchResults(String searchType, String searchTerm, Model model){
        //String searchType = search.getType();

        if(searchTerm.equals("")){
            jobs = JobData.findAll();
        }else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
        model.addAttribute("jobs", jobs);
        return "redirect:";
    }

}
